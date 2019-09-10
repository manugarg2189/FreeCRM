package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;;

public class FrameHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver) {
		this.driver = driver; 
	}
	
	/*
	 * switch to frame child to parent
	 */
	public void switchToParentFrame(){
		driver.switchTo().defaultContent();
		log.info("Switch to Parent");
	}
	
	/*
	 * switch to frame based on frame index
	 */
	public void switchFrame(int frameIndex){
		driver.switchTo().frame(frameIndex);
		log.info("Switch to :"+frameIndex+"frame");
	}
	/*
	 * switch to frame based on WebElemnt
	 */
	public void switchFrame(WebElement element){
		driver.switchTo().frame(element);
		log.info("Switch to :"+element.toString()+"frame");
	}
	/*
	 * switch to frame based on frameName
	 */
	
	public void switchFrame(String frameName){
		driver.switchTo().frame(frameName);
		log.info("Switch to :"+frameName+"frame");
	}
	
	

}
