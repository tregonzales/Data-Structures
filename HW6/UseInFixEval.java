//Tre Gonzales fgonzales19@cmc.edu	

public class UseInFixEval {
	public static void main(String [] args) throws NumberFormatException, ESException {
		String math="1 + 2 * 3";
		String [] ma=math.split(" ");
		for(int i=0;i<ma.length;i++) {
			System.out.print(ma[i]);
		}
		
		
		System.out.println("");;
		
		String [] postfix=InFixEval.toPostfix(ma);
		for(int i=0;i<postfix.length;i++) {
			System.out.print(postfix[i]);
		}
		System.out.println("");;
		System.out.println(InFixEval.evalPostfix(postfix));
		
		System.out.println("");
		
		String a="3 + 5 - 6 / 2 * 7 ";
		String [] a1=a.split(" ");
		for(int i=0;i<a1.length;i++) {
			System.out.print(a1[i]);
		}
		
		System.out.println("");
		
		String [] postfix3=InFixEval.toPostfix(a1);
		for(int i=0;i<postfix3.length;i++) {
			System.out.print(postfix3[i]);
		}
		System.out.println("");;
		System.out.println(InFixEval.evalPostfix(postfix3));
		
		System.out.println("");;
		
		String two="1 * ( 2 + 3 )";
		String [] two1=two.split(" ");
		for(int i=0;i<two1.length;i++) {
			System.out.print(two1[i]);
		}
		
		System.out.println("");;
		
		String [] postfix2=InFixEval.toPostfix(two1);
		for(int i=0;i<postfix2.length;i++) {
			System.out.print(postfix2[i]);
		}
		System.out.println("");;
		System.out.println(InFixEval.evalPostfix(postfix2));
	}

}
