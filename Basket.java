import java.util.ArrayList;

public class Basket {
    protected ArrayList<Product> products;

    public Basket(ArrayList<Product> products) {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
