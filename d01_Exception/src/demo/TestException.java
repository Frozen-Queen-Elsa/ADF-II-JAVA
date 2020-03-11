/*
    Lớp kiểm thử lớp MyException
 */
package demo;

import basic.MyException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestException {

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                System.out.println("Nhập vào 1 số >0");
                int n= Integer.parseInt(sc.nextLine().trim());

                if(n<0){

                        throw new MyException("Nhập sai rồi !! Nhập số > 0 mới đúng ");
                } 
                break;
            }catch (MyException ex) {
                    System.out.println("Lỗi : "+ex.getMessage());
                }
        }
        
    }
    
}
