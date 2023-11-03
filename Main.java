import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    /*
        Basket basket1 = new Basket(null);
        basket1.products.add(product2);
        basket1.products.add(product4);
        basket1.products.add(product1);

        Basket basket2 = new Basket(null);
        basket2.products.add(product3);
        basket2.products.add(product1);
        basket2.products.add(product4);
*/

/*
        System.out.println("Пользователь: " + user1.getLogin() + "\n" + "Купил: ");
        for (Product product : user1.basket.products) {
            System.out.println(product.getName());
        }
        System.out.println("Пользователь: " + user2.getLogin() + "\n" + "Купил: ");
        for (Product product : user2.basket.products) {
            System.out.println(product.getName());
        }
*/


        System.out.println("Введите логин: ");
        String strLogin = scan.nextLine();

        System.out.println("Веедите пароль: ");
        String strPassword = scan.nextLine();

        UserService myUserService = new UserService();
        if (myUserService.authorization(strLogin,strPassword)) {
            Menu.menu();
        }
        else
            System.out.println("Неверный логин или пароль!");

    }

}