/*
 demo collection don gian: list va set
 */
package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViDu1 {

    public static void main(String[] args) {

        ViDu1 p = new ViDu1();
        p.demoList();
        p.demoSET();
        p.demoMap();
    }

    void demoList() {
        // khai bao va khoi tao mot cau truc list chua danh sach TEN cac sinh vien(String)
        List<String> hoten = new ArrayList<String>(); // day la hinh thuc khai bao generic <>
        // them du lieu vao danh sach
        hoten.add("Quynh Luong ");
        hoten.add("Huy Nguyen");
        hoten.add("Tam Hoang");
        hoten.add("Huyen Nguyen");
        hoten.add("An Le");
        hoten.add("Nhan Le");
        hoten.add("Dung Ngo");
        hoten.add("Thu Vo");
        hoten.add("Kim Nguyen");
        hoten.add("Buu Loi");
        hoten.add("Huy Nguyen");
        System.out.println(">>TOng so sinh vien: "+hoten.size());
        // inn du lieu trong danhsach ra: nhu mang truyen thong
        System.out.println("Danh sach ten sinh vien");
        for (int i = 0; i < hoten.size(); i++) {

            String tensv = hoten.get(i);
            System.out.println(tensv);
        }

      // cach 2: dung vong lap for each
        System.out.println("Danh sach ten sinh vien[FOR EACH]");

        for (String item : hoten) {
            System.out.println(item);

        }
    }
    void demoSET(){
    Set<String> hoten = new HashSet<String>();
    hoten.add("Quynh Luong ");
        hoten.add("Huy Nguyen");
        hoten.add("Tam Hoang");
        hoten.add("Huyen Nguyen");
        hoten.add("An Le");
        hoten.add("Nhan Le");
        hoten.add("Dung Ngo");
        hoten.add("Thu Vo");
        hoten.add("Kim Nguyen");
        hoten.add("Buu Loi");
        hoten.add("Huy Nguyen");
        
        System.out.println("danh sach sinh vien: ");
        for (String item : hoten) {
            System.out.println(item);
        }
        System.out.println(">>TOng so sinh vien: "+hoten.size());
    }
    void demoMap(){
    // khai bao
        Map<String, String> hoten = new HashMap<String, String>();
        hoten.put("s1", "Quynh");
        hoten.put("s2", "Huy Nguyen");
        hoten.put("s3", "Tam Hoang");
        hoten.put("s4", "Huyen Nguyen");
        hoten.put("s5", "An Le");
        hoten.put("s6", "Nhan Le");
        hoten.put("s7", "Dung Ngo");
        hoten.put("s8", "Thu Vo");
        
        hoten.put("s2","Huy Nguyen");
        
        System.out.println("Danh sach ho ten cua sinh vien: ");
        for (String item : hoten.values()) {
            System.out.println(item);
            
        }
        System.out.println("tong so sinh vien: "+hoten.size());
        System.out.println("In danh sach vua co ten vua co ma so: ");
        for (String maSV : hoten.keySet()) {
            System.out.printf("%s - %s \n", maSV, hoten.get(maSV));
            
        }
                
                }
    

}

