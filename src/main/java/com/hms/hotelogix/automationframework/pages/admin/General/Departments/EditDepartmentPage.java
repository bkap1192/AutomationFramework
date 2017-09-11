package com.hms.hotelogix.automationframework.pages.admin.General.Departments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditDepartmentPage {

	
	@FindBy(xpath="//input[@name='deptName']")
	public WebElement Department_ED;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement Cancel_BT;
	
	@FindBy(xpath="//input[@value='Save Department']")
	public WebElement Save_BT;
	
	@FindBy(xpath="//input[@name='shortName']")
	public WebElement ShortName;
	
	@FindBy(xpath="//a[text()='Departments List']")
	public WebElement DepartmentsList_Link;
	
	public String Deptname;
	public String Shortname;
	
	
	
	public void fn_GetExistingDepartmentName() throws Exception{
		try{

			Deptname=Department_ED.getAttribute("value");
			Shortname=ShortName.getAttribute("value");
			GenericClass.clickElement(DepartmentsList_Link);
			}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	public void fn_ChangeExistingDeptname(String title) throws Exception{
		try{
			GenericClass.sendKeys(Department_ED, title);
			GenericClass.clickElement(Save_BT);
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	public String fn_GetExistingDepartmentname(){
		try{
			return Department_ED.getAttribute("value");
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void fn_VerifyLinkOrButton(WebElement element) throws Exception{
		try{
		GenericClass.clickElement(element);
		}catch(Exception e){
			throw e;
		}
	   }
	
}
