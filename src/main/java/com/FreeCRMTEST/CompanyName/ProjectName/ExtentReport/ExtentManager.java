package com.FreeCRMTEST.CompanyName.ProjectName.ExtentReport;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Resource.ResourceHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		if(extent == null){
			return craeteInstnce(ResourceHelper.getResource("//test-output//extent.html"));
		}else{
			return extent;
		}
	}
	
	public static ExtentReports craeteInstnce(String filename){
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.config().setDocumentTitle("Automation FreeCRM report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Tester-name", "Manu Garg");
		extent.setSystemInfo("OS", "Win-10");
		return extent;
	}
}
