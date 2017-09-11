package com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class GroupViewDetailPage {


	@FindBy(xpath="//input[@value='Enable Editing']")
	public WebElement Btn_EnableEditing;


	@FindBy(xpath="//span[@class='panel-link']")
	public WebElement Link_AddEditDetail;

	@FindBy(xpath="//input[@id='srTxtFirstName']")
	public WebElement TxtBx_Fname;


	@FindBy(xpath="//input[@id='srTxtLastName']")
	public WebElement TxtBx_LastName;


	@FindBy(xpath="//input[@id='chkVipGst']")
	public WebElement CB_markVipGuest;

	@FindBy(xpath="//input[@id='chkBlGst']")
	public WebElement CB_markBlackListed;


	@FindBy(xpath="//input[@id='btnSave']")
	public WebElement Btn_Save;

	@FindBy(xpath="//img[@title='Black Listed']")
	public WebElement Img_forBlackListedGuest;

	@FindBy(xpath="//td[contains(text(),'VIP#')]")
	public WebElement Lable_guestAsVIP;

	@FindBy(xpath="//strong[@style='color:red;']")
	public WebElement Txt_GuestIdForGroup;

	@FindBy(xpath="//span[@class='colorblue']")
	public WebElement Txt_groupOwnerName;
	
	
	
public GroupEnableEditingPage fn_clickOnEnableEditingBtn() throws Exception{
try{
GenericClass.clickElement(Btn_EnableEditing);
}
catch(Exception e){
throw e;
}
GroupEnableEditingPage GEEP=PageFactory.initElements(GenericClass.driver, GroupEnableEditingPage.class);
return GEEP;
}
				
	
	
}
