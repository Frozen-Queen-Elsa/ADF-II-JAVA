/*
    DAO = Data Access Object
Lớp phụ trách tương tác giữa bảng[tbBatch] trong CSDL sem2_demo 
và đối tượng [Batch] trong ứng dụng Java

 */
package data;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDAO {
    //1.Hàm lấy dữ liệu của bảng tbBatch -> arraylist
    public static List<Batch> getList(){
        List<Batch> ds=new ArrayList<>();
        Batch b=null;
        //1. Tạo kết nối với CSDL sem2_demo
        Connection cn=MyLIB.getConnect();
        
             
        
        try {
            //2. Tạo lệnh sql để gọi đến sql server   
            String s= "select * from tbBatch";
            Statement sta =cn.createStatement();
            
            //3.Thi hành lệnh
            ResultSet rs=sta.executeQuery(s);
            
            //4. Đọc hết tất cả các dòng trong ResulSet rs -> đưa vô arraylist
            while(rs.next()){
                b=new Batch();
                
                //5. Đọc từng cột trong dòng để gắn vô các thuộc tính tương ứng của b
                b.batchNo=rs.getString("batchno");      //  <=> b.batchNo=rs.getString(1);
                b.desc=rs.getString("description");     //  <=> b.desc=rs.getString(2);
                b.fee=rs.getInt(3);                     //  <=> b.fee=rs.getInt("fee");
                
                //6. Đưa đối tượng b vào trong arraylist ds
                ds.add(b);
            }
            //Đóng resources
            sta.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return ds;
    }
    
    //2. ham thêm 1 lop hoc moi [newBatch] o trong bang [tbBach] dua vao ma so lop
        /*
            cac buoc thuc hien:
            1. tao ket noi 
            2. tao doi tuong preparestatement chua lenh insert SQL
            3. set gia tri cho cac tham so ? trong lenh insert
            4. thi hanh lenh insert (goi ham executeUpdate())
            5. dong tat ca cac tai nguyen: cn, pst ...
        */
    public static int insert(Batch newBatch){
        int r=-1;
        
        //1. Tạo 1 kết nối từ ứng dụng java đến sql server
        Connection cn = MyLIB.getConnect();      
        
        try {
            //2. Tạo 1 đối tượng statement chứa lệnh insert SQL
            String sql="insert tbBatch values(?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            
            
            //3.Set giá trị cho các tham số  ? trong lệnh insert
            pst.setString(1,newBatch.batchNo);
            pst.setString(2,newBatch.desc);
            pst.setInt(3,newBatch.fee);
            
            //4. Thực hiện lệnh insert SQL
            r = pst.executeUpdate();
            
            //5. Đóng các tài nguyên
            pst.close();
            cn.close();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return r;
    }
    
    
    //3. ham xoa 1 lop hoc moi [newBatch] o trong bang [tbBach] dua vao ma so lop
    /*
        cac buoc thuc hien:
        1. Tạo 1 kết nối từ ứng dụng java đến sql server
        2. Tạo 1 đối tượng statement chứa lệnh delete SQL
        3. Set giá trị cho các tham số  ? trong lệnh delete
        4. Thực hiện lệnh delete SQL (goi ham executeUpdate())
        5. Đóng các tài nguyên: cn, pst ...
    */
        
    
    public static int delete(String maLopHoc){
        int r=-1;
        
        //1. Tạo 1 kết nối từ ứng dụng java đến sql server
        Connection cn = MyLIB.getConnect();      
        
        try {
            //2. Tạo 1 đối tượng statement chứa lệnh delete SQL
            String sql="delete from tbBatch where batchno=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            
            
            //3.Set giá trị cho các tham số  ? trong lệnh delete
            pst.setString(1,maLopHoc);
            
            //4. Thực hiện lệnh insert SQL
            r = pst.executeUpdate();
            
            //5. Đóng các tài nguyên
            pst.close();
            cn.close();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return r;
    }
    
    
    //3. ham thay đổi thông tin và học phí 1 lớp học [newBatch] o trong bang [tbBach] dua vao ma so lop
    /*
        cac buoc thuc hien:
        1. Tạo 1 kết nối từ ứng dụng java đến sql server
        2. Tạo 1 đối tượng statement chứa lệnh update SQL
        3. Set giá trị cho các tham số  ? trong lệnh delete
        4. Thực hiện lệnh update SQL (goi ham executeUpdate())
        5. Đóng các tài nguyên: cn, pst ...
    */
    
    
    public static int update(Batch newBatch){
        int r=-1;
        
        //1. Tạo 1 kết nối từ ứng dụng java đến sql server
        Connection cn = MyLIB.getConnect();      
        
        try {
            //2. Tạo 1 đối tượng statement chứa lệnh update SQL
            String sql="update tbBatch set description=?,fee=? where batchno=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            
            
            //3.Set giá trị cho các tham số  ? trong lệnh update SQL
            pst.setString(1,newBatch.desc);
            pst.setInt(2,newBatch.fee);
            pst.setString(3,newBatch.batchNo);
            
            //4. Thực hiện lệnh update SQL
            r = pst.executeUpdate();
            
            //5. Đóng các tài nguyên
            pst.close();
            cn.close();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return r;
    }
    
}
