package controller;

import authenticator.AdminUserAuthenticator;
import authenticator.Authenticator;
import authenticator.AuthenticatorProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpringController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authenticator adminAuthenticator = new AdminUserAuthenticator();
        Authenticator authenticatorProxy = new AuthenticatorProxy(adminAuthenticator);

        if (authenticatorProxy.authenticate(email, password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Login failed. Invalid credentials");
        }
    }

}

class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
