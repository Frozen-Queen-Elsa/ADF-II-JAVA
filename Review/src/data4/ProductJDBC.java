/*
Quan ly danh san pham trong bang [tbProduct] cua CSDL [sem2_demo]
1. xem toan bo san pham
2. them san pham moi
3. tim kiem san pham theo ten
4. xoa sp theo ma so
5. thoat

 */
package data4;

import java.util.*;
public class ProductJDBC {

    public static void main(String[] args) {
         ProductJDBC o = new ProductJDBC();
         String op ="";
         Scanner sc = new Scanner(System.in);
         
         while(true){
             System.out.println("\n  MENU");
             System.out.println("1. Xem danh sach");
             System.out.println("2. Them san pham");
             System.out.println("3. Tim san pham theo ten");
             System.out.println("4. xoa san pham theo ma so");
             System.out.println("5. thoat");
             
             System.out.print("  chon chuc nang [1-5]: ");
             op = sc.nextLine().trim();
             
             switch(op){
                 case "1": o.display();break;
                 case "2": o.add(); break;
                 case "3": 
                     System.out.print("Nhap ten sp muon tim: ");
                     o.display(sc.nextLine().trim());
                     break;
                 case "4": 
                     System.out.print("Nhap ma sp muon xoa: ");
                     o.remove(sc.nextLine().trim());
                     break;
                 case "5": return;
             }
         }
    }

    private void display() {
        List<Product> ds = ProductDAO.getList();
        
        if(ds.isEmpty()){
            System.out.println("\n  >> HT chua co du lieu ");
            return;
        }
        System.out.println("\n >> Danh sach san pham");
        ds.stream().forEach(System.out::println);
    }

    private void add() {
        Product p = new Product();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("nhap ma so: "); p.id = sc.nextLine().trim();
        System.out.print("nhap ten: "); p.name= sc.nextLine().trim();
        System.out.print("nhap don gia: "); p.price = Integer.parseInt(sc.nextLine().trim());
        
        //dua san pham vo trong bang [tbProduct]
        if(ProductDAO.insert(p)>0){
            System.out.println(" >> Them sp thanh cong");
        }
        else{
            System.out.println(" >> Loi sai xay ra khi them du lieu !!!");
        }
    }

    private void display(String s) {
        //lay tat ca sp trong bang [tbProduct] -> ds
        List<Product> ds = ProductDAO.getList();
        
        if(ds.isEmpty()){
            System.out.println("HT chua co du lieu");
            return;
        }
        
        String s1 = s.toLowerCase();
        if(ds.stream().filter(item->item.name.toLowerCase().contains(s1)).count()==0){
            System.out.println("\n KHONG TIM THAY SAN PHAM co Ten : " + s);
        }
        else{
            ds.stream().filter(item->item.name.toLowerCase().contains(s1)).forEach(System.out::println); 
        }
    }

    private void remove(String s) {
        if(ProductDAO.delete(s)>0){
            System.out.println("\n >> da xoa san pham co ma so : " + s);
        }
        else{
            System.out.println("\n >> loi sai khi xoa san pham !!!");
        }
    }
}
