
package data4;

public class Product {
    public String id, name;
    public int price;

    @Override
    public String toString() {
        return String.format("%s, %s, %d ", id, name, price);
    }

}
