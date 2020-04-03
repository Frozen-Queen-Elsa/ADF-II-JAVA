/*
    iii. Tạo class EmployeeDAO, bao gồm các methods : 
            1. public int insert (Employee emp):        
               • thêm đối tượng nhân viên emp vô bảng tbEmployee
               • trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá trị âm
            2. public int update (Employee emp): • thay đổi thông tin của đối tượng nhân viên emp trong bảng tbEmployee
               • trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá trị âm
            3. public int delete (String eID): • Xóa đối tượng nhân viên có mã số eID trong bảng tbEmployee
               • trả về số nguyên dương nếu tác vụ thành công, ngược lại trả về giá trị âm
            4. public List<Employee> getList() , trả về danh sách nhân viên trong bảng tbEmployee.
            5. public List<Employee> getList (String eName), trả về danh sách nhân viên trong bảng tbEmployee có tên chứa nội dung của biến eName

 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class EmployeeDAO {
    public static int insert(Employee emp){
        int s=0;
        
        //1.Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
           //2.Tạo lệnh select để gọi lệnh sql
           String sql="insert tbEmployee values(?,?,?,?)";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Gán giá trị thuộc tính của các đối tượng cho các tham số ?
           pst.setString(1, emp.id);
           pst.setString(2, emp.name);
           pst.setInt(3, emp.gender?1:0);
           pst.setInt(4, emp.salary);
           
           
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
    
    
    public static int delete(String eID){
        int s=0;
        
        //1.Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
           //2.Tạo lệnh delete để gọi lệnh sql
           String sql="delete from tbEmployee where ID like ?";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Gán giá trị thuộc tính của các đối tượng cho các tham số ?
           pst.setString(1, eID);
           
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
    
    public static int update(Employee emp){
        int s=-1;
        
        //1.Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
           //2.Tạo lệnh delete để gọi lệnh sql
           String sql="update tbEmployee set fullname=?,gender=?,salary=? where id=?";
           PreparedStatement pst=cn.prepareStatement(sql);
           
           //3. Gán giá trị thuộc tính của các đối tượng cho các tham số ?
           pst.setString(1,emp.name);
           pst.setInt(2, emp.gender?1:0);
           pst.setInt(3, emp.salary);
           pst.setString(4, emp.id);
           
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
    
    public static List<Employee> getList(){
        List<Employee> ds=new ArrayList<>();
        
        //Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
            //Tạo lệnh SQL để select
            String sql="select * from tbEmployee";
            PreparedStatement pst=cn.prepareStatement(sql);
            //Thi hành lệnh select
            ResultSet rs=pst.executeQuery();
            //Đọc dữ liệu trong rs->ds
            Employee emp=null;
            while(rs.next()){
               emp=new Employee();
               emp.id=rs.getString(1);
               emp.name=rs.getString(2);
               emp.gender=rs.getBoolean(3);
               emp.salary=rs.getInt(4);
               
               //Đưa đối tượng p vào danh sách
               ds.add(emp);

            }
            //5. Đóng các tài nguyên
            pst.close();
            cn.close();
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    
    public static List<Employee> getList(String ename){
        List<Employee> ds=new ArrayList<>();
        
        //Tạo kết nối
        Connection cn=MyLIB.getConnect();
        
        try{
            //Tạo lệnh SQL để select
            String sql="select * from tbEmployee where fullname= ?";
            PreparedStatement pst=cn.prepareStatement(sql);
            
            //Gán giá trị thuộc tính của các đối tượng cho các tham số ?
            pst.setString(1,ename);
            
            //Thi hành lệnh select
            ResultSet rs=pst.executeQuery();
            
            //Đọc dữ liệu trong rs->ds
            Employee emp=null;
            while(rs.next()){
               emp=new Employee();
               emp.id=rs.getString(1);
               emp.name=rs.getString(2);
               emp.gender=rs.getBoolean(3);
               emp.salary=rs.getInt(4);
               
               //Đưa đối tượng p vào danh sách
               ds.add(emp);
           }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
}
