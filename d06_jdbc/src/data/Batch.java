/*
Mo ta cau truc cua bang tbBatch trong CSDL sem2_demo
 */
package data;

import java.util.*;

public class Batch {

    public String batchNo, desc;
    public int fee;

    public Batch() {
    }

    public Batch(String batchNo, String desc, int fee) {
        this.batchNo = batchNo;
        this.desc = desc;
        this.fee = fee;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ma lop hoc: ");
        batchNo = sc.nextLine().trim();
        System.out.print("nhap chuong trinh hoc: ");
        desc = sc.nextLine().trim();
        System.out.print("nhap hoc phi: ");
        fee = Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", batchNo, desc, fee);
    }
    
    

}
