package home.training.HolidaysTest.services;

import java.util.Collection;

import home.training.HolidaysTest.dao.UserDAO;
import home.training.HolidaysTest.entities.User;

/**
 * Класс возвращает boolean-значение, которое позволяет определить,
 * совпадают ли данные авторизации пользователя (логин и пароль) с
 * данными, хранящимся в базе данных.
 * Связь с базой данных осуществляется посредством класса MysqlUserDAO. 
 *
 */
public class UserService {
	private UserDAO _userDAO = null;
	public UserService (UserDAO userDAO) {
		_userDAO = userDAO;
	}
	
	public boolean isLoginPasswordCorrect (User user) {
		Collection<User> allUsers = _userDAO.getAll();
		for (User users: allUsers) {
			if (users.getLogin().equals(user.getLogin()) &&
				users.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
