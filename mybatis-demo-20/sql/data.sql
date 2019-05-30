
DROP DATABASE IF EXISTS jt35;
CREATE DATABASE jt35 DEFAULT CHARACTER SET utf8;
USE jt35;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
    u_id INT PRIMARY KEY AUTO_INCREMENT,
    u_userName VARCHAR(30),
    u_password VARCHAR(40),
    u_gender TINYINT,
    u_birthday DATE,
    u_registeTime DATETIME
);

DROP TABLE IF EXISTS t_message;
CREATE TABLE t_message(
    m_id INT PRIMARY KEY AUTO_INCREMENT,
    m_content VARCHAR(400),
    m_userId INT NOT NULL,
    m_time DATETIME
);

INSERT INTO t_user VALUES(1000, 'admin', '9999', 1, '1989-3-7', '2008-10-10 10:10:10');
INSERT INTO t_message VALUES(10000000, '系统上线了~~', 1000, '2008-10-10 10:30:30');


/*
	select * from t_user;
	select * from t_message;
*/





