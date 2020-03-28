/*
lop cau noi giua class [Product] cua ung dung Java va bang [tbProduct] trong CSDL [sem2_demo]
 - xem, them, xoa, sua du lieu 
  ( select, insert, delete, update SQL )
 */
package data4;

import java.sql.*;
import java.util.*;

public class ProductDAO {

    public static List<Product> getList() {
        List<Product> ds = new ArrayList<>();

        //1. tao ket noi
        Connection cn = MyLIB.getConnect();

        try {
            //2. tao doi tuong chua linh select SQL
            String sql = "select * from tbProduct";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. cho thuc hien linh select SQL
            ResultSet rs = pst.executeQuery();
            
            //4. doc cac dong du lieu trong rs => ds
            Product p = null;
            while(rs.next()){
                p = new Product();
                p.id = rs.getString(1); // doc du lieu cot [productID]
                p.name = rs.getString(2); // doc du lieu cot [productName]
                p.price = rs.getInt(3);  // doc du lieu cot [price]
                
                //dua doi tuong p vo ds
                ds.add(p);
            }
            
            //5. dong resource
            pst.close();
            cn.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ds;
    }
    
    //ham them 1 san pham p [Product] vo bang [tbProduct]
    public static int insert(Product p){
        int n = 0;
        
        //1. tao ket noi
        Connection cn = MyLIB.getConnect();        
        try {
            //2. tao doi tuong chua linh insert SQL
            String sql = "insert tbProduct values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. gan gia tri (thuoc tinh cua doi tuong p) cho cac tham so ?
            pst.setString(1, p.id);
            pst.setString(2, p.name);
            pst.setInt(3, p.price);
            
            //4. cho thuc hien linh insert SQL
            n = pst.executeUpdate();
                    
            //5. dong resource
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }
    
    //ham xoa 1 san pham p [Product] trong bang [tbProduct] dua vao ma so cua san pham
    public static int delete(String maSP){
        int n = 0;
        
        //1. tao ket noi
        Connection cn = MyLIB.getConnect();        
        try {
            //2. tao doi tuong chua linh delete SQL
            String sql = "delete from tbProduct where productID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. gan gia tri cho cac tham so ?
            pst.setString(1, maSP);
            
            //4. cho thuc hien linh delete SQL
            n = pst.executeUpdate();
                    
            //5. dong resource
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }
    
}
