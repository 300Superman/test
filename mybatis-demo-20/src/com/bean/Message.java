package com.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发言
 * @author Administrator
 *
 */
public class Message implements Serializable {
	
	private Integer id;
	private String content;
	private Integer userId;
	private Date time;
	
	private User user; //方式2
	
//	private String userName; //方式1
	
	public Message() {
	}

	public Message(Integer id) {
		this.id = id;
	}
	
	public Message(String content, Integer userId, String time) {
		this.content = content;
		this.userId = userId;
		setTime(time);
	}

	public Message(String content, Integer userId, Date time) {
		this.content = content;
		this.userId = userId;
		this.time = time;
	}

	public Message(Integer id, String content, Integer userId, Date time) {
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", userId=" + userId + ", time=" + time + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}

	public void setTime(String time) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			this.time = format.parse(time);
		} catch (ParseException e) {
			this.time = new Date();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/
}

















