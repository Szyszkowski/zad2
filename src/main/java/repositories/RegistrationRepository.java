package repositories;

import java.sql.SQLException;
import java.util.List;

import domain.Registration;

public interface RegistrationRepository {
	Registration getRegistrationByLogin (String login);
	Boolean checkPassword (String login, String password);
	void add(Registration registration);
	List<Registration> GetAllUsersData();
	void updatePremiumStatus (String[] loginList, String[] checkedList) throws SQLException;
}

