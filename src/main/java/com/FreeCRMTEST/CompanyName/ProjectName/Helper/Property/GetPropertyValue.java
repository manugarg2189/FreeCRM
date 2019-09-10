package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.ExcelUtility.ExelHelper;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Resource.ResourceHelper;
import com.google.common.io.Resources;

public class GetPropertyValue 
{
	private static Logger log = LoggerHelper.getLogger(GetPropertyValue.class);

	public static String getProperty(String key)
	{
		String value = "";
		try
		{		
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(ResourceHelper.getResource("\\src\\main\\java\\com\\crm\\config\\Config.properties"))));
			value = prop.getProperty(key);
			log.info("Key is :"+key);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{	
			e.printStackTrace();
		}
		return value;
	}
}
