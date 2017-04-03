//Tre Gonzales fgonzales19@cmc.edu

public class Message {
  
  private String from, to, subject, date, body;
  private static int idgen=0;
  private int id;
  
  public String getSender() //returns sender
  {
    return from;
  }
  public int getID()
  {
    return id;
  }

  public String getReceiver() //returns receiver
  {
    return to;
  }
  public String getSubject() //returns subject
  {
    return subject;
  }
  public String getDate() //returns date
  {
    return date;
  }
  public String getBody() //returns body of message
  {
    return body;
  }
  public int getLength() //returns length of emial body in characters
  {
    return body.length();
  }
  
  public Message(String f, String t, String s, String b, String d) //constructor that takes arguments for all fields
  {   
    from=f; to=t; subject=s; body=b; date=d; id=generateID();
  }
  public int generateID()
  {
    idgen+=1;
    return idgen;
  }
  
 public void setSubject(String s) //sets the subject
 {
   subject=s;
 }
 public void setReceiver(String r) //sets the receiver
 {
  to=r;
 }
 public void setSender(String f) //sets the sender
 {
   from=f;
 }
  public void setBody(String b) //sets the body of the message
  {
   body=b;
  }
  public void setDate(String d) //sets the date
  {
    date=d;
  }
  
 public Message() //constructor with default values
 {
   from="";
   to="";
   date="";
   subject="";
   body="";
 }
 
 public boolean isImportant()
 {
   if((body.indexOf("kite")!=-1 || (body.indexOf("plunge")!=-1)) && date.indexOf("2015")!=-1)
     return true;
     else 
       return false;
 }
   
 public void print()
 {
   System.out.println("From: "+from);
   System.out.println("To: "+to);
   System.out.println("Subject: "+subject);
   System.out.println("Date: "+date);
   System.out.println("Body: "+body);
 }
 public String toString()
 {
   return "To: " +to+ " From: "+from+" Subject: "+subject+" ID#: "+id;
 }

  
}
