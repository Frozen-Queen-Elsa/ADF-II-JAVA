/*
    d. Tạo package ui, trong package ui, tạo java main class Test chứa menu để thực hiện các chức năng quản lý dự án.
 */
package ui;

import model.*;
import java.util.*;

public class Test {

    ArrayList<Employee> empList = new ArrayList<Employee>();

    public static void main(String[] args) {
        Test o = new Test();
        o.menu();
    }

    public void menu() {
        Test o = new Test();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String op = "";
            System.out.println(">>MENU<<");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm Employee");
            System.out.println("3. Xóa Employee");
            System.out.println("4. Sửa thông tin Employee");
            System.out.println("5. Tìm kiếm Employee");
            System.out.println("6. Thoát");
            System.out.println("Vui lòng lựa chọn [1-6]");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.display();
                    break;
                case "2":
                    o.add();
                    break;
                case "3":
                    System.out.println("Nhập id Employee cần xóa ");
                    o.remove(sc.nextLine().trim());
                    break;
                case "4":
                    o.update();
                    break;
                case "5":
                    System.out.println("Nhập tên nhân viên cần tìm kiếm");
                    o.display(sc.nextLine().trim());
                    break;
                case "6":
                    return;

                default:
                    System.out.println("Xin vui lòng nhập lại [1-6]");
                    break;
            }
        }
    }

    public void add() {
        Employee emp = new Employee();
        
        emp.input();
        
        empList.add(emp);

        if (EmployeeDAO.insert(emp) > 0) {
            System.out.println("Thêm Employee thành công");
        } else {
            System.out.println("Đã xảy ra lỗi !! Thêm Employee thất bại");
        }

    }

    public void remove(String s) {

        if (EmployeeDAO.delete(s) > 0) {
            System.out.println("Đã xóa thành công Employee có id " + s);
        } else {
            System.out.println("Đã xảy ra lỗi !!! Không thể xóa employee có id " + s);
        }
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();
        System.out.println("Nhập thông tin của nhân viên muốn thay đổi");
        //Nhập ID
        while (true) {
            System.out.println(">> Nhập Id nhân viên");
            emp.id = sc.nextLine().trim();
            if (emp.id.length() <= 5 && emp.id.length() > 0) {
                break;
            }
            if (emp.id.length() > 5) {
                System.out.println("ID chỉ có tối đa 5 ký tự");
                break;
            }
            System.out.println("ID must be not null");
        }
        System.out.println("===========");
        //Nhập name
        while (true) {
            System.out.println(">> Tên nhân viên muốn thay đổi");
            emp.name = sc.nextLine().trim();
            if (emp.name.length() <= 30 && emp.name.length() > 0) {
                break;
            }
            if (emp.name.length() > 30) {
                System.out.println("Name chỉ có tối đa 30 ký tự");
                break;
            }
            System.out.println("Name must be not null");
        }
        //Nhập gender
        while (true) {
            String gioitinh;
            System.out.println(">> Giới tính nhân viên muốn thay đổi [M/F]");
            gioitinh = sc.nextLine().trim().toUpperCase();
            if (gioitinh.equals("M")) {
                emp.gender = true;
                break;
            }
            if (gioitinh.equals("F")) {
                emp.gender = false;
                break;
            }
            System.out.println("Gender phải có định dạng 'M' hoặc 'F' ");
        }

        //Nhập salary
        while (true) {
            System.out.println(">> Lương nhân viên muốn thay đổi");
            emp.salary = Integer.parseInt(sc.nextLine().trim());
            if (emp.salary >= 100 && emp.salary <= 10000) {
                break;
            }
            System.out.println("Salary phải nằm trong khoảng [100-10000]");
        }

        int r = EmployeeDAO.update(emp);

        if (r > 0) {
            System.out.println("Đã thay đổi thông tin nhân viên thành công");
        } else {
            System.out.println("Thay đổi thất bại ....");
        }
    }

    public void display() {
        List<Employee> empList = EmployeeDAO.getList();
        if (empList.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }
        System.out.println("\n>> Danh sách Employee <<");
        empList.stream().forEach(System.out::println);
    }

    public void display(String ename) {
        List<Employee> empList = EmployeeDAO.getList(ename);
        if (empList.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }

        System.out.println("\n>> Danh sách Employee <<");
        empList.stream().forEach(System.out::println);
    }
}
