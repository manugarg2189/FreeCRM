package com.FreeCRMTEST.CompanyName.ProjectName.Helper.JavaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScript helper is initialized");
	}
	
	public Object executeScript(String script){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		return je.executeScript(script);
	}
	public Object executeScript(String script, Object...obj){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		return je.executeScript(script, obj);
	}
	
	public void scrollToElement(WebElement element){
		log.info("scroll to element :"+element.toString());
		executeScript("window.scrollTo(argument[0],argument[1])",element.getLocation().x,element.getLocation().y);
	}
	public void scrollToElementAndClickable(WebElement element){
		log.info("element to click:"+element.toString());
		scrollToElement(element);
		element.click();
	}
	public void scrollIntoView(WebElement element){
		log.info("scroll element to view:"+element.toString());
		executeScript("argument[0].scrollIntoView()",element);
	}
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		log.info("scroll element to click:"+element.toString());
		element.click();
	}
	
	public void scrollDownVertically(){
		log.info("scroll down vertically...");
		executeScript("window.scrollTo(0,document.Body.scrollHeight)");
	}
	public void scrollUpVertically(){
		log.info("scroll up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public void scrollDownByPixel(int pixel){
		log.info("scroll down by pixel");
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	public void scrollUpByPixel(int pixel){
		log.info("scroll Up by pixel");
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	public void zoomBy100Percent(){
		log.info("100 percrent zoom");
		executeScript("document.body.style.zoom = '100%'");
	}
	public void zoomBy60Percent(){
		log.info("100 percrent zoom");
		executeScript("document.body.style.zoom = '60%'");
	}
	public void clickElement(WebElement element){
		executeScript("argument[0].click();",element);
	}
	

}
