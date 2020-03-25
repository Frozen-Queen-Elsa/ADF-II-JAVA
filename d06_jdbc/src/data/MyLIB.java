/*
Lop thu vien de:
    1/ nap va dang ky driver SQL JDBC
    2/ ket noi den CSDL [sem2_demo] de truy cap cac bang trong CSDL do
 */
package data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyLIB {
    
    //phuong thuc nap driver JDBC va ket noi den CSDL [sem2_demo]
    public static java.sql.Connection getConnect(){
        java.sql.Connection cn = null;
        
        try {
            //1. nap va dang ky driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. mo ket noi den SQL SERVER [localhost:1433], 
            //   cu the la se lam viec voi database [Sem2_demo]
            String url ="jdbc:sqlserver://localhost:1433; database=sem2_demo";
            cn = DriverManager.getConnection(url, "sa", "123");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cn;
    }
}
