/*
Demo ve cac tap hop cai dat cau truc Set : HashSet, LinkedHashSet, TreeSet
 */
package demo;

import java.util.*;
public class Vidu3 {

    static String[] ds = {
        "Quynh Luong", "Huy Nguyen", "Buu Loi", "Kim Nguyen",
        "Dung Doan", "Huyen Nguyen", "An Le", "Nhan Le", "Hoa Nguyen",
        "Trung Nguyen", "Vuong Ta", "Kien Nguyen", "Tam Hoang",
        "Quynh Luong"
    };

    public static void main(String[] args) {
        demoHashSet();
        demoLinkedHashSet();
        demoTreeSet();
    }

    static void demoHashSet(){
        Set<String> hoten = new HashSet<>(Arrays.asList(ds));
        
        //in ra danh sach ten sinh vien       
        System.out.println("\n >> Danh sach ten [HASH SET]: ");
        for (String item : hoten) {
            System.out.printf("\t %s \n", item);
        }
    }
    
    static void demoLinkedHashSet(){
        Set<String> hoten = new LinkedHashSet<>(Arrays.asList(ds));
        
        //in ra danh sach ten sinh vien       
        System.out.println("\n >> Danh sach ten [LINKED HASH SET]: ");
        for (String item : hoten) {
            System.out.printf("\t %s \n", item);
        }
    }
    
    static void demoTreeSet(){
        Set<String> hoten = new TreeSet<>(Arrays.asList(ds));
        
        //in ra danh sach ten sinh vien       
        System.out.println("\n >> Danh sach ten [TREE SET]: ");
        for (String item : hoten) {
            System.out.printf("\t %s \n", item);
        }
    }
}
