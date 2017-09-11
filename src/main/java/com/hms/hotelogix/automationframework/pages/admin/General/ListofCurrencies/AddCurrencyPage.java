package com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies;

import java.util.List;

import org.apache.poi.util.PackageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class AddCurrencyPage {
	
	
 
@FindBy(xpath="//td[text()='Select Acceptable Currencies']")
public WebElement Txt_pageTitle;



@FindBy(xpath="//a[text()='Main']")	
public WebElement Link_Main;

@FindBy(xpath="//a[text()='Currency List']")
public WebElement Link_CurrencyList;

@FindBy(xpath="//select[@id='mainCurrList']")
public WebElement SelectBox_Currencies;

@FindBy(xpath="//select[@id='childCurrList']")
public WebElement SelectBox_AcceptableCurrencies;

@FindBy(xpath="//input[@value='>>']")
public WebElement Btn_moveToRight;

@FindBy(xpath="//input[@value='<<']")
public WebElement Btn_moveToLeft;

@FindBy(xpath="//input[@value='Save currency list']")
public WebElement Btn_SaveCurrencyList;

@FindBy(xpath="//input[@value='Cancel']")
public WebElement Btn_Cancel;

@FindBy(xpath="//input[contains(@src,'/save_btn.gif')]")
public WebElement Btn_SaveAtTop;

@FindBy(xpath="//input[contains(@src,'/cancel_btn.gif')]")
public WebElement Btn_CancelAtTop;

@FindBy(xpath="//a[text()='AuditTrail']")
public WebElement Btn_AuditTrail;

@FindBy(xpath="//select[@id='mainCurrList']/option")
public List<WebElement> AllCurrencies;

public String currencyToAdd=null;;


/**
 * As it verifies the Move To Right ('>>') & Move To Left ('>>') button functionality.
 * 
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifyMovefunctionOfCurrency() throws Exception{
try{
List<WebElement> hotelAvailableCurrency=GenericClass.GetAllOptionFromDropdown(SelectBox_Currencies);
List<WebElement> hotelAcceptableCurrency=GenericClass.GetAllOptionFromDropdown(SelectBox_AcceptableCurrencies);
int initialSizeforAvilableCurrency=hotelAvailableCurrency.size();
int initialSizeforAcceptableCurrency=hotelAcceptableCurrency.size();
hotelAvailableCurrency.get(0).click();
GenericClass.clickElement(Btn_moveToRight);
List<WebElement> hotelAcceptableCurrency1=GenericClass.GetAllOptionFromDropdown(SelectBox_AcceptableCurrencies);
int SizeforAcceptableCurrency=hotelAcceptableCurrency1.size();
Assert.assertEquals(SizeforAcceptableCurrency, initialSizeforAcceptableCurrency+1);
Reporter.log("As currency moved towards the acceptable currency.", true);
//hotelAcceptableCurrency.get(0).click();
GenericClass.clickElement(Btn_moveToLeft);
List<WebElement> hotelAcceptableCurrency2=GenericClass.GetAllOptionFromDropdown(SelectBox_AcceptableCurrencies);
System.out.println(hotelAcceptableCurrency2.size() + "hotelAcceAfterCurrency");
Assert.assertEquals(SizeforAcceptableCurrency-1, hotelAcceptableCurrency2.size());
Reporter.log("As added currency moved towards the avilable currency.", true);
}
catch(Exception e){
throw e;	
}
}






/**
 * 
 * As it verifies the page element of Add currency page.
 * @author deepak
 * @throws Exception 
 */
public void fn_verifyPageElements() throws Exception{
try{
	GenericClass.checkElementDisplay("Txt_pageTitle", Txt_pageTitle);
	GenericClass.checkElementDisplay("Link_Main", Link_Main);	
	GenericClass.checkElementDisplay("Link_CurrencyList", Link_CurrencyList);	
	GenericClass.checkElementDisplay("SelectBox_Currencies", SelectBox_Currencies);	
	GenericClass.checkElementDisplay("SelectBox_AcceptableCurrencies", SelectBox_AcceptableCurrencies);	
	GenericClass.checkElementDisplay("Btn_moveToRight", Btn_moveToRight);	
	GenericClass.checkElementDisplay("Btn_moveToLeft", Btn_moveToLeft);	
	GenericClass.checkElementDisplay("Btn_SaveCurrencyList", Btn_SaveCurrencyList);	
	GenericClass.checkElementDisplay("Btn_Cancel", Btn_Cancel);	
	GenericClass.checkElementDisplay("Btn_SaveAtTop", Btn_SaveAtTop);	
	GenericClass.checkElementDisplay("Btn_CancelAtTop", Btn_CancelAtTop);	
	GenericClass.checkElementDisplay("Btn_AuditTrail", Btn_AuditTrail);	
}
catch(Exception e){
throw e;	
}
}


/**
 * 
 * @return : As it returns initialized AdminHome Page after clicking on Main link.
 * @throws Exception : if any occurs.
 * @author deepak
 * 
 */
public AdminHome fn_ClickOnMainLink() throws Exception{
try{
GenericClass.clickElement(Link_Main);
}
catch(Exception e){
	throw e;
}
AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
return AH;
}


/**
 * 
 * 
 * @return : As it returns initialized ListofCurrenciesLandingPage . 
 * @throws Exception : if any occurs.
 * @author deepak
 */
public ListofCurrenciesLandingPage fn_ClickOnListOfCurrenciesLink() throws Exception{
try{
GenericClass.clickElement(Link_CurrencyList);	
}
catch(Exception e){
throw e;	
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}
	



/**
 * As this method adds the currency to the hotel.
 * 
 * @param currency : The currency which needs to added.
 * @return : As it returns initialized {@link ListofCurrenciesLandingPage} class.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public ListofCurrenciesLandingPage fn_addCurrencyToHotel(String currency) throws Exception{
try{
GenericClass.selectElement(SelectBox_Currencies, currency);
GenericClass.clickElement(Btn_moveToRight);
GenericClass.clickElement(Btn_SaveCurrencyList);
}
catch(Exception e){
throw e;	
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}


/**
 * 
 * 	
 * @return : As it returns initialized ListofCurrenciesLandingPage after adding currency to hotel.
 * 
 * @author deepak.
 */
public ListofCurrenciesLandingPage fn_addCurrency(WebElement saveBtn){
try{
 currencyToAdd=GenericClass.SelectByIndex(SelectBox_Currencies, 0);
 Thread.sleep(2000);
 GenericClass.clickElement(Btn_moveToRight);
 GenericClass.clickElement(saveBtn);
}
catch(Exception e){
e.printStackTrace();	
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}
	
	

/**
 * 
 * @return : as it returns initialized AuditTrailPage after clicking on audit trail button.
 * @throws Exception : if any occurs.
 * 
 * @author deepak
 */
public AuditTrailPage fn_clickOnAuditTrail() throws Exception{
try{
GenericClass.clickElement(Btn_AuditTrail);	
}
catch(Exception e){
	throw e;
}
AuditTrailPage ATP=PageFactory.initElements(GenericClass.driver, AuditTrailPage.class);
return ATP;
}
	

/**
 * As this methods clicks on Cancel button on Top after selecting and deselecting the currency for the hotel.
 * 
 * @return : As it returns initialized ListofCurrenciesLandingPage page.
 * @throws Exception : If any occurs.
 * @author : deepak
 */
public ListofCurrenciesLandingPage fn_clickOnCancelBtn(WebElement cancelBtn) throws Exception{
try{
List<WebElement> ele=GenericClass.GetAllOptionFromDropdown(SelectBox_Currencies);
for(int i=0;i<1;i++){
    ele.get(i).click();
	ele.get(i).click();
	GenericClass.clickElement(Btn_moveToRight);
}
List<WebElement> ele1=GenericClass.GetAllOptionFromDropdown(SelectBox_AcceptableCurrencies);
for(int i=0;i<1;i++){
 
    ele.get(i).click();
	ele.get(i+1).click();
	GenericClass.clickElement(Btn_moveToLeft);
}
}
catch(Exception e){
throw e;
}
GenericClass.clickElement(Btn_CancelAtTop);
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}


}
