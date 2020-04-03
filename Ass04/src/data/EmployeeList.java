/*
    2. Tạo Java Main class EmployeeList bao gồm :
        a. Các fields dữ liệu:
            i. HashSet< Employee> empList để lưu danh sách nhân viên.
        b. Default contructor:
            i. khởi tạo field empList . Đọc file NV.txt, nếu có, vô ds empList
        c. void addEmp() : thêm 1 nhân viên mới vô danh sách empList. Yêu cầu kiểm tra trùng mã.
        d. boolean searchByName() : Tìm nhân viên theo tên được nhập từ bàn phím
        e. void display() : In toàn bộ danh sách nhân viên ra màn hình
        f. void display(int years) : In danh sách nhân viên có thâm niên công tác trên years năm
        g. void writeFileText() : Ghi ds nv vô tập tin vb “NV.txt”
        h. void ReadFileText() : Đọc tập tin văn bản “NV.txt”, phân tích dữ liệu và lưu vô danh sách empList
        i. trong hàm main tạo menu để gọi các hàm trên.
 */
package data;

import java.util.HashSet;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeList {

    
    HashSet<Employee> empList=new HashSet<Employee>();
    public String fname;
    
    public EmployeeList() {
        empList=new HashSet<>();
        fname="NV.txt";
        ReadFileText();
    }
    
    
    
    public static void main(String[] args) {
        EmployeeList o=new EmployeeList();
        while(true){
            Scanner sc=new Scanner(System.in);
            String op="";
            System.out.println(">>MENU<<");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Tìm kiếm nhân viên");
            System.out.println("3. Hiện thỉ toàn bộ danh sách nhân viên");
            System.out.println("4. Tìm kiếm nhân viên có thâm niên công tác");
            System.out.println("5. Ghi File");
            System.out.println("6. Thoát");
            System.out.println("Xin vui lòng lựa chọn [1-6]");
            op=sc.nextLine().trim();
            
            switch(op){
                case "1":
                    o.add();
                    break;
                case "2":
                    String ename;
                    System.out.println(">> Xin vui lòng nhập tên nhân viên cần tìm");
                    ename=sc.nextLine().trim();
                    o.search(ename);
                    break;
                case "3":
                    o.display();
                    break;
                case "4":
                    int year;
                    System.out.println(">> Xin vui lòng nhập số năm công tác cần tìm");
                    year=sc.nextInt();
                    o.display(year);
                    break;
                case "5":
                    o.WriteFileText();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Xin vui lòng lựa chọn lại [1-6]");
                    break;
            }
            
        }
                
    }

    
    private void WriteFileText(){
        ObjectOutputStream os;
        try {
            //Open file để ghi dữ liêu5
            os = new ObjectOutputStream(new FileOutputStream(fname));
            //Ghi dữ liệu : ghi đối tượng empLise
            os.writeObject(empList);
            //Đóng file
            os.close();
            System.out.println("Hệ thóng đã ghi file thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    private void ReadFileText() {        
        
        
        try {
            //Kiểm tra file có tồn tại hay không ?
            File f=new File(fname);
            if(f.exists()==false){
                return;
            }
            //Open file để đọc dữ liệu
            ObjectInputStream is=new ObjectInputStream(new FileInputStream(fname));
            
            //Đọc dữ liệu trong tập tin NV.txt -> danh sách Nhân viên
            empList=(HashSet<Employee>) is.readObject();
            
            //Đóng file
            is.close();
            System.out.println("Hệ thóng đã đọc file thành công");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    private void add() {
        Scanner sc=new Scanner(System.in);
        Employee e=new Employee();
        e.input();
        
        if(empList.contains(e)){
            System.out.println("Dữ liệu bị trùng từ chối thêm mới ");
        }
        else{
            empList.add(e);
        }
    }

    private void search(String ename) {
        if(empList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!!");
        }
        
        int cnt=0;
        for(Employee item:empList ){
            if(item.name.toLowerCase().contains(ename.toLowerCase())){
                System.out.println(item);
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("Hệ thống không tìm thấy nhân viên có tên "+ename);
        }
        else{
            System.out.println("Hệ thống tìm thấy "+cnt+" nhân viên có tên "+ename);
        }
    }

    private void display() {
        if(empList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!!");
        }
        empList.stream().forEach(System.out::println);
    }

    private void display(int year) {
        if(empList.isEmpty()){
            System.out.println("Hệ thống chưa có dữ liệu !!!");
        }
        
        int cnt=0;
        for(Employee item:empList){
            if(item.GetYears()>=year){
                System.out.println(item);
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("Hệ thống không tim thấy nhân viên nào có số năm làm việc nhiều hơn "+year+" năm");
        }
        else{
            System.out.println("Hệ thống tìm thấy "+cnt+ " nhân viên có sô năm làm việc nhiều hơn "+year+" năm");
        }
    }
    
    
    
    
}
