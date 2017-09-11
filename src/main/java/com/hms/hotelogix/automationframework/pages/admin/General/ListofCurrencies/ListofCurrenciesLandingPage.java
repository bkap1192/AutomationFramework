package com.hms.hotelogix.automationframework.pages.admin.General.ListofCurrencies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.sun.jna.platform.win32.OaIdl.EXCEPINFO;


public class ListofCurrenciesLandingPage {
	
	
@FindBy(xpath="//div[@id='heading_new']/div/table/tbody/tr/td[2]")
public WebElement HeaderTxt_PageTitle;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th/strong")
public WebElement HeaderTxt_HashSign;

@FindBy(xpath="//input[@name='checkbox5']")
public WebElement HeaderCB_Master;

@FindBy(xpath="//th[contains(text(),'Currencies')]")
public WebElement HeaderTxt_Currencies;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[3]/a[1]/img")
public WebElement Link_DownwardArrowForCurrencies;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[3]/a[2]/img")
public WebElement Link_UpwardArrowForCurrencies;

@FindBy(xpath="//th[contains(text(),'Abreviation ')]")
public WebElement HearerTxt_Abreviation;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[4]/a[1]/img")
public WebElement Link_DownwardArrowForAbreviation;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[4]/a[2]/img")
public WebElement Link_UpwardArrowForAbreviation;

@FindBy(xpath="//th[contains(text(),'Symbol')]")
public WebElement HeaderTxt_Symbol;

@FindBy(xpath="//th[contains(text(),'Conversion Rate')]")
public WebElement  HeaderTxt_ConversionRate;

@FindBy(xpath="//th[text()='Action']")
public WebElement HeaderTxt_Action;

@FindBy(xpath="//th[text()='Status']")
public WebElement HeaderTxt_Status;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[1]/th[8]/a[1]/img")
public WebElement Link_DownwardArrowForStatus;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[1]/th[8]/a[2]/img")
public WebElement Link_UpwardArrowForStatus;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[1]/th[5]/a[1]/img")
public WebElement Link_DownwardArrowForSymbol;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[1]/th[5]/a[2]/img")
public WebElement Link_UpwardArrowForSymbol;

@FindBy(xpath="//td[text()='<<Previous | Next>>']")
public WebElement Txt_PreviousAndNext;

@FindBy(xpath="//select[@name='offset']")
public WebElement DD_Page;

@FindBy(xpath="//select[@name='maxEntries']")
public WebElement DD_View;

@FindBy(xpath="//a[text()='AuditTrail']")
public WebElement Link_AuditTrail;

@FindBy(xpath="//div[@id='currencyConversionText']/em")
public WebElement  Txt_The_Conversions_are_picked_in_real_time;

@FindBy(xpath="//div[@id='currencyMarginText']")
public WebElement Txt_The_buffer_margins_for_all_conversions_is_Somthing; 

@FindBy(xpath="//a[text()='Main']")
public WebElement Link_Main;

@FindBy(xpath="//a[@title='Add Currencies']/img")
public WebElement Link_AddCurrencies;

@FindBy(xpath="//form[@id='frmListView']/table[1]/tbody/tr[1]/td")
public WebElement Msg_CurrencyAdded;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
public List<WebElement> AllCurrencies;

@FindBy(xpath="//input[@name='id[]']")
public WebElement CB_Currency;

@FindBy(xpath="//a[contains(text(),'Delete Selected Currencies')]")
public WebElement Btn_DeleteSelectedCurrency;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[2]/td[3]")
public WebElement Txt_currencyToDelete;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
public List<WebElement> AllRows_table;

@FindBy(xpath="//form[@id='frmListView']/table[1]/tbody/tr[1]/td")
public WebElement Msg_deletionCurrency;

@FindBy(xpath="//a[text()='Cancel']")
public WebElement Link_Cancel;

@FindBy(xpath="//input[@name='checkbox5']")
public WebElement CB_Master;

@FindBy(xpath="//input[@type='checkbox' and @name='id[]']")
public List<WebElement> CB_All;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/td[3]")
public WebElement Txt_CurrencyName;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[2]/td[8]/a/img")
public WebElement Img_ActiveStatus;

@FindBy(css="table.list_viewnew>tbody>tr")
public List<WebElement> AllTableRow; 

@FindBy(xpath="//a[text()='Edit']")
public WebElement Link_Edit;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[2]/td[1]")
public WebElement Txt_PageNumber;

@FindBy(xpath="//input[@name='id[]']")
public List<WebElement> AllCheckBoxForTheAllrecords;

@FindBy(xpath="//a[text()='Next>>']")
public WebElement Link_Next;

@FindBy(xpath="//a[text()='<<Previous']")
public WebElement Link_Previous;




public String currencySymb;
public String activeStatus="on.GIF";
public String dectiveStatus="off.GIF";
public String currency=null;
public String src=null;
public String shortName=null;
public String currencyToDelete=null;
public String deactivatedCurrencyName=null;
public String deactivatedCurrencyAbreviation=null;
public String conversionRate=null;
public String deactivateCurrencyName=null;



/**
 * As this method extracts the currency symbol from the  list of currency page.
 * @param iTestCaseRow : As it takes this args for test data handling.
 * @return : As it returns currency symbol for the currency.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public String fn_getCurrencySymbol(int iTestCaseRow) throws Exception{
try{
Thread.sleep(2000);
GenericClass.selectElement(DD_View, "All");
Thread.sleep(2000);
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
int count=GenericClass.tr_count(AllTableRow);
for(int i=2;i<=count;i++){
String str=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)));
  if(str.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd)).trim())){
     Assert.assertEquals(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_CurrencyToAdd))), true);
     currencySymb=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]")).getText();
      break;
}
}
return currencySymb;
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
 * As this method clicks on audit trail page.
 *  @return : As it returns initialized ListOfCurrencyAuditTrail Page.
 * @throws Exception : If any occurs.\
 * @author deepak
 */
public ListOfCurrencyAuditTrailPage fn_clickOnAuditTrailPage() throws Exception{
try{
GenericClass.clickElement(Link_AuditTrail);	
}
catch(Exception e){
throw e;
}
ListOfCurrencyAuditTrailPage LOCATP=PageFactory.initElements(GenericClass.driver, ListOfCurrencyAuditTrailPage.class);
return LOCATP;
}


/**
 * As this method verifies the previous link.
 *  @throws Exception : If any occurs.
 *  @author deepak
 */
public void fn_verifyPreviousLink() throws Exception{
try{
GenericClass.selectElement(DD_View, "1");
String pNum=GenericClass.getText(Txt_PageNumber).trim();
Assert.assertEquals(pNum, "1");
GenericClass.clickElement(Link_Next);
String pNum1=GenericClass.getText(Txt_PageNumber).trim();
Assert.assertEquals(pNum1, "2");
GenericClass.clickElement(Link_Previous);
String pnum2=GenericClass.getText(Txt_PageNumber).trim();
Assert.assertEquals(pnum2, pNum);
}
catch(Exception e){
throw e;
}
}



/**
 * As this method ensures that the next link is working.
 * 
 * @throws Exception: If any occurs.
 * @author deepak
 */
public void fn_verifyNextLink() throws Exception{
try{
GenericClass.selectElement(DD_View, "1");
String pNum=GenericClass.getText(Txt_PageNumber).trim();
Assert.assertEquals(pNum, "1");
GenericClass.clickElement(Link_Next);
String pNum1=GenericClass.getText(Txt_PageNumber).trim();
Assert.assertEquals(pNum1, "2");
}
catch(Exception e){
throw e;
}
}


/**
 *As it verifies the view dropdown.
 *
 *@author deepak 
 * @throws Exception 
 */
public void fn_verifyViewDropdown() throws Exception{
try{
GenericClass.selectElement(DD_View, "1");	
int size=AllCheckBoxForTheAllrecords.size();
Assert.assertEquals(size, 1);
GenericClass.selectElement(DD_View, "5");	
int size1=AllCheckBoxForTheAllrecords.size();
Assert.assertEquals(size1, 5);
Reporter.log("View dropdown verified.",true);
}
catch(Exception e){
throw e;	
}
}


/**
 *As this method verifies the page dropdown.
 *@author deepak
 * @throws Exception : If any occurs.
 */
public void fn_verifyPageDropdown() throws Exception{
try{
GenericClass.selectElement(DD_View, "1");
String pageNumber=GenericClass.getText(Txt_PageNumber);
Assert.assertEquals(pageNumber, "1");
GenericClass.selectElement(DD_Page, "2");
String pageNumber1=GenericClass.getText(Txt_PageNumber);
Assert.assertEquals(pageNumber1, "2");
Reporter.log("Page dropdown verifeid.", true);
}
catch(Exception e){
throw e;	
}
}


/**
 * As this method is used to get edited title and conversion rate for edited title.
 *  @param editedCurrency: AS its currency name which is edited should be passed as an args.
 * @author deepak
 * @throws Exception 
 */
public void fn_getEditedTitleAndConversionRate(String editedCurrency) throws Exception{
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
int size=AllTableRow.size();
for(int i=2;i<=size;i++){
currency=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
if(currency.equals(editedCurrency)){
	conversionRate=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[6]")).getText();
	break;
}
}
}
catch(Exception e){
throw e;
}
}


/**
 * As this method clicks on edit link of and currency which is passed as an args.
 * @return : As it returns initialized {@link EditCurrencyPage} class.
 * @author deepak.
 * @throws Exception 
 */
public EditCurrencyPage fn_clickOnEditforParticularCurrency(String currency) throws Exception{
	String currency1=null;
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
int size=AllTableRow.size();
for(int i=2;i<=size-1;i++){
	currency1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
if(currency1.equals(currency)){
GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[7]/a")).click();
break;
}
}
}
catch(Exception e){
throw e;
}
EditCurrencyPage ECP=PageFactory.initElements(GenericClass.driver, EditCurrencyPage.class);
return ECP;
}



/**
 * As this method clicks on edit link for the currency which is passed as an arg.
 * 
 * @param currencyToEdit : This is the currency for which we need to click on Edit link.
 * @return : As it returns initialized EditCurrency Page.
 * @throws Exception 
 */
public EditCurrencyPage fn_ClickOnEditLinkForCurrency(String currencyToEdit) throws Exception{
	String currency1=null;
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
int size=AllTableRow.size();
for(int i=2;i<=size-1;i++){
	currency1=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
if(currency1.equals(currencyToEdit)){
GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[7]/a")).click();
break;
}
}
}
catch(Exception e){
throw e;	
}
EditCurrencyPage ECP=PageFactory.initElements(GenericClass.driver, EditCurrencyPage.class);
return ECP;
}




/**
 * As this method clicks on Edit link.
 * 
 * @return : As it returns initialized {@link EditCurrencyPage} class.
 * @throws Exception: If any occurs.
 * @author deepak
 */
public EditCurrencyPage fn_clickOnEditLink() throws Exception{
try{
GenericClass.clickElement(Link_Edit);
}
catch(Exception e){
throw e;	
}
EditCurrencyPage ECP=PageFactory.initElements(GenericClass.driver, EditCurrencyPage.class);
return ECP;
}




/**
 * As this methods verifies the deactivated currency in the hotel.
 * 
 * @author deepak
 * @throws Exception : If any occurs.
 */
public void fn_verifyDeactivatedCurrency(String deactivatedCurrency) throws Exception{
	String src=null;
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
int size=AllCurrencies.size();	
for(int i=2;i<=size;i++){
String currencyName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText().trim();	
if(currencyName.equals(deactivatedCurrency)){
	Thread.sleep(2000);
	 src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/a/img")).getAttribute("src").trim();
	 deactivatedCurrencyAbreviation=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[4]")).getText();
	 break;
}
}
Thread.sleep(2000);
Assert.assertTrue(src.endsWith(dectiveStatus));
Reporter.log("Currency " + deactivatedCurrency + " Deactivated successfully.", true);
}
catch(Exception e){
throw e;
}
}






/**
 * As this method activates the deactivated currency.
 * 
 * @param deactivatedCurrency : As this is deactivated currency name which we are going to activate.
 * @author deepak
 * @throws Exception 
 */
public void fn_activateTheCurrencyAndVerify(String deactivatedCurrency) throws Exception{
int i=0;
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
int size=AllTableRow.size();
for( i=2;i<=size;i++){
String currencyName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();	
if(currencyName.equals(deactivatedCurrency)){
	Thread.sleep(2000);
String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/a/img")).getAttribute("src");
Thread.sleep(2000);
if(src.endsWith(dectiveStatus)){
	Thread.sleep(2000);
	GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/a/img")).click();
	break;
}
}
}
Thread.sleep(2000);
Assert.assertTrue(GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/a/img")).getAttribute("src").endsWith(activeStatus));
Reporter.log("Currency " + deactivatedCurrency + " Activated ."  ,true);
}
catch(Exception e){
throw e;	
}
}



/**
 * As this method deactivates the mentioned currency.
 * 
 * @param currencyToDeactivate : It's currency which is being to deactivate.
 * @author deepak 
 * @throws Exception 
 */
public void fn_DeactivateTheCurrency(String currencyToDeactivate) throws Exception{
try{
GenericClass.selectElement(DD_View, "All");	
GenericClass.ActionOnAlert("Accept");
int size=AllTableRow.size();
for(int i=2;i<=size;i++){
deactivateCurrencyName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
if(deactivateCurrencyName.equals(currencyToDeactivate)){
GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/a/img")).click();	
deactivatedCurrencyAbreviation=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[4]")).getText().trim();
break;	
}
	
}

}
catch(Exception e){
throw e;	
}
}



/**
 * As this methods deactivates the currency from the hotel.
 * 
 * @author deepak
 */
public void fn_deactivateTheCurrency(){
try{
	String src=Img_ActiveStatus.getAttribute("src");
	if(src.endsWith(activeStatus)==true){
		Img_ActiveStatus.click();
		deactivatedCurrencyName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[2]/td[3]")).getText().trim();
		deactivatedCurrencyAbreviation=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[2]/td[4]")).getText().trim();
		
}
	else{
		deactivatedCurrencyName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[2]/td[3]")).getText().trim();
		deactivatedCurrencyAbreviation=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[2]/td[4]")).getText().trim();
}
}
catch(Exception e){
throw e;
}
}


/**
 * As this methods selects the individual records from the list of currency module along with ensuring that all gets selected.
 * 
 * @return : As returns true if all the check box are selected and false when any check box doesn't get selected if we select.
 * @author deepak
 * @throws Exception 
 */
public boolean fn_selectRecordUsingCheckBoxAndVerifySelectedCheckBox() throws Exception{
	boolean res=true;
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
int size=CB_All.size();
for(int i=0;i<=size-1;i++){
	CB_All.get(i).click();	
}
for(int i=0;i<=size-1;i++){
	if(CB_All.get(i).isSelected()==true){
		Assert.assertTrue(CB_All.get(i).isSelected());
		res=true;
}
else{
res=false;
break;
}
}
}
catch(Exception e){
throw e;	
}
return false;
}




/**
 * As this methods ensures that all the checkbox are selected.
 * 
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifySelectAllFromMasterCB() throws Exception{
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
GenericClass.clickElement(CB_Master);
for(int i=0;i<=CB_All.size()-1;i++){
	Thread.sleep(2000);
Assert.assertTrue(CB_All.get(i).isSelected());	
}
}
catch(Exception e){
throw e;
}
Reporter.log("Mater check box Select All functionality verified.", true);
}


/**
 * As this methods ensures the all the checkbox are deselected. 
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifyDeselectAllFromMasterCB() throws Exception{
try{
fn_verifySelectAllFromMasterCB();
GenericClass.clickElement(CB_Master);
for(int i=0;i<=CB_All.size()-1;i++){
Assert.assertFalse(CB_All.get(i).isSelected());	
}
}
catch(Exception e){
	throw e;
}
Reporter.log("Master check Box Deselect functionality verified.",true);
}


/**
 * As this methods click over cancel link on List of currency page.
 * 
 * @return : As it returns initialize List of currency landing page.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public AdminHome fn_clickOnCancel() throws Exception{
try{
GenericClass.clickElement(Link_Cancel);	
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
 * @param iTestCaseRow : As it takes an iTestCaseRow as an args for test data handling.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_verifyPageElements(int iTestCaseRow) throws Exception{
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept");
GenericClass.checkElementDisplay("HeaderTxt_PageTitle", HeaderTxt_PageTitle);
GenericClass.checkElementDisplay("HeaderTxt_HashSign", HeaderTxt_HashSign);	
GenericClass.checkElementDisplay("HeaderCB_Master", HeaderCB_Master);	
GenericClass.checkElementDisplay("HeaderTxt_Currencies", HeaderTxt_Currencies);	
GenericClass.checkElementDisplay("Link_DownwardArrowForCurrencies", Link_DownwardArrowForCurrencies);	
GenericClass.checkElementDisplay("Link_UpwardArrowForAbreviation", Link_UpwardArrowForCurrencies);	
GenericClass.checkElementDisplay("Txt_PreviousAndNext", Txt_PreviousAndNext);	
GenericClass.checkElementDisplay("HearerTxt_Abreviation", HearerTxt_Abreviation);	
GenericClass.checkElementDisplay("Link_DownwardArrowForAbreviation", Link_DownwardArrowForAbreviation);	
GenericClass.checkElementDisplay("Link_UpwardArrowForAbreviation", Link_UpwardArrowForAbreviation);	
GenericClass.checkElementDisplay("HeaderTxt_Symbol", HeaderTxt_Symbol);	
GenericClass.checkElementDisplay("HeaderTxt_ConversionRate", HeaderTxt_ConversionRate);	
GenericClass.checkElementDisplay("HeaderTxt_Action", HeaderTxt_Action);	
GenericClass.checkElementDisplay("HeaderTxt_Status", HeaderTxt_Status);	
GenericClass.checkElementDisplay("Link_DownwardArrowForStatus", Link_DownwardArrowForStatus);	
GenericClass.checkElementDisplay("Link_UpwardArrowForStatus", Link_UpwardArrowForStatus);	
GenericClass.checkElementDisplay("DD_Page", DD_Page);	
GenericClass.checkElementDisplay("DD_View", DD_View);	
GenericClass.checkElementDisplay("Link_AuditTrail", Link_AuditTrail);	
GenericClass.checkElementDisplay("Link_Main", Link_Main);	
Assert.assertTrue(GenericClass.getText(Txt_The_Conversions_are_picked_in_real_time).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))));
Thread.sleep(2000);
Assert.assertTrue(GenericClass.getText(Txt_The_buffer_margins_for_all_conversions_is_Somthing).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))));

}
catch(Exception e){
	throw e;
}
}



/**
 * 
 * @return : As it returns initialize {@link AddCurrencyPage} class after clicking on add currency button. 
 * @throws Exception : If any occurs.
 * @author deepak
 */
public AddCurrencyPage fn_clickOnAddCurrency() throws Exception{
try{
GenericClass.clickElement(Link_AddCurrencies);	
}
catch(Exception e){
	throw e;
}
AddCurrencyPage ACP=PageFactory.initElements(GenericClass.driver, AddCurrencyPage.class);
return ACP;
}
	
	
/**
 * As it verifies the newly added currency.
 * 
 * @param currencyToVerify : The currency which is choosen as hotel currency.
 * @throws Exception : If any occurs.
 * @author deepak
 */
	
public void fn_verifyAddedCurrency(String currencyToVerify) throws Exception{

try{
int size=AllCurrencies.size();	
for(int i=2;i<=size-1;i++){
 currency=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText().trim();
	if(currency.equals(currencyToVerify)){
		src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/a/img")).getAttribute("src").trim();
		shortName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[4]")).getText().trim();
		conversionRate=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[6]")).getText().trim();
		break;
}
}
Assert.assertTrue(currency.equals(currencyToVerify));
Thread.sleep(2000);
Assert.assertTrue(src.endsWith(activeStatus));
}
catch(Exception e){
	throw e;
}
}


/**
 * As this method is used to get currency which we going to delete and getting alert pop text and cancelling the pop up.
 * 
 * @return : As it returns the alert pop up text as an string.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public String fn_VerifyCurrencyDeletionPopUp() throws Exception{
String popUpTxt=null;
try{
GenericClass.clickElement(CB_Currency);	
currencyToDelete=GenericClass.getText(Txt_currencyToDelete).trim();
GenericClass.clickElement(Btn_DeleteSelectedCurrency);
GenericClass.ActionOnAlert("Dismiss");
popUpTxt=GenericClass.value;
}
catch(Exception e){
throw e;
}
return popUpTxt;
}


/**
 * As this method deletes the currency which is exist to the hotel.
 * 
 * @param currencyToDelete : Existing currency in hotel.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public void fn_deleteCurrency(String currencyToDelete) throws Exception{
try{
GenericClass.selectElement(DD_View, "All");
GenericClass.ActionOnAlert("Accept"); 
int size=AllRows_table.size();
for(int i=2;i<=size-1;i++){
String currency=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
if(currency.equals(currencyToDelete)){
     GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]/input")).click();
     GenericClass.clickElement(Btn_DeleteSelectedCurrency);
     GenericClass.ActionOnAlert("Accept");
     break;
}	
}
}
catch(Exception e){
throw e;	
}
}

/**
 * As this methods takes currency name which is added to hotel as an args makes deletion message for validation.
 * @param currencyName : Currency which is added.
 * @return : As it returns currency deletion message in string format.
 * @author deepak
 */
public String fn_vlidateDeletionMsg(String currencyName){
String deletionMsg=null;
try{
 deletionMsg="- Currencies " + "\""+currencyName+"\"" + " deleted successfully";
}
catch(Exception e){
throw e;	
}
return deletionMsg;
}
	

/**
 * As it click over main link on List Of Currency Page.
 * 
 * @return : As it returns initialized {@link AdminHome} page.
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
AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
return AH;
}


/**
 * As this method verifies the Master check box.
 * @return : returns true if all check boxes are selected else false.
 * @throws Exception : If any occurs.
 * @author deepak
 */
public boolean fn_verifyTheMasterCheckBox() throws Exception {
boolean res=false;
try{
GenericClass.selectElement(DD_View, "All");	
GenericClass.ActionOnAlert("Accept");
GenericClass.clickElement(CB_Master);
for(int i=0;i<=CB_All.size()-1;i++){
Assert.assertTrue(CB_All.get(i).isSelected());
res=true;
}
}
catch(Throwable e){
	res=false;
throw e;	
}
return res;
}









}
