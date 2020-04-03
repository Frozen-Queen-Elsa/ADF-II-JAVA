
package raceCondition;

public class TestRaceCondition {


    public static void main(String[] args) {
        System.out.println("TEST RACE CONDITION - Sharing ATM Account");
        
        //khoi tao tai khoan dung chung cho 2 thread
        ATMaccount acc = new ATMaccount("TK Iris", 800);
        
        //khoi tao thread papa
        Thread cha = new Thread(new Papa(acc));
        
        //khoi tao thread con
        Thread con = new Thread(new Son(acc));
        
        //khoi dong 2 thread cha va con
        cha.start();
        con.start();
    }
    
}
