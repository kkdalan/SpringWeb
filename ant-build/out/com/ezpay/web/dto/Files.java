package com.ezpay.web.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Files implements Serializable {

    /** identifier field */
    private int id;

    /** nullable persistent field */
    private String filename;

    /** nullable persistent field */
    private String notes;

    /** nullable persistent field */
    private String type;

    /** nullable persistent field */
    private byte[] content;

    /** full constructor */
    public Files(String filename, String notes, String type, byte[] content) {
        this.filename = filename;
        this.notes = notes;
        this.type = type;
        this.content = content;
    }

    /** default constructor */
    public Files() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return this.content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
