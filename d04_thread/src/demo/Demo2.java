/*
    Thử nghiệm thread M1 và Thread M2
 */
package demo;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Demo2 {

    public static void main(String[] args) {
        // Khởi tạo thread DemM1
        Thread t1=new DemM1();
        //Đặt tên cho t1
        t1.setName("Iris");
        
        //Khởi tạo thread DemM2
        Thread t2=new Thread(new DemM2());
        //Đặt tên cho t2
        t2.setName("Seohyun");
        
        //Ra lệnh cho t1 và t2 hoạt động;
        t1.start();
        t2.start();
        
        int dem = Thread.activeCount();
        
        System.out.println("Số lượng thread đang hoạt động "+dem);
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("\n****** MAIN THREAD FINISHED !!!******");
    }
    
}
