package com.ezpay.web.controller.form;

public class FileForm {

	private String name = null;
	private byte[] contents = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

}
