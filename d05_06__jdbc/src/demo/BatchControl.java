/*
    Quản lý lớp học được lưu trong bảng [tbBatch] trong CSDL [sem2_demo]
    -Xem danh sách
    -Thêm 1 lớp học
    -Xóa 1 lớp học
    -Cập nhật thông tin 1 lớp học
 */
package demo;
import data.*;
import java.util.*;

public class BatchControl {

   
    public static void main(String[] args) {
        //Tạo menu để thực hiện các chức năng
        BatchControl bc=new BatchControl();
        String op="";
        Scanner sc=new Scanner(System.in);
        
        while(true){
            System.out.println("\n== BATCH CONTROL ==");
            System.out.println("1. Xem danh sách các lớp học");
            System.out.println("2. Thêm 1 lớp học");
            System.out.println("3. Xóa 1 lớp học");
            System.out.println("4. Thay đổi thông tin 1 lớp học");
            System.out.println("5. In danh sách các lớp học có học phí >1000");
            System.out.println("6. Exit");
            System.out.println("Vui lòng lựa chọn [1-6]");
            op=sc.nextLine().trim();
            
            switch(op){
                case "1": bc.display();break;
                case "2": bc.add();break;
                case "3": {
                    System.out.println(">> Nhập mã số lớp học muốn xóa");
                    bc.delete(sc.nextLine().trim());
                    break;
                }
                case "4": bc.update();break;
                case "5": bc.diplay1000();break;
                case "6": return;
                default: System.out.println("Vui long lựa chọn [1-6]"); break;
                    
            }
        }
    }
    
    //Hàm thêm 1 lớp học mới (Vidu2)
    void add(){
        Batch b = new  Batch();
        b.input();
        
        int n= BatchDAO.insert(b);
        if(n>0){
            System.out.println(">>Đã thêm lớp học thành công !!!");
        }
        else{
            System.out.println("Lỗi sai :Thêm mới thất bại");
        }
    }
    
    //Hàm xem danh sách(Vidu1)
    void display(){
        List<Batch> ds=new ArrayList<>();
        ds=BatchDAO.getList();
        ds.forEach(System.out::println);   //Streaming API +method
    }
    
    //Hảm xóa 1 lớp học(Vidu 3)
    void delete(String ms){
        int r=BatchDAO.delete(ms);
        if(r>0){
            System.out.println(">>Đã xóa lớp học thành công");
        }
        else{
            System.out.println(">> Lỗi sai : Không thể xóa lớp học !!");
        }
    }
    
    
    //Hàm thay đổi thông tin lớp học
    void update(){
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
    
    void diplay1000(){
        List<Batch> ds=new ArrayList<>();
        ds=BatchDAO.getList();
        //Cách viết theo kỹ thuật streming API
        System.out.println("\n*** NEW STYLE STREAMING***");
        ds.stream().filter(item->item.fee>=1000).forEach(System.out::println);
        long dem=ds.stream().filter(item->item.fee>=1000).count();
        if(dem==0){
            System.out.println(">>Không tìm thấy lớp học nào có học phí lớn hơn 1000");
        }
        else{
            System.out.println(">> Tìm thấy "+dem+" lớp học có học phí lớn hơn 1000");
        }
        
        //Cách viết bình thường
        System.out.println("\n*** OLD STYLE **");
        int dem1000=0;
        for(Batch item :ds){
            if(item.fee>=1000){
                System.out.println(item);
                dem1000++;
            }
        }
        if(dem1000==0){
            System.out.println(">>Không tìm thấy lớp học nào có học phí lớn hơn 1000");
        }
        else{
            System.out.println(">> Tìm thấy "+dem1000+" lớp học có học phí lớn hơn 1000");
        }
    }
}
        
    
     
