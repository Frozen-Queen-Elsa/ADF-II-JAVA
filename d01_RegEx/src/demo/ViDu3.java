/*
 vi du ve bieu thuc chinh qui : 
 - kiem tra ma so Nhan Vien co hop le ko ?
   MaNV hop le: bat dau "N" hoac "Q", tiep theo tu 5 ky so.
 - kiem tra chuc vu co hop le hay ko ?
   Chuc vu hop le : hoac la chuoi "nv" hoac "ql" hoac "gd"
 */
package demo;

import java.util.*;
import java.util.regex.*;
public class Vidu3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String manv=null;
        String chucvu =null;
        
        //1. kiem tra ma so nhan vien
        Pattern p = Pattern.compile("[NQ]\\d{5}");  // \\d <=> [0-9]
        Matcher m = null;
        while(true){
            System.out.print("nhap ma nhan vien: ");
            manv = sc.nextLine().trim();
            
            m= p.matcher(manv);
            if(m.matches()){
                break;
            }
            System.out.println("Ma Nhan Vien KO HOP LE. Phai bat dau 'N' hoac 'Q', sau do la 5 ky so");
        }//ket thuc vong lap WHILE 
        
        //2. kiem tra chuc vu hop le 
        p = Pattern.compile("(NV|QL|GD)", Pattern.CASE_INSENSITIVE);
        m = null;
        while(true){
            System.out.print("nhap chuc vu nhan vien: ");
            chucvu = sc.nextLine().trim();
            
            m= p.matcher(chucvu);
            if(m.matches()){
                break;
            }
            System.out.println("chuc vu KO HOP LE. Phai 'NV' hoac 'QL', hoac 'GD'");
        }//ket thuc vong lap WHILE 
        
        System.out.println("\nThong tin nhan vien: ");
        System.out.println("Ma so: " + manv);
        System.out.println("Chuc vu (viet tat): " + chucvu );
    }
    
}
