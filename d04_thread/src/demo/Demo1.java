
package demo;

public class Demo1 {

    public static void main(String[] args) {
        //Lấy tên của main thread
        String ten = Thread.currentThread().getName();
        
        //Đếm có bao nhiêu thread đang chạy trong chương trình / Ứng dụng Demo1
        int dem = Thread.activeCount();
        
        System.out.println("Tên của main thread : "+ten);
        System.out.println("Số lượng thread đang hoạt động "+dem);
        
        m1();
        m2();
    }
    
    static void m1(){
        System.out.println(">>19 si61 nguyên đầu tiên [0-9]");
        for(int i=0;i<10;i++){
            System.out.printf("\t M1: %3d \n",i);
        }
    }
    
    static void m2(){
        System.out.println(">>19 si61 nguyên đầu tiên [9-0]");
        for(int i=9;i>0;i--){
            System.out.printf("\t\t M2: %3d \n",i);
        }
    }
    
}
