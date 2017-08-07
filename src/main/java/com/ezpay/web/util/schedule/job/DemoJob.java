package com.ezpay.web.util.schedule.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ezpay.web.util.schedule.jobdata.JobData;

public class DemoJob extends QuartzJobBean {

	private JobData jobData = null;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println(jobData.getData() + " SimpleJob is executed!");
	}
	
	public JobData getJobData() {
		return jobData;
	}

	public void setJobData(JobData jobData) {
		this.jobData = jobData;
	}

}
