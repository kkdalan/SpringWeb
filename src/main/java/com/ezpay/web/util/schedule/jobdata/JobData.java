package com.ezpay.web.util.schedule.jobdata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JobData {

	public String getData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		return "Date time = " + sdf.format(new Date()).toString();
	}

}
