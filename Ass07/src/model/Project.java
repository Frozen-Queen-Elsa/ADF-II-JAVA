/*
    ii. Tạo class Project, bao gồm :
        1. Các fields dữ liệu (mô tả cấu trúc bảng tbEmployee):
            int id
            String projectName, startDate
            int value
            boolean completed
        2. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
        3. Các method:
            public void input()
            public void String toString()
 */
package model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Project {
    public int id=100,value;
    public String projectName,startDate;
    public boolean completed;

    public Project() {
    }

    public Project(int id, int value, String projectName, String startDate, boolean completed) {
        this.id = id;
        this.value = value;
        this.projectName = projectName;
        this.startDate = startDate;
        this.completed = completed;
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("== Nhập dữ liệu Project ==");
        
        while(true){
            System.out.println(">> Input ProjectName");
            projectName=sc.nextLine().trim();
            if(projectName.length()<=30 &&projectName.length()>0) break;
            System.out.println("Project Name nhiều nhất 30 ký tự và không thể là NULL");
        }
        
        Pattern p=Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
        Matcher m=null;
        while(true){
            System.out.println(">> Input StartDate [YYYY/MM/DD]");
            startDate=sc.nextLine().trim();
            m=p.matcher(startDate);
            if(m.matches()) break;
            System.out.println("Start Date phải có định dạng [YYYY/MM/DD]");
        }
        
        while(true){
            Scanner sc1=new Scanner(System.in);
            System.out.println(">> Completed ? [Y/N]");
            if(sc1.nextLine().trim().toUpperCase().equals("Y")){
                completed=true;
                break;
            }
                
            if(sc1.nextLine().trim().toUpperCase().equals("N")){
                completed=false;
                break;
            }
                
            else
                System.out.println("Xin vui lòng nhập lại [Y/N]");
        }
        
        while(true){
            System.out.println(">> Input Value");
            value=Integer.parseInt(sc.nextLine().trim());
            if(value>0) break;
            System.out.println("Value phải lớn hơn 0");
        }
        
        
    }

    @Override
    public String toString() {
        return String.format("ID : %d - ProjectName : %s - StartDate : %s - Value : %d - Completed : %s",id,projectName,startDate,value,completed?"Y":"N");
    }
    
    
    
    
}
