import java.util.*;

public class InFixEval {

	private InFixEval() {

	}

	public static String[] toPostfix(String[] infix) {
		StackArray<String> op = new StackArray<String>();
		String result = "";
		for (int i = 0; i < infix.length; i++) {
			if (isOperator(infix[i])) {
				try {
					if (op.isEmpty() || prec(infix[i], op.top())) {
						op.push(infix[i]);
					} /*else if (!prec(infix[i], op.top())) {
						result = result + op.pop() + " ";
						op.push(infix[i]);
						
					} */ else {
						result = result + op.pop() + " ";
						op.push(infix[i]);
					}
				} catch (ESException e) {

					e.printStackTrace();
				}
			} else if (infix[i].equals("(")) {
				op.push(infix[i]);
			} else if (infix[i].equals(")")) {
				try {
					while (!op.top().equals("(")) {
						result = result + op.pop() + " ";
					}
				} catch (ESException e) {
					e.printStackTrace();
				}
				try {
					op.pop();
				} catch (ESException e) {
					e.printStackTrace();
				}
			} else {
				result = result + infix[i] + " ";
			}
		}
		while (!op.isEmpty()) {
			try {
				result = result + op.pop()+" ";
			} catch (ESException e) {
				e.printStackTrace();
			}
		}

		return result.split(" ");

	}

	public static double evalPostfix(String[] postfix) throws NumberFormatException, ESException {
		StackArray<Double> plz = new StackArray<Double>();
		for (int i = 0; i < postfix.length; i++) {
			String str=postfix[i];
			if (!isOperator(str)) {
				plz.push(Double.parseDouble(str));
			}
			 else {
				String operator = str;
				double b = plz.pop();
				double a = plz.pop();
				if (operator.equals("+")) {
					plz.push(a + b);
				} else if (operator.equals("-")) {
					plz.push(a - b);
				} else if (operator.equals("*")) {
					plz.push(a * b);
				} else {
					plz.push(a / b);
				}
			}
		}
		return plz.pop();
	}

	public static boolean isOperator(String c) {
		if (c.equals("+") || c.equals ("-") || c.equals("/") || c.equals("*")) {
			return true;
		} else
			return false;
	}

	public static boolean prec(String a, String b) { // b to be used as top element
													// of stack
		if ((a.equals("*") || a.equals("/")) && (b.equals("+") || b.equals("-") || b.equals("("))) {
			return true;
		} else if ((a.equals("+") || a.equals("-")) && (b.equals("("))) {
			return true;
		} else if (a.equals(b) || (a.equals("/") && b.equals("*")) || (a.equals("*") && b.equals("/"))) {
			return false;
		}

		else {
			return false;
		}
	}
}
