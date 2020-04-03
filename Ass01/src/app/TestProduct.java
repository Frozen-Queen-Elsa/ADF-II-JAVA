/*
    4. Tạo java main class TestProduct có menu để test chương trình
 */
package app;

import java.util.*;
import data.*;

public class TestProduct {

    
    public static void main(String[] args) {
        TestProduct t=new TestProduct();
        t.menu();
    }
    
    public void menu(){
        ProductList pl=new ProductList();
        while(true){
            Scanner sc=new Scanner(System.in);
            String op="";
            System.out.println(">>MENU<<");
            System.out.println("1. Thêm sản phẩm ");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("4. Thoát");
            System.out.println("Vui lòng lựa chọn [1-4]");
            op=sc.nextLine().trim();
            
            switch(op){
                case "1": 
                    pl.addProduct(); 
                    break;
                case "2": 
                    pl.displayALl(); 
                    break;
                case "3":
                    String pname;
                    System.out.println("Xin vui lòng nhập tên sản phẩm cần tìm kiếm");
                    pname=sc.nextLine().trim();
                    pl.searchByName(pname);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Xin vui lòng nhập lại lựa chọn [1-4]");
            }
        }
    }
    
}
