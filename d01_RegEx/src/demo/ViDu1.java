/*
    Ví dụ về biểu thức chính quy 
    Kiểm tra dữ liệu nhập vào có dạng thức hợp lệ của chuỗi họ tên hay không
    Họ tên hợp lệ: không có ký tự đặc biệt, không chứa số- ít nhất 1 ký tự, nhiều nhất 30 ký tự
 */
package demo;

import java.util.*;
import java.util.regex.Pattern;

public class ViDu1 {

    
    public static void main(String[] args) {
        //1. Tạo mẫu quy tắc cho chuỗi họ tên hợp lệ
        java.util.regex.Pattern p=Pattern.compile("[a-zA-Z ]{1,30}");

        
        
        //2. Tạo đối tượng để thực hiện tính năng kiểm tra luật p với chuỗi văn bản bất kỳ
        java.util.regex.Matcher m=null;
        
        String hoten="";
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Nhập họ tên sinh viên : ");
            hoten=sc.nextLine().trim();
            
            //3. Khởi tạo đối tượng matcher m,để tiến hình so khơp p và chuỗi hoten
            m=p.matcher(hoten);
            
            //4. Đánh giá bằng hàm matches() / lookingAt()  / find()
            if(m.matches()){
                System.out.println("Tên nhập hợp lệ");
                break;
            }
            //Thông báo lỗi
            else{
                System.out.println("Tên không hợp lệ, Vui lòng nhập lại !!!");
            }
        }
    }
    
}
