package controller;

import authenticator.AdminUserAuthenticator;
import authenticator.Authenticator;
import authenticator.AuthenticatorProxy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpringController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authenticator adminAuthenticator = new AdminUserAuthenticator();
        Authenticator authenticatorProxy = new AuthenticatorProxy(adminAuthenticator);

        if (authenticatorProxy.authenticate(email, password)) {
            return "Login successful!";
        }
        else{
            return "Login failed. Invalid credentials";
        }

    }

    // Add more request mapping methods as needed
}

class LoginRequest {
    private String email;
    private String password;

    // Getters and setters

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
