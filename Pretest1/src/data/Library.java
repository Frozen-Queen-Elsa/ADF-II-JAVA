/*
    2. Tạo Java Main class Library, thực hiện chức năng quản lý các quyển sách trong 1 HashSet<Book> , bao gồm :
        a. Add() : Thêm 1 quyển sách mới vô HashSet - thông báo thành công nếu thêm mới hoàn tất, ngược lại thông báo lỗi mỗi khi nhập sai.
        b. Display() : in danh mục sách trong thư viện bao gồm các cột: Số thứ tự, Mã sách , Tên , Nhà xuất bản
        c. Save() Lưu danh mục sách trong HashSet vô tập tin văn bản. Thông tin của mỗi quyển sách sẽ được ghi trên 1 dòng. Sử dụng NotePad để xem nội dung tập tin này sau khi lưu xong.
    d. Menu()
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Library {
    HashSet<Book> bList = new HashSet<Book>();
    String fname;

    public Library() {
        bList=new HashSet<>();
        fname="BookList.data";
        ReadFile();
    }    
    
    public static void main(String[] args) {
      Library o=new Library();
      o.menu();
    }

    
    public void menu(){
        Library o=new Library();
        while(true){
            Scanner sc=new Scanner(System.in);
            String op="";
            System.out.println(">>MENU<<");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Save File");
            System.out.println("4. Thoát");
            System.out.println("Xin vui lòng lựa chọn 1-5]");
            op=sc.nextLine().trim();

            switch(op){
                case "1":
                    o.add();
                    break;
                case "2":
                    o.display();
                    break;
                case "3":
                    o.Savefile();
                    break;                
                case "4":
                    return;
                default:
                    System.out.println("Xin vui lòng lựa chọn 1-5]");
                    break;
            }
        }
        
    }
    
    
    
    private void ReadFile() {
        try {
            File f=new File(fname);
            if(f.exists()==false) return;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fname));
            bList=(HashSet<Book>) is.readObject();
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void Savefile(){
        try{
            ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream(fname));
            System.out.println("Đã lưu file");
            os.writeObject(bList);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void add(){
        Book b=new Book();
        b.input();
        if(bList.contains(b.BookId)){
            System.out.println("ID bị trùng !! Từ chối thêm mới !!");
        }
        else{
            bList.add(b);
        }     
    }
    
    private void display(){
        if(bList.isEmpty()){ 
            System.out.println("Hệ thống chưa có dữ liệu");
        }
        bList.stream().forEach(System.out::println);
    }

    
}
