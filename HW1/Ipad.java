//Tre Gonzales fgonzales19@cmc.edu
public class Ipad {
  
private String name; //name
private double price; //price
private int displaySize; //display size
private int memory; //memory capacity
private boolean wireless; //cellular network capability
private String color; //color
private static int serialCode=0; //serial code
private static Ipad[] array=new Ipad[5];
private static int IpadCount=0;
private int code;
private int apps;
public Ipad(String n, int d, int m, int p, boolean w, String c, int a)
{
  name=n; displaySize=d; memory=m; wireless=w; color=c;
  price=p; 
  apps=a;
  IpadCount+=1;
  code=getCode();
  array[IpadCount-1]=this;

}
public static Ipad[] getArray()
{
 return array;
}
public int getCode()
{
  serialCode+=1;
  return serialCode;
}
public String getName()
{
  return name;
}
public void setName(String n)
{
  name=n;
}

public void setColor(String c)
{ 
  color=c;
}
 public int getMemory()
 {
   return memory;
 }
 public boolean getWireless()
 {
   return wireless;
 }
 public int getSerialCode()
 {
   return serialCode;
 }

 public static void remove(int x)
 {
  for(int i=x;i<array.length-1; i++)
   array[i]=array[i+1];
  array[array.length-1]=null;
  IpadCount-=1;
  
 }
public int getCount()
{
 return IpadCount;
}

public void installApp(int x)
{
 apps+=x;
}
public int getApps()
{
 return apps;
 
}
public static int allApps()
{
 int a=0;
 for(int i=0;i<IpadCount;i++)
  a=a+array[i].getApps();
 return a;
}
public String toString()
{

 return "(Name: "+name+", Serial Code: "+code+", Display size: "+displaySize+", Memory: "+memory+", Wireless: "+wireless+", Color: "+color+", Apps: "+apps+", Price: "+price+")";
}
public static void allIpads()
{
  for(int i=0;i<array.length;i++)
    {
    if(array[i]!=null)
     System.out.println(array[i]);
    }
    System.out.println("The total number of apps: "+Ipad.allApps());

}

}
