/*
Quan ly ds nhan vien trong 1 HashMap bao gom cac chuc nang xem, them, xoa
 */
package app;

import data.*;
import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HashMapDemoIOObject {

    Map<String, Employee> ds = new HashMap<>();

    public static void main(String[] args) {
        HashMapDemoIOObject h = new HashMapDemoIOObject();
        h.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = null;

        readFileObject();
        
        while (true) {
            System.out.println("\n   === MENU ===");
            System.out.println("1. Them nv moi");
            System.out.println("2. Xem ds nhan vien");
            System.out.println("3. Xoa nv theo ma so");
            System.out.println("4. Tim nhan vien theo ten");
            System.out.println("5. Ghi File ");
            System.out.println("6. ket thuc");
            System.out.print("  Vui long chon chuc nang [1-6]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    add();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    System.out.print("Nhap ms nhan vien:");
                    delete(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.print("Nhap ten nhan vien can tim: ");
                    display(sc.nextLine().trim());
                    break;
                case "5":
                    saveFileObject();
                    break;
                case "6":
                    return;
            }
        }
    }
    
    String fname = "nhanvien.dat";
    public void saveFileObject(){
        try {
            /*
            muon ghi file object, doi tuong duoc ghi (Employee)
            phai implement interface 'Serializable'
            */
            
            //1. mo luong ghi
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            
            //2. ghi file
            oos.writeObject(ds);
            
            //3. dong luong
            oos.close();
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
    }
    
    //doc file "nhanvien.dat", luu du lieu vo ds
    public void readFileObject(){
        //1. kiem tra file "nhanvien.dat" co chua ?
        File f = new File(fname);
        if(f.exists() == false){
            //tap tin chua co
            return;
        }
        
        try {
            //2. mo luong doc file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            
            //3. doc toan bo file, fill vo ds
            ds = (Map<String, Employee>) ois.readObject();
            
            //3. dong luong
            ois.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    //them nv vo ds 
    private void add() {
        Employee e = new Employee();
        e.input();

        //kiem tra ms cua nv moi nhap lieu da co trong ds chua
        if (ds.containsKey(e.id)) {
            System.out.println(" Ms nv da ton tai. tu choi them moi.");
            return; //ket thuc ham
        }

        //dua thong tin nv vo ds
        ds.put(e.id, e);
    }

    private void display(String tenNV) {
        if (ds.isEmpty()) {
            System.out.println(" >> HT chua co du lieu !");
            return;
        }

        String sNV = tenNV.toLowerCase();
        int dem = 0;

        for (Employee d : ds.values()) {
            if (d.name.toLowerCase().contains(sNV)) {
                System.out.println(d);
                dem++;
            }
        }

        if (dem == 0) {
            System.out.println("Ko tim thay nhan vien co ten " + tenNV);
        }

        //cach viet khac cua Java 8
        Stream<Employee> nv = ds.values().stream();
        long count = nv.filter(e -> e.name.toLowerCase().contains(sNV)).count();
        if (count == 0) {
            System.out.println("KO TIM THAY NV !!!");
        } else {
            nv.filter(e -> e.name.toLowerCase().contains(sNV)).forEach(System.out::println);
        }
        
    }

    private void delete(String ms) {
        //kiem tra ms co ton tai trong ds ko?
        if (ds.containsKey(ms)) {
            //da tim thay ms trong ds
            ds.remove(ms);
            System.out.println(" >> da xoa thanh cong ");
        } else {
            System.out.println(" >> ko tim thay nv muon xoa !!!");
        }
    }

    //in ra toan bo ds nv
    private void display() {
        if (ds.isEmpty()) {
            System.out.println(" >> HT chua co du lieu !");
            return;
        }

        System.out.println("\n Bang ds nhan vien");
        for (Employee item : ds.values()) {
            System.out.println(item);
        }

        // cach viet khac 
        //ds.values().forEach(System.out::println);
    }

}
