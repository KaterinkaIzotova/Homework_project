import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CatalogPrinter {
    public static void printSortedCatalog(List<Product> catalog, String sortBy, boolean reverseOrder) {
        if (catalog.isEmpty()) {
            System.out.println("Каталог товаров пуст.");
            return;
        }

        System.out.println("Товары в каталоге:");

        Comparator<Product> comparator = null;
        if ("имя".equalsIgnoreCase(sortBy)) {
            comparator = Comparator.comparing(Product::getName);
        } else if ("цена".equalsIgnoreCase(sortBy)) {
            comparator = Comparator.comparing(Product::getPrice);
        } else if ("рейтинг".equalsIgnoreCase(sortBy)) {
            comparator = Comparator.comparing(Product::getRate);
        } else {
            System.out.println("Некорректный параметр сортировки.");
            return;
        }

        // Сортировка в обратном порядке
        if (reverseOrder) {
            comparator = comparator.reversed();
        }
        // Сортировка
        catalog.sort(comparator);

        for (Product product : catalog) {
            System.out.println(product);
        }
    }
}
