package com.FreeCRMTEST.CompanyName.ProjectName.Helper.ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Logger.LoggerHelper;
import com.FreeCRMTEST.CompanyName.ProjectName.Helper.Resource.ResourceHelper;

public class ExelHelper {
	
	private static Logger log = LoggerHelper.getLogger(ExelHelper.class);

	static String filePath=ResourceHelper.getResource("\\src\\main\\resources\\configfile\\Demo.xlsx");
	static Workbook wb;
	public static String readData(String Sheet, int rownum, int cellnum){
		
		String data="";
		
		try {
			wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
			data= wb.getSheet(Sheet).getRow(rownum).getCell(cellnum).getStringCellValue();
		}
		catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			e.printStackTrace();
		}		
		catch(IOException e){
			log.info(e.getCause());
		}
		catch(EncryptedDocumentException e){
				log.info(e.getCause());
		}
		return data;
  }

	public static void writeData(String sheetName, int rownum,int cellnum, String cellValue){
		try{
			FileInputStream fis = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rownum+1);
		    row.createCell(rownum).setCellValue(cellValue);
		    FileOutputStream fos = new FileOutputStream(new File(filePath));
			workbook.write(fos);
			fos.close();
		}
		catch(NotOfficeXmlFileException e)
		{
			log.info(e.getCause());
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String a[]) {
		writeData("Sheet4", 0, 0, "Manu");
		
	}
	
}
