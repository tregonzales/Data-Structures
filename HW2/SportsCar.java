//Tre Gonzales fgonzales19@cmc.edu
public class SportsCar extends Car {
  
  private int maxSpeed;
  private int numSeconds;
  private boolean isConvertible;
  
  public SportsCar(String m, String mo, int y, String c, int n, String s, int max, int num, boolean i)
  {
    super(m,mo,y,c,n,s);
    maxSpeed=max; numSeconds=num; isConvertible=i;
  }
  public int getMax()
  {
    return maxSpeed;
  }
 
  public int getSec()
  {
    return numSeconds;
  }
  
  public boolean isShazzy()
  {
    if(maxSpeed>=100&&isConvertible==true&&(getColor().equals("red")||getColor().equals("yellow")||getColor().equals("pink"))&&numSeconds<=4)
      return true;
    else return false;
  }
  
  public int compareTo(Car c)
  {
   
    if(getYear()+getMax()<((SportsCar)c).getYear()+((SportsCar)c).getMax())
      return -1;
    else if(getYear()+getMax()==((SportsCar)c).getYear()+((SportsCar)c).getMax())
      return 0;
    else
      return 1;
  }
  public static void main(String [] args)
  {
    SportsCar p = new SportsCar("Porsche", "911", 2015, "red", 0, "bill", 220, 5, false);
    System.out.println(p.getMake());  System.out.println(p.getModel());  System.out.println(p.getYear());
       System.out.println(p.getColor());  System.out.println(p.getNumRepairs());  System.out.println(p.getMax());
       System.out.println(p.getSec()); System.out.println(p.isShazzy());
       SportsCar q = new SportsCar("Porsche", "911", 2015, "red", 0, "bill", 220, 3, true);
System.out.println(q.isShazzy());
       SportsCar d = new SportsCar("Toyota", "Corolla", 2015, "red", 0, "bill", 160, 5, false);
              SportsCar e = new SportsCar("Toyota", "Corolla", 2015, "red", 0, "bill", 160, 5, false);
       System.out.println(p.compareTo(d));
       System.out.println(d.compareTo(p));
       System.out.println(d.compareTo(e));
  }
                     

  
}
