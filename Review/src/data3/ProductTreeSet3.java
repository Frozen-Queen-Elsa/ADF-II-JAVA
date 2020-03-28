package data3;

import java.util.*;

public class ProductTreeSet3 {

    public static void main(String[] args) {
        ProductTreeSet3 o = new ProductTreeSet3();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {
            System.out.println("\n MENU 3");
            System.out.println("1. them san pham");
            System.out.println("2. in danh sach sp");
            System.out.println("3. thoat");

            System.out.print("  chon chuc nang [1-3]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.add();
                    break;
                case "2":
                    o.display();
                    break;
                case "3":
                    return;
            }
        }
    }

    Set<Product3> ds = new TreeSet<>();

    public void add() {
        Product3 p = new Product3();

        Scanner sc = new Scanner(System.in);
        System.out.print("nhap id: ");
        p.id = sc.nextLine().trim();
        System.out.print("nhap ten: ");
        p.name = sc.nextLine().trim();
        System.out.print("nhap don gia: ");
        p.price = Integer.parseInt(sc.nextLine().trim());

        //kiem trung ma so
        if(ds.contains(p)){
            System.out.println("MA SO [Phan tu] da ton tai. Tu choi them moi ");
        }
        else{
            ds.add(p);
        }

    }

    public void display() {
        if (ds.isEmpty()) {
            System.out.println("HT chua co du lieu");
            return;
        }

        System.out.println("Danh sach san pham");
        ds.stream().forEach(System.out::println);
    }
}
