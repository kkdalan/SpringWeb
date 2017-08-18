package com.ezpay.web.dto.test;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class User implements Serializable {

    /** identifier field */
    private int id;

    /** nullable persistent field */
    private String username;

    /** nullable persistent field */
    private String passwd;

    /** nullable persistent field */
    private String email;

    /** nullable persistent field */
    private com.ezpay.web.dto.test.User actualUser;

    /** nullable persistent field */
    private com.ezpay.web.dto.test.User lastUser;

    /** persistent field */
    private List favorites;

    /** persistent field */
    private List favoriteBookmarks;

    /** persistent field */
    private Set bookmarks;

    /** full constructor */
    public User(String username, String passwd, String email, com.ezpay.web.dto.test.User actualUser, com.ezpay.web.dto.test.User lastUser, List favorites, List favoriteBookmarks, Set bookmarks) {
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.actualUser = actualUser;
        this.lastUser = lastUser;
        this.favorites = favorites;
        this.favoriteBookmarks = favoriteBookmarks;
        this.bookmarks = bookmarks;
    }

    /** default constructor */
    public User() {
    }

    /** minimal constructor */
    public User(List favorites, List favoriteBookmarks, Set bookmarks) {
        this.favorites = favorites;
        this.favoriteBookmarks = favoriteBookmarks;
        this.bookmarks = bookmarks;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public com.ezpay.web.dto.test.User getActualUser() {
        return this.actualUser;
    }

    public void setActualUser(com.ezpay.web.dto.test.User actualUser) {
        this.actualUser = actualUser;
    }

    public com.ezpay.web.dto.test.User getLastUser() {
        return this.lastUser;
    }

    public void setLastUser(com.ezpay.web.dto.test.User lastUser) {
        this.lastUser = lastUser;
    }

    public List getFavorites() {
        return this.favorites;
    }

    public void setFavorites(List favorites) {
        this.favorites = favorites;
    }

    public List getFavoriteBookmarks() {
        return this.favoriteBookmarks;
    }

    public void setFavoriteBookmarks(List favoriteBookmarks) {
        this.favoriteBookmarks = favoriteBookmarks;
    }

    public Set getBookmarks() {
        return this.bookmarks;
    }

    public void setBookmarks(Set bookmarks) {
        this.bookmarks = bookmarks;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
