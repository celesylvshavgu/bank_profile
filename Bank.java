import java.util.ArrayList;

public class Bank {
    private ArrayList<Profile> users;

    public Bank() {
        this.users = new ArrayList<>();
    }

    public void addUser(Profile user) {
        users.add(user);
    }

    public Profile getUser(String username) {
        for (Profile p : users) {
            if (p.getUsername().equalsIgnoreCase(username)) return p;
        }
        return null;
    }

    public Profile login(String username, String password) {
        Profile p = getUser(username);
        if (p != null && p.getPassword().equals(password)) {
            return p;
        }
        return null;
    }
}