import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Basket {
    private List<Product> purchasedProducts;
    private Date purchaseDate;

    public Basket() {
        this.purchasedProducts = new ArrayList<>();
        this.purchaseDate = new Date();
    }

    public void addProductToBasket(Product product) {
        purchasedProducts.add(product);
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void makePurchase(String fileName) {
        if (!purchasedProducts.isEmpty()) {
            double totalCost = calculateTotalCost();

            // Отчёт о покупке
            String pDate = "Дата: " + purchaseDate;
            String pTitle = "Продукты   Категория         Цена";
            String pDelimiter = "--------------------------------------";
            String pTotal = "Итого: " + formatPrice(totalCost);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writeAndPrint(writer, pDate);
                writeAndPrint(writer, pTitle);
                writeAndPrint(writer, pDelimiter);
                for (Product product : purchasedProducts) {
                    writeAndPrint(writer, product.toString());
                }
                writeAndPrint(writer, pDelimiter);
                writeAndPrint(writer, pTotal);
            } catch (IOException e) {
                System.out.println("Ошибка при записи отчёта в файл");
            }

            // Очистка корзины после покупки
            purchasedProducts.clear();
        } else {
            System.out.println("Корзина пуста. Выберите товары для покупки.");
        }
    }

    private void writeAndPrint(BufferedWriter writer, String string) throws IOException {
        System.out.println(string);
        writer.write(string);
        writer.newLine();
    }

    private double calculateTotalCost() {
        double totalCost = 0.0;
        for (Product product : purchasedProducts) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    private String formatPrice(double price) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(price);
    }
}
