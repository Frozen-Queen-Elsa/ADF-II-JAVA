
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    ArrayList<Product> pList=new ArrayList<Product>();
    
    public static void main(String[] args) {
       Inventory o=new Inventory();
       o.menu();
    }
    
    public void menu() {
        Inventory o = new Inventory();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String op = "";
            System.out.println(">>MENU<<");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm Product");
            System.out.println("3. Tìm kiếm Product");
            System.out.println("4. Thoát");
            System.out.println("Vui lòng lựa chọn [1-4]");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.display();
                    break;
                case "2":
                    o.add();
                    break;
                case "3":
                    System.out.println("Nhập tên sản phẩm cần tìm kiếm");
                    o.display(sc.nextLine().trim());
                    break;
                case "4":
                    return;

                default:
                    System.out.println("Xin vui lòng nhập lại [1-3]");
                    break;
            }
        }
    }

    

    private void add() {
        Product p=new Product();
        p.input();
        pList.add(p);
        
        if(ProductDAO.insert(p)>0){
            System.out.println("Thêm product thành công");
        }
        else{
            System.out.println("Đã xảy ra lỗi !! Thêm product thất bại");
        }
    }
    
    private void display() {
        List<Product> empList = ProductDAO.getList();
        if (pList.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }
        System.out.println("\n>> Danh sách Employee <<");
        empList.stream().forEach(System.out::println);
    }
    
    private void display(String pname) {
        List<Product> pList = ProductDAO.getList(pname);
        if (pList.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }

        System.out.println("\n>> Danh sách Product <<");
        pList.stream().forEach(System.out::println);
    }
}
