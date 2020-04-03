/*
dong vai tro thread rut tien ra khoi tai khoan dung chung
 */
package raceCondition;

import java.util.Random;


public class Son implements Runnable{

    public ATMaccount atm;

    public Son() {
    }

    public Son(ATMaccount atm) {
        this.atm = atm;
    }
    
    
    @Override
    public void run() {
        java.util.Random r = new Random();
        int sotien=0;
        
        //thread son se rut tien 10 lan de xai
        for (int i = 0; i < 10; i++) {
            //moi lan rut 1 so tien ngau nhien tu 300-1000
            sotien = r.nextInt(700)+300; 
                       
            //rut tien ra khoi tk dung chung
            atm.withdraw(sotien);            
            
            
            try {
                Thread.sleep(350);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
