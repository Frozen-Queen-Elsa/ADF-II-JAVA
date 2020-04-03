/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.*;
public class ViDu2 {

    static String[] ds = {
    "Quynh Luong", "Huy Nguyen", "Buu Loi", "Kim Nguyen",
     "Dung Ngo", "Huyen Nguyen", "An Le", "Nhan Le","Hoa Nguyen",
     "Trung Nguyen", "Vuong Trieu", "Kien Nguyen", "Tam Hoang"
    };
    public static void main(String[] args) {
        demoArrayList();
        demoLinkeList();
        demoArrayList();
    }
    static void demoArrayList(){
    List<String> hoten = Arrays.asList(ds);
    // in ra danh sach cac sinh vien vua nhap
        System.out.println("Danh sach sinh vien[ARRAYS LIST]");
        for (String item : hoten) {
            System.out.printf("\t %s \n",item);
        }
    }
    
    static void demoLinkeList(){
    List<String> hoten = new LinkedList<>(Arrays.asList(ds));
            System.out.println("Danh sach sinh vien[LINKED LIST]");
        for (String item : hoten) {
            System.out.printf("\t %s \n",item);
        }
    }
    
    static void demoVector(){
    List<String> hoten = new Vector(Arrays.asList(ds));
            System.out.println("Danh sach sinh vien[VECTOR LIST]");
        for (String item : hoten) {
            System.out.printf("\t %s \n",item);
        }
    }
}
