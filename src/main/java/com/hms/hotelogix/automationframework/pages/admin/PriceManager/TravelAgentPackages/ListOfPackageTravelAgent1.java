package com.hms.hotelogix.automationframework.pages.admin.PriceManager.TravelAgentPackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.PackageMaster.AddAPackagePage;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages.AttachaPackageWindow;

public class ListOfPackageTravelAgent1 {

	@FindBy(xpath="//a[contains(.,'Attach a Package')]")
	public  WebElement AttachaPackage_Link;
	
	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public  List<WebElement> TR_Count;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a")
	public  WebElement edit_link;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement drpdwn_View;
	
	public AttachaPackageWindow fn_ClickAttachaPackageLink() throws Exception
	{try{
		GenericClass.clickElement(AttachaPackage_Link);
		AttachaPackageWindow attchpkgwindow=PageFactory.initElements(GenericClass.driver, AttachaPackageWindow.class);
		return attchpkgwindow;
	}catch(Exception e){
		throw e;
	}
	}

	
	
	public  PackageDetailTravelAgent clck_Editlnk() throws Exception
	{
		try
		{
			int count=GenericClass.tr_count(TR_Count);
	           if(count<=4)
	           {
	        	   String a=GenericClass.GetCurrentWindowID();
	        	   AttachaPackageWindow APW=fn_ClickAttachaPackageLink();
	        	   GenericClass.windowHandle(a);   
	        	   APW.fn_AttachPackage();   
	        	   GenericClass.Switch_Parent_Window(a);        	   
	           }
			
			
		GenericClass.clickElement(edit_link);
		PackageDetailTravelAgent pageobj=PageFactory.initElements(GenericClass.driver, PackageDetailTravelAgent.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  ListOfPackageTravelAgent1 fn_viewAll()
    {try{
    	GenericClass.selectElement(drpdwn_View, "All");
    	GenericClass.ActionOnAlert("Accept");
    	ListOfPackageTravelAgent1 pageobj=PageFactory.initElements(GenericClass.driver, ListOfPackageTravelAgent1.class);
		return pageobj;
    }catch(Exception e){
    	throw e;
    }
    }
	
	public  PackageDetailTravelAgent clckSpecifiedPkg_Editlnk() throws Exception
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
		PackageDetailTravelAgent FPD=PageFactory.initElements(GenericClass.driver, PackageDetailTravelAgent.class);
		return FPD;
	  }

}
