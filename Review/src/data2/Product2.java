package data2;

public class Product2 implements java.io.Serializable{
    public String id, name;
    public int price;

    @Override
    public String toString() {
        return String.format("%s, %s, %d ", id, name, price);
    }

    //ck noi dung
    @Override
    public boolean equals(Object obj) {
        Product2 p = (Product2) obj;
        return this.id.equals(p.id);
    }
    
    //ck bo nho
    @Override
    public int hashCode() {
        return 100;
    }
    
    
}
