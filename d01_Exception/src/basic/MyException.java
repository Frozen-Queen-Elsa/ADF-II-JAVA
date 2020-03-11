/*
    Đây là lớp thông báo lỗi sai nhập dữ liệu ứng dụng
 */
package basic;

public class MyException extends Exception{

    public MyException() {
        super("Lỗi sai nhập dữ liệu !!!");
    }

    public MyException(String tb) {
        super(tb);
    }
    
    
}
