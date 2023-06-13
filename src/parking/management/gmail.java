/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.management;



import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author aditya
 */
public class gmail {
   
       
    static void sendMail(String recip)throws Exception {
         System.out.println("messge sending ");
        Properties pro=new Properties();
        pro.put("mail.smtp.auth","true");
        pro.put("mail.smtp.starttls.enable","true");
        pro.put("mail.smtp.host","smtp.gmail.com");
        pro.put("mail.smtp.port","587");
        
        
        
        String email="adityahfjc17@gmail.com";
        String password="Sudha@1970";
        
        Session session=Session.getInstance(pro,new Authenticator() {
         @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(email,password);
            }
        });
        
        Message message=prepareMessage(session,email,recip);
        Transport.send(message);
        System.out.println("messge sent successfully");
    
    
    }

    private static Message prepareMessage(Session session,String email,String recip) {
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recip));
            message.setSubject("PARKING ZONE");
            message.setText("your expected time limit for the parking zone is over.....please call to update your time limit");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(gmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static void sendail(String s) {
          System.out.println("messge sending ");
        Properties pro=new Properties();
        pro.put("mail.smtp.auth","true");
        pro.put("mail.smtp.starttls.enable","true");
        pro.put("mail.smtp.host","smtp.gmail.com");
        pro.put("mail.smtp.port","587");
        
        
        
        String email="adityahfjc17@gmail.com";
        String password="Sudha@1970";
        
        Session session=Session.getInstance(pro,new Authenticator() {
         @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(email,password);
            }
        });
        
        Message message=prepareMessage(session,email,s);
        try {
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(gmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("messge sent successfully");
    
    
    }

   
    }

