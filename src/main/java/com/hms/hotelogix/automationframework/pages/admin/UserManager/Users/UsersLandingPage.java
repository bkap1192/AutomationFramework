package com.hms.hotelogix.automationframework.pages.admin.UserManager.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class UsersLandingPage {
	
	
	
	
	@FindBy(xpath="//a[text()='Add a new user']")
	public static WebElement AddNewUser_Link;
	
	
	
	public AddNewUserPage fn_ClickAddNewUserLink() throws Exception{
		try{
			GenericClass.clickElement(AddNewUser_Link);
		}catch(Exception e){
			throw e;
		}
		return PageFactory.initElements(GenericClass.driver, AddNewUserPage.class);
	   }

}
