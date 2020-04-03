/*
Quan ly ds nhan vien trong 1 arraylist bao gom cac chuc nang xem, them, xoa
 */
package app;

import data.*;
import java.util.*;
import java.io.*;


public class ArrayListDemoIOText {
    List<Employee> ds = new ArrayList<>();
    
    public static void main(String[] args) {
        ArrayListDemoIOText a = new ArrayListDemoIOText();
        a.menu();
    }
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        String op=null;
        
        readFileText();
        
        while(true){
            System.out.println("\n   === MENU ===");
            System.out.println("1. Them nv moi");
            System.out.println("2. Xem ds nhan vien");
            System.out.println("3. Xoa nv theo ma so");
            System.out.println("4. Tim nhan vien theo ten");
            System.out.println("5. Ghi File");
            System.out.println("6. ket thuc");
            System.out.print("  Vui long chon chuc nang [1-6]: ");
            op = sc.nextLine().trim();
            
            switch(op){
                case "1": add(); break;
                case "2": display(); break;
                case "3": System.out.print("Nhap ms nhan vien:");
                          delete(sc.nextLine().trim());
                          break;
                case "4": System.out.print("Nhap ten nhan vien can tim: ");
                          display(sc.nextLine().trim());
                          break;
                case "5": saveFileText();
                          break;
                case "6": return;
            }
        }
    } 
    
    //ham ghi ds vo 1 tap tin van ban, "nhanvien.txt"
    String fname = "nhanvien.txt";
    public void saveFileText(){
        try {
            //1. mo luong output, ket voi tap tin co ten "nhanvien.txt"
            PrintStream ps = new PrintStream(fname);
            
            //2. doc het du lieu trong list ds, ghi vo file 
            ds.forEach(s -> ps.println(s));

            //3. dong luong output (quan trong lam nha)
            ps.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }   
    }
    
    //ham doc tap tin van ban, "nhanvien.txt", phan tich du lieu va dua vo ds
    public void readFileText(){
        //kiem tra xem tap tin "nhanvien.txt" co chua ?
        File f = new File(fname);
        if(f.exists() == false){
            return; //tap tin chua co -> ket thuc ha doc file
        }
        
        try {
            //1. mo luong input de doc noi dung file "nhanvien.txt"
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            //2. doc tung dong, phan tich tao thanh doi tuong nv, luu vo ds
            String line=null;
            String[] items;
            while(br.ready()){
                line = br.readLine();
                items = line.split(",");
                if(items.length == 4){
                    // tao doi tuong nv tu dong du lieu doc tu file
                    Employee emp = new Employee();
                    emp.id = items[0].trim();
                    emp.name = items[1].trim();
                    emp.salary = Integer.parseInt(items[2].trim());
                    emp.dept = items[3].trim();
                    
                    // dua nv vo ds
                    ds.add(emp); 
                }
            }
            
            //3. doc het file, dong luong input
            br.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    //ham them 1 nhan vien moi vo ds
    public void add(){
        Employee e = new Employee();
        e.input();
        
        ds.add(e);  //dua doi tuong e vo ds.
    }
    
    //ham in ds nhan vien
    public void display(){
        if(ds.isEmpty()){
            System.out.println("HT chua co du lieu !");
            return;
        }
        
        System.out.println(" >> Danh sach nhan vien <<");
        for (Employee item : ds) {
            System.out.println(item);
        }
    }
    
    //ham xoa nhan vien theo ma so
    public void delete(String ms){
        if(ds.isEmpty()){
            System.out.println("HT chua co du lieu !");
            return;
        }
        
        for (Employee item : ds) {
            if(item.id.equals(ms)){
                ds.remove(item);
                System.out.println(" >> da xoa thanh cong !");
                return;
            }
        }//ket thuc for
        System.out.println(" >> KO tim thay nv co ma so "+ ms);
    }
    
    
    //ham tim nv theo ten
    public void display(String tenNV) {
        if(ds.isEmpty()) {
            System.out.println("He thong chua co du lieu");
            return;
        }
        
        String sNV = tenNV.toLowerCase();
        int dem = 0;
        
        for (Employee d : ds) {
            if(d.name.toLowerCase().contains(sNV)) {
                System.out.println(d);
                dem++;
            }
        }
        
        if(dem == 0)
        {
            System.out.println("Ko tim thay nhan vien co ten " + tenNV);
        }
    }
}
