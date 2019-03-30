package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Registration;

public class DummyRegistrationRepository implements RegistrationRepository {

    @Override
    public Registration getRegistrationByLogin(String login) {
        Registration user = null;

        Connection con = HSQLDBConnection.getConnection();
        System.out.println("Connection Obtained");

        try {
            PreparedStatement preparedStmt = con.prepareStatement(
                    "SELECT name, login, isPremium, email, isAdmin FROM users where login = ? LIMIT 1");
            preparedStmt.setString(1, login);
            ResultSet result = preparedStmt.executeQuery();

            while (result.next()) {
                user = new Registration();
                user.setName(result.getString("name"));
                user.setLogin(result.getString("login"));
                user.setIsPremium(result.getBoolean("isPremium"));
                user.setIsAdmin(result.getBoolean("isAdmin"));
                user.setEmail(result.getString("email"));
            }
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return user;

    }

    @Override
    public Boolean checkPassword(String login, String password) {
        Boolean correctPassword = false;

        Connection con = HSQLDBConnection.getConnection();
        System.out.println("Connection Obtained");

        try {
            PreparedStatement preparedStmt = con.prepareStatement(
                    "SELECT name, login, isPremium, email, isAdmin FROM users where login = ? AND password = ? LIMIT 1");
            preparedStmt.setString(1, login);
            preparedStmt.setString(2, password);
            ResultSet result = preparedStmt.executeQuery();

            while (result.next()) {
                correctPassword = true;
            }
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return correctPassword;

    }

    @Override
    public List<Registration> GetAllUsersData() {
        List<Registration> userList = new ArrayList<Registration>();

        Connection con = HSQLDBConnection.getConnection();
        System.out.println("Connection Obtained");

        try {
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT name, login, isPremium, email FROM users");

            while (result.next()) {
                Registration user = new Registration();
                user.setName(result.getString("name"));
                user.setLogin(result.getString("login"));
                user.setIsPremium(result.getBoolean("isPremium"));
                user.setEmail(result.getString("email"));
                userList.add(user);
            }
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return userList;
    }

    @Override
    public void add(Registration registration) {
        Connection con = HSQLDBConnection.getConnection();
        System.out.println("Connection Obtained");

        try {
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?)");
            preparedStmt.setString(1, registration.getName());
            preparedStmt.setString(2, registration.getLogin());
            preparedStmt.setString(3, registration.getEmail());
            preparedStmt.setString(4, registration.getPassword());
            preparedStmt.setBoolean(5, registration.getIsPremium());
            preparedStmt.setBoolean(6, registration.getIsAdmin());

            preparedStmt.executeUpdate();
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void updatePremiumStatus(String[] loginList, String[] checkedList) throws SQLException {
        Connection con = HSQLDBConnection.getConnection();
        System.out.println("Connection Obtained");

        for (String login : loginList) {
            try {

                PreparedStatement preparedStmt = con.prepareStatement("UPDATE users SET isPremium = ? WHERE login = ?");
                preparedStmt.setBoolean(1, Arrays.asList(checkedList).contains(login));
                preparedStmt.setString(2, login);
                preparedStmt.executeUpdate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        con.close();
    }

}
