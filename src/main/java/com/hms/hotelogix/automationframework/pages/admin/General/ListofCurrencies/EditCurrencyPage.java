package com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;



public class EditCurrencyPage {
	
	
	
	
@FindBy(xpath="//a[text()='Main']")	
public WebElement Link_Main;

@FindBy(xpath="//a[text()='List of Acceptable Currencies']")
public WebElement Link_ListOfAcceptableCurrencies;

@FindBy(xpath="//td[@class='page-heading']")
public WebElement Txt_PageHeading;

@FindBy(xpath="//input[@name='currName']")
public WebElement TB_CurrencyTitle;

@FindBy(xpath="//input[@name='currShortName']")
public WebElement TB_CurrencyAbreviation;

@FindBy(xpath="//input[@id='crncyRate']")
public WebElement TB_ConversionRate;

@FindBy(xpath="//input[@value='Save Currency']")
public WebElement Btn_SaveCurrency;

@FindBy(xpath="//input[@value='Cancel']")
public WebElement Btn_Cancel;

@FindBy(xpath="//td[text()='Symbol']")
public WebElement Txt_Symbol;

@FindBy(xpath="//a[text()='AuditTrail']")
public WebElement Link_AuditTrail;

@FindBy(xpath="//em")
public WebElement Txt_ConversionRateIsAuto;

@FindBy(xpath="//table[@class='table-content']/tbody/tr[9]/td[2]")
public WebElement Txt_MandatoryFields;









public EditAuditTrailPage fn_clickOnAuditTrailPage() throws Exception{
try{
GenericClass.clickElement(Link_AuditTrail);
}
catch(Exception e){
throw e;	
}
EditAuditTrailPage EATP=PageFactory.initElements(GenericClass.driver, EditAuditTrailPage.class);
return EATP;
}




/**
 * As this method clicks on List of Currency link on Edit currency page.
 * @return : As it returns initialized ListofCurrenciesLanding Page.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public ListofCurrenciesLandingPage fn_clickOnListOfCurrencyLink() throws Exception{
try{
GenericClass.js_Click(Link_ListOfAcceptableCurrencies);	
}
catch(Exception e){
throw e;	
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}

/**
 * As this method clicks on Main link.
 * 
 * @return : As it returns initialized Admin home page.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public AdminHome fn_clickOnMainLink() throws Exception{
try{
GenericClass.clickElement(Link_Main);
}
catch(Exception e){
throw e;
}
AdminHome AH=PageFactory.initElements(GenericClass.driver,AdminHome.class);
return AH;
}


/**
 * As this method verifies the page elements.
 * @author deepak
 * @throws Exception 
 */
public void fn_verifyPageElements() throws Exception{
try{
GenericClass.checkElementDisplay("Link_Main", Link_Main);	
GenericClass.checkElementDisplay("Link_ListOfAcceptableCurrencies", Link_ListOfAcceptableCurrencies);	
GenericClass.checkElementDisplay("Txt_PageHeading", Txt_PageHeading);	
GenericClass.checkElementDisplay("TB_CurrencyTitle", TB_CurrencyTitle);	
GenericClass.checkElementDisplay("TB_CurrencyAbreviation", TB_CurrencyAbreviation);	
GenericClass.checkElementDisplay("TB_ConversionRate", TB_ConversionRate);	
GenericClass.checkElementDisplay("Btn_SaveCurrency", Btn_SaveCurrency);	
GenericClass.checkElementDisplay("Btn_Cancel", Btn_Cancel);	
Assert.assertTrue(TB_ConversionRate.getAttribute("value")!=null);

}
catch(Exception e){
throw e;
}
}
	
	
/**
 * As this methods verify Edit page elements when conversion rate is set to the automatic.
 * 
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_VerifyPageElementsWhenConversionReateIsAuto() throws Exception{
try{
GenericClass.checkElementDisplay("Link_Main", Link_Main);	
GenericClass.checkElementDisplay("Link_ListOfAcceptableCurrencies", Link_ListOfAcceptableCurrencies);	
GenericClass.checkElementDisplay("Txt_PageHeading", Txt_PageHeading);	
GenericClass.checkElementDisplay("TB_CurrencyTitle", TB_CurrencyTitle);	
GenericClass.checkElementDisplay("TB_CurrencyAbreviation", TB_CurrencyAbreviation);	
GenericClass.checkElementDisplay("Btn_SaveCurrency", Btn_SaveCurrency);	
GenericClass.checkElementDisplay("Btn_Cancel", Btn_Cancel);		
GenericClass.checkElementDisplay("Txt_ConversionRateIsAuto", Txt_ConversionRateIsAuto);		
GenericClass.checkElementDisplay("Txt_MandatoryFields", Txt_MandatoryFields);		
}
catch(Exception e){
throw e;
}
}



/**
 * As this method sets the conversion rate to the currency.
 * 	
 * @param rateToInput : it's a conversion rate.
 * @return : As it returns {@link ListofCurrenciesLandingPage} class.
 * @throws Exception : If any occurs.
 * @author deepak.
 */
public ListofCurrenciesLandingPage fn_setConversionRate(String rateToInput) throws Exception{
try{
GenericClass.sendKeys(TB_ConversionRate, rateToInput);
GenericClass.clickElement(Btn_SaveCurrency);
}
catch(Exception e){
throw e;	
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}

	

/**
 * As this method Edits the currency title and Conversion rate in hotel while conversion rate is set to the Manual in default currency.
 * 	
 * @param iTestCaseRow : As this args for handling test from Excel file. 
 * @return : As it returns initialized ListofCurrenciesLandingPage.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public ListofCurrenciesLandingPage fn_EditTitleAndConversionRate(int iTestCaseRow) throws Exception{
try{
GenericClass.sendKeys(TB_CurrencyTitle, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
GenericClass.sendKeys(TB_ConversionRate, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ConversionRateToInput)));
GenericClass.clickElement(Btn_SaveCurrency);
}
catch(Exception e){
throw e;
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}
	
/**
 * As this method edits the currency title when conversion rate is set to the Automatic.
 * @param : iTestCaseRow : As this args for test data handling.
 * @return : As it returns initialized ListofCurrenciesLanding Page.
 * @throws Exception: If any occurs.
 * @author deepak
 */
public ListofCurrenciesLandingPage fn_EditTitle(int iTestCaseRow) throws Exception{
try{
GenericClass.sendKeys(TB_CurrencyTitle, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyTitleToEdit)));
Thread.sleep(2000);
GenericClass.clickElement(Btn_SaveCurrency);
}
catch(Exception e){
throw e;
}
ListofCurrenciesLandingPage LOCLP=PageFactory.initElements(GenericClass.driver, ListofCurrenciesLandingPage.class);
return LOCLP;
}
	
	
	

}
