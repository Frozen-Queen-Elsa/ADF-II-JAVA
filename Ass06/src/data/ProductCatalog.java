/*
    2. Tạo lớp ProductCatalog bao gồm :
        a. Các fields dữ liệu:
            i. HashMap <String , Product> pList , lưu danh sách sản phẩm trong bộ nhớ.
            String fname [=TONKHO.DAT], chứa tên tập tin lưu danh sách sản phẩm
        b. Default contructor:
            i. khởi tạo field pList, fname .
            ii. Đọc dữ liệu từ tập tin TONKHO.DAT (nếu có) vô danh sách pList
        c. void add() : Tạo và nhập thông tin chi tiết cho sản phẩm mới & lưu vô danh sách pList
        d. void set (String sID, float sQty, boolean isReceive) : nhập/xuất kho sản phẩm
                if isReceive = true
                { thêm 1 lượng sQty của mặt hàng có mã số sID vô kho (in_qty += sQty) }
                else { xuất 1 lượng sQty của sản phẩm có mã số sID ra khỏi kho (out_qty += sQty) }
        e. void display() : In báo cáo tồn kho ( gọi hàm output() class Product )
        f. void saveFile() : Ghi danh sách sản phẩm vô tập tin TONKHO.DAT
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductCatalog {
    HashMap<String, Product> pList=new HashMap<String,Product>();
    String fname;
    
    public ProductCatalog() {
        pList=new HashMap<>();
        fname="TONKHO.DAT";
        Readfile();
    }

    private void Readfile() {
        try {
            File f=new File(fname);
            if(f.exists()==false) return;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fname));
            pList=(HashMap<String, Product>) is.readObject();
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void Savefile(){
        try{
            ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream(fname));
            os.writeObject(pList);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void add(){
        Product p=new Product();
        p.input();
        if(pList.containsKey(p.id)){
            System.out.println("ID bị trùng !! Từ chối thêm mới !!");
        }
        else{
            pList.put(p.id, p);
        }     
    }
    
    public void set(String sID,float sQty,boolean isReceive){
        if(pList.isEmpty()){ 
            System.out.println("Hệ thống chưa có dữ liệu");
        }
        if(pList.containsKey(sID)){
            Product p=pList.get(sID);
            if(isReceive){
                p.in_qty+=sQty;
                System.out.println("Đã nhập thêm "+sQty+" sản phẩm có id "+sID);
            }
            else{
                p.out_qty+=sQty;
                System.out.println("Đã xuất ra "+sQty+" sản phẩm có id "+sID);
            }
        }
        else{
            System.out.println("Hệ thống không tìm thấy sản phẩm có id "+sID);
        }
    }
    
    public void display(){
        if(pList.isEmpty()){ 
            System.out.println("Hệ thống chưa có dữ liệu");
        }
        pList.values().stream().forEach(System.out::println);
    }
    
}
