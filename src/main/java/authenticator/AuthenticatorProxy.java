package authenticator;

import database.Connect_db;
import dbRepo.Repo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AuthenticatorProxy implements Authenticator {
    private final Authenticator realAuthenticator;
    private final Connect_db dbConnection;

    public AuthenticatorProxy(Authenticator realAuthenticator) {
        this.realAuthenticator = realAuthenticator;
        this.dbConnection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");
    }

    @Override
    public boolean authenticate(String email, String password) {
        System.out.println("Proxy: Checking if user is an admin");
        try {
            Connection db = dbConnection.connect();
            Repo guideRepo = new Repo();

            List<Object[]> guideInfoList = guideRepo.gudiesDatabaseRepository.getGuideByEmail(db, email);

            if (!guideInfoList.isEmpty()) {
                Object[] guideInfo = guideInfoList.get(0);
                String storedPassword = (String) guideInfo[5];
                if (!storedPassword.equals(password)) {
                    return false;
                }
                realAuthenticator.authenticate(email, password);
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}

