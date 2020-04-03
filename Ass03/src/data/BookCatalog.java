/*
    2. Tạo class BookCatalog bao gồm :
        a. Các f ields dữ liệu:
            HashSet<Book> bkList để lưu tất cả các quyển sách trong thư viện.
        b. Method :
            1. void add() : thêm 1 sách mới vô bkList. Yêu cầu kiểm tra trùng mã .
            2. void remove( String bkID ) : Xóa 1 quyển sách có mã số bkID ra khỏi bkList.
            3. void display() : In danh mục các quyển sách trong thư viện .
            4. void display( String auName ) : Tìm và in ra các quyển sách có của tác giả có tên auName
 */
package data;

import java.util.HashSet;

public class BookCatalog {
    HashSet<Book> bkList=new HashSet<Book>();
    
    public void add(){
        Book b=new Book();
        b.input();
        
        if(bkList.contains(b))
            System.out.println("Dữ liệu bị trùng . Từ chối thêm mới !!");
            
        else{
            bkList.add(b);
        }
    }
    
    public void remove(String bkID){
        int cnt=0;
//        for(Book item:bkList){
//            if(item.id.contains(bkID)){
//                bkList.remove(item);
//                cnt++;
//            }
//        }
        
        for(Book item:bkList){
            if(item.id.equalsIgnoreCase(bkID)){
                bkList.remove(item);
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("Không tìm thấy sách cần xóa");
        }
        else{
            System.out.println("Đã xóa "+cnt+" sách có chứa "+bkID);
        }
    }
    
    public void display(){
        if(bkList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu");
            return;
        }
        
        System.out.println("\n Cách 1");
        System.out.println(">>Danh sách các cuốn sách");
        for(Book item:bkList){
            System.out.println(item);
        }
        
        System.out.println("\n Cách 2");
        bkList.stream().forEach(System.out::println);
        
    }
    
    
    public void display(String auName){
        if(bkList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu");
            return;
        }
        
        System.out.println(">>Danh sách các cuốn sách có Author là : "+auName);
        int cnt=0;
        for(Book item:bkList){
            if(item.author.toLowerCase().equals(auName.toLowerCase())){
                System.out.println(item);
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("Hệ thống không tìm thấy sách có Author là "+auName);
        }
        else{
            System.out.println("Hệ thống tìm thấy "+cnt+" cuốn sách có Author là "+auName);
        }
    }
}
