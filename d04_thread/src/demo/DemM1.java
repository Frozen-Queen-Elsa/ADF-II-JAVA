/*
    Đây là 1 thread - in ra 1 chuỗi số nguyên từ 0-9
 */
package demo;

import java.util.logging.Level;
import java.util.logging.Logger;


public class DemM1 extends Thread{

    
    //Hàm run sẽ chứa các câu lệnh mà thread phải thực hiện 
    @Override
    public void run() {
        String ten=Thread .currentThread().getName();
        System.out.println("Tên của Thread : "+ten);
        System.out.println(">>10 số nguyên đầu tiên [0-9]");
        for(int i=0;i<10;i++){
            System.out.printf("\t "+ten+": %3d \n",i);
            try {
                Thread.sleep(500); // nghỉ 500 ms 
            } catch (InterruptedException ex) {
                System.out.println("Lỗi: "+ex.getMessage());
            }
        }
    }
    
}
