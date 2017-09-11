package com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.AddAPackagePage;

public class FrontDeskPackagesLandingPage {

	
	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a[text()='Edit']")
	public  WebElement link_edit;
	
	@FindBy(xpath="//a[contains(.,'Attach a Package')]")
	public  WebElement AttachaPackage_Link;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement drpdwn_View;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr//input[@type='checkbox']")
	public  List<WebElement> checkBox;
	
	public PackageDetailsFrontDesk clck_Editlnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_edit);
		PackageDetailsFrontDesk PDF=PageFactory.initElements(GenericClass.driver, PackageDetailsFrontDesk.class);
		return PDF;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public AttachaPackagesWindow fn_ClickAttachAPackageLink() throws Exception
	{
		try
		{
		GenericClass.clickElement(AttachaPackage_Link);
		AttachaPackagesWindow attwin=PageFactory.initElements(GenericClass.driver, AttachaPackagesWindow.class);
		return attwin;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_viewAll()
	{try{
		GenericClass.selectElement(drpdwn_View, "All");
		GenericClass.Alert_Accept();
	}catch(Exception e){
		throw e;
	}
	}
	
	
	public  PackageDetailsFrontDesk clckSpecifiedPkg_Editlnk() throws Exception
	  {
		 int tble_cnt=GenericClass.tr_count(checkBox);
		for(int i=2;i<=tble_cnt;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			//System.out.println(data);
			if(data.contains(AddAPackagePage.pkgName))
			{
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a"));

				//Actions action =new Actions(GenericMethods.driver);
				Thread.sleep(2000);
				GenericClass.js_Click(ele);
				Thread.sleep(2000);
				break;
			}
		}
		PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericClass.driver, PackageDetailsFrontDesk.class);
  	return FPD;
	    }

}

