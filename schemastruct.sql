USE lms;
CREATE TABLE userdetails(
id INTEGER(5)  AUTO_INCREMENT,
 user_id VARCHAR  (50) ,
f_name VARCHAR (50) NOT NULL,
 l_name VARCHAR (50) NOT NULL,
 email  VARCHAR (50) NOT NULL,
mobile_no VARCHAR (40) NOT NULL,
 gender VARCHAR (5) NOT NULL,
state VARCHAR (50),
 city VARCHAR (50),
PRIMARY KEY(id),
UNIQUE (email),
UNIQUE (mobile_no),
UNIQUE (user_id)
);
USE lms;
CREATE TABLE usercred(
id INTEGER (4) AUTO_INCREMENT,
user_id VARCHAR (50) NOT NULL,
password VARCHAR (50) NOT NULL, 
PRIMARY KEY(id),
UNIQUE(user_id),
UNIQUE(password)
);