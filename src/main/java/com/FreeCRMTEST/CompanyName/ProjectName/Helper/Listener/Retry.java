package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;

public class Retry implements IRetryAnalyzer{

	private Logger log = LoggerHelper.getLogger(Retry.class);
	
	int count = 0;
	int limit = 3;
	public boolean retry(ITestResult result){
		if(count<limit){
			log.info("Retrying test "+result.getName()+" with status :"+getResultStatus(result.getStatus()));
			count++;
			return true;
		}
		return false;
	}

	public String getResultStatus(int status){
		String resultName = null;
		if(status == 1){
			resultName = "Success";
		}
		if(status == 2){
			resultName ="Failure";
		}
		if(status == 3){
			resultName = "Skip";
		}
		return resultName;
	}
}
