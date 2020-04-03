/*
    3. Tạo class ProductList bao gồm :
        a. Các fields dữ liệu:
            ArrayList<Product> prList để lưu danh sách sản phẩm.
        b. Method :
            1. void addProduct() : thêm 1 sản phẩm vô danh sách prList.
            2. void displayAll() : In toàn bộ danh sách sản phẩm ra màn hình.
            3. void searchByName(String name) : Tìm và in ra ds các sp có tên chứa trong đối số name
 */
package data;

import java.util.ArrayList;
import java.util.List;


public class ProductList {
    ArrayList<Product> prList=new ArrayList<Product>();
    
    
    
    public void addProduct(){
        Product p=new Product();
        p.input();
        
        if(prList.contains(p.id)){
            System.out.println("ID đã tồn tại !!! Xin vui lòng nhập lại !! [Từ chối thêm mới]");
            return;
        }
        
        //Lưu thông tin vào prList
        prList.add(p);
    }
    
    public void displayALl(){
        if(prList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!!");
            return;
        }
        
        System.out.println("/n>>DANH SÁCH SẢN PHẨM<<");
        for(Product item:prList){
            System.out.println(item);
        }
        
               
    }
    
    public void searchByName(String Productname){
        if(prList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!!");
            return;
        }
        
        int dem=0;
        String pname=Productname.toLowerCase();
        for(Product item:prList){
            if(item.name.toLowerCase().contains(pname)){
                System.out.println(item);
                dem++;
            }            
        }
        if(dem==0){
            System.out.println(">> Hệ thống không tim thấy sản phẩm có tên chứa "+Productname);
        }
        else{
            System.out.println(">> Hệ thống tìm thấy "+dem +" sản phẩm có tên chứa "+Productname);
        }
    }
}
