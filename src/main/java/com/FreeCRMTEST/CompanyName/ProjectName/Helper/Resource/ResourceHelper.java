package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Resource;

public class ResourceHelper {
	
	public static String getResource(String path)
	{
		String basePath = System.getProperty("user.dir");
		
		String ab = basePath+path;
		System.out.println(ab);
		
		return basePath+path ;
	}

}
