package com.FreeCRMTEST.CompanyName.ProjectName.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.FreeCRMTEST.CompanyName.ProjectName.TestBase.TestBase;
import com.FreeCRMTEST.CompanyName.ProjectName.page.LoginPage;

class LoginCRMTest extends TestBase
{
	LoginPage lp = new LoginPage(driver);
	
	@Test(priority=1)
	public void loginTitle()
	{
		String tile = lp.validateLoginPageTitle(driver);
		Assert.assertEquals(tile, "actiTIME - Login");		
	}
	
	@Test(priority=2)
	public void loginLogo()
	{
		boolean flag = lp.validateCRMImage();
		Assert.assertTrue(flag);	
	}
	

}
