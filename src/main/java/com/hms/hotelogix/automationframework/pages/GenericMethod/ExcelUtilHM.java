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

public class ExcelUtilHM {
	
	private  HashMap<String, String> TDMap;
	private static ExcelUtilHM EU=null;
	private HashMap<String, HashMap<String, String>> TTDMap;
	
	
	private ExcelUtilHM(){
		
	}
	
	public static ExcelUtilHM UI(){
		if(EU==null){
			EU=new ExcelUtilHM();
		}
		return EU;
	}

	
	public  HashMap<String, String> getTestCaseDataMap(String filePath, String sheetName, String TCID) throws IOException{
		 Workbook wBook=getWorkBook(filePath);
		 TDMap=new HashMap<String, String>();
		 Sheet sheetObj=wBook.getSheet(sheetName);
		 int rowNumber=getTDRowNumber(sheetObj, TCID);
		    Row reqRowObj=sheetObj.getRow(rowNumber);
		    int cellCount=reqRowObj.getLastCellNum()-1;
		    for(int i=2; i<=cellCount-1; i+=2){
		    	Cell cellObj=reqRowObj.getCell(i, Row.CREATE_NULL_AS_BLANK);
		    	String dataKey=cellObj.getStringCellValue();
		    	cellObj=reqRowObj.getCell(i+1, Row.CREATE_NULL_AS_BLANK);
		    	String dataValue=cellObj.getStringCellValue();
		    	TDMap.put(dataKey, dataValue);
		    }
			return TDMap;
	        }

	
	public Workbook getWorkBook(String filePath) throws IOException{	
		Workbook wBook=null;
		//String ext=filePath.split("Block.")[1];
		FileInputStream fis=new FileInputStream(filePath);
		//if(ext.equalsIgnoreCase("xlsx")){
			wBook=new XSSFWorkbook(fis);
		//}else{
			//wBook=new HSSFWorkbook(fis);
		//}
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

	
	
	public String fn_fetchData(String filePath, String sheetName, String rowname, String column) throws Exception{
		String val=null;
		try{
			 Workbook wBook=getWorkBook(filePath);
			 Sheet sobj=wBook.getSheet(sheetName);
			 int rownum=fn_RowNum(sobj, rowname);
			 int coulumnum=fn_column(sobj, column);
			 Row robj=sobj.getRow(rownum);
			 Cell cellobj= robj.getCell(coulumnum);
			 cellobj.setCellType(Cell.CELL_TYPE_STRING);
			 val=cellobj.getStringCellValue();
		}catch(Exception e){
			throw e;
		}
		 return val;
	    }
	
	
	public int fn_column(Sheet sheetName, String column){
		int rownum=sheetName.getLastRowNum();
		int columnnumber=0;
		for(int i=0; i<=rownum; i++){
			Row row=sheetName.getRow(0);
		    Cell cell=row.getCell(i,Row.CREATE_NULL_AS_BLANK);
		    String cellvalue=cell.getStringCellValue();
		    if(cellvalue.equals(column)){
		    	columnnumber=i;
		    	break;
		    }
		    }
		return columnnumber;
	}
	
	
	public int fn_RowNum(Sheet sheetName, String rowname){
		try{
			int rownum=sheetName.getLastRowNum();
			int rownumber=0;
			for(int i=0; i<=rownum; i++){
				Row row=sheetName.getRow(i);
			    Cell cell=row.getCell(0,Row.CREATE_NULL_AS_BLANK);
			    String cellvalue=cell.getStringCellValue();
			    if(cellvalue.equals(rowname)){
			    	rownumber=i;
			    	break;
			    }
			}
			return rownumber;
		}catch(Exception e){
			throw e;
		}
	    }
	
}
