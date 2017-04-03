//Tre Gonzales fgonzales19@cmc.edu
public abstract class Car implements Comparable<Car> {
  
  private String make;
  private String model;
  private int year;
  private String color;
  private int numRepairs;
  private String owner;
  


  public void repair() //increments the number of repairs
  {
    numRepairs++;
  }
  
  public void sellTo(String s)
  {
    owner=s;
  }
  
  public boolean isReliable(Car c) //checks if the car is reliable
  {
    if(((double)numRepairs/(double)(2015-year))<=1)
      return true;
    else return false;
    
  }
  
  public Car() //generic constructor
  {
    make="Ford"; model="T-150"; year=1960; color="grey"; numRepairs=10; owner="no one";
  }
  
  public Car (String m, String mo, int y, String c, int n, String s) //constructor with user variables
  {
    make=m; model=mo; year=y; color=c; numRepairs=n; owner=s;
  }
  public String getMake()
  {
    return make;
  }
  public String getModel()
  {
    return model;
  }
  public int getYear()
  {
    return year;
  }
  public String getColor()
  {
    return color;
  }
  public int getNumRepairs()
  {
    return numRepairs;
  }
  
      
  
  
  
}