package com.hms.hotelogix.automationframework.pages.admin.General.DefaultSettings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskContinueTrialPage;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;



public class DefaultSettingsLandingPage {
	
	
	
@FindBy(xpath="//div[@id='_divDefaultCurrText1']/a")
public WebElement Link_ClickToChange;
	
@FindBy(xpath="//select[@id='currencyId']")
public WebElement DD_DefaultCurrency;

@FindBy(xpath="//input[@name='Submit33' and @value='Save Changes']")
public WebElement Btn_SaveChanges;

@FindBy(xpath="//div[@id='_divcurrencyConversionDom1']/a")
public WebElement Link_clickToChangeForConversionRate;

@FindBy(xpath="//select[@id='convertionRate']")
public WebElement DD_ConversionRate;

@FindBy(xpath="//div[@id='divcurrencyConversion']//input")
public WebElement Btn_SaveConversionRate;

@FindBy(xpath="//input[contains(@src,'save_btn.gif')]")
public WebElement Btn_Save;

@FindBy(xpath="//div[@id='_divconvertionMarginDom1']/a")
public WebElement Link_clickToChangeForCurrencyMargin;

@FindBy(xpath="//input[@id='convertionMargin']")
public WebElement TB_convertionMargin;

@FindBy(xpath="//div[@id='divconvertionMargin']/input[2]")
public WebElement Btn_saveCurrencyMargin;





/**
 * As this method verifies the edited currency in the hotel.
 * @throws Exception: If any occurs.
 * @author deepak 
 */
public void fn_verifyEditedCurrency(String editedCurrency) throws Exception{
String currency=null;
try{
GenericClass.clickElement(Link_ClickToChange);	
List<WebElement> ele=GenericClass.GetAllOptionFromDropdown(DD_DefaultCurrency);
for(int i=0;i<ele.size()-1;i++){
currency=ele.get(i).getText();	
if(currency.equals(editedCurrency)){
break;	
}
}
Thread.sleep(2000);
Assert.assertTrue(currency.equals(editedCurrency));
Reporter.log("Edited currency is:"+ currency + "Verified in default currency dropdown.", true);
}
catch(Exception e){
throw e;	
}
}









/**
 * As this method for setting conversion margin.
 * @author deepak
 * @throws Exception 
 */
public void fn_setConversionMargin(String marginAmt) throws Exception{
try{
GenericClass.clickElement(Link_clickToChangeForCurrencyMargin);
GenericClass.sendKeys(TB_convertionMargin, marginAmt);
Thread.sleep(2000);
GenericClass.clickElement(Btn_saveCurrencyMargin);
Thread.sleep(2000);
GenericClass.clickElement(Btn_Save);
Thread.sleep(2000);
}
catch(Exception e){
throw e;	
}
}


/**
 * As this method for changing the conversion rate.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_setConversionRate(String rateToBeselect) throws Exception{
try{
GenericClass.clickElement(Link_clickToChangeForConversionRate);	
Thread.sleep(2000);
GenericClass.selectElement(DD_ConversionRate, rateToBeselect);
GenericClass.fn_ActionsClick(Btn_SaveConversionRate); 
Thread.sleep(2000);
GenericClass.clickElement(Btn_Save);
Thread.sleep(2000);
}
catch(Exception e){
throw e;	
}
}


/**
 * As this method verifies the deactivated currency in default currency dropdown in default setting page.
 * 
 * @param deactivatedCurrency : As it's name of currency which is deactivated.
 * @throws Exception : If any occurs.
 */
public void fn_verifyDeactivatedCurrency(String deactivatedCurrency) throws Exception{
try{
GenericClass.clickElement(Link_ClickToChange);
List<WebElement> allCurr=GenericClass.GetAllOptionFromDropdown(DD_DefaultCurrency);	
for(WebElement ele:allCurr){
	Assert.assertFalse(ele.getText().equals(deactivatedCurrency));
}
Reporter.log("As Deactivated currency not found inside default currency dropdown.", true);
}
catch(Exception e){
throw e;	
}
}


/**
 * As this method verifies the activated currency.
 * @author deepak
 * @throws Exception : If any occurs.
 */
public void fn_verifyActivatedCurrency(String currencyActivatedName) throws Exception{
String currency=null;
try{
GenericClass.clickElement(Link_ClickToChange);
List<WebElement> allCurr=GenericClass.GetAllOptionFromDropdown(DD_DefaultCurrency);
for(int i=0;i<=allCurr.size();i++){
	currency=allCurr.get(i).getText();
if(currency.equals(currencyActivatedName)){
break;		
}
}
Assert.assertTrue(currency.equals(currencyActivatedName));
}
catch(Exception e){
throw e;	
}
}


/**
 * As this methods verifies the added currency in default currency dropdown.
 * 
 * @param CurrencyToVerify : As it is currency which is added to the hotel.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifyAddedCurrency(String CurrencyToVerify) throws Exception{
	String currency=null;
try{
	GenericClass.clickElement(Link_ClickToChange);
	List<WebElement> allCurr=GenericClass.GetAllOptionFromDropdown(DD_DefaultCurrency);	
for(int i=0;i<=allCurr.size()-1;i++){
	 currency=allCurr.get(i).getText();
	 Thread.sleep(2000);
	if(currency.equals(CurrencyToVerify)){
		break;
	}
}
Thread.sleep(2000);
Assert.assertEquals(currency, CurrencyToVerify);
Reporter.log("Added Currency verified at defauld currency in admin. ", true);
}
catch(Exception e){
throw e;	
}
}


/**
 * As this method click on frontdesk link.
 * @return : As it returns initialized {@link FrontdeskContinueTrialPage} .
 * @author deepak
 */
public  FrontdeskContinueTrialPage fn_clickOnFrontdeskLink(){
try{
GenericClass.driver.findElement(By.xpath("//a[contains(@href,'frontdeskautologin')]")).click();	
}
catch(Exception e){
throw e;	
}
FrontdeskContinueTrialPage FCTP=PageFactory.initElements(GenericClass.driver, FrontdeskContinueTrialPage.class);
return FCTP;
}
	
	
	
	
	
	
	
	
	
	
	
	

}
