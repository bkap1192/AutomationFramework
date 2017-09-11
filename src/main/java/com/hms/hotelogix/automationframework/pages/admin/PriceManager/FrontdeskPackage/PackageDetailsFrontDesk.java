package com.hms.hotelogix.automationframework.pages.admin.PriceManager.FrontdeskPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class PackageDetailsFrontDesk {

	@FindBy(xpath="//a/strong[text()='View']")
	public  WebElement link_view;
	
	@FindBy(xpath="//td[@class='table-validity']/table//tr[3]//table//tr")
	public  List<WebElement> rowcount;
	
	@FindBy(xpath="//td[@class='crumbs']//a[2]")
	public  WebElement link_PkgFDList;
	
	public  void clk_view() throws Exception
	{
		try
		{
		GenericClass.clickElement(link_view);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericClass.js_Click(link_view);
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
    			System.out.println("Added room type name is being displayed on Package Details(Frontdesk)' page.");
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
	
	public  FrontDeskPackagesLandingPage clk_PkgFrontdeskLnk() throws Exception
    {
    	try
    	{
  	  GenericClass.clickElement(link_PkgFDList);
  	FrontDeskPackagesLandingPage FPL=PageFactory.initElements(GenericClass.driver, FrontDeskPackagesLandingPage.class);
  	  return FPL;
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
	    			System.out.println("Deleted room type name is still being displayed on Package Details(Frontdesk)' page.");
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
	    }
	    }

	
	 public void verify_DeactiveRTName(String rtName) throws Exception
	    {
	    	try
	    	{
	    	int count1=GenericClass.tr_count(rowcount);
	    	for(int i=2;i<=count1;i++)
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
