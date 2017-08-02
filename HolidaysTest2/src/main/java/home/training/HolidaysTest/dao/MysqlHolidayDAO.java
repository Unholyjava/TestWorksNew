package home.training.HolidaysTest.dao;

import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import home.training.HolidaysTest.entities.Holiday;

/**
 * Класс MysqlHolidayDAO выполняет доступ к базе данных посредством 
 * объекта Session и предоставляет коллекцию объектов Holiday.
 * 
 */
public class MysqlHolidayDAO implements HolidayDAO {

	private Session _session;
	public MysqlHolidayDAO(Session session) {
		_session = session;
	}

	public Collection<Holiday> getAll() {
		NativeQuery<Holiday> query = _session.createNativeQuery("SELECT * FROM holidays", Holiday.class);
		Collection<Holiday> result = query.list();
		
		return result;
	}
	
}
