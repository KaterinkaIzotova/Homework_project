import java.util.ArrayList;

public class Basket {
    protected ArrayList<Product> products;
    protected long date;

    public Basket(ArrayList<Product> products, long date) {
        this.products = products;
        this.date = date;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
