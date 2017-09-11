package com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AttachaPackageWindow {

	@FindBy(id="chkId_1")
	public  WebElement Check_Box;
	
	@FindBy(xpath="//form[@id='frmListView']//table[2]//tr[2]//td[4]")
	public  WebElement PackageName_Column;
	
	@FindBy(xpath="//input[@value='Attach']")
	public  WebElement Attach_BT;
	
	
	public static String Packagename;
	
public String fn_AttachPackage() throws Exception{
		
		try
		{
			Thread.sleep(2000);
		GenericClass.clickElement(Check_Box);
		String pkgstrname=GenericClass.getText(PackageName_Column);
	    Packagename=pkgstrname;
	    GenericClass.clickElement(Attach_BT);
	    return Packagename;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
}
