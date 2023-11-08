public class User {
    private String username;
    private String password;
    private Basket basket;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.basket = new Basket();
    }

    public Basket getBasket() {
        return basket;
    }

}
