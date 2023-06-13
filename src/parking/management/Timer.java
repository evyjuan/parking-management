/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.management;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import static parking.management.priority.dtime;

/**
 *
 * @author aditya
 */
public class Timer extends Thread{
    public void run(){
			
			
			
			while(priority.front!=-1){
                               


				try{
					int min;
                                        String date ;
					while(true){
						 min =priority.peekd();
                                                 
						int minute =getCurrentT();
                                                String cDate=getCurrentD();
						System.out.println("current"+minute);
						System.out.println("min"+minute);
						
                                               
						if(min==minute  ){
                                                            String s=priority.peeke();
							System.out.println("yes "+min);
                                                           gmail.sendail(s);
                                                            vehicle rm =new vehicle();
                                                           JOptionPane.showMessageDialog(rm, dtime[priority.front]);
							break;
						}
						TimeUnit.SECONDS.sleep(4);
					}
				}
				catch(Exception e){
					System.out.println("sdfg"+e);
				}
			priority.deque();
                       
                       
				
			}
			
		}
	
	public static int getCurrentT(){   // gets current time
	Calendar now = Calendar.getInstance();
	int minute = now.get(Calendar.MINUTE)+now.get(Calendar.HOUR_OF_DAY)*60;
	return minute;
	}

    private String getCurrentD() {
        Calendar now = Calendar.getInstance();
         Date date = now.getTime();
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String strDate1 = DateFormat.getDateInstance().format(date);
          return strDate1;
    }
	
}
