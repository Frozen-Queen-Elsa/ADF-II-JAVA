/*
    2. Tạo class Product bao gồm :
    a. Các fields dữ liệu:
        i. String id, name, mfg
        ii. int unitPrice, qoh
    b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
    c. Method void input() : nhập và kiểm tra thông tin chi tiết cho sản phẩm :
        - id : Fxxxx (food) hoặc Bxxxx (beverage), với x là ký số.
        - name : ít nhất 2 ký tự.
        - unitPrice, qoh > 0
        - mfg: US hoặc VN hoặc TL
    d. Method String standardlizeMFG() : trả về chuỗi mô tả đầy đủ tên quốc gia sản xuất của field
        mfg: US => United State, VN => Vietnam, TL => Thailand
    f. Override method toString() để biểu diễn nội dung của 1 đối tượng sp dưới dạng chuỗi, với nội
        dung của field mfg được thay thế bằng hàm standardlizeMFG().
 */
package data;

import java.util.Scanner;
import java.util.regex.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class Product implements Comparable<Product>{
    //a. Các fields dữ liệu:
        //i. String id, name, mfg
        //ii. int unitPrice, qoh
    public String id,name,mfg;
    public int unitPrice,qoh;
    
    //b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
    public Product() {
    }

    public Product(String id, String name, String mfg, int unitPrice, int qoh) {
        this.id = id;
        this.name = name;
        this.mfg = mfg;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        
        //Nhập ID
        Pattern p = Pattern.compile("F\\d{4}|B\\d{4}",Pattern.CASE_INSENSITIVE);
        Matcher m=null;
        while(true){
            System.out.println("Nhập mã số sản phẩm Fxxxx(Food) hoặc Bxxxx(Beverage), với x là ký số");
            id=sc.nextLine().trim().toUpperCase();
            m=p.matcher(id);
            if (m.matches()) {
                //nhap dung yeu cau => thoat vong lap while
                break;
            }
            System.out.println(" >> ID ko hop le, vui long nhap lai !");                
        }
        
        //Nhập name
        p=Pattern.compile("\\w{2,}");
        m=null;
        while(true){
            System.out.println("Nhập tên sản phẩm [ít nhất 2 ký tự]");
            name=sc.nextLine().trim();
            m=p.matcher(name);
            if(m.matches()){
                break;
            }
            System.out.println(">>Name không hợp lệ,xin vui lòng nhập lại !");
        }
        
        //Nhập mfg
        p=Pattern.compile("US|VN|TL",Pattern.CASE_INSENSITIVE);
        m=null;
        while(true){
            System.out.println("Xin vui lòng nhập mfg [US , VN , TL]");
            mfg=sc.nextLine().trim().toUpperCase();
            m=p.matcher(mfg);
            if(m.matches()) break;
            System.out.println(">>MFG phải là [US,VN,TL] . XIn vui lòng nhập lại !");
        }
        
        //Nhập unitPrice
        while(true){
            try{
                System.out.println("Xin vui lòng nhập giá sản phẩm");
                unitPrice=sc.nextInt();
                if(unitPrice>0) break;
                System.out.println("Giá sản phẩm phải lớn hơn 0");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        //Nhập qoh
        while(true){
            try{
                System.out.println("Xin vui lòng nhập số lượng sản phẩm");
                qoh=sc.nextInt();
                if(qoh>0) break;
                System.out.println("QoH phải lớn hơn 0");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        
        
    }
    
    
    public String standardlizeMFG(){
        String s = null;
        switch(mfg){
            case "US": s= "United State" ; break;
            case "VN": s= "VietNam"; break;
            case "TL": s= "ThaiLand"; break;
        }
        return s;
    }

    @Override
    public String toString() {
        return String.format("ID : %s - Name : %s - MFG : %s - UnitPrice : %d - QoH : %d",id,name,standardlizeMFG(),unitPrice,qoh);
    }
    
    //Check phần tử bị trùng
    
    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        return this.id.equals(p.id);
    }
    
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public int compareTo(Product o) {
        return this.id.compareTo(o.id);
    }
   
}
