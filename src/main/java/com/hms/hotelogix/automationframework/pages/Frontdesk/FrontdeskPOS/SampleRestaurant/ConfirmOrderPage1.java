package com.hms.hotelogix.automationframework.pages.Frontdesk.FrontdeskPOS.SampleRestaurant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ConfirmOrderPage1 {

	@FindBy(name="paymentType")
	public  WebElement PaymentType_DD;

	@FindBy(xpath="//input[@value='Pay Now!']")
	public  WebElement PayNow_BT;

	@FindBy(xpath="//fieldset[@id='myBalId']")
	public  WebElement BalanceAmountBox;
	
	
	
	public OrderFolioPage fn_VerifyPayNowButton(int iTestCaseRow) throws Exception
	{
		try
		{
	  
	    //GenericClass.selectElement(PaymentType_DD, "Cash");
			Thread.sleep(4000);
			GenericClass.SelectByIndex(PaymentType_DD, 1);
	    GenericClass.clickElement(PayNow_BT);
	    Thread.sleep(6000);
/*	    String str=GenericClass.getText(BalanceAmountBox);
	    Assert.assertTrue(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));
*/		
		OrderFolioPage OFP=PageFactory.initElements(GenericClass.driver, OrderFolioPage.class);
		return OFP;
		
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
