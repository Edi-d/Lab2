package controller;

import authenticator.AdminUserAuthenticator;
import authenticator.AuthenticatorProxy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpringController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        AuthenticatorProxy authenticatorProxy = new AuthenticatorProxy();

        if (authenticatorProxy.authenticate(email, password)) {
            return "Login successful!";
        }
        else{
            return "Login failed. Invalid credentials";
        }
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world!";
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
