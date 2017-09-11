package com.hms.hotelogix.automationframework.pages.admin.PriceManager.WebPackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages.ListOfPackagesCorporate1;

public class PackageDetailWeb {

	@FindBy(xpath="//a//strong[text()='View']")
	public  WebElement View_link;
	
	@FindBy(xpath="//td[@class='table-validity']/table//tr[3]//table//tr")
	public  List<WebElement> rowcount;
	
	@FindBy(xpath="//a[contains(.,'Package List (Web)')]")
	public  WebElement PackageListWeb_Link;

	

	
	public  void clk_view() throws Exception
	{
		try
		{
		GenericClass.clickElement(View_link);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericClass.js_Click(View_link);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void verify_AddedRTName(String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//table//tr["+i+"]//td[1]")).getText();
			if(data.equals(rtName))
			{
				Assert.assertTrue(data.equals(rtName));
			    break;
			}
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public ListOfPackagesWeb fn_PackageListWeb_Link() throws Exception
	{
		try
		{
		 GenericClass.clickElement(PackageListWeb_Link);
		 ListOfPackagesWeb WPLP=PageFactory.initElements(GenericClass.driver,ListOfPackagesWeb.class);
		 return WPLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void verify_DeletedRTName(String rtName) throws Exception
	{try{
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//table//tr["+i+"]//td[1]")).getText();
			if(data.equals(rtName))
			{
				System.out.println("Deleted room type name is still being displayed on Package Details(Web)' page.");
			    break;
			}
		}
	}catch(Exception e){
		throw e;
	}
	}
	
	
	public void verify_EditedRTName(String rtName) throws Exception
	{try{
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//table//tr["+i+"]//td[1]")).getText();
			if(data.equals(rtName))
			{
	           Assert.assertEquals(data.equals(rtName), true);
				break;
			}
		}
	}catch(AssertionError e){
		throw e;
	}catch(Exception e){
		throw e;
	}
	}
	
	
	public void verify_DeactiveRTName(String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//table//tr["+i+"]//td[1]")).getText();
			if(data.equals(rtName)){
			Assert.assertFalse(data.contains(rtName));
			break;
			}
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void verify_ActiveRTName(String rtName) throws Exception
	{
		try
		{
		int count=GenericClass.tr_count(rowcount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericClass.driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//table//tr["+i+"]//td[1]")).getText();
			if(data.equals(rtName))
			{
			Assert.assertTrue(data.contains(rtName));
			break;
			}		
		}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}

