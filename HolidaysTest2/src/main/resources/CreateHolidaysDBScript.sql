#Comment
DROP DATABASE IF EXISTS holidaysDB;
CREATE DATABASE IF NOT EXISTS holidaysDB;
USE holidaysDB;

create TABLE users
(
	id SERIAL,
	login VARCHAR(64),
	password VARCHAR(64),
	PRIMARY KEY(id)
);

create TABLE holidays
(
	id SERIAL,
	date DATE,
	PRIMARY KEY(id)
			
);



