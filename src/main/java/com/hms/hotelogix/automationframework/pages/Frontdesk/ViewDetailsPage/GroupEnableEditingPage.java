package com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.AccountStatementLandingPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class GroupEnableEditingPage {

	@FindBy(xpath="//a[contains(text(),'Currency Converter ')]")
	public WebElement Link_CurrencyConverter;


	@FindBy(xpath="//select[@id='selTargetCurrOption']")
	public WebElement DD_ConvertTo;


	@FindBy(xpath="//button[@id='btnCurrClose-button']")
	public WebElement Btn_closeConverter;

	@FindBy(xpath="//input[@id='btnGrpPayments']")
	public WebElement Btn_groupPayment;

	@FindBy(xpath="//table[@id='roomGrTableId']/tbody/tr")
	public List<WebElement> AllGroupResRooms;

	@FindBy(xpath="//fieldset[@id='fldGrpFinalAmount']")
	public WebElement Text_TotalGroupPrice;


	@FindBy(xpath="//input[contains(@id,'txtFname')]")
	public WebElement TxtBx_Fname;



	@FindBy(xpath="//input[starts-with(@id,'txtLname')]")
	public WebElement TxtBx_Lname;

	@FindBy(xpath="//input[contains(@id,'txtPh')]")
	public WebElement TxtBx_PhNum;

	@FindBy(xpath="//select[contains(@id,'txtSalutionAtG_')]")
	public WebElement DD_Title;


	public ArrayList<String> guestDetail=new ArrayList<String>(Arrays.asList("ab", "cd", "123"));





	/**
	 * As this method adds the guest detail in group reservation.
	 * 
	 * @param resvId : It's reservation id for which we are going to fill the guest detail.
	 * @param guestDetail : As its list of detail which is required during filling the guest details. 
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public void fn_addGuestDetails(String resvId,ArrayList<String> guestDetail) throws Exception{
	try{
	int roomCount=AllGroupResRooms.size();
	for(int i=2;i<=roomCount;i++){
	Thread.sleep(2000);
	String resId=GenericClass.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
	if(resId.equals(resvId)){
		
		GenericClass.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[6]/fieldset[2]")).click();
		Thread.sleep(2000);
		GenericClass.SelectByIndex(DD_Title, 1);
		Thread.sleep(1000);
		GenericClass.js_Sendkey(TxtBx_Fname, guestDetail.get(0).toString());
		Thread.sleep(1000);
		GenericClass.js_Sendkey(TxtBx_Lname, guestDetail.get(1).toString());
		Thread.sleep(1000);
		GenericClass.js_Sendkey(TxtBx_PhNum, guestDetail.get(2).toString());
		Thread.sleep(1000);
		GenericClass.driver.findElement(By.xpath("//input[contains(@value,'OK')]")).click();
	    Thread.sleep(2000);
		break;
	}
	}
	}
	catch(Exception e){
	throw e;
	}
	}



	/**
	 * As this method verifies the deactivated currency in the hotel.
	 * @throws Exception : If any occurs.
	 * @author deepak 
	 * 
	 */
	public void fn_verifyDeactivatedCurrency(String deactivatedCurrencyShortName) throws Exception{
	try{
	GenericClass.clickElement(Link_CurrencyConverter);
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

	/**
	 * As this method verifies the activated currency.
	 * 
	 * @author deepak
	 * @throws Exception : If any occurs.
	 */
	public void fn_verifyActivatedCurrency(String deactivatedCurrency) throws Exception{
		String currency=null;
	try{
	GenericClass.clickElement(Link_CurrencyConverter);
	List<WebElement> ele=GenericClass.GetAllTheValueFromDropDown(DD_ConvertTo);	
	for(int i=0;i<=ele.size()-1;i++){
	currency=ele.get(i).getText();	
	if(currency.equals(deactivatedCurrency)){
		Thread.sleep(2000);
	break;		
	}
	}
	Assert.assertTrue(currency.equals(deactivatedCurrency));
	Reporter.log("Currency " + currency + " Activated." ,true);
	}
	catch(Exception e){
	throw e;	
	}
	}


	/**
	 * As this method verifies the added currency to hotel.
	 * 
	 * @param currencyShortName : Currency name which is added to the hotel.
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public void fn_VerifyAddedCurrency(String currencyShortName) throws Exception{
		
		String currency=null;
	try{
	GenericClass.clickElement(Link_CurrencyConverter);
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
	 * As this method clicks group payment button on group enable editing page.
	 * 
	 * @return : As it returns initialized AccountStatementLandingPage.
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public AccountStatementLandingPage fn_clickOnGroupPayment() throws Exception{
	try{
	GenericClass.clickElement(Btn_groupPayment);
	}
	catch(Exception e){
	throw e;
	}
	AccountStatementLandingPage ASL=PageFactory.initElements(GenericClass.driver, AccountStatementLandingPage.class);
	return ASL;
	}
		
		



	/**
	 * As this method gets the total number of reservation ids from the group reservation.
	 * 
	 * @return : As it returns the list of all the reservation id.
	 * @throws Exception : If any occurs.
	 * @author deepak
	 */
	public  ArrayList<String> getGroupResIds() throws Exception{
		
	ArrayList<String> al=new ArrayList<String> ();
	try{
	int roomCount=AllGroupResRooms.size();
	for(int i=2;i<=roomCount;i++){
	Thread.sleep(2000);
	String resId=GenericClass.driver.findElement(By.xpath("//table[@id='roomGrTableId']/tbody/tr["+i+"]/td[3]")).getText().trim();
	Thread.sleep(2000);
	al.add(resId);
	}
	//groupTotalrate=GenericClass.fn_getRateFromRateString(GenericClass.getText(Text_TotalGroupPrice).trim());
	}
	catch(Exception e){
	throw e;
	}
	return al;
	}





	
}
