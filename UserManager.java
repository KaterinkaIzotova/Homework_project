import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> userCredentials; // Логин и пароль пользователей

    public UserManager() {
        this.userCredentials = new HashMap<>();
    }

    // Регистрация нового пользователя
    public boolean registerUser(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, password);
            return true;
        }
        return false; // Пользователь с таким логином уже существует
    }

    // Аутентификация пользователя
    public boolean authenticateUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            return storedPassword.equals(password);
        }
        return false; // Пользователь не найден
    }

    public Map<String, String> getUserCredentials() {
        return userCredentials;
    }
}
