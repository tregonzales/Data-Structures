public class Mailbox
{
  private String name;
  private Message [] inbox=new Message[5];
  private Message [] delbox=new Message[5];
  private int inCount=0;
  private int delCount=0;
  

  
  public Mailbox(String n)
  {
    name=n;
  }
  
  public void sortInbox()
  {
    
   for(int i=0;i<inCount-1;i++)
   { 
     int minPos=i;
       for(int x=minPos;x<inCount;x++)
     {
     if(inbox[x].getID()<inbox[minPos].getID())
   {
     Message temp=inbox[minPos];
     inbox[minPos]=inbox[x];
     inbox[x]=temp;   
  }
  }
  }
  }
  
  public void receive(Message m)
  {
    inCount++;
 inbox[inCount-1]=m;
 sortInbox();
  }
  
  public void getinCount()
  {
    System.out.println(inCount);
  }
  
  public void delete(Message m)
  {
    
    
    for(int i=0;i<=inCount;i++)
    {
      if(i==inCount)
      System.out.println("Message not in inbox");
      
      else if(inbox[i]==m)
    {
      delCount++;
      inbox[i]=inbox[inCount-1];
      inbox[inCount-1]=null;
      inCount-=1;
      delbox[delCount-1]=m;
      sortInbox();
      break;
    }
    }
  }
  
  public String searchMessage(int x)
  {
    for(int i=0;i<inCount;i++)
      if(inbox[i].getID()==x)
      return "Id "+x+" is in inbox";
    for(int i=0;i<delCount;i++)
      if(delbox[i].getID()==x)
      return "Id "+x+" is in delbox";
    return "Id "+x+" is in neither";
  }
  
  public void seeMessages()
  {
   
    System.out.print("Inbox: ");
    for(int i=0;i<inCount;i++)
    System.out.print(inbox[i].getID()+" ");
    System.out.print("Delbox: ");
    for(int i=0;i<delCount;i++)
      System.out.println(delbox[i].getID()+" ");
  }
}