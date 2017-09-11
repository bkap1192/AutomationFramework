package com.hms.hotelogix.automationframework.pages.GenericMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsHMM {

	
	
	
	
	private  HashMap<String, String> TDMap;
	private static ExcelUtilsHMM EU=null;
	private HashMap<String, HashMap<String, String>> TTDMap;
	
	
	
	
	private ExcelUtilsHMM(){
		 
	}
	
	public static ExcelUtilsHMM UI(){
		if(EU==null){
			EU=new ExcelUtilsHMM();
		}
		return EU;
	}

	
	
	
	public HashMap<String,HashMap<String,String>> getTestCaseDataMap(String filePath, String sheetName) throws IOException{
		 Workbook wBook=getWorkBook(filePath);
		 TDMap=new HashMap<String, String>();
		 TTDMap=new HashMap<String, HashMap<String, String>>();
		 Sheet sheetObj=wBook.getSheet(sheetName);
		 int rowsize=sheetObj.getLastRowNum();
		 for(int j=1; j<=rowsize-1;j++){
		    Row reqRowObj=sheetObj.getRow(j);
		   String tcname= reqRowObj.getCell(0).getStringCellValue();
		    int cellCount=reqRowObj.getLastCellNum()-1;
		    for(int i=2; i<=cellCount-1; i+=2){
		    	Cell cellObj=reqRowObj.getCell(i, Row.CREATE_NULL_AS_BLANK);
		    	String dataKey=cellObj.getStringCellValue();
		    	cellObj=reqRowObj.getCell(i+1, Row.CREATE_NULL_AS_BLANK);
		    	String dataValue=cellObj.getStringCellValue();
		    	TDMap.put(dataKey, dataValue);
		    }
		    TTDMap.put(tcname, TDMap);
		    }
			return TTDMap;
	        }

	
	public Workbook getWorkBook(String filePath) throws IOException{	
		Workbook wBook=null;
		FileInputStream fis=new FileInputStream(filePath);
		if(filePath.endsWith("xlsx")){
			wBook=new XSSFWorkbook(fis);
		}else{
			wBook=new HSSFWorkbook(fis);
		}
		return wBook;
	   }
	
	public int getTDRowNumber(Sheet sheetObj, String TestCaseID){
		int rowCount=sheetObj.getLastRowNum();
		int dataRowNumber=0;
		for(int i=0; i<=rowCount; i++){
			Row rowObj=sheetObj.getRow(i);
			Cell cellObj=rowObj.getCell(0);
			String TCID_cellValue=cellObj.getStringCellValue();
			if(TestCaseID.equalsIgnoreCase(TCID_cellValue)){
				dataRowNumber=i;
				break;
			}
	       }
		return dataRowNumber;
	}
}
