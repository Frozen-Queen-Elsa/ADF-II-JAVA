/*
    1. Tạo lớp Product, bao gồm :
        a. Các fields dữ liệu:
            i. String id, name
            ii. Int price
            iii. float in_qty =0, out_qty=0
        b. Method:
            i. void input(): nhập dữ liệu cho các field sau, yêu cầu kiểm tra dữ liệu nhập:
                1. Id phải có dạng Pxxx với x : ký số
                2. name: không được để trống
                3. price > 0
        ii. void output() : xuất nội dung của 1 sp ra màn hình trên 1 dòng có dạng như sau: id, name, price, in_qty, out_qty,                            qoh [= in_qty - out_qty ], amt [=qoh*price]
        iii. String toString() : biểu diễn nội dung của đối tượng sản phẩm dưới dạng chuỗi
 */
package data;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Product implements Serializable{
    public String id,name;
    public int price;
    public float in_qty=0,out_qty=0;

    public Product() {
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        
        
        Pattern p=Pattern.compile("P\\d{3}");
        Matcher m=null;
        while(true){
            System.out.println(">> Vui lòng nhập ID [Pxxx]");
            id=sc.nextLine().trim().toUpperCase();
            m=p.matcher(id);
            if(m.matches()) break;
            System.out.println(">> ID phải có định dạng [Pxxx} x là ký số");
        }
        
        while(true){
            System.out.println(">> Xin vui lòng nhập tên sản phẩm");
            name=sc.nextLine().trim();
            if(name.length()>0) break;
            System.out.println(">> Name không được để trổng !!!");
        }
        
        while(true){
            System.out.println(">> Xin vui lòng nhập giá sản phẩm");
            price=sc.nextInt();
            if(price>0) break;
            System.out.println(">> Price phải lớn hơn 0 ");
        }
    }

    public float getQoH(){
        return in_qty-out_qty;
    }
    
    public float getAmt(){
        return getQoH()*price;
    }
    
    @Override
    public String toString() {
        return String.format("Id : %s - Name : %s - Price : %d - In_Qty : %.3f - Out_Qty : %.3f - QoH : %.3f - Amt : %.3f",id,name,price,in_qty,out_qty,getQoH(),getAmt());
    }
    
    
    
    
}
