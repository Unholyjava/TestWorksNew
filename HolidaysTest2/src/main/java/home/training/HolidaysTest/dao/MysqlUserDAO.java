package home.training.HolidaysTest.dao;

import java.util.Collection;


import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import home.training.HolidaysTest.entities.User;

/**
 * Класс MysqlUserDAO выполняет доступ к базе данных посредством 
 * объекта Session и предоставляет коллекцию объектов User.
 * 
 */
public class MysqlUserDAO implements UserDAO {

	private Session _session;
	public MysqlUserDAO(Session session) {
		_session = session;
	}
	
	public Collection<User> getAll() {
		NativeQuery<User> query = _session.createNativeQuery("SELECT * FROM users", User.class);
		Collection<User> result = query.list();
		
		return result;
		
	}
	
}
