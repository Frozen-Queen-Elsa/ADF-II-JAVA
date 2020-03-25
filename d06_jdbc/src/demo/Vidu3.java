/*
Xoa 1 lop hoc trong bang [tbBatch] cua CSDL [sem2_demo] theo ma so lop
 */
package demo;

import data.*;
import java.util.*;

public class Vidu3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String maso="";
        System.out.print("Nhap ma so cua lop hoc muon xoa: ");
        maso = sc.nextLine().trim();
        
        int n = BatchDAO.delete(maso);
        
        if(n>0){
            System.out.println("Da xoa lop hoc co ma so: " + maso);
        }
        else{
            System.out.println("Viec xoa lop hoc that bai !!!");
        }
    }
    
}
