package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;

public class WaitstatmentLib 
{	
	private static WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(WaitstatmentLib.class);
	
	public WaitstatmentLib(WebDriver driver){
		this.driver = driver;
	}
	public static void implicitWaitForSecond(int time)
	{
		log.info("Implicit wait has been set for second :"+time);
		driver.manage().timeouts().implicitlyWait(time,	TimeUnit.SECONDS);
	}
	public static void implicitWaitForMinute(int time)
	{
		log.info("Implicit wait has been set for minute :"+time);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	
	private static WebDriverWait getWait(int timeout, int pollingEveryInMilliSec)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMilliSec)); 
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait; 
		
	}
	
	public static void explicitWaitForVisiblity(WebElement element, int time, int pollEverySecond)
	{
		log.info("wait for :"+element.toString()+"for :"+ time +"seconds");
		WebDriverWait wait = getWait(time, pollEverySecond);	
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is Visble now");
	}
	public static void explicitWaitForClickable(WebElement element, int time)
	{
		log.info("wait for :"+element.toString()+"for :"+ time +"seconds");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		log.info("element is Visble now");
	}
	
	/*
	 * Fluent wait
	 * param int timeforsecond
	 * param int pollingEverySecond
	 * 
	 */
	 private Wait<WebDriver> getFluentWait(int timeforsecond, int pollingEverySecond)
	 {
		 Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(timeforsecond))
				 .pollingEvery(Duration.ofMillis(pollingEverySecond))
				 .ignoring(NoSuchElementException.class);
		 
		 return fwait;
	 }
	 
	 public WebElement waitforElement(WebElement element, int timeforsecond, int pollingEverySecond)
	 {
		 Wait<WebDriver> fwait = getFluentWait(timeforsecond, pollingEverySecond);
		 fwait.until(ExpectedConditions.visibilityOf(element));
		 return element;
	 }
	
	
}
