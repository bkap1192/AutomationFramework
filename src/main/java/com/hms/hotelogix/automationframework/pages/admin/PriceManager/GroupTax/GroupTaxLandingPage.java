package com.hms.hotelogix.automationframework.pages.admin.PriceManager.GroupTax;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;


public class GroupTaxLandingPage {
	
	
	
	@FindBy(xpath="//a[text()='Add a Group Tax']")
	public WebElement Link_AddGroupTax;
	
	
	
	
	
	
	
	public AddGroupTaxPage fn_ClickOnAddGroupTaxBtn(){
		try{
			GenericClass.clickElement(Link_AddGroupTax);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		AddGroupTaxPage AGTP=PageFactory.initElements(GenericClass.driver, AddGroupTaxPage.class);
		return AGTP;
	}

}
