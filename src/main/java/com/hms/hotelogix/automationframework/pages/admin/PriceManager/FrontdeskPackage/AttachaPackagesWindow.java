package com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.AddAPackagePage;

public class AttachaPackagesWindow {

	
	@FindBy(xpath="//form[@id='frmListView']//table[2]//tr")
	public  List<WebElement> Tr_count;

	@FindBy(xpath="//form[@id='frmListView']//table[2]//tr//td[4]")
	public  WebElement Title_Text;

	@FindBy(xpath="//input[@name='save']")
	public  WebElement btn_Attach;
	
	public FrontDeskPackagesLandingPage fn_attachPkg() throws Exception
	{
		try
		{
		int trvalue=GenericClass.tr_count(Tr_count);
		int trva=trvalue+2;
		for(int i=2;i<trva;i++){
			String str=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[4]")).getText();

			if(str.contains(AddAPackagePage.pkgName))
			{
			    WebElement ele=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[2]/input"));
			    ele.click();
				break;
			}
			}
       GenericClass.clickElement(btn_Attach);
       FrontDeskPackagesLandingPage FLP=PageFactory.initElements(GenericClass.driver, FrontDeskPackagesLandingPage.class);
       return FLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}
