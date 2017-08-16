package com.ezpay.web.dto.test;

import java.util.List;
import java.util.Set;

public class User {

	private Integer id = null;
	private String username = null;
	private String passwd = null;
	private String email = null;
	private Set bookmarks = null;
	private List favorites = null;
	private List favoriteBookmarks = null;
	private User actualUser = null;
	private User lastUser = null;

	public User() {

	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, User actualUser) {
		this.username = username;
		this.actualUser = actualUser;
	}

	public User(String username, Set bookmarks) {
		this.username = username;
		this.bookmarks = bookmarks;
	}

	public User(String username, List favorites) {
		this.username = username;
		this.favorites = favorites;
	}

	public User(String username, Set bookmarks, List favoriteBookmarks) {
		this.username = username;
		this.bookmarks = bookmarks;
		this.favoriteBookmarks = favoriteBookmarks;
	}

	public User(String username, String passwd, String email, Set bookmarks) {
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.bookmarks = bookmarks;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Set bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List getFavorites() {
		return favorites;
	}

	public void setFavorites(List favorites) {
		this.favorites = favorites;
	}

	public List getFavoriteBookmarks() {
		return favoriteBookmarks;
	}

	public void setFavoriteBookmarks(List favoriteBookmarks) {
		this.favoriteBookmarks = favoriteBookmarks;
	}

	public User getActualUser() {
		return actualUser;
	}

	public void setActualUser(User actualUser) {
		this.actualUser = actualUser;
	}

	public User getLastUser() {
		return lastUser;
	}

	public void setLastUser(User lastUser) {
		this.lastUser = lastUser;
	}

}
