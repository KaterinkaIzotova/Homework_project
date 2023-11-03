import java.util.ArrayList;
public class Category {
    protected String name;
    protected ArrayList <Product> products;

    public Category(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


    public static void seeCatalog(ArrayList<Product> myProdyct) {
        Category categoryFace = new Category("Для Лица", null );
        for (int i = 0; i < myProdyct.size(); i++) {
            categoryFace.products.add(myProdyct.get(i));
        }

        Category categoryBody = new Category("Для Тела", null);
        for (int i = 0; i < myProdyct.size(); i++) {
            categoryFace.products.add(myProdyct.get(i));
        }

        Category categoryHair = new Category("Для Волос", null);
        for (int i = 0; i < myProdyct.size(); i++) {
            categoryFace.products.add(myProdyct.get(i));
        }

        System.out.println("Каталог товаров: " + "\n" + categoryFace.getName() + "\n"
                + categoryBody.getName() + "\n" + categoryHair.getName()
        );

    }
}

