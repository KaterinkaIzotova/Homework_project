public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Крем для лица" , 234, 7);
        Product product2 = new Product("Пенка для умывания" , 850, 9);
        Product product3 = new Product("Крем для рук" , 180, 7);
        Product product4 = new Product("Термозащита" , 899, 8);

        Category categoryFace = new Category("Для Лица", null );
        categoryFace.products.add(product1);
        categoryFace.products.add(product2);

        Category categoryBody = new Category("Для Тела", null);
        categoryBody.products.add(product3);

        Category categoryHair = new Category("Для Волос", null);
        categoryHair.products.add(product4);

        Basket basket1 = new Basket(null);
        basket1.products.add(product2);
        basket1.products.add(product4);
        basket1.products.add(product1);

        Basket basket2 = new Basket(null);
        basket2.products.add(product3);
        basket2.products.add(product1);
        basket2.products.add(product4);

        User user1 = new User("Konfetka", "12345", basket1);
        User user2 = new User("Luchik", "54321", basket2);

        System.out.println("Пользователь: " + user1.getLogin() + "\n" + "Купил: ");
        for (Product product : user1.basket.products) {
            System.out.println(product.getName());
        }
        System.out.println("Пользователь: " + user2.getLogin() + "\n" + "Купил: ");
        for (Product product : user2.basket.products) {
            System.out.println(product.getName());
        }

    }
}