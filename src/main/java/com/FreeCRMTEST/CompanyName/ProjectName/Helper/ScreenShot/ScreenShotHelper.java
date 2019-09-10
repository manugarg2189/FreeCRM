package com.FreeCRMTEST.CompanyName.ProjectName.Helper.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Resource.ResourceHelper;

public class ScreenShotHelper{
	
	private static WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(ScreenShotHelper.class);
	
	public ScreenShotHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public void getScreenShot(String filename){		
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		
		File scrfile = efw.getScreenshotAs(OutputType.FILE);
		File destfile = new File(ResourceHelper.getResource("\\src\\main\\resources\\screenshot\")"+filename+"_"+dateFormat.format(calendar.getTime())+".png"));		
		try{
			FileUtils.copyFile(scrfile, destfile);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
