/*
    In ra toàn bộ danhs ách các lớp học trong bảng [tbBatch] của CSDL [sem2_demo]
 */
package demo;
import data.*;
import java.util.*;
public class Vidu1 {

    public static void main(String[] args) {
        List<Batch> dsLop=BatchDAO.getList();
        for (Batch item : dsLop) {
            System.out.println(item);
        }
    }
    
}
