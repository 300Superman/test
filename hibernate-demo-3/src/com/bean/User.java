package com.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class User implements Serializable {

	/** 编号 */
	private Integer id;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	/** 性别 */
	private Integer gender;
	/** 生日 */
	private Date birthday;
	/** 注册日期 */
	private Date registeTime;
	
	/* 一对多 */
	private Set<Message> messages;
	
	public User() {
	}
	
	public User(Integer id) {
		this.id = id;
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(Integer id, String password) {
		this.id = id;
		this.password = password;
	}

	public User(String userName, String password, Integer gender, String birthday, String registeTime) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		setBirthday(birthday);
		setRegisteTime(registeTime);
	}

	public User(String userName, String password, Integer gender, Date birthday, Date registeTime) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.registeTime = registeTime;
	}
	
	public User(Integer id, String userName, String password, Integer gender, String birthday, String registeTime) {
		this(userName, password, gender, birthday, registeTime);
		this.id = id;
	}

	public User(Integer id, String userName, String password, Integer gender, Date birthday, Date registeTime) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.registeTime = registeTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", birthday=" + birthday + ", registeTime=" + registeTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void setBirthday(String birthday) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			this.birthday = format.parse(birthday);
		} catch (ParseException e) {
			try {
				this.birthday = format.parse("2001-10-1");
			} catch (ParseException e1) {
			}
		}
		
	}

	public Date getRegisteTime() {
		return registeTime;
	}
	
	public void setRegisteTime(String registeTime) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			this.registeTime = format.parse(registeTime);
		} catch (ParseException e) {
			try {
				this.registeTime = format.parse("2010-10-1 12:01:00");
			} catch (ParseException e1) {
			}
		}
	}

	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}











