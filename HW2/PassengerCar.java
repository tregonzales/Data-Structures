//Tre Gonzales fgonzales19@cmc.edu
public class PassengerCar extends Car {
  
  private int numPassengers;
  private int numDoors;
  private String transmissionType;
  
  public boolean isComfortable(Car c) //checks if the car is comfortable
  {
    if(numPassengers>=5&&numDoors>=4&&(2015-getYear())<=5)
      return true;
    else return false;
}
  
  public PassengerCar(String m, String mo, int y, String c, int n, int np, int nd, String trans, String s) //constructor of passenger car
  {
    super(m,mo,y,c,n,s);
    numPassengers=np;
    numDoors=nd;
    transmissionType=trans;
  }
  
  public int getNumPassengers()
  {
    return numPassengers;
  }
  public int getNumDoors()
  {
    return numDoors;
  }
 public String getTrans()
 {
   return transmissionType;
 }
  
  public boolean isHardToDrive() //tests if the car is hard to drive by evaluating the string transmission
  {
    if(transmissionType.equals("manual"))
       return true;
       else return false;
  }
  
    public int compareTo(Car c) //compares passenger cars
  {
    	
      
    if(getYear()+numPassengers+numDoors<((PassengerCar)c).getYear()+((PassengerCar)c).getNumPassengers()+((PassengerCar)c).getNumDoors())
      return -1;
    else if(getYear()+numPassengers+numDoors==((PassengerCar)c).getYear()+((PassengerCar)c).getNumPassengers()+((PassengerCar)c).getNumDoors())
      return 0;
    else 
      return 1;
}
    
    public static void main(String [ ] args)
    {
      PassengerCar p=new PassengerCar("Dodge", "avenger", 1998, "Black", 3, 5, 2, "automatic", "Tre");
      System.out.println(p.getMake());  System.out.println(p.getModel());  System.out.println(p.getYear());
       System.out.println(p.getColor());  System.out.println(p.getNumRepairs());   System.out.println(p.getNumPassengers());
        System.out.println(p.getNumDoors()); System.out.println(p.isHardToDrive());
        PassengerCar e=new PassengerCar("Dodge", "avenger", 2000, "Black", 3, 5, 2, "manual", "Tre");
System.out.println(e.isHardToDrive());
        PassengerCar d=new PassengerCar("Dodge", "avenger", 2000, "Black", 3, 5, 2, "automatic", "Tre");
              PassengerCar l=new PassengerCar("Dodge", "avenger", 1998, "Black", 3, 5, 2, "automatic", "Tre");
        System.out.println(d.compareTo(p));
                System.out.println(p.compareTo(d));
                System.out.println(l.compareTo(p));
        
        
    }



  
      
                     

}
