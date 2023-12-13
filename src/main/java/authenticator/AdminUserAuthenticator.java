// UserAuthenticator.java
package authenticator;

import java.util.HashMap;
import java.util.Map;

import authenticator.AuthenticatorProxy;

public class AdminUserAuthenticator {
    private final Map<String, String> userDatabase;

    public AdminUserAuthenticator() {
        // admin database
        userDatabase = new HashMap<>();
        userDatabase.put("edi@gmail.com", "pass123");
        userDatabase.put("tavi@gmail.com", "pass123");
    }

    public boolean authenticate(String username, String password) {
        System.out.println("user...");
        return (userDatabase.containsKey(username) && userDatabase.get(username).equals(password));
    }
}
