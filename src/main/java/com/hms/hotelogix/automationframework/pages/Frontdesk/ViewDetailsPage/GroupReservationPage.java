package com.hms.hotelogix.automationframework.pages.Frontdesk.ViewDetailsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class GroupReservationPage {

	

	@FindBy(xpath="//span[@class='tname']")
	public WebElement title_GroupResPage;
	
	@FindBy(xpath="//input[@id='btnGrpSave']")
	public WebElement Btn_Reserve;	
	
	
	
public FrontdeskLandingPage ClickOnReserve() throws Exception{
try{
GenericClass.clickElement(Btn_Reserve);
}
catch(Exception e){
throw e;
}
FrontdeskLandingPage FLP=PageFactory.initElements(GenericClass.driver, FrontdeskLandingPage.class);
return FLP;
}	
	
	
}
