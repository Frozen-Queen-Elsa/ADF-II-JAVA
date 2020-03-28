package data;

import java.util.*;
import java.io.*;

public class ProductHashSet {

    public static void main(String[] args) {
        ProductHashSet o = new ProductHashSet();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {
            System.out.println("\n MENU");
            System.out.println("1. them san pham");
            System.out.println("2. in danh sach sp");
            System.out.println("3. ghi file");
            System.out.println("4. thoat");

            System.out.print("  chon chuc nang [1-4]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.add();
                    break;
                case "2":
                    o.display();
                    break;
                case "3":
                    o.writeFileText();
                case "4":
                    return;
            }
        }
    }

    Set<Product> ds = new HashSet<>();

    public void add() {
        Product p = new Product();

        Scanner sc = new Scanner(System.in);
        System.out.print("nhap id: ");
        p.id = sc.nextLine().trim();
        System.out.print("nhap ten: ");
        p.name = sc.nextLine().trim();
        System.out.print("nhap don gia: ");
        p.price = Integer.parseInt(sc.nextLine().trim());

        //kiem trung ma so
        if (ds.stream().filter(item -> item.id.equals(p.id)).count() == 0) {
            ds.add(p);
        } else {
            System.out.println("MA SO da ton tai. Tu choi them moi !!!");
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

    String fname = "Product.txt";
    private void writeFileText() {
        try {
            java.io.PrintWriter pw = new PrintWriter(fname);
            // lấy hết dữ liệu ra sau đó lưu vô tập tin này
            for (Product Pr : ds) {
                pw.println(Pr);
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Lỗi: "+e.getMessage());
        }
        // xem nội dung = notepad
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad "+ fname);
        } catch (IOException ex) {
            System.out.println("Loi: "+ex.getMessage());
        }

    }
}
