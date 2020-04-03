/*
    1. Tạo class Book, mô tả 1 quyển sách:
        a. Fields: BookID, Title, Price, Publisher
        b. Methods:
            i. public void input() : nhập dữ liệu chi tiết của 1 quyển sách. Yêu cầu kiểm tra: BookID : phải có định dạng Bxxxx Tilte : không được để trống Price : có giá trị từ 1 – 1000 Publisher : là chuỗi “OUP” hoặc “CUP”
            ii. toString(), trả về chuỗi mô tả thông tin chi tiết 1 quyển sách, có tên nhà xuất bản đã được thay thế bằng hàm standardizedPublisher()
            iii. public String standardizedPublisher(), trả về 1 chuỗi thay thế các từ trong field Publisher “OUP” thành “Oxford University Press” “CUP” thành “Cambridge University Press”
 */
package data;



import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Book implements java.io.Serializable{
    public String BookId,Title,Publisher;
    public int Price;

    public Book() {
    }

    public Book(String BookId, String Title, String Publisher, int Price) {
        this.BookId = BookId;
        this.Title = Title;
        this.Publisher = Publisher;
        this.Price = Price;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        Pattern p=Pattern.compile("B\\d{4}");
        Matcher m=null;
        while(true){
            try{
                System.out.println("Nhập Book ID  [Bxxxx]");
                BookId=sc.nextLine().trim();
                m=p.matcher(BookId);
                if(m.matches()) break;
                System.out.println("Book ID có định dạng Bxxx \n Xin vui lòng nhập lại !");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        while(true){
            try {
                System.out.println("Nhập Book Title");
                Title=sc.nextLine().trim();
                if(Title.length()>0) break;
                System.out.println("Book Title must be not null");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        Pattern p1=Pattern.compile("OUP||CUP");
        Matcher m1=null;
        while(true){
            try {
                System.out.println("Nhập Book Publisher [OUP/CUP]");
                Publisher=sc.nextLine().trim().toUpperCase();
                m1=p1.matcher(Publisher);
                if(m1.matches()) break;
                System.out.println("Publisher must be 'OUP' or 'CUP'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
                while(true){
            try {
                System.out.println("Nhập Book Price");
                Price=Integer.parseInt(sc.nextLine().trim());
                if(Price>0&&Price<=1000) break;
                System.out.println("Price must be in range [1-1000]");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("ID : %s - Title : %s - Publisher : %s - Price : %d ",BookId,Title,standardizedPublisher(),Price);
    }
    
    public String standardizedPublisher(){
        String s=null;
        if(Publisher=="OUP")
            s="Oxford University Press";
        else
            s="Cambridge University Press";
        
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        Book b = (Book) obj;
        return this.BookId.equals(b.BookId);
    }
    
    @Override
    public int hashCode() {
        return 100;
    }

    
    
    
    
}
