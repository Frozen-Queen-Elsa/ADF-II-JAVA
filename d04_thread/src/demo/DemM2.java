/*
    Hoạt động như 1 thread - in ra 1 chuỗi số nguyên từ 9-0
 */
package demo;

public class DemM2 implements Runnable{

    @Override
    public void run() {
            String ten=Thread .currentThread().getName();
            System.out.println("Tên của Thread : "+ten);
            System.out.println(">>10 số nguyên đầu tiên [9-0]");
            for(int i=9;i>=0;i--){
                System.out.printf("\t\t "+ten+": %3d \n",i);
                try {
                    Thread.sleep(700); // nghỉ 500 ms 
                } catch (InterruptedException ex) {
                    System.out.println("Lỗi: "+ex.getMessage());
                }
            }
        
    }
    
}
