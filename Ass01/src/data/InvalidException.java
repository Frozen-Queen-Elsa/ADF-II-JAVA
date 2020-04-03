/*
    1. Tạo class exception InvalidException bao gồm các hàm dựng thông báo lỗi sai.
 */
package data;

public class InvalidException extends Exception{

    public InvalidException() {
        super("Lỗi sai nhập dữ liệu !!!");
    }
    
    public InvalidException(String tb){
        super(tb);
    }
    
}
