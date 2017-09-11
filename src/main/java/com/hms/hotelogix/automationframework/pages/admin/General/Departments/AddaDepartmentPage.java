package com.hms.hotelogix.automationframework.pages.admin.General.Departments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AddaDepartmentPage {

	
	@FindBy(xpath="//input[@name='deptName']")
	public WebElement Department_Title;
	
	@FindBy(xpath="//input[@name='shortName']")
	public WebElement ShortName;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement Description_ED;
	
	@FindBy(xpath="//input[@value='Save Department']")
	public WebElement SaveDepartment_BT;
	
	@FindBy(xpath="//input[@name='Submit5']")
	public WebElement SaveDepartment_IMG;
	
	@FindBy(xpath="//td[@class='padingtd']//p")
	public WebElement Error_TX;
	
	@FindBy(xpath="//td[@class='comments']//input[2]")
	public WebElement Cancel_BT;
	
	@FindBy(xpath="//div[@id='listing-icons']//input")
	public WebElement Cancel_IMG;
	
	@FindBy(xpath="//a[text()='Departments List']")
	public WebElement DepartmentList_Link;
	
	@FindBy(xpath="//a[text()='Main']")
	public WebElement Main_Link;
	
	@FindBy(xpath="//a[text()='AuditTrail']")
	public WebElement AuditTrail_Link;
	
	
	
	
	
	public void fn_FillMenedatoryfield(WebElement savedepartment,String title, String shortname, String description) throws Exception{
		try{
			GenericClass.sendKeys(Department_Title, title);
			GenericClass.sendKeys(ShortName, shortname);
			GenericClass.sendKeys(Description_ED, description);
			GenericClass.clickElement(savedepartment);
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_FillMenedatoryfieldWithoutSave(String title, String shortname, String description) throws Exception{
		try{
			GenericClass.sendKeys(Department_Title, title);
			GenericClass.sendKeys(ShortName, shortname);
			GenericClass.sendKeys(Description_ED, description);
		}catch(Exception e){
			throw e;
		}
	}
	
	public String fn_GetErrorText(){
		try{
			String error=GenericClass.getText(Error_TX);
			return error;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_ClickButtonOrWebelement(WebElement cancel) throws Exception{
		try{
			GenericClass.clickElement(cancel);
		}catch(Exception e){
			throw e;
		}
		
	    }
	
	public AddAuditTrailPage fn_AuditTrail() throws Exception{
		try{
			GenericClass.clickElement(AuditTrail_Link);
		}catch(Exception e){
			throw e;
		}
		
		return PageFactory.initElements(GenericClass.driver, AddAuditTrailPage.class);
	    }
	
	
}
