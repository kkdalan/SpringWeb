package com.ezpay.web.dto.test;

public class FavoriteBookmark {
	private String desc = null;
	private Bookmark bookmark = null;

	public FavoriteBookmark() {
		 
	}
	
	public FavoriteBookmark(String desc, Bookmark bookmark) {
		this.desc = desc;
		this.bookmark = bookmark;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}

}