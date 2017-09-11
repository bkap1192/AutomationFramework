package com.hms.hotelogix.automationframework.pages.admin.PosManager.POSPoints;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class POSPointsLandingPage {
	
	

	

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[5]/a[2]")
	public static WebElement Addnew_link;
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement Edit_link;
	
	
	
	
	
	public EditPOSProductPage fn_ClickOnEditLink() throws Exception{
		try{
			GenericClass.clickElement(Edit_link);
		}catch(Exception e){
			throw e;
		}
		return PageFactory.initElements(GenericClass.driver, EditPOSProductPage.class);
	}
	
	
	

}
