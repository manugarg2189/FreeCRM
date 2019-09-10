package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;

public class AlertHelper {
	
	private static WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver){
		this.driver = driver;
		log.info("Alert object is created....");
	}

	public Alert getAlert(){	
		log.info("Alert test :"+driver.switchTo().alert().getText());
		return driver.switchTo().alert(); 
	}
	
	public void getAccept(){	
		getAlert().accept();
		log.info("Alert test is accept...");
	}
	public void getDismiss(){	
		getAlert().dismiss();;
		log.info("Alert test is dismiss...");
	}
	
	public  String getText(){	
		String text = getAlert().getText();
		log.info("Alert test :"+text);
		return text;
	}
	
	public boolean alertIsPresent(){		
		try{
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch(NoAlertPresentException e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIsPresent(){
		if(alertIsPresent()){
			getAccept();
		}
		else{
			log.info("alert is not present...");
		}	
	}
	
	public void dismissAlertIsPresent(){
		if(alertIsPresent()){
			getDismiss();
		}
		else{
			log.info("alert is not present...");
		}	
	}
	
	public void acceptPrompt(String text){
		if(alertIsPresent()){
			Alert alt = driver.switchTo().alert();
			alt.sendKeys(text);
			alt.accept();
			log.info("alert send Text :"+text);
		}	
	}
}
