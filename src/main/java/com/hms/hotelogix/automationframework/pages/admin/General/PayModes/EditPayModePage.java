package com.hms.hotelogix.automationframework.pages.admin.General.PayModes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.General.PayTypes.PayTypesLandingPage;

public class EditPayModePage {
	
	
	
	
@FindBy(xpath="//div[@id='heading_new']//table//tr/td[2]")
public WebElement Header_Page;
	
@FindBy(xpath="//a[text()='Main']")
public WebElement Link_Main;

@FindBy(xpath="//a[text()='Pay Mode List']")
public WebElement Link_PayModeList;

@FindBy(xpath="//input[@value='Save']")
public WebElement Btn_Save;

@FindBy(xpath="//input[@value='Cancel']")
public WebElement Btn_Cancel;

@FindBy(xpath="//td[@class='padingtd']//table//tbody//tr//th")
public WebElement Txt_EnterTheDetails;

@FindBy(xpath="//td[@class='padingtd']//table//tbody//tr[3]//td[1]")
public WebElement Txt_PayTypeMode;

@FindBy(xpath="//td[@class='padingtd']//table//tbody//tr[4]//td[1]")
public WebElement Txt_PayTypeTitle;

@FindBy(xpath="//a[text()='AuditTrail']")
public WebElement Link_AuditTrail;

@FindBy(xpath="//input[@id='title']")
public WebElement TB_PayTypeTitle;



public String valueBeforeEdit;



public PayModesLandingPage fn_setPayTypeTitle(WebElement ele,String titleToInsert) throws Exception{
try{
valueBeforeEdit=ele.getAttribute("value");
Thread.sleep(2000);
GenericClass.sendKeys(ele, titleToInsert);
GenericClass.clickElement(Btn_Save);
}
catch(Exception e){
	throw e;
}
PayModesLandingPage PMLP=PageFactory.initElements(GenericClass.driver, PayModesLandingPage.class);
return PMLP;
}


public void fn_verifyPageElements() throws Exception{
try{
GenericClass.checkElementDisplay("Header_Page", Header_Page);
GenericClass.checkElementDisplay("Link_Main", Link_Main);
GenericClass.checkElementDisplay("Link_PayModeList", Link_PayModeList);
GenericClass.checkElementDisplay("Btn_Save", Btn_Save);
GenericClass.checkElementDisplay("Btn_Cancel", Btn_Cancel);
GenericClass.checkElementDisplay("Txt_EnterTheDetails", Txt_EnterTheDetails);
GenericClass.checkElementDisplay("Txt_PayTypeMode", Txt_PayTypeMode);
GenericClass.checkElementDisplay("Txt_PayTypeTitle", Txt_PayTypeTitle);
GenericClass.checkElementDisplay("Link_AuditTrai", Link_AuditTrail);
}
catch(Exception e){
	throw e;
}
}



public PayModesLandingPage fn_clickOnCancelBtn() throws Exception{
try{
GenericClass.clickElement(Btn_Cancel);
}
catch(Exception e){
	throw e;
}
PayModesLandingPage PMLP=PageFactory.initElements(GenericClass.driver, PayModesLandingPage.class);
return PMLP;

}
	
	
	
	
		

}
