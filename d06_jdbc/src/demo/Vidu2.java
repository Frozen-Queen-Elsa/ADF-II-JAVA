/*
Them 1 lop hoc moi (Batch) vo bang [tbBang] cua CSDL [sem2_demo]
 */
package demo;

import data.*;
import java.util.*;
public class Vidu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Batch b = new Batch();
        
        System.out.println("Nhap thong tin lop hoc moi: ");
        System.out.print(" >> nhap ma lop: "); 
        b.batchNo = sc.nextLine().trim();
        System.out.print(" >> nhap chuong trinh: "); 
        b.desc = sc.nextLine().trim();
        System.out.print(" >> nhap hoc phi: "); 
        b.fee = Integer.parseInt(sc.nextLine().trim());

        int kq = BatchDAO.insert(b);
        
        if(kq>0){
            System.out.println("Them 1 lop hoc moi thanh cong");
        }
        else{
            System.out.println("Them lop hoc: that bai !!!");
        }
    }
    
}
