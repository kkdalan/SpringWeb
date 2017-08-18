package com.ezpay.web.dto.test;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class FavoriteBookmark implements Serializable {

    /** nullable persistent field */
    private String desc;

    /** nullable persistent field */
    private com.ezpay.web.dto.test.Bookmark bookmark;

    /** full constructor */
    public FavoriteBookmark(String desc, com.ezpay.web.dto.test.Bookmark bookmark) {
        this.desc = desc;
        this.bookmark = bookmark;
    }

    /** default constructor */
    public FavoriteBookmark() {
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public com.ezpay.web.dto.test.Bookmark getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(com.ezpay.web.dto.test.Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
