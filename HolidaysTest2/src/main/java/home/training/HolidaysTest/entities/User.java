package home.training.HolidaysTest.entities;

/**
 * Класс сущности User - описывает данные авторизации (логин и пароль),
 * имеет map-таблицу для связи с базой данных посредством технологии Hibernate.
 *
 */
public class User {
	private long _id = 0;
	private String _login;
	private String _password;
	
	public User() {
	}
	
	public User(String login, String password) {
		super();
		_login = login;
		_password = password;
	}
	
	public User(long id, String login, String password) {
		super();
		_id = id;
		_login = login;
		_password = password;
	}
	
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}
		
	public String getLogin() {
		return _login;
	}
	public void setLogin(String login) {
		_login = login;
	}
	public String getPassword() {
		return _password;
	}
	public void setPassword(String password) {
		_password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (_id ^ (_id >>> 32));
		result = prime * result + ((_login == null) ? 0 : _login.hashCode());
		result = prime * result + ((_password == null) ? 0 : _password.hashCode());
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
		User other = (User) obj;
		if (_id != other._id)
			return false;
		if (_login == null) {
			if (other._login != null)
				return false;
		} else if (!_login.equals(other._login))
			return false;
		if (_password == null) {
			if (other._password != null)
				return false;
		} else if (!_password.equals(other._password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id = " + getId() + 
				", login = " + _login + 
				", password = " + _password + "\n";
	}
	
}
