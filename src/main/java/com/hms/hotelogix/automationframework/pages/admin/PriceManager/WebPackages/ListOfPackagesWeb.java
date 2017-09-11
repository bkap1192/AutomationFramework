package com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.AddAPackagePage;

public class ListOfPackagesWeb {

	
	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a[text()='Edit']")
	public  WebElement edit_link;
	
	@FindBy(xpath="//a[contains(.,'Attach a Package')]")
	public  WebElement AttachaPackage_Link;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement view_dropdwn;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public  List<WebElement> TR_Count;
	
	public  PackageDetailWeb clck_Editlnk() throws Exception
	{
		try
		{
		GenericClass.clickElement(edit_link);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericClass.js_Click(edit_link);
		}
		catch(Exception e)
		{
			throw e;
		}
		PackageDetailWeb pageobj=PageFactory.initElements(GenericClass.driver, PackageDetailWeb.class);
		return pageobj;
	}
	
	public AttachaPackageWindow fn_ClickAttachaPackageLink() throws Exception{
		try{
		GenericClass.clickElement(AttachaPackage_Link);
		AttachaPackageWindow attchpkgwindow=PageFactory.initElements(GenericClass.driver, AttachaPackageWindow.class);
		return attchpkgwindow;
		}catch(Exception e){
			throw e;
		}
	}
	
	public void fn_viewAll()
	{try{
	   GenericClass.selectElement(view_dropdwn, "All");
	   GenericClass.Alert_Accept();
	}catch(Exception e){
		throw e;
	}
	}
	
	
	public  PackageDetailWeb clckSpecifiedPkg_Editlnk() throws Exception
	{
		 int tble_cnt=GenericClass.tr_count(TR_Count);
		for(int i=2;i<=tble_cnt;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			//System.out.println(data);
			if(data.contains(AddAPackagePage.pkgName))
			{
				WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a"));

				//Actions action =new Actions(GenericMethods.driver);
				Thread.sleep(2000);
				GenericClass.js_Click(ele);
				Thread.sleep(2000);
				break;
			}
		}
		PackageDetailWeb FPD=PageFactory.initElements(GenericClass.driver, PackageDetailWeb.class);
		return FPD;
	  }

	
}
