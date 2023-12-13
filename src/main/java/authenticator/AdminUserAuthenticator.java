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
    public boolean authenticate(String email, String password) {
        if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
