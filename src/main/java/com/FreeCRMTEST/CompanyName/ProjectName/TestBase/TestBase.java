package com.FreeCRMTEST.CompanyName.ProjectName.TestBase;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.FreeCRMTEST.CompanyName.ProjectName.ExtentReport.ExtentManager;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Property.GetPropertyValue;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.ScreenShot.ScreenShotHelper;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Wait.WaitstatmentLib;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public WebDriver driver; 
	
	@BeforeSuite
	public void beforeSuit() {
		extent = ExtentManager.getInstance();
	}
	
	@BeforeClass
	public void beforeClass(){
		extentTest = extent.createTest(getClass().getName());
	}
	
	@BeforeMethod
	@Parameters(value="browser")
	public void preCondition(String browsername , Method method)
	{
		extentTest.log(Status.INFO, method.getName()+"Test started");
		if(browsername.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
			
		}else if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ".\\exefiles\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(GetPropertyValue.getProperty("testURL"));
		Reporter.log("Navigate to Url", true);
		WaitstatmentLib.implicitWaitForSecond(Integer.parseInt(GetPropertyValue.getProperty("implicitwaitforsecond")));
	}

	@AfterMethod
	public void postCondition(ITestResult result)
	{
		if(result.getStatus() == ITestResult.SUCCESS){
			extentTest.log(Status.PASS, result.getName()+" test passed");
		}
		if(result.getStatus() == ITestResult.FAILURE){
			extentTest.log(Status.FAIL, result.getThrowable());
			String filename = result.getMethod().getMethodName();			
			ScreenShotHelper sh = new ScreenShotHelper(driver);
			sh.getScreenShot(filename);
		}
		if(result.getStatus() == ITestResult.SKIP){
			extentTest.log(Status.SKIP, result.getName()+" test skip");
		}
		extent.flush();
		driver.quit();
	}
}
