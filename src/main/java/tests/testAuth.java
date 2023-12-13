package tests;

import authenticator.AdminUserAuthenticator;
import authenticator.Authenticator;
import authenticator.AuthenticatorProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testAuth {
    @Test
    void testAuth() {
        Authenticator adminAuthenticator = new AdminUserAuthenticator();
        Authenticator authenticatorProxy = new AuthenticatorProxy(adminAuthenticator);

        assertFalse(authenticatorProxy.authenticate("wrongEmail", "wrongPassword"));
        assertFalse(authenticatorProxy.authenticate("edi@gmail.com", "pass124"));
        assertTrue(authenticatorProxy.authenticate("edi@gmail.com", "pass123"));
    }

}
