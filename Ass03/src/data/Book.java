/*
    Tạo class Book bao gồm :
        a. Các fields dữ liệu:
            i. String id, title, author, publisher
            ii. int pages, price
    b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
    c. Method :
        - void input() : nhập chi tiết cho 1 quyển sách và kiểm tra dữ liệu hợp lệ như sau :
        - id : Bxxxx, với x là ký số.
        - title : tựa sách. ít nhất 2 ký tự chữ, số hoặc khoảng trắng.
        - author, pubisher : tên tác giả, nhà xuất bản: ko được để trống
        - pages: số trang , từ 5 – 2000.
        - price : đơn giá, >0
        - String toString() : override method này để biểu diễn nội dung của 1 đối tượng sách dưới dạng chuỗi.
 */
package data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Book {
    public String id,title,author,publisher;
    public int pages,price;

    public Book() {
    }

    public Book(String id, String title, String author, String publisher, int pages, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        
        //Nhập id
        Pattern p=Pattern.compile("B\\d{4}",Pattern.CASE_INSENSITIVE);
        Matcher m=null;
        while(true){
            System.out.println("Nhập mã số sách [Bxxxx]");
            id=sc.nextLine().trim().toUpperCase();
            m=p.matcher(id);
            if(m.matches()) break;
            System.out.println(">> Mã số sách phải có định dạng Bxxxx [x là ký số ]");
            System.out.println(">> Xin vui lòng nhập lại\n");
        }
        
        //Nhập title
        p=Pattern.compile("[a-z0-9 ]{2,}",Pattern.CASE_INSENSITIVE);
        m=null;
        while(true){
            System.out.println("Nhập tên sách");
            title=sc.nextLine().trim();
            m=p.matcher(title);
            if(m.matches()) break;
            System.out.println(">> Tên sách phải có ít nhất 2 ký tự !!");
            System.out.println(">> Xin vui lòng nhập lại\n");
        }
        
        //Nhập author
        while(true){
            System.out.println("Nhập tên tác giả");
            author=sc.nextLine().trim();
            if(author.length()>0) break;
            System.out.println(">> Tên tác giả không được để trống !!");
            System.out.println(">> Xin vui lòng nhập lại \n");
        }
        
        //Nhập publisher
        while(true){
            System.out.println("Nhập tên nhà xuất bản");
            publisher=sc.nextLine().trim();
            if(publisher.length()>0) break;
            System.out.println(">> Tên nhà xuất bản không được để trống !!");
            System.out.println(">> Xin vui lòng nhập lại \n");
        }
        
        //Nhập pages
        while(true){
            System.out.println("Nhập số trang sách [5-2000]");
            pages=sc.nextInt();
            if(pages>=5 && pages <=2000) break;
            System.out.println(">> Số trang phải nằm trong khoảng [5-2000]");
            System.out.println("xin vui lòng nhập lại");
        }
        
        //Nhập price
        while(true){
            System.out.println("Nhập giá của sách");
            price=sc.nextInt();
            if(price>0) break;
            System.out.println(">> Giá của sách phải lớn hơn 0 ");
            System.out.println(">>xin vui lòng nhập lại");
        }
    }

    @Override
    public String toString() {
        return String.format("Id : %s - Title : %s - Author : %s - Publisher : %s - Pages : %d - Price : %d",id,title,author,publisher,pages,price);
    }

    @Override
    public boolean equals(Object obj) {
        Book b=(Book) obj;
        return this.id.equals(b.id);
    }

//    @Override
    public int hashCode() {
        return 100;
    }
    
    
}
