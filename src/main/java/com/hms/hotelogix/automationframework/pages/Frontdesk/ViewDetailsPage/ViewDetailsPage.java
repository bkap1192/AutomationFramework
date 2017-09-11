package com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.AccountStatementLandingPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ViewDetailsPage {

	@FindBy(xpath="//input[@id='btnmainSRPay']")
    public  WebElement Payment_BT;
	
	 @FindBy(xpath="//ul[@id='maintabset']//li[3]//span[2]")
	 public  WebElement txt_tabTitle;
	
	public AccountStatementLandingPage fn_ClickOnPayment_BT() throws Exception{
	    try{   
		GenericClass.clickElement(Payment_BT);
	        AccountStatementLandingPage VDP=PageFactory.initElements(GenericClass.driver, AccountStatementLandingPage.class);
	            return VDP;
	    }catch(Exception e){
	    	throw e;
	    }
	    }
	
	public void verify_CodeChange(int iTestCaseRow) throws Exception
	    {
	    	try
	    	{
	    		Thread.sleep(3000);
	  	    	String text=GenericClass.getText(txt_tabTitle);
	  	    	Thread.sleep(2000);
	    	Assert.assertTrue(text.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AlphabetCodeFD))));
	    	}
	    	catch(AssertionError e)
	    	{
	    		throw e;
	    	}
	    }

}
