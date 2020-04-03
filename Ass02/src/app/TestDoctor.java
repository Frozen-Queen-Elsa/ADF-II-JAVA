package app;

import data.*;
import java.util.*;

public class TestDoctor {

    public static void main(String[] args) {
        DoctorList d = new DoctorList();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {
            System.out.println("\n   === MENU ===");
            System.out.println("1. Them nv moi");
            System.out.println("2. Xem ds Bac Si cuyen khoa 2");
            System.out.println("3. Xoa Bac Si theo ma so");
            System.out.println("4. Tim Bac Si theo ten");
            System.out.println("5. Ghi file");
            System.out.println("6. ket thuc");
            System.out.print("  Vui long chon chuc nang [1-6]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    d.add();
                    break;
                case "2":
                    d.display();
                    break;
                case "3":
                    System.out.print("Nhap ms Bac Si:");
                    d.remove(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.print("Nhap ten Bac Si can tim: ");
                    d.display(sc.nextLine().trim());
                    break;
                case "5":
                    d.saveFile();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Vui Long Chon Chuc Nang [1-6] Cho Dung !!");

            }

        }
    }
}
