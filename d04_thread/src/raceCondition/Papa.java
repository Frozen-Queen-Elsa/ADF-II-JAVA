/*
dong vai tro thread nap tien vo tai khoan dung chung
 */
package raceCondition;

import java.util.Random;


public class Papa implements Runnable{
    //khai bao bien dung chung giua cac thread
    public ATMaccount atm;

    public Papa() {
    }

    public Papa(ATMaccount atm) {
        this.atm = atm;
    }
       
    @Override
    public void run() {
        
        java.util.Random r = new Random();
        int sotien=0;
        
        //thread papa se nap tien vo the 8 lan
        for (int i = 0; i < 8; i++) {
            //moi lan nap vo 1 so tien ngau nhien tu 500-1000
            sotien = r.nextInt(500)+500; 
            
            //nap tien vo tk dung chung
            atm.deposit(sotien);            
            
                
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
