/*
    d. Tạo package ui, trong package ui, tạo java main class Test chứa menu để thực hiện các chức năng quản lý dự án.
 */
package ui;

import model.*;
import java.util.*;

public class Test {
    ArrayList<Project> proList=new ArrayList<Project>();

    public static void main(String[] args) {
        Test o=new Test();
        o.menu();
    }
    
    
    public void menu(){
        Test o=new Test();
        while(true){
            Scanner sc=new Scanner(System.in);
            String op="";
            System.out.println(">>MENU<<");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm Project");
            System.out.println("3. Xóa Project");
            System.out.println("4. Xem danh sách Project đã hoàn thành");
            System.out.println("5. Thoát");
            System.out.println("Vui lòng lựa chọn [1-5]");
            op=sc.nextLine().trim();
            
            switch(op){
                case "1":
                    o.display();
                    break;
                case "2":
                    o.add();
                    break;
                case "3":
                    System.out.println("Nhập id Project cần xóa ");
                    o.remove(sc.nextLine().trim());
                    break;
                case "4":
                    o.display(Boolean.TRUE);
                    break;
                case "5": 
                    return;
                default: 
                    System.out.println("Xin vui lòng nhập lại [1-5]");
                    break;
            }
        }
    }
    
    public void add(){
        Project p=new Project();
        p.input();
        proList.add(p);
        
        if(ProjectDAO.insert(p)>0){
            System.out.println("Thêm project thành công");
        }
        else{
            System.out.println("Đã xảy ra lỗi !! Thêm project thất bại");
        }
    }
    
    public void remove(String s){
        if(ProjectDAO.delete(s)>0){
            System.out.println("Đã xóa thành công Project có id "+s);
        }
        else{
            System.out.println("Đã xảy ra lỗi !!! Không thể xóa project có id "+s);
        }
    }
    
    public void display(){
        List<Project> ds=ProjectDAO.getList();
        if(ds.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }
        System.out.println("\n>> Danh sách Project <<");
        ds.stream().forEach(System.out::println);
    }
    
    public void display(Boolean ckCompleted){
        List<Project> ds=ProjectDAO.getCompletedProject();
        if(ds.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!");
            return;
        }
        
        System.out.println("\n>> Danh sách Project <<");
        ds.stream().forEach(System.out::println);
    }
}
