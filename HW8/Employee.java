//Tre Gonzales fgonzales19@cmc.edu
import java.util.*;

public class Employee implements Comparable, Comparator {
	private String name;
	private int salary;

	public Employee(String n, int s) {
		name = n;
		salary = s;
	}

	public String toString() {
		return name + ", " + salary;
	}

	public int compareTo(Object o) {
		Employee e = (Employee) o;
		if (this.name.compareTo(e.name) < 0) {
			return -1;
		} else if (this.name.compareTo(e.name) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	

	public int compare(Object a, Object o) {
		Employee b = (Employee) a;
		Employee e = (Employee) o;
		if (b.salary < e.salary) {
			return -1;
		} else if (b.salary == e.salary) {
			return 0;
		} else {
			return 1;
		}
	}

	public static <E> void heapSortName(List<E> aList) {

		Heap<E> aHeap = new Heap<E>(aList.size());

		for (E element : aList) {
			aHeap.add(element);
		}
		aList.clear();

		// Copy elements, smallest to largest, from heap to aList:
		while (aHeap.size() > 0) {
			aList.add(aHeap.removeMin());
		}
	}
	
	public static <E> void heapSortSalary(List<E> aList) {

		Heap<E> aHeap = new Heap<E>(aList.size(), new Employee("Phil", 14));

		for (E element : aList) {
			aHeap.add(element);
		}
		aList.clear();

		// Copy elements, smallest to largest, from heap to aList:
		while (aHeap.size() > 0) {
			aList.add(aHeap.removeMin());
		}
	}


	public static void main(String[] args) {
		Employee e1 = new Employee("David", 10);
		Employee e2 = new Employee("Tre", 21);
		Employee e3 = new Employee("Luke", 12);
		Employee e4 = new Employee("Nick", 8);
		Employee e5 = new Employee("Lucipher", 15);
		Employee e6 = new Employee("Pablo", 18);
		Employee e7 = new Employee("Natalie", 26);
		LinkedList<Employee> list = new LinkedList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		System.out.println(list);
		heapSortName(list);
		System.out.println(list);
		ArrayList<Employee> list2 = new ArrayList<Employee>();
		list2.add(e1);
		list2.add(e2);
		list2.add(e3);
		list2.add(e4);
		list2.add(e5);
		list2.add(e6);
		list2.add(e7);
		System.out.println(list2);
		heapSortSalary(list2);
		System.out.println(list2);

	}

}
