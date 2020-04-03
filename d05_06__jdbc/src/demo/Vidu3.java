/*
    Xóa 1 lớp học trong [tbBatch] cùa CSDL [sem2_demo]theo mã số lớp học
 */
package demo;
import data.*;
import java.util.*;

public class Vidu3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String maso="";
        System.out.println("Nhập mã số lớp học muốn xóa: ");
        maso=sc.nextLine().trim();
        
        int n=BatchDAO.delete(maso);
        
        if(n>0){
            System.out.println("Đã xóa thành công lớp học có mã số "+maso);
        }
        else{
            System.out.println("Việc xóa lớp học có mã số "+maso+" đã thất bại !!");
        }
    }
    
}
