package com.bean;

import java.io.Serializable;

/**
 * 信息实体
 * @author Administrator
 *
 */
public class Message implements Serializable{

	private Integer id;
	private String title;
	private String content;
	private Integer userId;
	
	/* 主表对应的java类型, 单个对象 */
	private User user;
	
	public Message() {
	}

	public Message(Integer id) {
		this.id = id;
	}

	public Message(String title, String content, Integer userId) {
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public Message(Integer id, String title, String content, Integer userId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
