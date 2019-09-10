package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Resource.ResourceHelper;

public class LoggerHelper {

	private static boolean root = false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		
			PropertyConfigurator.configure(ResourceHelper.getResource("\\src\\main\\resources\\configfile\\Log4j.properties"));
			root = true;
			return Logger.getLogger(cls);
	
	}
	
	public static void main(String a[]){
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		log.info("Logger is configured");
		log.info("Logger is configured");
		log.info("Logger is configured");
		
	}
	
}
