//Tre Gonzales fgonzales19@cmc.edu
public class UseIpad {
  
  
  public static void main(String[] args) { 
    
    Ipad bob=new Ipad("bob", 5 , 8, 100, true, "red", 3);
    Ipad bill=new Ipad("bill", 6, 32, 200, false, "yellow", 5);
    Ipad jill=new Ipad("jill", 10, 64, 300, true, "blue", 7);
    Ipad alice=new Ipad("alice", 12, 12, 400, false, "gold", 9);
    Ipad jane=new Ipad("jane", 20, 10, 500, true, "white", 10);
  
    Ipad.allIpads();
    Ipad.remove(1);
    Ipad.allIpads();
    Ipad.remove(2);
    Ipad.allIpads();
    Ipad.remove(0);
    Ipad.allIpads();

    
    
  }

 
  
}
