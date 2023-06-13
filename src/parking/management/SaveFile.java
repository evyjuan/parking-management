/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parking.management;
import java.io.*;
import java.nio.file.*;

/**
 *
 * @author andre
 */
public class SaveFile {
    private static int KEY = 5;
    public static void saveFile(String name, String n, String emaili, String etime, int dtime, String pay, int amount, String dater, int p){
        File fp = new File(".//Account_Details.txt");
        if (!fp.exists()){
            try {
                fp.createNewFile();
            } catch (IOException e) {
                System.out.println("\nERROR: " + e.getMessage());
            }
        }
        
        try (BufferedWriter fwrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fp), "UTF-8"))) {
                //-------------------encrypting-------------------
                /*
                String encrypted_name = encryptString(name, KEY);
                String encrypted_n = encryptString(n, KEY);
                String encrypted_emaili = encryptString(emaili, KEY);
                String encrypted_etime = encryptString(etime, KEY);
                int encrypted_dtime = encryptInt(dtime, KEY);
                String encrypted_pay = encryptString(pay, KEY);
                int encrypted_amount = encryptInt(amount, KEY);
                String encrypted_dater = encryptString(dater, KEY);
                int encrypted_p= encryptInt(p, KEY);

                //-------------------saving-------------------
                fwrite.write(encrypted_name + "," + encrypted_n + "," + encrypted_emaili + "," +
                            encrypted_etime + "," + encrypted_dtime + "," +
                            encrypted_pay + "," + encrypted_amount + "," + 
                            encrypted_dater + "," + encrypted_p);
                fwrite.newLine();
                */
                
                //-------------------without encrytion-------------------
                fwrite.write(name + "," + n + "," + emaili + "," +
                            etime + "," + dtime + "," +
                            pay + "," + amount + "," + 
                            dater + "," + p);
                fwrite.newLine();
                
        }catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    private static String encryptString(String value, int encryptionKey) {
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += encryptionKey;
        }
        return new String(chars);
    }

    // Encrypt an integer value using XOR encryption
    private static int encryptInt(int value, int encryptionKey) {
        return value ^ encryptionKey;
    }
    
    /*
    private static String decryptString(String encryptedValue, int encryptionKey) {
        char[] chars = encryptedValue.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= encryptionKey;
        }
        return new String(chars);
    }

    // Decrypt an encrypted integer value using XOR decryption
    private static int decryptInt(int encryptedValue, int encryptionKey) {
        return encryptedValue ^ encryptionKey;
    }
    */
}
