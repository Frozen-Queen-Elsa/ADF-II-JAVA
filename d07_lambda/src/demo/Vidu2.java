/*
    Sử dụng function interface[ICasio] và biểu thức lambda
 */
package demo;

import java.util.Scanner;

public class Vidu2 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số thứ 1");
        int a=Integer.parseInt(sc.nextLine().trim());
        System.out.println("Nhập số thứ 2");
        int b=Integer.parseInt(sc.nextLine().trim());
        
        
        //1. Basic Lambda
        ICasio f1=(int n1,int n2)->System.out.printf("%d + %d = %d\n",n1,n2,n1+n2);
        
        //2. Lambda with interface type
        ICasio f2=(n1,n2)->System.out.printf("%d - %d = %d\n",n1,n2,n1-n2);
        
        //Thực hiện biểu thức f1,f2
        f1.calculate(a, b);
        f2.calculate(a, b);
    }
    
}
