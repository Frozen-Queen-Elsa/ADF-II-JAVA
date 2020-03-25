/*
Lop phu trach viec tuong tac giua bang [tbBatch] trong CDSL sem2_demo 
va doi tuong [Batch] trong ung dung java
 */
package data;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDAO {

    //1. ham lay het du lieu cua bang tbBatch -> arraylist
    public static List<Batch> getList() {
        List<Batch> ds = new ArrayList<>();
        Batch b = null;

        //1. tao ket noi voi CSDL sem2_demo
        Connection cn = MyLIB.getConnect();

        try {
            //2. tao linh sql de goi den sql server
            String s = "select * from tbBatch;";
            Statement sta = cn.createStatement();

            //3. thi hanh linh
            ResultSet rs = sta.executeQuery(s);

            //4. doc het cac dong trong rs -> dua vo arraylist ds
            while (rs.next()) {
                b = new Batch();

                //5. doc tung cot trong dong va gan vo cac thuoc tinh tuong ung cua b
                b.batchNo = rs.getString("batchno");    // <=> b.batchNo = rs.getString(1)
                b.desc = rs.getString("description");   // <=> b.desc = rs.getString(2)
                b.fee = rs.getInt(3);                   // <=> b.fee = rs.getInt("fee");

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

    //2. ham them 1 lop hoc moi [newBatch] vo bang [tbBach]
    /*
        cac buoc thuc hien:
        1. tao ket noi 
        2. tao doi tuong preparestatement chua linh insert SQL
        3. set gia tri cho cac tham so ? trong linh insert
        4. thi hanh linh insert (goi ham executeUpdate())
        5. dong tat ca cac tai nguyen: cn, pst ...
    */
    public static int insert(Batch newBatch) {
        int r = -1;

        //1. tao ket noi tu ung dung java den sql server
        Connection cn = MyLIB.getConnect();

        try {
            //2. tao doi tuong statement chua linh insert SQL
            String sql = "insert tbBatch values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. set gia tri cho cac tham so ? trong linh insert
            pst.setString(1, newBatch.batchNo);
            pst.setString(2, newBatch.desc);
            pst.setInt(3, newBatch.fee);
            
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
    
    
    //3. ham xoa 1 lop hoc moi [newBatch] o trong bang [tbBach] dua vao ma so lop
    /*
        cac buoc thuc hien:
        1. tao ket noi 
        2. tao doi tuong preparestatement chua linh delete SQL
        3. set gia tri cho cac tham so ? trong linh delete
        4. thi hanh linh delete (goi ham executeUpdate())
        5. dong tat ca cac tai nguyen: cn, pst ...
    */
    public static int delete(String maLopHoc){
        int r = -1;
        
        //1. tao ket noi tu ung dung java den sql server
        Connection cn = MyLIB.getConnect();

        try {
            //2. tao doi tuong statement chua linh delete SQL
            String sql = "delete from tbBatch where batchno=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. set gia tri cho cac tham so ? trong linh delete
            pst.setString(1, maLopHoc);
                        
            //4. thuc hinh linh delete SQL
            r = pst.executeUpdate();

            //5. dong cac resources
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return r;
    }
    
    //4. ham thay doi thong tin cua 1 lop hoc [newBatch] vo bang [tbBach]
    /*
        cac buoc thuc hien:
        1. tao ket noi 
        2. tao doi tuong preparestatement chua linh update SQL
        3. set gia tri cho cac tham so ? trong linh update
        4. thi hanh linh update (goi ham executeUpdate())
        5. dong tat ca cac tai nguyen: cn, pst ...
    */
    public static int update(Batch newBatch) {
        int r = -1;

        //1. tao ket noi tu ung dung java den sql server
        Connection cn = MyLIB.getConnect();

        try {
            //2. tao doi tuong statement chua linh update SQL
            String sql = "update tbBatch set description=?, fee=? where batchno=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            //3. set gia tri cho cac tham so ? trong linh update           
            pst.setString(1, newBatch.desc);
            pst.setInt(2, newBatch.fee);
            pst.setString(3, newBatch.batchNo);
            
            //4. thuc hinh linh update SQL
            r = pst.executeUpdate();

            //5. dong cac resources
            pst.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return r;
    }
    
}
