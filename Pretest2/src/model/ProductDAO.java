
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static int insert(Product p){
        int s=0;
        
        //1.Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
           //2.Tạo lệnh select để gọi lệnh sql
           String sql="insert tbPreTest2 values(?,?,?)";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Gán giá trị thuộc tính của các đối tượng cho các tham số ?           
           pst.setString(1, p.Name);
           pst.setInt(2, p.price);
           pst.setInt(3, p.qoh);
           
           
           //4. Thi hành lệnh insert sql
           s=pst.executeUpdate();
           
           
           //5. Đóng các tài nguyên
           pst.close();
           cn.close();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       } 
        
        return s;
    }
    
    public static List<Product> getList(){
        List<Product> ds=new ArrayList<>();
        
        //Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
            //Tạo lệnh SQL để select
            String sql="select * from tbPreTest2";
            PreparedStatement pst=cn.prepareStatement(sql);
            //Thi hành lệnh select
            ResultSet rs=pst.executeQuery();
            //Đọc dữ liệu trong rs->ds
            Product p=null;
            while(rs.next()){
               p=new Product();
               p.id=rs.getInt(1);
               p.Name=rs.getString(2);
               p.price=rs.getInt(3);
               p.qoh=rs.getInt(4);
               
               //Đưa đối tượng p vào danh sách
               ds.add(p);

            }
            //5. Đóng các tài nguyên
            pst.close();
            cn.close();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    
    public static List<Product> getList(String pname){
        List<Product> ds=new ArrayList<>();
        
        //Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
            //Tạo lệnh SQL để select
            String sql="select * from tbPreTest2 where name like ?";
            PreparedStatement pst=cn.prepareStatement(sql);
            
            //Gán giá trị thuộc tính của các đối tượng cho các tham số ?
            pst.setString(1,"%"+pname+"%");
            
            //Thi hành lệnh select
            ResultSet rs=pst.executeQuery();
            
            //Đọc dữ liệu trong rs->ds
            Product p=null;
            while(rs.next()){
               p=new Product();
               p.id=rs.getInt(1);
               p.Name=rs.getString(2);
               p.price=rs.getInt(3);
               p.qoh=rs.getInt(4);
               
               //Đưa đối tượng p vào danh sách
               ds.add(p);
           }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
}
