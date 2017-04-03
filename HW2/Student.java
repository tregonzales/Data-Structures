//Tre Gonzales fgonzales19@cmc.edu	
public class Student {
private String name;
private String address;
private String phone;
private int id;
private String major;
private double gpa;
private String state;
public Student(String n, String a, String p, int i, String m, double g, String s)
{
	setName(n); setAddress(a); setPhone(p); setId(i); setMajor(m); setGpa(g); setState(s);
}
public Student()
{

}

public String toString()
{
	return name+" "+id+ " "+gpa+" "+state;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public double getGpa() {
	return gpa;
}
public void setGpa(double gpa) {
	this.gpa = gpa;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

}