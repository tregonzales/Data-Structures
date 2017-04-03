//Tre Gonzales fgonzales19@cmc.edu
public class UseMessage {
  
  public static void main(String [] args)
{
  Message mg1=new Message();
  System.out.println("Sender: "+mg1.getSender()); 
  System.out.println("Receiver: "+mg1.getReceiver()); 
  System.out.println("Subject: "+mg1.getSubject()); 
  System.out.println("Date: "+mg1.getDate()); 
  System.out.println("Body: "+mg1.getBody());
  System.out.println("Length of message: "+mg1.getLength());
  
  mg1.setSender("Me");
  mg1.setReceiver("You");
  mg1.setSubject("school");
  mg1.setDate("9/5/2015");
  mg1.setBody("information");
  
    System.out.println("Sender: "+mg1.getSender()); 
  System.out.println("Receiver: "+mg1.getReceiver()); 
  System.out.println("Subject: "+mg1.getSubject()); 
  System.out.println("Date: "+mg1.getDate()); 
  System.out.println("Body: "+mg1.getBody());
  System.out.println("Length of message: "+mg1.getLength());
  
  Message mg2=new Message("Me", "you", "email", "kite", "9/5/2015");
  System.out.println("Sender: "+mg2.getSender()); 
  System.out.println("Receiver: "+mg2.getReceiver()); 
  System.out.println("Subject: "+mg2.getSubject()); 
  System.out.println("Date: "+mg2.getDate()); 
  System.out.println("Body: "+mg2.getBody());
  System.out.println("Length of message: "+mg2.getLength());
  
  mg2.setBody("It is too hot to hike and too cold to plunge.");
  System.out.println(mg2.isImportant());
  System.out.println(mg1.isImportant());
  
  mg1.print();
  System.out.println(mg1);
  Message[] messages=new Message[5];
  messages[0]=mg1;
  messages[1]=mg2;
  messages[2]=new Message();
  messages[3]=new Message();
  messages[4]= new Message();
  
  for(int i=0;i<messages.length;i++)
  {
    messages[i].print();
  }
  
  for(int i=0;i<messages.length;i++)
  {
    System.out.println(messages[i]);
  }
  
  for(int i=0;i<messages.length;i++)
  {
    if(messages[i].isImportant()==true)
      System.out.println(messages[i]);
  
}
}
}   


