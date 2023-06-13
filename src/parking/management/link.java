










/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.management;

/**
 *
 * @author aditya
 */
public  class link {
   static node header;
   public   static void insert( String nam, String n,String emaili, String etime,String dtime,String  pay, int ammoun,String dater, int p)
   {
   node node =new node();
   node.name=nam;
            node.no=n;
             node.emailid=emaili;

              node.etime=etime;

               node.dtime=dtime;

                node.payt=pay;

                 node.ammount=ammoun;
 node.date=dater;

  node.pn=p;
  node.next=null;
  if(header==null)
  {
  header=node;
  
  
  }
  else
  {
  node.next=header;
  header=node;
  
  }

                 

   
   
   
   
   }
   public  void traverse()
   {
   node p;
   if(header==null)
   {
   return;
   }
   p=header;
   while(p!=null)
   {
      
  
   p=p.next;
   }

   
   }
   
}