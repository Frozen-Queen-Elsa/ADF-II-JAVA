
package model;

import java.util.Scanner;


public class Product {
    public int id,price,qoh;
    public String Name;

    public Product() {
    }

    public Product(int id, int price, int qoh, String Name) {
        this.id = id;
        this.price = price;
        this.qoh = qoh;
        this.Name = Name;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Nhập tên sản phẩm");
            Name=sc.nextLine().trim();
            if(Name.length()<=50 && Name.length()>0) break;
            System.out.println("Name is not null and doesnt have more than 50 character");
        }
        while(true){
            System.out.println("Nhập giá sản phẩm");
            price=Integer.parseInt(sc.nextLine().trim());
            if(price>0 &&price<1001) break;
            System.out.println("Price must be [1-1000]");
        }
        while(true){
            System.out.println("Nhập QoH");
            qoh=Integer.parseInt(sc.nextLine().trim());
            if(qoh>0) break;
            System.out.println("QoH must be greater than 0");
        }
    }

    @Override
    public String toString() {
        return String.format("Id : %d - Name : %s - Price : %d - QoH : %d",id,Name,price,qoh);
    }
    
    
}
