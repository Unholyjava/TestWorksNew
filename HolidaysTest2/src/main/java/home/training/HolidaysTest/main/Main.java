package home.training.HolidaysTest.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import home.training.HolidaysTest.dao.HolidayDAO;
import home.training.HolidaysTest.dao.MysqlHolidayDAO;
import home.training.HolidaysTest.dao.MysqlUserDAO;
import home.training.HolidaysTest.dao.UserDAO;
import home.training.HolidaysTest.entities.User;
import home.training.HolidaysTest.services.DateService;
import home.training.HolidaysTest.services.UserService;
/**
 * Класс Main представляет собой имитацию работы пользовательского
 * интерфейса для проверки и демонстрации работы основной части программы
 * без веб-интерфейса.
 * Входные данные для работы программы должны быть предоставлены
 * в результате работы сервлетов InputLogin и InputData.
 * 
 */
public class Main {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
                .configure()
                .buildSessionFactory();
		Session session = sf.openSession();
		
		UserDAO userDAO = new MysqlUserDAO(session);
		HolidayDAO holidayDAO = new MysqlHolidayDAO(session);
		
		System.out.println(userDAO.getAll());
		System.out.println(holidayDAO.getAll());
		
		UserService us = new UserService(userDAO);
		//данные должны быть получены в результате работы сервлета InputLogin
		User isUserCorrect = new User("Max", "mac");
		boolean isCorrect = us.isLoginPasswordCorrect(isUserCorrect);
		System.out.println(isCorrect);
		
		DateService servisDB = new DateService(holidayDAO);
		//данные должны быть получены в результате работы сервлета InputData
		LocalDate startDate = LocalDate.of(2017, 01, 1);
		LocalDate endDate = LocalDate.of(2017, 01, 9);
		int weekendAll = servisDB.holidayNumber(startDate, endDate);
		System.out.println("Количество выходных всего: " + weekendAll);
		
		session.close();
		sf.close();
	}
}
