package com.hms.hotelogix.automationframework.pages.Frontdesk.Payment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.Keys;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AccountStatementLandingPage {

	
	@FindBy(xpath="//select[@name='payTypesMode']")
    public  WebElement paymentMode;
	
	@FindBy(xpath="//input[@name='btnPaymentPayNow']")
    public WebElement payNowBtn;
	
	@FindBy(xpath="//input[@name='btnGenarateFolio']")
	public WebElement generateFolioBtn;
	
	@FindBy(xpath="//input[@name='btnSettleFolio']")
    public  WebElement settleFolio;
	
	@FindBy(xpath="//table[@class='dont-print-me-hidden']//table//tr")
    public  List<WebElement> folioCount;
	
	@FindBy(xpath="(//td[@class='front_tbl_lft'])[2]//tr")
	public  List<WebElement> tbl_cnt;
	
	@FindBy(xpath="//input[@name='amount']")
    public  WebElement amount;
	
	@FindBy(xpath="//a[contains(text(),'Currency Converter')]")
	public WebElement Link_currencyConverter;
	
	@FindBy(xpath="//select[@id='selTargetCurrOption']")
	public WebElement DD_ConvertTo;
	
	@FindBy(xpath="//button[@id='btnCurrClose-button']")
	public WebElement Btn_closeConverter;
	
	@FindBy(xpath="//input[@id='btnGenarateFolio']")
	public  WebElement Btn_GenerateFolio;
	
	@FindBy(xpath="//table[starts-with(@id,'flListTable_')]//tr//td//a")
	public WebElement PI;
	
	@FindBy(xpath="//input[@id='btnCustomCharges']")
	public WebElement Btn_customCharges;

	@FindBy(xpath="//select[@id='selPOS']")
	public WebElement DD_posPoint;

	@FindBy(xpath="//input[@id='ocTxtProduct']")
	public WebElement TB_description;

	@FindBy(xpath="//input[@id='price']")
	public WebElement TB_price;

	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public WebElement TB_qty;

	@FindBy(xpath="//input[@id='ocTxtDiscount']")
	public WebElement TB_discount;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public WebElement Btn_saveCustomCharge;

	@FindBy(xpath="//input[@id='btnAddNewCharges']")
	public  WebElement Btn_OtherCharges;
	
	@FindBy(xpath="//select[@id='selPOSGuest']")
	public WebElement DD_ChargeTo;

	@FindBy(xpath="//select[@id='selPOS']")
	public WebElement DD_POSPointOtherCharges;

	@FindBy(xpath="//select[@id='SelocTxtProduct']")
	public WebElement DD_ProductOtherCharges;

	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public WebElement Txtbx_QuantityOtherCharges;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public WebElement Btn_SaveOtherCharges;

	
	public  String editedINV;
	public String selRoomOwnerForOtherCharge;
	public String selProduct;
	
	public void fn_makeFullPayment() throws Exception
	{
		try
		{
		Select sel=new Select(paymentMode);
	    sel.selectByIndex(1);
	    Thread.sleep(4000);
	    //Select sel1=new Select(payTypes);
	    //sel1.selectByVisibleText("Cheque1");
	    //sel1.selectByIndex(1);
	    //Thread.sleep(3000);
	    //GenericClass.js_Sendkey(chequeNum, num);
	    //Thread.sleep(3000);
	    GenericClass.js_Click(payNowBtn);
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_clkGenerateFolio() throws Exception
	{
		try
		{
		GenericClass.clickElement(generateFolioBtn);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(4000);
			GenericClass.js_Click(generateFolioBtn);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public void fn_ClickSettleFolio_Accept() throws Exception
	{
		try
		{
	    GenericClass.clickElement(settleFolio);
	    //GenericMethods.ActionOnAlert(Alertcommand);
	    String str=GenericClass.Alert_Accept();
	    Assert.assertEquals(str, "Do you wish to settle all folios?");
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
	
	
	
	public void fn_LockFolio(int iTestCaseRow) throws Exception
	{
        editedINV=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))+ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber));

		try
		{
           // editedINV=ExcelUtil.getCellData(iTeastCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))+ExcelUtil.getCellData(iTeastCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber));
			//int size=folioCount.size();
			//String text=folioCount.get(size-1).getText();
			//boolean value=moreLink.isDisplayed();
			//if(text.contains("More >>"))
			//{
				
			//}
			ArrayList<String> arr=new ArrayList<String>();
//			if(value==true)
//			{
//				GenericClass.clickElement(moreLink);
//			}
			int count=GenericClass.tr_count(folioCount);

			Thread.sleep(3000);
			for(int i=4;i<=count;i++)
		    {
				 WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
		    	 GenericClass.js_Click(ele);
		    	 GenericClass.ActionOnAlert("Accept");
		    	 Thread.sleep(3000);		    	 				    	 
		    	String actual=GenericClass.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
		    	//int j=actual.lastIndexOf("(");
		    	//String a=actual.split(" ")[0]+" "+actual.split(" ")[1];
		    	arr.add(actual.split(" ")[0]);
		    	if(actual.contains(editedINV))
		    	{
		    		Assert.assertTrue(actual.contains(editedINV));		    	
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
			Thread.sleep(2000);
			Assert.assertEquals(arr.contains(editedINV), true);

		}
		
		catch(NoSuchElementException e)
		{
			
			ArrayList<String> arr=new ArrayList<String>();
			int count=GenericClass.tr_count(folioCount);

			Thread.sleep(3000);
			for(int i=4;i<=count;i++)
		    {

				 WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
		    	 GenericClass.js_Click(ele);
		    	 GenericClass.ActionOnAlert("Accept");
		    	 		    	 Thread.sleep(3000);				    	 
		    	String actual=GenericClass.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
		    	//int j=actual.lastIndexOf("(");
		    	//String a=actual.split(" ")[0]+" "+actual.split(" ")[1];
		    	arr.add(actual.split(" ")[0]);
		    	if(actual.contains(editedINV))
		    	{
		    		Assert.assertTrue(actual.contains(editedINV));		    	
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
	      Assert.assertEquals(arr.contains(editedINV), true);
		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
	
	
	
	
	public void fn_clkPayNow(int iTestCaseRow) throws Exception
	{
		try
		{
	  /*  Select sel=new Select(paymentMode);
	    sel.selectByValue("cash");
*/	    //Select sel1=new Select(paymentTypes);
	    //sel1.selectByValue("");
			
			GenericClass.SelectByIndex(paymentMode, 1);
	    Actions acobj= new Actions(GenericClass.driver);
		acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Amount))).build().perform() ;
		//amt=GenericMethods.getText(amount);
		GenericClass.js_Click(payNowBtn);
		Thread.sleep(6000);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	public void fn_verifyPREditedInvoice(int iTestCaseRow) throws Exception
	{
		try
		{
		String inv=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Prefix))+ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_StartSeriesNumber));
		int count=GenericClass.tr_count(tbl_cnt);
		for(int i=2;i<=count-2;i++)
		{
			String str=GenericClass.driver.findElement(By.xpath("(//td[@class='front_tbl_lft'])[2]//tr["+i+"]//td[9]/a")).getText();
			if(str.contains(inv))
			{
				Assert.assertEquals(str.contains(inv), true);
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

	
	/**	
	 * As this method verifies the added currency to the hotel.
	 * 
	 * @param currencyShortName : It's currency abreviation corresponding to the added currency.
	 * @throws Exception : If any occurs.
	 */
	public void fn_VerifyAddedCurrency(String currencyShortName) throws Exception{
		
		String currency=null;
	try{
	GenericClass.js_Click(Link_currencyConverter);
	Thread.sleep(2000);
	List<WebElement> ele=GenericClass.GetAllTheValueFromDropDown(DD_ConvertTo);
	for(int i=0;i<=ele.size();i++){
	 currency=ele.get(i).getText();	
	if(currency.equals(currencyShortName)){
		break;
	}
	}
	Assert.assertEquals(currency, currencyShortName);
	GenericClass.clickElement(Btn_closeConverter);
	Reporter.log("Currency verified at converter dropdown.", true);

	}
	catch(Exception e){
	throw e;
	}
	
	}
	
	/**
	 * As this methods clicks on Generate folio.
	 * 
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public void fn_generateFolio() throws Exception{
	try{
	GenericClass.clickElement(Btn_GenerateFolio);	
	}
	catch(Exception e){
	throw e;
	}
	}
	
	
	/**
	 * As this method click on perfoma invoice link.
	 * 	
	 * @return : As it returns the initialized ReservationFolioPage .
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public ReservationFolioPage fn_ClickOnPI() throws Exception{
	try{	
		
	GenericClass.clickElement(PI);
	Thread.sleep(2000);
	GenericClass.ActionOnAlert("Accept");
	}
	catch(Exception e){
		throw e;
	}
	ReservationFolioPage RFP=PageFactory.initElements(GenericClass.driver, ReservationFolioPage.class);
	return RFP;
	}

	
	/**
	 * AS this method verifies the deactivated currency in the hotel.
	 * 
	 * @param currencyShortName :It's currency abreviation corresponding to the added currency.
	 * @throws Exception 
	 */
	public void fn_verifyDeactivatedCurrency(String deactivatedCurrencyShortName) throws Exception{
	try{
	GenericClass.clickElement(Link_currencyConverter);
	List<WebElement> ele=GenericClass.GetAllTheValueFromDropDown(DD_ConvertTo);
	for(WebElement ele1: ele){
	Assert.assertFalse(ele1.getText().equals(deactivatedCurrencyShortName));
	}
	Reporter.log("As deactivated currency not found inside currency converter drop down.", true);	
	}
	catch(Exception e){
	throw e;
	}
	}
	
	
	/* * As this method verifies the activated currency in the hotel.
	 * @author deepak
	 * @throws Exception 
	 */
	public void fn_verifyActivatedCurrency(String deactivatedCurrency) throws Exception{
		String currency=null;
	try{
	GenericClass.clickElement(Link_currencyConverter);
	List<WebElement> ele=GenericClass.GetAllTheValueFromDropDown(DD_ConvertTo);
	for(int i=0;i<=ele.size();i++){
	currency=ele.get(i).getText();
	if(currency.equals(deactivatedCurrency)){
	break;	
	}
	}
	Assert.assertTrue(currency.equals(deactivatedCurrency));
	}
	catch(Exception e){
	throw e;	
	}
	}

	
	/**
	 * As this method for posting custom charge.
	 * @throws Exception:If any occurs.
	 * @author deepak 
	 */
	public void fn_postCustomCharge(int iTestCaseRow) throws Exception{
	try{
	GenericClass.clickElement(Btn_customCharges);
	Thread.sleep(1000);
	GenericClass.selectElement(DD_posPoint, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_POSPoint)));
	Thread.sleep(1000);
	GenericClass.sendKeys(TB_description, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
	Thread.sleep(1000);
	String rate=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Price));
	Thread.sleep(1000);
	GenericClass.js_Sendkey(TB_price, rate);
	Thread.sleep(1000);
	GenericClass.clickElement(Btn_saveCustomCharge);
	Thread.sleep(1000);
	}
	catch(Exception e){
	throw e;	
	}
	}

	
	/**
	 * As this method verifies the edited pay modes.
	 * 
	 * @param editedPayModeName : This is the pay mode name after edit.
	 * @return : As it returns edited pay mode from pay mode drop down.
	 * @author deepak
	 */
	public String fn_verifyEditedPayMode(String editedPayModeName){
		String pm=null;
	try{
	ArrayList<WebElement> ele=(ArrayList<WebElement>) GenericClass.GetAllOptionFromDropdown(paymentMode);
	int size1=ele.size();
	System.out.println(size1);
	for(int i=0;i<=size1-1;i++){
	 pm=ele.get(i).getText();	
	if(pm.equals(editedPayModeName)){
		break;
	}
	}
	}
	catch(Exception e){
	throw e;	
	}
	return pm;
	}
		
	
	/**
	 * As this method adds the other charges to the reservation.
	 * 
	 * @param iTestCaseRow : As this args for test data handling.
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public void fn_addOtherCharge(int iTestCaseRow) throws Exception{
	try{
		selRoomOwnerForOtherCharge=GenericClass.SelectByIndex(DD_ChargeTo, 0);	
		Thread.sleep(2000);
		GenericClass.SelectByIndex(DD_POSPointOtherCharges, 1);	
		Thread.sleep(2000);
		selProduct=GenericClass.SelectByIndex(DD_ProductOtherCharges,1);
		Thread.sleep(2000);
		GenericClass.js_Sendkey(Txtbx_QuantityOtherCharges, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Quantity)));
		Thread.sleep(2000);
		GenericClass.clickElement(Btn_SaveOtherCharges);
		Thread.sleep(1000);
	}
	catch(Exception e){
	throw e;
	}
		
	}
	
	/**
	 * As this method verifies the activated pay mode.
	 * 
	 * @param ActivePayMode : It's pay mode name which we activated.
	 */
	public void fn_verifyActivatedPayMode(String ActivePayMode){
		ArrayList<String> pmode=new ArrayList<String>();
	try{
	ArrayList<WebElement> ele=(ArrayList<WebElement>) GenericClass.GetAllOptionFromDropdown(paymentMode);
	for(WebElement Ele: ele){
		String pm=Ele.getText();
		pmode.add(pm);
	}
	}
	catch(Exception e){
		throw e;
	}
	Assert.assertTrue(pmode.contains(ActivePayMode));
	Reporter.log("Active pay mode is  present in pay mode dropdown.", true);
	}
	
	/**
	 * As this method verifies the deactivated pay modes.
	 * 
	 * @param DeactivePayMode : It's name of deactivated pay mode.
	 * @author deepak
	 */
	public void fn_verifyDeactivatedPayMode(String DeactivePayMode){
		ArrayList<String> pmode=new ArrayList<String>();
	try{
	ArrayList<WebElement> ele=(ArrayList<WebElement>) GenericClass.GetAllOptionFromDropdown(paymentMode);
	for(WebElement Ele: ele){
		String pm=Ele.getText();
		pmode.add(pm);
	}
	}
	catch(Exception e){
		throw e;
	}
	Assert.assertFalse(pmode.contains(DeactivePayMode));
	Reporter.log("Deactive pay mode is not present in pay mode dropdown.", true);
	}
}
