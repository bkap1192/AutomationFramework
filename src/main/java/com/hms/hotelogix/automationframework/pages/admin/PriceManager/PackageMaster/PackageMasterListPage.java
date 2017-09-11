package com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class PackageMasterListPage {

	
	@FindBy(xpath="//a[text()='Add a Package']")
	public  WebElement AddPackage_Link;
	
	public AddAPackagePage fn_ClickAddaPackageLink() throws Exception
	{
		try
		{
		GenericClass.clickElement(AddPackage_Link);
		AddAPackagePage app=PageFactory.initElements(GenericClass.driver, AddAPackagePage.class);
		return app;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
