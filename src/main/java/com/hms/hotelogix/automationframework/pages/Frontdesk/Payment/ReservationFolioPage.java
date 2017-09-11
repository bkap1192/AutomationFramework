package com.hms.hotelogix.automationframework.pages.Frontdesk.Payment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ReservationFolioPage {
	
	
	@FindBy(xpath="//select[@id='payTypesMode']")
	public WebElement DD_PayMode;
	
	@FindBy(xpath="//a[contains(text(),'Converter')]")
	public WebElement Link_Converter;
	
	@FindBy(xpath="//select[@id='selTargetCurrOption']")
	public WebElement DD_ConvertTo;
	
	
	@FindBy(xpath="//button[@id='btnCurrClose-button']")
	public WebElement Btn_closeConverter;
	
	@FindBy(xpath="//button[@id='btnCurrConvert-button']")
	public WebElement Btn_Convert;
	
	@FindBy(xpath="//div[@id='displayCurrRate']")
	public WebElement Txt_convertedAmount;
	
	

	
	
	
	
public String fn_getConvertedAmount(String ConvertTo) throws Exception{
	String convertedAmount=null;
try{
GenericClass.clickElement(Link_Converter);
GenericClass.selectElement(DD_ConvertTo, ConvertTo);
GenericClass.clickElement(Btn_Convert);
Thread.sleep(3000);
convertedAmount=GenericClass.getText(Txt_convertedAmount);
}
catch(Exception e){
throw e;	
}
return convertedAmount;
}
	
	
	
/**
 * As this method verifies the added currency to hotel.
 * 	
 * @param currencyShortName : As this is currency abreviation corresponding to the added currency.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_VerifyAddedCurrency(String currencyShortName) throws Exception{
	String currency=null;
try{
GenericClass.js_Click(Link_Converter);
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
 * AS this method verifies the deactivated currency in the hotel.
 * 
 * @param currencyShortName :It's currency abreviation corresponding to the added currency.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifyDeactivatedCurrency(String deactivatedCurrencyShortName) throws Exception{
try{
GenericClass.clickElement(Link_Converter);
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
 * As this method ensures that the currency which is passed as an args is activated.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifyActivatedCurrency(String deactivatedCurrency) throws Exception{
	String currency=null;
try{
GenericClass.clickElement(Link_Converter);
List<WebElement> ele=GenericClass.GetAllTheValueFromDropDown(DD_ConvertTo);	
for(int i=0;i<=ele.size();i++){
currency=ele.get(i).getText();
if(currency.equals(deactivatedCurrency)){
break;
}
}
Assert.assertTrue(currency.equals(deactivatedCurrency));
Reporter.log("Currency is activated.", true);
}
catch(Exception e){
throw e;	
}
}





/**
 * As this method verifies the edit pay mode.
 * @param editedPayModeName : it's edited pay mode name which is added.
 * @return : As it returns the edited pay mode from the pay mode drop down.
 * @author deepak
 */
public String fn_verifyEditedPayMode(String editedPayModeName){
	String pm=null;
	try{
	ArrayList<WebElement> ele=(ArrayList<WebElement>) GenericClass.GetAllOptionFromDropdown(DD_PayMode);
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
 * As this method verifies the activated pay mode.
 * @param ActivePayMode : It's pay mode name which is activated.
 * @author deepak
 */
public void fn_verifyActivatedPayMode(String ActivePayMode){
	ArrayList<String> pmode=new ArrayList<String>();
try{
ArrayList<WebElement> ele=(ArrayList<WebElement>) GenericClass.GetAllOptionFromDropdown(DD_PayMode);
for(WebElement Ele: ele){
	String pm=Ele.getText();
	pmode.add(pm);
}
}
catch(Exception e){
	throw e;
}
Assert.assertTrue(pmode.contains(ActivePayMode));
Reporter.log("Active pay mode is present in pay mode dropdown.", true);
}

public void fn_verifyDeactivatedPayMode(String DeactivePayMode){
	ArrayList<String> pmode=new ArrayList<String>();
try{
ArrayList<WebElement> ele=(ArrayList<WebElement>) GenericClass.GetAllOptionFromDropdown(DD_PayMode);
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
