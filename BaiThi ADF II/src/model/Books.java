
package model;

import java.util.*;

public class Books {
    public int BookID,Edition;
    public String Title,Author;

    public Books() {
    }

    public Books(int BookID, int Edition, String Title, String Author) {
        this.BookID = BookID;
        this.Edition = Edition;
        this.Title = Title;
        this.Author = Author;
    }
    
    
    
    public void acceptBook() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(">>Nhập Title : ");
            Title = sc.nextLine().trim();
            if(Title.length()>0 && Title.length()<=40){
                break;
            }
            System.out.println("Title không được NULL và có tối đa 40 ký tự");
        }
        
        while (true) {
            System.out.print(">>Nhập Author : ");
            Author = sc.nextLine().trim();
            if(Author.length()>0 && Author.length()<=40){
                break;
            }
            System.out.println("Author không được NULL và có tối đa 40 ký tự");
        }

        while(true){
            try {
                System.out.print(">>Nhập Edition : ");
                Edition = Integer.parseInt(sc.nextLine().trim());
                if(Edition>=1){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Loi: "+ e.getMessage());
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("ID : %d - Title : %s - Author : %s - Edition : %d\n",BookID,Title,Author,Edition);
    }
    
    
    
}
