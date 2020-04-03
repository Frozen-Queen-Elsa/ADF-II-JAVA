/*
Lớp dùng để kiểm tra thử các hình thức Generic của Product
 */
package demo;

public class TestProduct {


    public static void main(String[] args) {
        //Tạo 1 đối tượng sản phẩm
        Product p1=new Product();
        p1.id=100;
        p1.name="Laptop";
        p1.price=200;
        
        //Tạo 1 đối tượng sản phẩm-generic
        Product<String> p2=new Product<>();
        p2.id="100";
        p2.name="Smart phone";
        p2.price=200;
        
        System.out.println("Sản phẩm thứ 1 : ");
        p1.output();
        
        System.out.println("Sản phẩm thứ 2 : ");
        p2.output();
    }
    
}
