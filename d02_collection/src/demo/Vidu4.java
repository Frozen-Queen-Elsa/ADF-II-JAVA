/*
 Demo ve cac tap hop cai dat cau truc Map : HashMap, LinkedHashMap, TreeMap, Hashtable
 */
package demo;

import java.util.*;
    
class SinhVien{
    public String id, ten;
    public int diem;

    public SinhVien() {
    }

    public SinhVien(String id, String ten, int diem) {
        this.id = id;
        this.ten = ten;
        this.diem = diem;
    }

    @Override
    public String toString() {
        return String.format(" %-4s - %-20s -%4d", id, ten, diem);
    }
}

public class Vidu4 {
 
    static List<SinhVien> ds = Arrays.asList(
        new SinhVien("s1", "Quynh Luong", 90),
        new SinhVien("s3", "Huy Nguyen", 60),
        new SinhVien("s2", "An Le", 30),
        new SinhVien("s6", "Dung Doan", 20),
        new SinhVien("s5", "Binh Nguyen", 100),
        new SinhVien("s4", "Duc Le", 80),
        new SinhVien("s8", "Huyen Nguyen", 50),
        new SinhVien("s7", "Thu Le", 40)
    );
    
    public static void main(String[] args) {
        demoHashMap();
        demoLinkedHashMap();
        demoTreeMap();
        demoHashTable();
    }
    
    static void demoHashMap(){
        Map<String, SinhVien> dssv = new HashMap<>();
        
        //fill du lieu vo dssv
        for (SinhVien sv : ds) {
            dssv.put(sv.id, sv);
        }
        
        //in danh sach sinh vien
        System.out.println("\n >> Danh sach sinh vien [HASH MAP]: ");
        for (SinhVien item : dssv.values()) {
            System.out.println(item);
        }
    }
    
    static void demoLinkedHashMap(){
        Map<String, SinhVien> tapSV = new LinkedHashMap<>();
        //fill du lieu vo dssv
        for (SinhVien sv : ds) {
            tapSV.put(sv.id, sv);
        }
        
        //in danh sach sinh vien
        System.out.println("\n >> Danh sach sinh vien [LINKED HASH MAP]: ");
        for (SinhVien item : tapSV.values()) {
            System.out.println(item);
        }
    }
    
    static void demoTreeMap(){
        Map<String, SinhVien> tapSV = new TreeMap<>();
        
        //fill du lieu vo dssv
        for (SinhVien sv : ds) {
            tapSV.put(sv.id, sv);
        }
        
        //in danh sach sinh vien
        System.out.println("\n >> Danh sach sinh vien [TREE MAP]: ");
        for (SinhVien item : tapSV.values()) {
            System.out.println(item);
        }
    }
    
    static void demoHashTable(){
        Map<String,SinhVien> tapSV = new Hashtable<>();
        //fill du lieu vo dssv
        for (SinhVien sv : ds) {
            tapSV.put(sv.id, sv);
        }
        
        //in danh sach sinh vien
        System.out.println("\n >> Danh sach sinh vien [HASH TABLE]: ");
        for (SinhVien item : tapSV.values()) {
            System.out.println(item);
        }
    
    }
        
    
}
