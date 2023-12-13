package authenticator;

public interface Authenticator {
    boolean authenticate(String email, String password);
}
