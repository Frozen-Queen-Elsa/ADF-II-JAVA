/*
Ví dụ về biểu thức chính quy:
Kiểm tra số điện thoại có hợp lệ hay ko ?
Số điện thoại hợp : Chứa các ký số hoặc khoảng trắng , ít nhất 3 số
 */
package demo;

import java.util.*;
import java.util.regex.*;

public class ViDu2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. Tạo mẫu quy tắc cho chuỗi số điện thoại hợp lệ
 //       java.util.regex.Pattern p=Pattern.compile("[0-9 ]{3,}");
        java.util.regex.Pattern p=Pattern.compile("[\\d ]{3,}");

        
        
        //2. Tạo đối tượng để thực hiện tính năng kiểm tra luật p với chuỗi văn bản bất kỳ
        java.util.regex.Matcher m=null;
        
        
        String sdt="";
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Nhập Số điên thoại : ");
            sdt=sc.nextLine().trim();
            
            //3. Khởi tạo đối tượng matcher m,để tiến hình so khơp p và chuỗi hoten
            m=p.matcher(sdt);
            
            //4. Đánh giá bằng hàm matches() / lookingAt()  / find()
            if(m.matches()){
                System.out.println("Số điện thoại nhập hợp lệ");
                break;
            }
            //Thông báo lỗi
            else{
                System.out.println("Số điện thoại không hợp lệ, Vui lòng nhập lại !!!");
            }
        }
    }
    
}
