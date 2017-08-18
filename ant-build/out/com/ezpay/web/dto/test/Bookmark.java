package com.ezpay.web.dto.test;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Bookmark implements Serializable {

    /** identifier field */
    private int id;

    /** nullable persistent field */
    private String username;

    /** nullable persistent field */
    private String url;

    /** persistent field */
    private Set users;

    /** persistent field */
    private Set comments;

    /** full constructor */
    public Bookmark(String username, String url, Set users, Set comments) {
        this.username = username;
        this.url = url;
        this.users = users;
        this.comments = comments;
    }

    /** default constructor */
    public Bookmark() {
    }

    /** minimal constructor */
    public Bookmark(Set users, Set comments) {
        this.users = users;
        this.comments = comments;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set getUsers() {
        return this.users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getComments() {
        return this.comments;
    }

    public void setComments(Set comments) {
        this.comments = comments;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
