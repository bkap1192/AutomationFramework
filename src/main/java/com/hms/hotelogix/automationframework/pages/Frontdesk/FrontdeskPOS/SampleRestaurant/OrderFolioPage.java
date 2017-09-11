package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class OrderFolioPage {

	@FindBy(xpath="//fieldset[@id='folioNumberId']")
	public  WebElement TransferItemFolioNum;
	
	public void verify_FolioNumber(int iTestCaseRow) throws Exception
	{
		try
		{
			String exp=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))+ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber));
	String folioNum=GenericClass.getText(TransferItemFolioNum);
	String[] Foliono=folioNum.split(" ");
	Assert.assertEquals(Foliono[1], exp);
	
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
