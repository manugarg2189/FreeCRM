package com.FreeCRMTEST.CompanyName.ProjectName.Helper.DropDown;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;

public class DropDownHelper {
	
	private static WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver){
		this.driver = driver;
		log.info(" Dropdown object is created...");
	}

	
	public void selectByValue(WebElement element, String value){
		Select sel = new Select(element);
		log.info("Dropdown value is select :"+value);
		sel.selectByValue(value);
		
	}
	public void selectByIndex(WebElement element, int index){
		Select sel = new Select(element);
		log.info("Dropdown value is select :"+index);
		sel.selectByIndex(index);
	}
	public void selectByVisbleText(WebElement element, String text){
		Select sel = new Select(element);
		log.info("Dropdown value is select by visible text :"+text);
		sel.selectByVisibleText(text);
	}
	public void deSelectByVisbleText(WebElement element, String text){
		Select sel = new Select(element);
		log.info("Dropdown value is deselect by visible text :"+text);
		sel.deselectByVisibleText(text);
	}
	public void deSelectByValue(WebElement element, String value){
		Select sel = new Select(element);
		log.info("Dropdown value is deselect by Value :"+value);
		sel.deselectByValue(value);
	}
	public void deselectByIndex(WebElement element, int index){
		Select sel = new Select(element);
		log.info("Dropdown value is deselect by index :"+index);
		sel.deselectByIndex(index);
	}
	
	public void deselectAll(WebElement element){
		Select sel = new Select(element);
		log.info("Dropdown all value is deselect");
		sel.deselectAll();
	}
	
	public List<String> getAllDropDownData(WebElement element){
		
		Select sel = new Select(element);
		List<WebElement> elementList = sel.getOptions();
		List<String> value = new LinkedList<String>();
		for (WebElement ele : elementList) {
			log.info(ele.getText());
			value.add(ele.getText());
		}
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
