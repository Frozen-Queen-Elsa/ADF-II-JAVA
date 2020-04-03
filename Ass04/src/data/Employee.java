/*
    1. Tạo class Employee, bao gồm :
        a. Các fields dữ liệu:
            i. String id, name, address
            ii. int salary, joinedYear (Năm gia nhập công ty)
        b. Các contructors: để khởi tạo giá trị ban đầu cho các field dữ liệu.
        c. Override method public String toString()
        d. Method void input() : nhập và kiểm tra thông tin chi tiết của 1 nhân viên:
            - id : EMxxxx, với x là ký số.
            - name, address : không dược để trống
            - salary : từ [100, 10000] , jointYear : từ 1980 - 2016
 */
package data;

import java.io.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Employee implements Serializable,Comparable<Employee>{
    public String id,name,address;
    public int salary,joinedYear;

    public Employee() {
    }

    public Employee(String id, String name, String address, int salary, int joinedYear) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.joinedYear = joinedYear;
    }

    @Override
    public String toString() {
        return String.format("ID : %s - Name : %s - Add : %s - Salary : %d - JoinedYear : %d",id,name,address,salary,joinedYear);
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        
        //Nhập ID
        Pattern p = Pattern.compile("EM\\d{4}",Pattern.CASE_INSENSITIVE);
        Matcher m= null;
        while(true){
            System.out.println(">> Vui lòng nhập ID [EMxxxx]");
            id=sc.nextLine().trim().toUpperCase();
            m=p.matcher(id);
            if(m.matches()) break;
            System.out.println("ID phải có định dạng EMxxxx !!!\n Xin vui lòng nhập lại\n");            
        }
        
        //Nhập name
        while(true){
            System.out.println(">> Vui lòng nhập tên");
            name=sc.nextLine().trim();
            if(name.length()>0) break;
            System.out.println(" Name không được để trống !! \n Xin vui lòng nhập lại\n");
        }
        
        //Nhập address
        while(true){
            System.out.println(">> Vui lòng nhập địa chỉ");
            address=sc.nextLine().trim();
            if(address.length()>0) break;
            System.out.println(" Address không được để trống !! \n Xin vui lòng nhập lại\n");
        }
        
        //Nhập salary
        while(true){
            System.out.println(">> Vui lòng nhập lương");
            salary=Integer.parseInt(sc.nextLine().trim());
            if(salary>=100 && salary<=10000) break;
            System.out.println("Salary phải nằm trong khoảng [100-10000] !! \n Xin vui lòng nhập lại \n");
        }
        
        //Nhập joinedYear
        while(true){
            System.out.println(">> Vui lòng nhập năm gia nhập");
            joinedYear=Integer.parseInt(sc.nextLine().trim());
            if(joinedYear>=1980 && joinedYear<=2016) break;
            System.out.println("Joined Year phải nằm trong khoảng [1980-2016] !! \n Xin vui lòng nhập lại \n");
        }
        
    }
   
    public int GetYears(){
        int year=Year.now().getValue();
        return year-joinedYear;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        Employee e=(Employee) obj;
        return this.id.equals(e.id);
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }
    
    
}
