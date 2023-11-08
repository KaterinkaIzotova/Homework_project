import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private String name;
    private double price;
    private double rate;

    public Product(String name, double price, double rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return String.format("%-20s %s %-18s", name, "цена - " + formatPrice(price), "рейтинг - " + rate);
    }

    private String formatPrice(double price) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(price);
    }
}
