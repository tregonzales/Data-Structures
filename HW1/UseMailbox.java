/**
 * Auto Generated Java Class.
 */
public class UseMailbox {
  
  
  public static void main(String[] args) { 
    
  
  Message m=new Message("me", "you", "hi", "whats up", "9/7");
  Message n=new Message("me", "you", "hi", "whats up", "9/7");
  Message a=new Message("me", "you", "hi", "whats up", "9/7");
  Message b=new Message("me", "you", "hi", "whats up", "9/7");
    Message e=new Message("me", "you", "hi", "whats up", "9/7");
    Message z=new Message("me", "you", "hi", "whats up", "9/7");
  Mailbox jane=new Mailbox("jane");
  jane.receive(a);
    jane.receive(n);
    jane.receive(b);
    jane.receive(m);
    

jane.receive(e);
    System.out.println("Jane's mailbox");
  jane.seeMessages();
  System.out.println();
  
  jane.delete(n);
  jane.delete(b);
      System.out.println("Jane's mailbox");
jane.seeMessages();
jane.delete(z);
System.out.println();

System.out.println(jane.searchMessage(1));
System.out.println(jane.searchMessage(7));
System.out.println(jane.searchMessage(2));
          System.out.println();

  Message l=new Message("me", "you", "hi", "whats up", "9/7");
  Message o=new Message("me", "you", "hi", "whats up", "9/7");
  Message p=new Message("me", "you", "hi", "whats up", "9/7");
  Message q=new Message("me", "you", "hi", "whats up", "9/7");
    Message r=new Message("me", "you", "hi", "whats up", "9/7");
  Mailbox bill=new Mailbox("Bill");
  
            System.out.println("Bill's mailbox");
  bill.receive(l);
    bill.receive(o);
      bill.receive(p);
        bill.receive(q);
          bill.receive(r);
          
          bill.seeMessages();
                    System.out.println();
  
  bill.delete(q);
  bill.delete(p);
      System.out.println("Bill's mailbox");
bill.seeMessages();
bill.delete(z);
System.out.println();

System.out.println(bill.searchMessage(1));
System.out.println(bill.searchMessage(7));
System.out.println(bill.searchMessage(2));
          

   



  


  

  }
  
}
