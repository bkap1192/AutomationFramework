package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskContinueTrialPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditRoomTaxPage {
	
	
	
	
@FindBy(xpath="//select[@id='accountCodeId']")
public WebElement DD_AccountCode;

@FindBy(xpath="//a[contains(@href,'frontdeskautologin')]")
public WebElement Link_frontDesk;

@FindBy(xpath="//input[contains(@id,'taxNameMulName_')]")
public WebElement TB_TaxTitle;

@FindBy(xpath="//input[@id='taxShortName']")
public WebElement TB_TaxId;

@FindBy(xpath="//textarea[contains(@id,'descriptionMulDes_')]")
public WebElement TA_Description;

@FindBy(xpath="//table[@id='slabTable']//input[contains(@id,'slbTaxAmount_')]")
public WebElement TB_TaxAmount;

@FindBy(xpath="//input[@value='Save Tax']")
public WebElement Btn_SaveTax;

@FindBy(xpath="//a[text()='Edit']")
public WebElement Link_Edit;


@FindBy(xpath="//img[@id='showCalFrom']")
public WebElement Link_ActivateCal;


@FindBy(xpath="//input[@id='woSlabTaxAmount']")
public WebElement TB_EditTaxAmouunt;



public String taxTitle;
public String taxId;
public String taxAmt="20.00";
public String Description=GenericClass.generateRandomString();










/**
 * As this methods verifies that the added language is reflects to the Edit Room Tax.	
 * @param langName: As its name of that png image corresponding to the added language.
 * @throws : Exception if any occurs.
 * @author deepak.
 * @throws Exception 
 */
public void fn_verifyAddedLanguage(String langName) throws Exception{
String src=null;
ArrayList<String> addedSource=new ArrayList<String>();
try{
List<WebElement> eles=GenericClass.driver.findElements(By.tagName("img"));	
for(int i=0;i<=eles.size();i++){
src=eles.get(i).getAttribute("src");
System.out.println(src);
if(src.endsWith(langName)){
break;
}
}
addedSource.add(src);
Thread.sleep(2000);
Assert.assertTrue(addedSource.get(0).toString().endsWith(langName));
Reporter.log("Language Added", true);
}
catch(Exception e){
throw e;
}
}





public RoomTaxesLandingPage fn_changeTaxSlabDate(String date) throws Exception{
try{
GenericClass.clickElement(Link_Edit);
Thread.sleep(2000);	
GenericClass.clickElement(Link_ActivateCal);
int size=GenericClass.driver.findElements(By.xpath("//table[@id='cal1']/tbody/tr/td/a")).size();
System.out.println("Number of days are"  +(size-1));
GenericClass.driver.findElements(By.xpath("//table[@id='cal1']/tbody/tr/td/a")).get(Integer.parseInt(date)-1).click();
GenericClass.clickElement(Btn_SaveTax);
Thread.sleep(3000);
}
catch(Exception e){
throw e;
}
RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
return RTLP;
}



/**
 * As this method changes the tax amount for the slab tax
 * @return: As it returns the initialized {@link RoomTaxesLandingPage} page.
 * @throws Exception : If any occur.
 * @author deepak
 */
public RoomTaxesLandingPage fn_changeTaxAmtForSlab() throws Exception{
try{
GenericClass.clickElement(Link_Edit);
Thread.sleep(2000);
GenericClass.js_Sendkey(TB_TaxAmount,taxAmt);
GenericClass.clickElement(Btn_SaveTax);
Thread.sleep(1000);
}
catch(Exception e){
throw e;	
}
RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
return RTLP;
}





/**
 * As this method clicks on frontdesk link.
 * @return: As it returns initilaized {@link FrontdeskLandingPage} page.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public FrontdeskContinueTrialPage fn_clickOnFDLink() throws Exception{
try{
GenericClass.clickElement(Link_frontDesk);	
}
catch(Exception e){
throw e;
}
FrontdeskContinueTrialPage FLP=PageFactory.initElements(GenericClass.driver, FrontdeskContinueTrialPage.class);
return FLP;
}





/**
 * As this method verifies the account code in account code dropdown.
 * @param aCode: As its added account code which is added earlier and passed as an arg for verification.
 * @exception: If any occurs.
 * @author deepak
 */
public void fn_verifyAccountCode(String aCode){
String acCode=null;
try{
List<WebElement> ele=GenericClass.GetAllOptionFromDropdown(DD_AccountCode);	
for(int i=0;i<=ele.size()-1;i++){
acCode=ele.get(i).getText();
if(acCode.equals(aCode)){
break;	
}
}
Assert.assertTrue(acCode.equals(aCode));
}
catch(Exception e){
throw e;	
}
Reporter.log("Account Code verified at Account code dropdown after clicking on edit link.  ", true);
}
	
	


public RoomTaxesLandingPage fn_editTaxDetails() throws Exception{
try{
taxTitle=GenericClass.generateRandomString();
taxId=GenericClass.generateRandomString();
GenericClass.sendKeys(TB_TaxTitle, taxTitle);
GenericClass.sendKeys(TB_TaxId, taxId);
GenericClass.sendKeys(TA_Description, Description);
GenericClass.sendKeys(TB_EditTaxAmouunt, taxAmt);
GenericClass.clickElement(Btn_SaveTax);
}
catch(Exception e){
throw e;
}
RoomTaxesLandingPage RTLP=PageFactory.initElements(GenericClass.driver, RoomTaxesLandingPage.class);
return RTLP;
}


	
	

}
