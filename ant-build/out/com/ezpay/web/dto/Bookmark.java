package com.ezpay.web.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Bookmark implements Serializable {

    /** identifier field */
    private int id;

    /** persistent field */
    private String username;

    /** nullable persistent field */
    private String url;

    /** full constructor */
    public Bookmark(String username, String url) {
        this.username = username;
        this.url = url;
    }

    /** default constructor */
    public Bookmark() {
    }

    /** minimal constructor */
    public Bookmark(String username) {
        this.username = username;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
