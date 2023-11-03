public class UserService {

    public boolean authorization (String login, String password) {
        UserRepository myUserRepository = new UserRepository();
        for (User myUser1 : myUserRepository.getUserList()) {
            if (myUser1.getLogin().equals(login) && myUser1.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
