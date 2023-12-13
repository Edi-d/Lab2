package tests;

import authenticator.AdminUserAuthenticator;
import authenticator.AuthenticatorProxy;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testAuth {
    @Test
    void testAuth() {
        AuthenticatorProxy authenticatorProxy = new AuthenticatorProxy();

        assertFalse(authenticatorProxy.authenticate("wrongEmail", "wrongPassword"));
        assertFalse(authenticatorProxy.authenticate("edi@gmail.com", "pass12"));
        assertTrue(authenticatorProxy.authenticate("edi@gmail.com", "pass123"));
    }

}
