/*
3. Tạo java main class TestBook có menu để test chương trình
 */
package app;
import data.*;
import java.util.Scanner;

public class TestBook {


    public static void main(String[] args) {
        TestBook tb=new TestBook();
        tb.menu();
    }
    
    public void menu(){
        BookCatalog bc=new BookCatalog();
            while(true){
                Scanner sc=new Scanner(System.in);
                String op="";
                System.out.println(">>MENU<<");
                System.out.println("1. Thêm sách");
                System.out.println("2. xóa sách");
                System.out.println("3. Hiện thỉ danh sách");
                System.out.println("4. Hiện thỉ danh sách theo tên tác giả");
                System.out.println("5. Thoát");
                System.out.println("Vui lòng lựa chọn [1-5]");
                op=sc.nextLine().trim();
                switch(op){
                    case "1":
                        bc.add();
                        break;
                    case "2":
                        String ms;
                        System.out.println("Vui long nhập mã số sách cần xóa");
                        ms=sc.nextLine().trim();
                        bc.remove(ms);
                        break;
                    case "3":
                        bc.display();
                        break;
                    case "4":
                        String tacgia;
                        System.out.println("Vui long nhập tên tác giả cần tìm kiếm");
                        tacgia=sc.nextLine().trim();
                        bc.display(tacgia);
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("Vui lòng lựa chọn lại [1-5]");
                        break;
                }
            }
    }
    
}
