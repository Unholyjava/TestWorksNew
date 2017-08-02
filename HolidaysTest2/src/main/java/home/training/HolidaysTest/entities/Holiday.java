package home.training.HolidaysTest.entities;

import java.util.Date;

/**
 * Класс сущности Holiday - описывает выходные дни в формате sql-Date,
 * имеет map-таблицу для связи с базой данных посредством технологии Hibernate.
 *
 */
public class Holiday {
	private long _id = 0;
	private Date _holiday;
	
	public Holiday() {
	}
	
	public Holiday(long id, Date holiday) {
		super();
		_id = id;
		_holiday = holiday;
	}
	
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}
	
	public Date getHoliday() {
		return _holiday;
	}
	
	public void setHoliday(Date holiday) {
		_holiday = holiday;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_holiday == null) ? 0 : _holiday.hashCode());
		result = prime * result + (int) (_id ^ (_id >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Holiday other = (Holiday) obj;
		if (_holiday == null) {
			if (other._holiday != null)
				return false;
		} else if (!_holiday.equals(other._holiday))
			return false;
		if (_id != other._id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id = " + getId() + 
				", holiday = " + _holiday + "\n";
	}
		
}
