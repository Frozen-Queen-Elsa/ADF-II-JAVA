/*
    3. Tạo main class Test chứa menu để thực hiện các chức năng quản lý kho theo yêu cầu.
 */
package app;

import data.*;
import java.util.*;
public class Test {

    
    public static void main(String[] args) {
        Test o=new Test();
        o.menu();
    }
    
    public void menu(){
        ProductCatalog p=new ProductCatalog();
        while(true){
            Scanner sc=new  Scanner(System.in);
            String op="";
            System.out.println(">>MENU<<");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Nhập kho sản phẩm");
            System.out.println("3. Xuất kho sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Save file");
            System.out.println("6. Thoát");
            System.out.println("Vui lòng lựa chọn [1-6]");
            op=sc.nextLine().trim();
            
            switch(op){
                case "1":
                    p.add();
                    break;
                case "2":
                    String id1;
                    float qty1;
                    System.out.println("==NHẬP KHO==");
                    System.out.println(">> Vui lòng nhập ID sản phẩm cần nhập kho ");
                    id1=sc.nextLine();
                    System.out.println(">> Vui lòng nhập số lượng cần nhập kho");
                    qty1=sc.nextFloat();
                    p.set(id1, qty1, true);
                    break;
                case "3":
                    String id2;
                    float qty2;
                    System.out.println("==XUẤT KHO==");
                    System.out.println(">> Vui lòng nhập ID sản phẩm cần xuất kho ");
                    id2=sc.nextLine();
                    System.out.println(">> Vui lòng nhập số lượng cần xuất kho");
                    qty2=sc.nextFloat();
                    p.set(id2, qty2, false);
                    break;
                case "4":
                    p.display();
                    break;
                case "5":
                    p.Savefile();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Vui lòng lựa chọn lại [1-6]");
            }
        }
    }
    
}
