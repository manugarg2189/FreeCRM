package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;

public class WindowHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver) {
		this.driver = driver; 
	}
	/*
	 * Switch the window on based on Index
	 * 
	 */
	public void switchToWindow(int index){
		Set<String> window = driver.getWindowHandles();
		int i=1;
		for(String win : window)
		if(i == index){
			log.info("Swtich to window : "+index);
			driver.switchTo().window(win);
		}
		else{
			i++;
		}
	}

	/*
	 * Switch the main window and closed all tabs
	 * 
	 */
	public void closeAllTabAndSwitchToMainWindow(){
		Set<String> window = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for(String win : window)
		if(!win.equalsIgnoreCase(mainWindow)){
			driver.close();
		}
		log.info("Switch the main window");
	}
	
	/*
	 * method will do browser navigation back   
	 */
	public void navigateBack(){
		log.info("get to navigate back ");
		driver.navigate().back();
	}
	
	/*
	 * method will do browser navigation forward   
	 */
	public void navigateForward(){
		log.info("navigate forward");
		driver.navigate().forward();
	}
}
