
package data2;

import data.*;

public class Product2 {
    public String id, name;
    public int price;

    @Override
    public String toString() {
        return String.format("%s, %s, %d ", id, name, price);
    }

    @Override
    public boolean equals(Object obj) {
        Product2 p = (Product2) obj;
        return this.id.equals(p.id);
    }
    
    @Override
    public int hashCode() {
        return 100;
    }
    
    
}
