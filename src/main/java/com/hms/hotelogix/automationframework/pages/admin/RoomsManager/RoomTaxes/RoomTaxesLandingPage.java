package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTaxes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class RoomTaxesLandingPage {

	@FindBy(xpath="//div[@class='headingtxt']/table/tbody/tr/td[2]")
	public  WebElement Txt_PageTitle;
	
	@FindBy(xpath="//a[text()='Delete Selected Tax(es)']")
	public WebElement Btn_DeleteSelectedTaxes;
	
	@FindBy(xpath="//a[text()='Add a Tax']")
	public WebElement Btn_AddATax;
	
	@FindBy(xpath="//a[text()='Save Sort Order']")
	public WebElement Btn_SaveSortOrder;
	
	@FindBy(xpath="//a[text()='Cancel']")
	public WebElement Btn_Cancel;
	
	@FindBy(xpath="//a[text()='Main']")
	public WebElement Link_Main;
	
	@FindBy(xpath="//a[text()='Next>>']")
	public WebElement Link_Next;
	
	@FindBy(xpath="//a[text()='<<Previous']")
	public WebElement Link_Previous;
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement Link_Edit;
	
	@FindBy(xpath="//a[text()='AuditTrail']")
	public WebElement Link_AuditTrail;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[1]")
	public WebElement TblHeader_SerialNum;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[2]/input")
	public WebElement TblHeader_MasterChkBox;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[3]")
	public WebElement TblHeader_Taxes;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[3]/a[1]")
	public WebElement TblHeader_DownWardSortBtnForTaxesColumn;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[3]/a[2]")
	public WebElement TblHeader_UpWardSortBtnForTaxesColumn;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[4]")
	public WebElement TblHeader_Description;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[5]")
	public WebElement TblHeader_Percentage_FixedAmount;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[6]")
	public WebElement TblHeader_Action;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[7]")
    public WebElement TblHeader_Status;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[7]/a[1]")
	public WebElement TblHeader_DownWardSortBtnForStatusColumn;
    
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[7]/a[2]")
	public WebElement TblHeader_UpWardSortBtnForStatusColumn;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[8]")
	public WebElement TblHeader_SortOrder;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[8]/a[1]")
	public WebElement TblHeader_DownWardSortBtnForSortOrderColumn;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[8]/a[2]")
	public WebElement TblHeader_UpWardSortBtnForSortOrderColumn;
	
	@FindBy(xpath="//select[@name='offset']")
	public WebElement DD_Page;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public WebElement DD_View;
	
	@FindBy(xpath="//td[text()='<<Previous | Next>>']")
	public WebElement Txt_PreviousANdNextLinks;
	
	@FindBy(xpath="//div[@class='error_new']")
	public WebElement ValidationMsg;
	
	@FindBy(xpath="//input[@name='id[]']")
	public List<WebElement> AllCheckBox;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public List<WebElement> AllTaxes;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/td[3]")
	public List<WebElement> AllTaxName;
	

    @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[7]/a/img")
	public  WebElement Icon1;
    
    @FindBy(xpath="//table/tbody/tr[3]/td/table/tbody/tr[1]/th[8]/a[1]/img")
	public  WebElement Btn_DownwardSortStatus;
    
    @FindBy(xpath="//table/tbody/tr[3]/td/table/tbody/tr[1]/th[8]/a[2]/img")
	public  WebElement Btn_UpwardSortStatus;

	
    public String deactiveTaxStatus="off.GIF";
	public String actStatus="on.GIF";
	public String seactStatus="off.GIF";
	
	
	public void VerifyPageElements() throws Exception{
		try{
			GenericClass.selectElement(DD_View, "All");
			GenericClass.ActionOnAlert("Accept");
			GenericClass.checkElementDisplay("Delete selected tax", Btn_DeleteSelectedTaxes);
			GenericClass.checkElementDisplay("Add a Tax button", Btn_AddATax);
			GenericClass.checkElementDisplay("Save sort order", Btn_SaveSortOrder);
			GenericClass.checkElementDisplay("Cancel Button", Btn_Cancel);
			GenericClass.checkElementDisplay("Main link", Link_Main);
			GenericClass.checkElementDisplay("Edit link", Link_Edit);
			GenericClass.checkElementDisplay("AuditTrail ", Link_AuditTrail);
			GenericClass.checkElementDisplay("Serial number", TblHeader_SerialNum);
			GenericClass.checkElementDisplay("Master check box", TblHeader_MasterChkBox);
			GenericClass.checkElementDisplay("Taxes", TblHeader_Taxes);
			GenericClass.checkElementDisplay("Taxes downward button", TblHeader_DownWardSortBtnForTaxesColumn);
			GenericClass.checkElementDisplay("Taxes upward button", TblHeader_UpWardSortBtnForTaxesColumn);
			GenericClass.checkElementDisplay("Description column", TblHeader_Description);
			GenericClass.checkElementDisplay("Percentage_FixedAmount column", TblHeader_Percentage_FixedAmount);
			GenericClass.checkElementDisplay("TblHeader_Action", TblHeader_Action);
			GenericClass.checkElementDisplay("DownWardSortBtnForStatusColumn", TblHeader_DownWardSortBtnForStatusColumn);
			GenericClass.checkElementDisplay("UpWardSortBtnForStatusColumnr", TblHeader_UpWardSortBtnForStatusColumn);
			GenericClass.checkElementDisplay("TblHeader_Status", TblHeader_Status);
			GenericClass.checkElementDisplay("TblHeader_SortOrder", TblHeader_SortOrder);
			GenericClass.checkElementDisplay("DownWardSortBtnForSortOrderColumn", TblHeader_DownWardSortBtnForSortOrderColumn);
			GenericClass.checkElementDisplay("UpWardSortBtnForSortOrderColumn", TblHeader_UpWardSortBtnForSortOrderColumn);
			GenericClass.checkElementDisplay("DD_Page", DD_Page);
			GenericClass.checkElementDisplay("DD_View", DD_View);

		}
		catch(Exception e){
			throw e;
		}
		}
	
	
	/**
	 * As this method clicks on Add tax button.
	 * @return : As it returns the initialized AddRoomTax Page. 
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public AddRoomTaxPage ClickOnAddATaxButton() throws Exception{
	try{
	GenericClass.clickElement(Btn_AddATax);
	}
	catch(Exception e){
	e.printStackTrace();
	}
	AddRoomTaxPage ARTP=PageFactory.initElements(GenericClass.driver, AddRoomTaxPage.class);
	return ARTP;
	}

	/**
	 * This is formatting message for validation that the room added successfully.
	 * @param s : Here s is room name.
	 * @return : As it returns proper validation message for added room along with room name.
	 */
	public String ValidationFormat(String titleTax){

	String fst="- Room Tax ";
	String scnd="\""+ titleTax+"\" ";
	String thrd="Saved Successfully";
	String res= fst+scnd+thrd;
	return res;


	}
	
	/**
	 * As this method verifies the added tax along with active status.
	 * @param taxTitle: As this is title for the added tax. 
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public void verifyAddedTaxAlongWithStatus(String taxTitle) throws Exception {
	try{
	GenericClass.selectElement(DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	ArrayList<String> taxesName=new ArrayList<String>();
	for(int i=2;i<=AllTaxes.size();i++){
	String name=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[3]")).getText();
	taxesName.add(name);
	if(name.equalsIgnoreCase(taxTitle)){
	String stat=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[7]/a/img")).getAttribute("src");
	Thread.sleep(2000);
	Assert.assertTrue(stat.endsWith(actStatus));
	Reporter.log("Room status Verified", true);
	Thread.sleep(2000);
	Assert.assertTrue(name.equalsIgnoreCase(taxTitle));
	break;
	}
	}
	Thread.sleep(2000);
	Assert.assertEquals(taxesName.contains(taxTitle),true);
	Reporter.log("Room Taxes added", true);
	}
	catch(Exception e){
	throw e;
	}
		
	}
	
	
	/**
	 * As this method will delete mentioned tax which is passed as an arg.
	 *@param taxTitle : It's tax title .
	 *@author deepak
	 * @throws Exception :If any occurs.
	 */
	public void fn_deleteTheTax(String taxTitle) throws Exception{
	try{
	GenericClass.selectElement(DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	for(int i=2;i<=AllTaxes.size()-1;i++){
	String taxName=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
	if(taxName.equals(taxTitle)){
	GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]/input")).click();
	GenericClass.clickElement(Btn_DeleteSelectedTaxes);
	GenericClass.ActionOnAlert("Accept");
	break;
	}
	}
	for(WebElement ele:AllTaxName ){
	System.out.println(ele.getText());
	Thread.sleep(2000);
	Assert.assertFalse(ele.getText().equals(taxTitle));
	}
	Reporter.log("Deleted Tax not found", true);
	}
	catch(Exception e){
	throw e;
	}
	}
		
	
	/**
	 * 	As this method clicks on Edit link for the mentioned tax title,which is passed as an arg.
	 * @param taxtTitle : Tax for which edit links needs to be click.
	 * @return : As it returns the initialized {@link EditRoomTaxPage} page.
	 * @exception : If any occurs.
	 * @author deepak 
	 * @throws Exception 
	 */
	public EditRoomTaxPage fn_clickOnEditLink(String taxtTitle) throws Exception{
	try{
	GenericClass.selectElement(DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	int size=AllTaxes.size();
	for(int i=2;i<=size-1;i++){
	String tname=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
	if(tname.equals(taxtTitle)){
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[6]/a")).click();
		break;
	}
	}
	}
	catch(Exception e){
	throw e;	
	}
	EditRoomTaxPage ERTP=PageFactory.initElements(GenericClass.driver, EditRoomTaxPage.class);
	return ERTP;
	}
	
	/**
	 * AS this method selects the check box for the mentioned Tax title which is passed as an arg.	
	 * @param taxTitle : Tax title for which check box needs to be selected.
	 * @throws Exception 
	 */
	public void fn_SelectCheckBoxForaTax(String taxTitle) throws Exception{
	try{
	GenericClass.selectElement(DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	int size=AllTaxes.size();
	for(int i=2;i<=size-1;i++){
	String tname=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
	if(tname.equals(taxTitle)){
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]/input")).click();
		break;
	}
	}
	}
	catch(Exception e){
	throw e;	
	}
	}
	
	/**
	 * As this method for getting validation message for deleted tax.	
	 * @param taxName: Its tax which is deleted.
	 * @return
	 */
	public String fn_getDeletionTaxMessage(String taxName){
	String msg=null;
	try{
	msg="- Room Tax(es)" + " \""+ taxName+"\""+" deleted Successfully";
	}
	catch(Throwable e){
	throw e;	
	}
	return msg;
	}
	
	/**
	 * This method is used to get the validation message while deleting tax which is attached to the room type.
	 * @param taxTitle: It's tax title which is being to delete.
	 * @return : As it returns the validation message as in string format.
	 * @exception : throw exception if any occurs.
	 * @author deepak
	 */
	public String fn_getValidationMsgWhenDeletingTaxAttachedWithRoomType(String taxTitle){
	String msg=null;
	try{
	msg="- Room Tax(es)" + " \""+taxTitle+"\""+" cannot be deleted as there are active room type(s) against them";
	}
	catch(Exception e){
	throw e;	
	}
	return msg;
	}
	
	/**
	 * As this method for viewing all records in page at once.
	 * @exception : throw exception if any occurs.
	 * @author deepak
	 * @throws Exception 
	 */
	public void fn_viewAllrecordsOnThePage() throws Exception{
	try{
	GenericClass.selectElement(DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	}
	catch(Exception e){
	throw e;	
	}
	}
	
	public String fn_getValidationMessage(String taxTitle){
		String msg=null;
		try{
		msg="- Room Tax" + " \""+taxTitle+"\""+" Saved Successfully";	
		}
		catch(Exception e){
		throw e;	
		}
		return msg;
		}
	
	/**
	 * This method ensures that the deleted tax not exist in the list.
	 * 	
	 * @param taxTitle: This is the tax title which is deleted.
	 * @throws Exception: If any occurs.
	 * @author deepak
	 */
	public void fn_verifyDeletedTax(String taxTitle) throws Exception{
	try{
	GenericClass.selectElement(DD_View, "All");
	GenericClass.ActionOnAlert("Accept");
	ArrayList<String> taxesName=new ArrayList<String>();
	for(int i=2;i<=AllTaxes.size()-1;i++){
	Thread.sleep(2000);
	String name=GenericClass.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[3]")).getText();
	Thread.sleep(2000);
	taxesName.add(name);
	}
	Thread.sleep(2000);
	Assert.assertFalse(taxesName.contains(taxTitle));
	Reporter.log("Deleted Room Tax not present", true);	
	}
	catch(Exception e){
	throw e;	
	}
	}
	
	/**
	 * As this method Deactivates the activated room tax in the hotel. 
	 * @param roomTaxToDeactivate: This is the room tax which we are going to deactivate. 
	 * @return: As it returns the status of deactivated currency.
	 * @exception : As it throws exception when any occurs.
	 * @author deepak
	 * @throws Exception 
	 */
	public String fn_DeactivateTheCurrency(String roomTaxToDeactivate) throws Exception{
	String stat=null;
	try{
	Thread.sleep(2000);
	GenericClass.selectElement(DD_View, "All");	
	GenericClass.ActionOnAlert("Accept");
	int size=AllTaxes.size();
	for(int i=2;i<=size;i++){
	String	roomTax=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
	if(roomTax.equals(roomTaxToDeactivate)){
	GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[7]/a/img")).click();
	Thread.sleep(2000);
	stat=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[7]/a/img")).getAttribute("src");
	break;	
	}
	}
	}
	catch(Exception e){
	throw e;	
	}
	return stat;
	}

	
	public AuditTrialPage fn_clickOnAuditTrailLink() throws Exception{
		try{
		GenericClass.clickElement(Link_AuditTrail);	
		}
		catch(Exception e){
		throw e;	
		}
		AuditTrialPage ATP=PageFactory.initElements(GenericClass.driver,AuditTrialPage.class);
		return ATP;
		}
	
	public void fn_VerifyCancelOrMainfunction(WebElement webele) throws Exception{
		try{
			GenericClass.clickElement(webele);
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void fn_VerifyCheckboxes() throws Exception{
		try{
			for(WebElement checkbox : AllCheckBox){
				GenericClass.clickElement(checkbox);
				Assert.assertEquals(checkbox.isSelected(), true);
		}
			Thread.sleep(2000);
			for(WebElement checkbox : AllCheckBox){
				GenericClass.clickElement(checkbox);
				Assert.assertEquals(checkbox.isSelected(), false);
		}
		}catch(Exception e){
			throw e;
		}
	    }
	
	/**
	 * This method ensures that downward arrow sort button works fine for room numbers/name.
	 * @throws Exception
	 */
	public void DownwardSortByStatus() throws Exception{
		GenericClass.sortstatus_Downward(DD_View, "All", Icon1, Btn_DownwardSortStatus, AllCheckBox, "//table[@class='list_viewnew']/tbody//tr//td[3]", "//table[@class='list_viewnew']//td[8]/a/img");
	}

	/**
	 * This method ensures that Upward arrow sort button works fine for room numbers/name.
	 * @throws Exception
	 */
	public void UpwardSortByStatus() throws Exception{
		 GenericClass.sortstatus_Upward(DD_View, "All", Btn_UpwardSortStatus, AllCheckBox, "//table[@class='list_viewnew']/tbody//tr//td[3]", "//table[@class='list_viewnew']//td[8]/a/img");
	}
	
	public void fn_VerifyNextAndPreviousLink() throws Exception{
		try{
			GenericClass.selectElement(DD_View, "1");
			GenericClass.selectElement(DD_Page, "2");
			Assert.assertEquals(Link_Next.isDisplayed() && Link_Next.isEnabled(), true);
			Assert.assertEquals(Link_Previous.isDisplayed() && Link_Previous.isEnabled(), true);
		    String curserialnumber=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]/td[1]")).getText();
			GenericClass.clickElement(Link_Next);
			String nextserialnumber=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]/td[1]")).getText();
			Assert.assertEquals(curserialnumber.equalsIgnoreCase(nextserialnumber), false);
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void fn_SaveOrderAndSortupwardandDownward() throws Exception{
		try{
			WebElement orderinputbox=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]/td[8]//input"));
			GenericClass.sendKeys(orderinputbox, "1");
		    GenericClass.clickElement(Btn_SaveSortOrder);
		    GenericClass.selectElement(DD_View, "All");
		    GenericClass.ActionOnAlert("Accept");
		    GenericClass.clickElement(TblHeader_DownWardSortBtnForSortOrderColumn);
			List<WebElement> colle=GenericClass.driver.findElements(By.name("shortOrder[]"));
			int siz=colle.size();
			String value=colle.get(siz-1).getAttribute("value");
			Assert.assertEquals(value, "1");
			GenericClass.clickElement(TblHeader_UpWardSortBtnForSortOrderColumn);
			List<WebElement> colle1=GenericClass.driver.findElements(By.name("shortOrder[]"));
			String upwardvalu=colle1.get(0).getAttribute("value");	
			Assert.assertEquals(upwardvalu, "1");
		}catch(Exception e){
			throw e;
		}
	}
}
