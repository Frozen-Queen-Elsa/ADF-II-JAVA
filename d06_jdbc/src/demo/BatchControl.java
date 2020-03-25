/*
Quan ly cac lop hoc duoc luu trong bang [tbBatch] cua CSDL [sem2_demo]:
- xem danh sach
- them 1 lop hoc moi
- xoa 1 lop hoc
- thay doi thong tin lop hoc
 */
package demo;

import data.*;
import java.util.*;
public class BatchControl {

    public static void main(String[] args) {
        //tao menu de thuc hien cac chuc nang 
        BatchControl bc = new BatchControl();
        String op = "";
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("\n === BATCH CONTROL PANEL ==");
            System.out.println("1. Xem danh sach cac lop hoc");
            System.out.println("2. Them 1 lop hoc moi");
            System.out.println("3. Xoa 1 lop hoc");
            System.out.println("4. Thay doi thong tin lop hoc");
            System.out.println("5. In danh sach cac lop hoc co hoc phi >= 1000");
            System.out.println("6. Thoat");
            
            System.out.print("Vui long nhap chuc nang [1-6]: ");
            op = sc.nextLine().trim();
            
            switch(op){
                case "1": bc.display(); break;
                case "2": bc.add(); break;
                case "3": bc.delete(); break;
                case "4": bc.update();break;
                case "5": bc.display1000();break;
                case "6": return;
            }
            
        }
        
        
    }
    
    // them 1 lop hoc moi (Vidu2)
    void add(){
        Batch b = new Batch();
        b.input();
        
        int duc = BatchDAO.insert(b);
        if(duc>0){
            System.out.println(" >> Da them lop hoc thanh cong.");
        }
        else{
            System.out.println(" >> Loi sai: Them moi that bai !!!");
        }
    }
    
    // xem danh sach cac lop hoc (Vidu1)
    void display(){
        List<Batch> ds = new ArrayList<>();
        ds = BatchDAO.getList();
        ds.forEach(System.out::println);  // streaming API + method reference
    
        /* 
        for (Batch item : ds) {
            System.out.println(item);
        }  
        */
    }
    
    // xoa 1 lop hoc theo ma so (Vidu3)
    void delete(){
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
    
    
    //thay doi thong tin lop hoc (Vidu4)
    void update(){
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
    
        // xem danh sach cac lop hoc co hoc phi >=1000 (Vidu1)
    void display1000(){
        List<Batch> ds = new ArrayList<>();
        ds = BatchDAO.getList();
        
        //cach viet theo streaming API
        System.out.println(" *** New Style: Streaming ***");
        ds.stream().filter(item->item.fee>=1000).forEach(System.out::println);
        long dem = ds.stream().filter(item->item.fee>=1000).count();
        if(dem ==0){
            System.out.println(" >>> Ko tim thay lop hoc co hoc phi >=1000 !!!! ");
        }
       
        // cach viet binh thuong
        System.out.println("\n *** Old Style ***");
        int dem1000=0;
        for (Batch item : ds) {
            if(item.fee >=1000){
                System.out.println(item);
                dem1000++;
            }
        }  
        
        if(dem1000==0){
            System.out.println(" >>> Ko tim thay lop hoc co hoc phi >=1000 !!!! ");
        }
    }
}
