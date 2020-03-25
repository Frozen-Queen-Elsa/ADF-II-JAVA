/*
Thay doi thong tin chi tiet (chuong trinh hoc, hoc phi) cua 1 lop hoc trong bang [tbBatch] cua CSDL [sem2_demo]
 */
package demo;


import data.*;
import java.util.*;
public class Vidu4 {
    /*
    vi du : (0908, ACCP 2007, 900) 
    => (0908, chuong trinh chuyen doi, 760)
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Batch b = new Batch();
        System.out.println("Nhap thong tin cua lop hoc muon thay doi : ");
        System.out.print("Ma cua lop hoc : ");
        b.batchNo = sc.nextLine().trim();
        System.out.println("===========");
        System.out.print(" >> chuong trinh muon doi ? : ");
        b.desc = sc.nextLine();
        System.out.print(" >> hoc phi muon doi ? ");
        b.fee = Integer.parseInt(sc.nextLine().trim());
        
        int r = BatchDAO.update(b);
        
        if(r > 0){
            System.out.println("Da thay doi noi dung thanh cong");
        }
        else{
            System.out.println("Thay doi that bai ...");
        }
    }
    
}
