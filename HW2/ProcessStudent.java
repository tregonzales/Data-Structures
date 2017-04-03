//Tre Gonzales fgonzales19@cmc.edu
	import java.util.*; 
	import java.io.*;
import java.io.File;
import java.io.IOException;

public class ProcessStudent {
	public static ArrayList<Student> list=new ArrayList<Student>();

	public static double averageGPA()
	{
		double allGPAs=0;
		for(Student s:list)
			allGPAs+=s.getGpa();
		return allGPAs/list.size();
		
	}
	public static Student highestGPA(String state)
	{
		Iterator <Student> itr = list.iterator();
		Student best=new Student();
		double maxGPA=0;
		
		while(itr.hasNext())
		{
			Student s=itr.next();
			if(s.getState().equals(state))
			if(s.getGpa()>maxGPA)
			{
				maxGPA=s.getGpa();
				best=s;
		}
		}
		if(maxGPA==0)
			return (Student) null;
		else
	return best;
	}
	
	public static ArrayList<Student> studentsMajoringIn(String m)
	{
		ArrayList<Student> majors=new ArrayList<Student>();
		for(Student s:list)
			if(s.getMajor().equals(m))
				majors.add(s);
		return majors;
	}
	
	public static ArrayList<Student> studentsWithAreaCode(String n)
	{
		ArrayList<Student> phones=new ArrayList<Student>();
		for(Student s:list)
			if(s.getPhone().startsWith(n))
				phones.add(s);
		return phones;
	}
	
	public static String histogram()
	{
		String fin="State, No of students \n";
		ArrayList<Student> st=list;
		while(st.size()>0)
		{
			int count=0;
			String curState=st.get(st.size()-1).getState();
		for(int x=st.size()-1;x>=0;x--)
		{
			
			if(st.get(x).getState().equals(curState))
			{
				count++;
				st.remove(x);
			}
		
		
		}
		fin=fin+curState+", "+count+"\n";
		}
		return fin;
	}
	
	
	    public static void main(String[] args) throws IOException {

	        String inputFileName = "./s0.txt";
	        //String inputFileName = ".\test.txt"; // or this

	        Scanner input = new Scanner(new File(inputFileName));
input.nextLine();

	        while (input.hasNext()) {
String name=input.nextLine().substring(6);
System.out.println(name);
String address=input.nextLine().substring(9)+" "+input.nextLine();
String state=input.nextLine();
System.out.println(state);
address=address+" "+state+" "+input.nextLine();
System.out.println(address);
String phone=input.nextLine().substring(7);
System.out.println(phone);
String i=input.nextLine().substring(4);
int id=Integer.parseInt(i);
System.out.println(id);
String major=input.nextLine().substring(7);
System.out.println(major);
String g=input.nextLine().substring(5);
double gpa=Double.parseDouble(g);
System.out.println(gpa);
System.out.println("");
list.add(new Student(name, address, phone, id, major, gpa, state));
input.nextLine();

	        }
System.out.println(list);	
System.out.println("average gpa:"+averageGPA());
System.out.println("highest gpa in south carolina:"+highestGPA("South Carolina"));
System.out.println("highest gpa in hawaii:"+highestGPA("Hawaii"));
System.out.println("students majoring in history:"+studentsMajoringIn("History"));
System.out.println("students with area code 802:"+studentsWithAreaCode("802"));
System.out.println(histogram());
	 
	        
	            
	        
	    }
	}
	

