/*
    Kiểm tra kết nối đến CSDL SQL SERVER
 */
package demo;

import data.*;
import java.sql.*;

public class TestConnectSQL {

    public static void main(String[] args) {
        Connection cn = MyLIB.getConnect();
        if(cn !=null){
            System.out.println("THÀNH CÔNG RỒI !!!");
        }
        
    }
    
}
