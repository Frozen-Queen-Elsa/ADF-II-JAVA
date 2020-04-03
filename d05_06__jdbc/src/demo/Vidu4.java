/*
    Thay đổi thông tin chi tiết (chương trình học,học phí) của 1 lớp học trong bảng [tbBatch] của CSDL [sem2_demo]
 */
package demo;

import data.*;
import java.util.*;

public class Vidu4 {
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Batch b=new Batch();
        System.out.println("Nhập thông tin của lớp học muốn thay đổi");
        System.out.println(">> Nhập mã lớp học");
        b.batchNo=sc.nextLine().trim();
        System.out.println("===========");
        System.out.println(">> Chương trình muốn thay đổi ");
        b.desc=sc.nextLine().trim();
        System.out.println(">> Học phí muốn thay đổi");
        b.fee=Integer.parseInt(sc.nextLine().trim());
        
        int r=BatchDAO.update(b);
        if(r>0){
            System.out.println("Đã thay đổi chương trình học va học phí thành công");
        }
        else{
            System.out.println("Thay đổi thất bại ....");
        }
    }
    
}
