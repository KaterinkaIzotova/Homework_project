import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> userList = new ArrayList<>();

    public UserRepository() {
        this.userList.add(new User("Konfetka", "12345", null));
        this.userList.add(new User("Luchik", "54321", null));
    }
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
