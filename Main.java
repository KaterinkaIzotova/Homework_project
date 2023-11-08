import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        UserManager userManager = new UserManager();
        List<Category> categories = new ArrayList<>();

        Category hairCategory = new Category("Товары для волос");
        hairCategory.addProduct(new Product("Термозащита"     , 650.50, 4.0));
        hairCategory.addProduct(new Product("Спрей для волос" , 299.99, 8.2));
        hairCategory.addProduct(new Product("Лак для волос"   , 549.99, 7.3));

        Category faceCategory = new Category("Товары для лица");
        faceCategory.addProduct(new Product("Крем для лица"      , 234.50, 7.3));
        faceCategory.addProduct(new Product("Пенка для умывания" , 850.50, 6.2));

        Category bodyCategory = new Category("Товары для тела");
        bodyCategory.addProduct(new Product("Крем для рук"             , 179.99, 7.3));
        bodyCategory.addProduct(new Product("Лак для ногтей"           , 449.99, 9.1));
        bodyCategory.addProduct(new Product("Жидкость для снятия лака" , 324.99, 8.0));

        categories.add(hairCategory);
        categories.add(bodyCategory);
        categories.add(faceCategory);

        User currentUser = null;

        userManager.registerUser("admin", "1234");

        while (isRunning) {
            System.out.println("1. Просмотр каталога товаров");
            System.out.println("2. Просмотр товаров определенного каталога");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Покупка товаров в корзине");
            System.out.println("5. Регистрация пользователя");
            System.out.println("6. Выйти из программы");

            System.out.println("Введите цифру из меню:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Просмотр каталога товаров
                    System.out.println("Выберите параметр сортировки (имя, цена, рейтинг):");
                    String sortBy = scanner.next();
                    System.out.println("Отсортировать в обратном порядке? (да/нет)");
                    boolean reverseOrder = "да".equalsIgnoreCase(scanner.next());

                    for (Category category : categories) {
                        System.out.println("Категория: " + category.getName());
                        CatalogPrinter.printSortedCatalog(category.getProducts(), sortBy, reverseOrder);
                    }
                    break;
                case 2:
                    // Просмотр товаров определенного каталога
                    System.out.println("Введите имя категории:");
                    String categoryName = scanner.nextLine();

                    Category selectedCategory = null;

                    for (Category category : categories) {
                        if (category.getName().equalsIgnoreCase(categoryName)) {
                            selectedCategory = category;
                            break;
                        }
                    }

                    if (selectedCategory != null) {
                        for (Product product : selectedCategory.getProducts()) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("Категория с таким именем не найдена.");
                    }
                    break;
                case 3:
                    // Аутентификация пользователя
                    System.out.println("войдите в свой аккаунт чтобы добавить товар в корзину");

                    System.out.println("Введите логин:");
                    String username = scanner.next();
                    System.out.println("Введите пароль:");
                    String password = scanner.next();
                    scanner.nextLine();

                    currentUser = userManager.authenticateUser(username, password) ?
                            new User(username, password) : null;

                    // Добавить товар в корзину
                    if (currentUser != null) {
                        // Пользователь должен быть аутентифицирован
                        System.out.println("Введите имя товара, который вы хотите добавить в корзину:");
                        String productName = scanner.nextLine();

                        Product productToAdd = null;

                        for (Category category : categories) {
                            productToAdd = category.findProductByName(productName);
                            if (productToAdd != null)
                                break;
                        }

                        if (productToAdd != null) {
                            currentUser.getBasket().addProductToBasket(productToAdd);
                            System.out.println("Товар успешно добавлен в корзину.");
                        } else {
                            System.out.println("Товар с таким именем не найден.");
                        }
                    } else {
                        System.out.println("Вы не аутентифицированы. Пожалуйста, войдите или зарегистрируйтесь.");
                    }
                    break;

                case 4:
                    // Покупка товаров в корзине
                    if (currentUser != null) {
                        Basket userBasket = currentUser.getBasket();
                        if (!userBasket.getPurchasedProducts().isEmpty()) {
                            System.out.println("Введите имя файла для записи отчёта:");
                            String fileName = scanner.nextLine();
                            userBasket.makePurchase(fileName);
                            System.out.println("Отчёт записан в файл: " + fileName);
                        } else {
                            System.out.println("Корзина пуста. Выберите товары для покупки.");
                        }
                    } else {
                        System.out.println("Вы не аутентифицированы. Пожалуйста, войдите или зарегистрируйтесь.");
                    }
                    break;
                case 5:
                    // Регистрация пользователя
                    System.out.println("Введите логин:");
                    String newUsername = scanner.next();
                    System.out.println("Введите пароль:");
                    String newPassword = scanner.next();

                    if (userManager.registerUser(newUsername, newPassword)) {
                        System.out.println("Пользователь зарегистрирован успешно.");
                    } else {
                        System.out.println("Пользователь с таким логином уже существует.");
                    }
                    break;

                case 6:
                    // Выйти из программы
                    isRunning = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }

        scanner.close();
    }
}

