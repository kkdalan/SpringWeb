package com.ezpay.web.util.schedule.job;

import com.ezpay.web.util.schedule.jobdata.JobData;

public class DemoMethodJob {

	private JobData jobData = null;

	public void execute() {
		System.out.println(jobData.getData() + " MethodInvokingJob is executed!");
	}

	public JobData getJobData() {
		return jobData;
	}

	public void setJobData(JobData jobData) {
		this.jobData = jobData;
	}

}
