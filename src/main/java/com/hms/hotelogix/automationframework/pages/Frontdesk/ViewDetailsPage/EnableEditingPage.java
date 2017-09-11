package com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EnableEditingPage {

	
	   @FindBy(xpath="//select[@id='groupOwner']")
	    public  WebElement drpdwn_GrpOwner;

	    @FindBy(xpath="//input[@id='travelAgent']")
	    public  WebElement txtbx_TA;

	    @FindBy(xpath="//input[@id='cNameGr']")
	    public  WebElement txtbx_CompName;

	    @FindBy(xpath="//select[@id='salutationGr']")
	    public  WebElement drpdwn_Salutation;

	    @FindBy(xpath="//input[@id='fNameGr']")
	    public  WebElement txtbx_FN;

	    @FindBy(xpath="//input[@id='lNameGr']")
	    public  WebElement txtbx_LN;

	    @FindBy(xpath="//input[@id='phoneNoGr']")
	    public  WebElement txtbx_Phone;

	    @FindBy(xpath="//input[@id='btnGrpSave']")
	    public  WebElement btn_ReserveGrp;
	
	public void reserve_TABooking()
    {
    	try
    	{
    	Select sel=new Select(drpdwn_GrpOwner);
    	sel.selectByIndex(0);
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}

    }


    /**
     *
     * Method fetches data from excel and fill details regarding TA Booking
     * @param iTestCaseRow : Is used for test data.
     * @return
     * @throws Exception
     */
    public void fillDetails_TABooking(int iTestCaseRow) throws Exception
    {
    	try
    	{
        GenericClass.sendKeys(txtbx_TA, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TravelAgentName)));
        GenericClass.sendKeys(txtbx_CompName, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TACompanyName)));
        Select sel=new Select(drpdwn_Salutation);

        sel.selectByIndex(1);

        GenericClass.sendKeys(txtbx_FN, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TAFirstName)));
        GenericClass.sendKeys(txtbx_LN, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TALastName)));
        GenericClass.sendKeys(txtbx_Phone, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_TAPhone)));
        GenericClass.clickElement(btn_ReserveGrp);
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }
    
    public void reserve_CorporateBooking()
    {
    	try
    	{
    	Select sel=new Select(drpdwn_GrpOwner);
    	sel.selectByIndex(1);
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}

    }


    /**
    *
    * Method fetches data from excel and fill details regarding Corporate Booking
    * @param iTestCaseRow : Is used for test data.
    * @return
    * @throws Exception
    */
   public void fillDetails_CorporateBooking(int iTestCaseRow) throws Exception
   {
   	try
   	{
       GenericClass.sendKeys(txtbx_TA, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CorporateName)));
       GenericClass.sendKeys(txtbx_CompName, GenericClass.generateRandomString());
       Select sel=new Select(drpdwn_Salutation);
       sel.selectByIndex(1);
       GenericClass.sendKeys(txtbx_FN, GenericClass.generateRandomString());
       GenericClass.sendKeys(txtbx_LN,GenericClass.generateRandomString());
       GenericClass.sendKeys(txtbx_Phone, GenericClass.GenerateRandomNumber(4));
       GenericClass.clickElement(btn_ReserveGrp);
   	}
   	catch(Exception e)
   	{
   		throw e;
   	}
   }



}


