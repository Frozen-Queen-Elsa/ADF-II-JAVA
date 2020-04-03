/*
Mo ta 1 nhan vien, bao gom:
thuoc tinh: 
    id (Exxx), 
    ten (a-z , it nhat la 3 ky tu), 
    luongcb >100, 
    bo phan (IT/ACC/AD/SM)
phuong thuc:
    nhap / xuat / toString
 */

package data;

import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class Employee implements Comparable<Employee>, Serializable{
    public String id, name, dept;
    public int salary;

    public Employee() {
    }

    public Employee(String id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        //nhap ma so nhan vien Exxx
        Pattern p = Pattern.compile("E\\d{3}");
        Matcher m = null;
        while(true){
            System.out.print(" nhap id (Exxx): ");
            id= sc.nextLine().trim();
            m = p.matcher(id);
            
            if(m.matches()){
                break;
            }
            System.out.println(" >> ma so ko hop le !!!");
        }//ket thuc nhap id
        
        //nhap ten nhan vien
        p = Pattern.compile("[a-z ]{3,}", Pattern.CASE_INSENSITIVE);
        while(true){
            System.out.print(" nhap ten nhan vien (it nhat 3 ky tu chu) :");
            name = sc.nextLine().trim();
            
            m = p.matcher(name);
            if(m.matches()){
                break;
            }
            System.out.println(" >> ten ko hop le !!!");
        }//ket thuc nhap ten nhan vien
        
        //nhap ma bo phan
        p = Pattern.compile("(IT|ACC|SM|AD)", Pattern.CASE_INSENSITIVE);
        while(true){
            System.out.print(" nhap ma bo phan (IT|ACC|SM|AD): ");
            dept = sc.nextLine().trim();
            
            m = p.matcher(dept);
            if(m.matches()){
                break;
            }
            System.out.println(" >> ma bo phan ko hop le !!!");
        }// ket thuc nhap ma bo phan
        
        //nhap muc luong 
        while(true){
            System.out.print(" nhap luong cb (>=300) : ");
            try {
                salary = Integer.parseInt(sc.nextLine().trim());
                if(salary>=300){
                    break;
                }
                throw new Exception(" luong cb ko hop le !");
            } catch (Exception e) {
                System.out.println(" >> Loi : "+ e.getMessage());
            }
        } //ket thuc nhap luong
    }//ket thuc ham input()
    
    //ham xuat du lieu
    public void output(){
        System.out.println("  Thong tin nhan vien: ");
        System.out.println("id: " + id);
        System.out.println("ten: " + name);
        System.out.println("bo phan: " + dept);
        System.out.println("luonhg cb: "+ salary);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %s", id, name, salary, dept);
    }

    //override 2 ham equals() va hashcode() de xu ly trung dl trong collection
    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
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
