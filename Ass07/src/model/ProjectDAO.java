/*
    iii. Tạo class ProjectDAO, bao gồm các methods : 1. public int insert (Project pro): • thêm đối tượng dự án pro vô bảng         2
        • trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá trị âm 2. public int delete (String pID): • Xóa            đối tượng dự án có mã số pID trong bảng tbProject2
        • trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá trị âm
        3. public List<Project> getList() , trả về danh sách dự án trong bảng tbProject2.
        4. public List<Project> getCompletedProject() , trả về danh sách dự án đã hoàn tất (completed = true) trong bảng tbPr           oject.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class ProjectDAO {
    public static List<Project> getList(){
        List<Project> ds=new ArrayList<>();
                
        //1.Tạo kết nối 
            Connection cn=MyLIB.getConnect();
       try{
           //2.Tạo lệnh select để gọi lệnh sql
           String sql="select * from tbProject2";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Thi hành lệnh select sql
           ResultSet rs=pst.executeQuery();
           
           //4. Đọc dữ liệu trong rs -> ds
           Project p=null;
           while(rs.next()){
               p=new Project();
               p.id=rs.getInt(1);
               p.projectName=rs.getString(2);
               p.startDate=rs.getString(3);
               p.value=rs.getInt(4);
               p.completed=rs.getBoolean(5);
               
               //Đưa đối tượng p vào danh sách
               ds.add(p);
           }
           //5. Đóng các tài nguyên
           pst.close();
           cn.close();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       } 
       
        return ds;
    }
    
    
    public static int insert(Project pro){
        int s=0;
        
        //1.Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
           //2.Tạo lệnh select để gọi lệnh sql
           String sql="insert tbProject2 values(?,?,?,?)";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Gán giá trị thuộc tính của các đối tượng cho các tham số ?
           pst.setString(1, pro.projectName);
           pst.setString(2, pro.startDate);
           pst.setInt(3, pro.value);
           pst.setInt(4, pro.completed?1:0);
           
           
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
    
    
    public static int delete(String pID){
        int s=0;
        
        //1.Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
           //2.Tạo lệnh delete để gọi lệnh sql
           String sql="delete from tbProject2 where ID=?";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Gán giá trị thuộc tính của các đối tượng cho các tham số ?
           pst.setInt(1, Integer.parseInt(pID));
           
           //4. Thi hành lệnh delete sql
           s=pst.executeUpdate();
           
           
           //5. Đóng các tài nguyên
           pst.close();
           cn.close();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       } 
        
        return s;
    }
    
    
    public static List<Project> getCompletedProject(){
        List<Project> ds=new ArrayList<>();
                
        //1.Tạo kết nối 
            Connection cn=MyLIB.getConnect();
       try{
           //2.Tạo lệnh select để gọi lệnh sql
           String sql="select * from tbProject2 where completed=1";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Thi hành lệnh select sql
           ResultSet rs=pst.executeQuery();
           
           //4. Đọc dữ liệu trong rs -> ds
           Project p=null;
           while(rs.next()){
               p=new Project();
               p.id=rs.getInt(1);
               p.projectName=rs.getString(2);
               p.startDate=rs.getString(3);
               p.value=rs.getInt(4);
               p.completed=rs.getBoolean(sql);
               
               //Đưa đối tượng p vào danh sách
               ds.add(p);
           }
           //5. Đóng các tài nguyên
           pst.close();
           cn.close();
           
       }catch(SQLException ex){
           ex.printStackTrace();
       } 
       
        return ds;
    }
}
