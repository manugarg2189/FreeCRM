package com.FreeCRMTEST.CompanyName.ProjectName.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Wait.WaitstatmentLib;



public class LoginPage 
{
	     WebDriver driver;
	//Page Factory - OR:
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(id="loginButton")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[contains(@src,'img/default/login/timer.gif')]")
		WebElement crmLogo;
		
		//Initializing the Page Objects:
		public LoginPage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(WebDriver driver){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			WaitstatmentLib.explicitWaitForClickable(driver, 20, crmLogo);
			return crmLogo.isDisplayed();
		}
		
		
}
