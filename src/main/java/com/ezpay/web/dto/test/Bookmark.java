package com.ezpay.web.dto.test;

import java.util.Set;

public class Bookmark {
	private Integer id = null;
	private String username = null;
	private String url = null;
	private Set users = null;
	private Set comments = null;

	public Bookmark() {

	}

	public Bookmark(String url) {
		this.url = url;
	}

	public Bookmark(String url, Set users) {
		this.url = url;
		this.users = users;
	}
	
	public Bookmark(String url, Set users, Set comments) {
		this.url = url;
		this.users = users;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getUsers() {
		return users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getComments() {
		return comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}