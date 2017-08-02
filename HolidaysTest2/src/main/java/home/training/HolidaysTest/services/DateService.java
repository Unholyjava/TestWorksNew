package home.training.HolidaysTest.services;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

import home.training.HolidaysTest.dao.HolidayDAO;
import home.training.HolidaysTest.entities.Holiday;
/**
 * Класс в основном публичном методе выполняет вычислительную логику, 
 * а именно:
 * - вычисляет количество выходных дней (субботы и воскресенья) 
 *   между двумя датами в формате LocalDate,
 * - вычисляет количество праздников за исключением тех, что выпадают 
 *   на выходные, причем, данные по праздникам извлекаются из базы данных
 *   посредством класса MysqlHolidayDAO.
 * Таким образом, возвращается суммарный результат выходных и праздничных
 * дней. Во вспомогательном методе dateToLocalDate(Date) производится
 * конвертация данных из базы данных формата sql-Date в формат LocalDate.
 *
 */
public class DateService {
	private HolidayDAO _holidayDAO = null;
	
	public DateService (HolidayDAO holidayDAO) {
		_holidayDAO = holidayDAO;
	}
		
	public int holidayNumber (LocalDate startDate, LocalDate endDate) {
        int weekendCount = countWeekend(startDate, endDate);
		int weekendCountDB = countWeekendDB(startDate, endDate);
		int weekendCountAll = weekendCount + weekendCountDB;
		//вывод в консоль для отладки и демонстрации
		System.out.println("Количество выходных (сб. и вс.): " + weekendCount);
		System.out.println("Количество праздников (не включаются сб. и вс.): "
			+ weekendCountDB);
		return weekendCountAll;
	}
	
	private LocalDate dateToLocalDate (Date date) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		java.util.Date utilDate = new java.util.Date(date.getTime());
		Instant instant = utilDate.toInstant();		
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		return localDate;
	}

	private int countWeekendDB(LocalDate startDate, LocalDate endDate) {
		Collection<Holiday> allHoliday = _holidayDAO.getAll();
		int weekdaysDB = 0;
		for (Holiday holidays: allHoliday) {
			LocalDate holidaysNextDB = dateToLocalDate(holidays.getHoliday());
			if ((holidaysNextDB.isBefore(endDate) && holidaysNextDB.isAfter(startDate))
					|| (holidaysNextDB.isEqual(endDate)
						|| holidaysNextDB.isEqual(startDate))) {
				if (!DayOfWeek.SATURDAY.equals(holidaysNextDB.getDayOfWeek())
						&& !DayOfWeek.SUNDAY.equals(holidaysNextDB.getDayOfWeek())) {
					++weekdaysDB;
				}
			}
		}
		return weekdaysDB;
	}

	private int countWeekend(LocalDate startDate, LocalDate endDate) {
		int weekdays = 0;
		while(startDate.isBefore(endDate)) {
			if (DayOfWeek.SATURDAY.equals(startDate.getDayOfWeek())
					|| DayOfWeek.SUNDAY.equals(startDate.getDayOfWeek())) {
				++weekdays;
			}
			startDate = startDate.plusDays(1);
		}
				
		if (startDate.isEqual(endDate) && 
				(endDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) 
					|| endDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
		return ++weekdays;
		} else	{ 
			if (startDate.isEqual(endDate)) {
				return weekdays;
			}
		}
		return weekdays;
	}		
}
