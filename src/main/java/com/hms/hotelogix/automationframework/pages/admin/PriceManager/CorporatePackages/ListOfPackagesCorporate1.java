package com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.AddAPackagePage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages.AttachaPackageWindow;

public class ListOfPackagesCorporate1 {

	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public  List<WebElement> TR_Count;

	@FindBy(xpath="//a[contains(.,'Attach a Package')]")
	public  WebElement AttachaPackage_Link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a")
	public  WebElement link_configure;

	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement drpdwn_View;
	
	public AttachaPackageWindow fn_ClickAttachaPackageLink() throws Exception
	{try
	{
		GenericClass.clickElement(AttachaPackage_Link);
		AttachaPackageWindow attchpkgwindow=PageFactory.initElements(GenericClass.driver, AttachaPackageWindow.class);
		return attchpkgwindow;
	}
	catch(Exception e)
	{
		throw e;
	}
	}
	
	
	public  PackageDetailCorporate clck_Editlnk() throws Exception
	{
		try
		{
		   int count=GenericClass.tr_count(TR_Count);
           if(count<=4)
           {
        	   String a=GenericClass.GetCurrentWindowID();
        	   AttachaPackageWindow APW=fn_ClickAttachaPackageLink();
        	   Thread.sleep(2000);
        	   GenericClass.windowHandle(a);   
         	   APW.fn_AttachPackage();   
        	   GenericClass.Switch_Parent_Window(a);        	   
           }
			GenericClass.clickElement(link_configure);
		PackageDetailCorporate pageobj=PageFactory.initElements(GenericClass.driver, PackageDetailCorporate.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public  ListOfPackagesCorporate1 fn_viewAll()
    {try{
    	GenericClass.selectElement(drpdwn_View, "All");
    	GenericClass.ActionOnAlert("Accept");
    	ListOfPackagesCorporate1 pageobj=PageFactory.initElements(GenericClass.driver, ListOfPackagesCorporate1.class);
		return pageobj;
    }catch(Exception e){
    	throw e;
    }
    }
	
	
	public  PackageDetailCorporate clckSpecifiedPkg_Editlnk() throws Exception
	{try{
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
		PackageDetailCorporate FPD=PageFactory.initElements(GenericClass.driver, PackageDetailCorporate.class);
		return FPD;
	  }catch(Exception e){
		  throw e;
	  }
	}
}
