import java.util.Scanner;

public class Menu {
    public static void menu() {
        System.out.println("Чтобы посмотреть каталог товаров нажмите 1.");
        System.out.println("Чтобы посмотреть список товаров определенного каталога, введите 2. ");
        System.out.println("Чтобы добавить товар в корзину, нажмите 3.");
        System.out.println("Чтобы перейти в корзину нажмите 4.");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        switch (x) {
            case 1:
                Category.seeCatalog(Product.seeProductBody());
                break;
            case 2:
                System.out.println("Выберите каталог из предложенных:"
                        + "\n" + "1 - Для лица" + "\n" + "2- Для тела" + "\n" + "3 - Для волос");
                int z = scan.nextInt();

                if (z == 1) {
                    System.out.println("Товары отсортированы по стоимости, вывести по убыванию (1) или по возрастанию (2)?.");
                    int t = scan.nextInt();
                    if (t == 2) {
                        System.out.println(Product.seeProductFace());
                    } else if ( t == 1) {
                        System.out.println(Product.seeProductFace().reversed());
                    }
                } else if (z ==2 ) {
                    System.out.println("Товары отсортированы по стоимости, вывести по убыванию (1) или по возрастанию (2)?.");
                    int t = scan.nextInt();
                    if (t == 2) {
                        System.out.println(Product.seeProductBody());
                    } else if (t == 1) {
                        System.out.println(Product.seeProductBody().reversed());
                    }
                }
                else if (z == 3) {
                    System.out.println("Товары отсортированы по стоимости, вывести по убыванию (1) или по возрастанию (2)?.");
                    int t = scan.nextInt();
                    if (t == 2) {
                        System.out.println(Product.seeProductHair());
                    } else if ( t == 1) {
                        System.out.println(Product.seeProductHair().reversed());
                    }
                }
                break;
            case 7:
                break;
            case 12:

        }
    }

}
