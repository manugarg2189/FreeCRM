package com.FreeCRMTEST.CompanyName.ProjectName.Helper.Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotation, Class testclass, 
			Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(Retry.class);
	}

}
