
package data;

import java.util.*;

public class ProductHashSet {

    public static void main(String[] args) {
        ProductHashSet o = new ProductHashSet();
        Scanner sc = new Scanner(System.in);
        String op = "";
        
        while(true){
            System.out.println("\n MENU");
            System.out.println("1. them san pham");
            System.out.println("2. in danh sach sp");
            System.out.println("3. thoat");
            
            System.out.print("  chon chuc nang [1-3]: ");
            op = sc.nextLine().trim();
            
            switch(op){
                case "1": o.add();break;
                case "2": o.display(); break;
                case "3": return;
            }
        }
    }
    
    
    Set<Product> ds = new HashSet<>();
    
    public void add(){
        Product p = new Product();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap id: "); p.id = sc.nextLine().trim();
        System.out.print("nhap ten: "); p.name = sc.nextLine().trim();
        System.out.print("nhap don gia: "); p.price = Integer.parseInt(sc.nextLine().trim());
        
        
        //Kiểm tra mã số 
        if(ds.stream().filter(item->item.id.equals(p.id)).count()==0){
            ds.add(p);
        }else{
            System.out.println("Mã số đã tồn tại . Từ chối thêm mới ");
        }
             
        
        
    }
    
    public void display(){
        if(ds.isEmpty()){
            System.out.println("HT chua co du lieu");
            return;
        }
        
        System.out.println("Danh sach san pham");
        ds.stream().forEach(System.out::println);
    }
}
