package authenticator;

import database.Connect_db;
import dbRepo.Repo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import authenticator.AdminUserAuthenticator;

public class AuthenticatorProxy {
    private final Connect_db dbConnection;
    private final AdminUserAuthenticator adminUserAuthenticator;

    public AuthenticatorProxy() {
        this.dbConnection = new Connect_db("jdbc:postgresql://localhost:5432/virtual_guide", "admin", "S3cret");
        this.adminUserAuthenticator = new AdminUserAuthenticator();
    }

    public boolean authenticate(String email, String password) {
        System.out.println("Authenticating user...");
        try {
            Connection db = dbConnection.connect();
            Repo guideRepo = new Repo();

            List<Object[]> guideInfoList = guideRepo.gudiesDatabaseRepository.getGuideByEmail(db, email);

            if (!guideInfoList.isEmpty()) {
                Object[] guideInfo = guideInfoList.get(0);
                String storedPassword = (String) guideInfo[5];
                if (storedPassword.equals(password)) {
                    return adminUserAuthenticator.authenticate(email, password);
                }
            } else {
                System.out.println("Invalid email or password. Please try again.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Invalid email or password. Please try again.");
            return false;
        }
        return false;
    }
}

