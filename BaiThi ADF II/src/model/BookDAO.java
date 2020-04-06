
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
    public static List<Books> getList() {
        List<Books> ds = new ArrayList<>();
        Books b = null;

        
        Connection cn = MyLIB.getConnect();

        try {
            
            String s = "select * from LibraryDB;";
            Statement sta = cn.createStatement();

            
            ResultSet rs = sta.executeQuery(s);

            while (rs.next()) {
                b = new Books();

                b.BookID = rs.getInt(1); 
                b.Title = rs.getString(2);   
                b.Author = rs.getString(3);   
                b.Edition = rs.getInt(4);

                //6. dua doi tuong b vo trong arraylist ds
                ds.add(b);
            }

            //5. dong resources
            sta.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ds;
    }
    
    public static int insert(Books newBooks) {
        int r = -1;

        //1. tao ket noi tu ung dung java den sql server
        Connection cn = MyLIB.getConnect();

        try {
            //2. tao doi tuong statement chua linh insert SQL
            String sql = "insert Book values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. set gia tri cho cac tham so ? trong linh insert
            pst.setString(1, newBooks.Title);
            pst.setString(2, newBooks.Author);
            pst.setInt(3, newBooks.Edition);
            
            //4. thuc hinh linh insert SQL
            r = pst.executeUpdate();

            //5. dong cac resources
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return r;
    }
    
    public static int delete(String bID){
        int r=-1;
        
        Connection cn=MyLIB.getConnect();
        
        try{
           
           String sql="delete from Book where BookId like ?";
           PreparedStatement pst=cn.prepareStatement(sql);
           pst.setString(1, bID);
           
           
           r=pst.executeUpdate();
           
           pst.close();
           cn.close();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       } 
        
        return r;
    }
}
