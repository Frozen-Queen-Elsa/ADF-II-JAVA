
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library {
    
    
    
    public static void main(String[] args) {
        Library o =new Library();
        o.menu();
    }
    
    public void viewAll() {
        List<Books> ds = BookDAO.getList();
        if (ds.size() == 0) {
            System.out.println(">> Hệ thống chưa có dữ liệu !!");
            return;
        }
        System.out.println("\n Danh sách Books trong thư viên"); 
        int i = 1;
        for (Books item : ds) {
            System.out.printf("%2d %s \n", i++, item);
        }
        
        System.out.println("********************************\n");
    }
    
    public void addBook(){
        Books b = new Books();
        b.acceptBook();
        
        if(BookDAO.insert(b)>0){
            System.out.println(">> Thêm Book thành công");
        }
        else {
        System.out.println("Lỗi sai !!! Từ chối thêm mới !!");
        }
        System.out.println("********************************\n");
    }
    
    
    public void deleteBook(String s) {

        if (BookDAO.delete(s) > 0) {
            System.out.println("Đã xóa thành công Book có id " + s);
        } else {
            System.out.println("Đã xảy ra lỗi !!! Không thể xóa Book có id " + s);
        }
        System.out.println("********************************\n");
    }

    
    public void menu(){
        Library o=new Library();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String op = "";
            System.out.println("--------------------------------");
            System.out.println("|            MENU              |");
            System.out.println("--------------------------------");
            System.out.println("|1. Create a new book          |");
            System.out.println("|2. Publish the entire list    |");
            System.out.println("|3. Search and delete the book |");
            System.out.println("|4. Exit                       |");
            System.out.println("--------------------------------");
            System.out.println("Please select an option [1-4]  ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.addBook();
                    break;
                case "2":
                    o.viewAll();
                    break;
                case "3":
                    System.out.println("Nhập id Book cần xóa ");
                    o.deleteBook(sc.nextLine().trim());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please select an option [1-4]");
                    break;
            }
        }
    }
}
