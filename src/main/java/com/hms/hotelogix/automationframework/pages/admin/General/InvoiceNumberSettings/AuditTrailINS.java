package com.hms.hotelogix.automationframework.pages.admin.General.InvoiceNumberSettings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrailINS 
{
	@FindBy(xpath="//td[@class='page-heading']")
	public WebElement header_page;

	@FindBy(xpath="//table[3]//tr[2]")
	public  WebElement titel_PE;

	@FindBy(xpath="//table[3]//tr")
	public  List<WebElement> tr_count;


	public void verify_pageHeader(int iTestCaseRow) throws Exception
	{
		try
		{
		String text=GenericClass.getText(header_page);
		Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
		
	
	public void verify_ChangedHistory(int iTestCaseRow) throws Exception
	{
		try
		{
        int count=GenericClass.tr_count(tr_count);
        for(int i=2;i<=count;i++)
        {
            String str=GenericClass.driver.findElement(By.xpath("//table[3]//tr["+i+"]/td")).getText();
            if(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))))
            {
            	Assert.assertEquals(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber))), true);
           	   break;
            }

        }
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


