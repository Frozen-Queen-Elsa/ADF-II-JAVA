/*
    Mô tả cấu trúc của bảng tbBatch trong CSDL sem2_demo
 */
package data;
import java.util.*;

public class Batch {
    public String batchNo,desc;
    public int fee;

    public Batch() {
    }

    public Batch(String batchNo, String desc, int fee) {
        this.batchNo = batchNo;
        this.desc = desc;
        this.fee = fee;
    }
    
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập mã lớp học : ");
        batchNo=sc.nextLine().trim();
        System.out.println("Nhập mô tả chương trình học : ");
        desc=sc.nextLine().trim();
        System.out.println("Nhập học phí : ");
        fee=Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    public String toString() {
        return String.format("%s ,%s,%d",batchNo,desc,fee);
    }
    
    
}
