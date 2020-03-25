/*
In ra toan bo danh sach cac lop hoc trong bang [tbBatch] cua CSDL [sem2_demo]
 */
package demo;

import data.*;
import java.util.*;
public class Vidu1 {

    public static void main(String[] args) {
        List<Batch> dsLop = BatchDAO.getList();
        for (Batch item : dsLop) {
            System.out.println(item);
        }
    }
    
}
