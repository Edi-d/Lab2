// UserAuthenticator.java
package authenticator;

import java.util.HashMap;
import java.util.Map;

public class AdminUserAuthenticator implements Authenticator {
    private final Map<String, String> userDatabase;

    public AdminUserAuthenticator() {
        // admin database
        userDatabase = new HashMap<>();
        userDatabase.put("edi@gmail.com", "pass123");
        userDatabase.put("tavi@gmail.com", "pass123");
    }

    @Override
    public void authenticate(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful. Welcome to the Admin page, " + username + "!");
        } else {
            System.out.println("User not an Admin!");
        }
    }
}
