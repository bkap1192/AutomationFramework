package com.hms.hotelogix.automationframework.pages.admin.UserManager.Users;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewUserPage {

	
	@FindBy(xpath="//select[@id='departmentId']")
	public WebElement Department_DD;
	
	
	
	
	
	public ArrayList<String> fn_VerifyDepartmentnameInDropDown(){
		try{
			ArrayList<String> depcollec=new ArrayList<String>();
			Select sobj=new Select(Department_DD);
			List<WebElement> colle=sobj.getOptions();
			for(WebElement we : colle){
				depcollec.add(we.getText());
			}
			return depcollec;
		}catch(Exception e){
			throw e;
		}
	    }
}
