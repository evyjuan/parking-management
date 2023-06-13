/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.management;

import java.util.Calendar;
import static parking.management.priority.dtime;
import static parking.management.priority.front;
import static parking.management.priority.name;

/**
 *
 * @author aditya
 */
public class finelink {
  static  String dtm;
       static   Calendar cal=Calendar.getInstance();
   static  int pi= cal.get(Calendar.HOUR_OF_DAY);
  static  int  mi= cal.get(Calendar.MINUTE);
  

   static   finenode head;
   public  void insert( String nam, String n,String emaili, String etime,int dtime,String  pay, int ammoun,String dater, int p)
   {
   finenode nod =new finenode();
   nod.name=nam;
            nod.no=n;
             nod.emailid=emaili;

              nod.etime=etime;

               nod.dtime=dtime;

                nod.payt=pay;

                 nod.ammount=ammoun;
 nod.date=dater;

  nod.pn=p;
  nod.next=null;
  if(head==null)
  {
  head=nod;
  
  
  }
  else
  {
  nod.next=head;
  head=nod;
  
  }
System.out.print("inserted successfully");
                  System.out.println("name"+nod.name);
  System.out.println("no"+nod.no);
System.out.println("email"+nod.emailid);
System.out.println("etime"+nod.etime);
System.out.println("dtime"+nod.dtime);

   }
    public static void deletespecific(int p)
    {
    finenode s,q;
    // link m =new link(); 
    if(head==null)
    {
    
    return;
    }
    s=head;
    q=head;
    if(s.next==null)
    {
    if(s.pn==p)
    {
        dtm=pi+":"+mi;

        viewlink.insert(s.name,s.no, s.emailid, s.etime,dtm, s.payt, s.ammount,s.date,s.pn);
        head=null;
        return;

    }
    }
    while(s!=null)
    {
    if(s.pn==p)
    {
         dtm=pi+":"+mi;

         viewlink.insert(s.name,s.no, s.emailid, s.etime, dtm, s.payt, s.ammount,s.date,s.pn);
    q.next=s.next;
    break;
    
    }
    q=s;
    s=s.next;
    
    }
    if(s==null)
    {
    return;
    }
    }
      public  String[] find(int p)
   {
    finenode s,q;
 
    // viewlink m =new viewlink(); 
    if(head==null)
    {
         System.out.print("find of finelink is empty");
            System.out.print("returning 2");
    String []so={"2"};
    return so;
    }
    s=head;
    q=head;
    if(s.next==null)
    {
    if(s.pn==p)
    {
        String dtim =s.dtime/60+":"+s.dtime%60;
                     System.out.println("name"+s.name);
  System.out.println("no"+s.no);
System.out.println("email"+s.emailid);
System.out.println("etime"+s.etime);
System.out.println("dtime"+s.dtime);

      String []so={s.name,s.etime,dtim,s.no};
        return so;

    }
    else
    {
    
     String []so={"2"};
             System.out.print("returning 2");
    return so;
    }
    }
    while(s!=null)
    {
    if(s.pn==p)
    {
          String dtim =s.dtime/60+":"+s.dtime%60;
            System.out.println("name"+s.name);
  System.out.println("no"+s.no);
System.out.println("email"+s.emailid);
System.out.println("etime"+s.etime);
System.out.println("dtime"+s.dtime);

      String []so={s.name,s.etime,dtim,s.no};

              return so;
    
    
    }
    q=s;
    s=s.next;

    
    }
    if(s==null)
    {
         String []so={"2"};
           System.out.print("returning 2");
    return so;

   
    }
    
      String []so={"2"};
       System.out.print("returning 2");
      return so;

    
      
    }
   public  void traverse()
   {
   finenode p;
   if(head ==null)
   {
   return;
   }
   p=head;
   while(p!=null)
   {
      
  System.out.println(p.name);
  System.out.println(p.no);
System.out.println(p.emailid);
System.out.println(p.etime);
System.out.println(p.dtime);

   p=p.next;
   }

   
   }    
}
