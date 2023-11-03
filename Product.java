import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product implements Comparable<Product> {
    protected String name;
    protected int price;
    protected int rate;

    public Product(String name, int price, int rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public static ArrayList<Product> seeProductBody () {
        ArrayList<Product> products = new ArrayList<>();

        products.add (new Product("Крем для рук" , 180, 7));
        products.add (new Product("Лак для ногтей" , 450, 9));
        products.add (new Product("Жидкость для снятия лака" , 300, 8));

        Collections.sort(products);

        return products;
    }

    public static ArrayList<Product>  seeProductFace () {
        ArrayList<Product>  products = new ArrayList<>();

        products.add (new Product("Крем для лица" , 234, 7));
        products.add (new Product("Пенка для умывания" , 850, 9));

        Collections.sort(products);

        return products;
    }

    public static ArrayList<Product> seeProductHair () {
        ArrayList<Product> products = new ArrayList<>();

        products.add (new Product("Термозащита" , 650, 8));
        products.add (new Product("Лак для волос" , 550, 9));
        products.add (new Product("Спрей для волос" , 300, 8));

        Collections.sort(products);

        return products;
    }
}
