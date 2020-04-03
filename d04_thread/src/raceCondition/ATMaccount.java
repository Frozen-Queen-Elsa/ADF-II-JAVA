/*
sharing resouce
 */
package raceCondition;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ATMaccount {

    public String accNo;
    public int balance;

    public ATMaccount() {
        accNo = "TK100";
        balance = 100;
    }

    public ATMaccount(String accNo, int balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("TK: %s - so du: %d \n", accNo, balance);
    }

    //nap tien vo tai khoan
    synchronized public void deposit(int amt) {
        //thong bao  nap tien
        System.out.printf("\t DAT LENH NAP TIEN %d \n", amt);

        balance += amt;

        //in tb ket thuc giao dich thanh cong
        System.out.printf("\t Nap tien [%d] thanh cong\n", amt);

        //in ra so du tk
        System.out.println("\t " + this);
        
        notify();
    }

    //rut tien ra 
    synchronized public void withdraw(int amt) {
        //thong bao yeu cau rut tien
        System.out.printf("DAT LENH RUT TIEN [%d] \n", amt);
        
        while (true) {
            if (balance > amt) {
                balance -= amt;

                //in tb ket thuc giao dich thanh cong
                System.out.printf("Rut tien [%d] thanh cong \n", amt);

                //in ra so du tk
                System.out.println(this);
                break;
            } else {
                System.out.printf("So tien muon rut [%d] > so du hien tai [%d] !!! \n", amt, balance);
                System.out.println("Hãy đợi đấy ... !");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}