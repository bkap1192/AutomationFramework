package com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class PackageDetailCorporate {

	@FindBy(xpath="//a//strong[text()='View']")
	public  WebElement View_link;
	
	@FindBy(xpath="//td[@class='table-validity']/table//tr[3]//table//tr")
	public  List<WebElement> rowcount;
	
	@FindBy(xpath="//td[@class='crumbs']//a[2]")
	public  WebElement link_PkgCorporateList;
	
	public  void clk_view() throws Exception
	{
		try
		{
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
	
	
	public  ListOfPackagesCorporate1 clk_PkgCorpLnk() throws Exception
    {
		try
		{
  	  GenericClass.clickElement(link_PkgCorporateList);
  	  ListOfPackagesCorporate1 LOC1=PageFactory.initElements(GenericClass.driver, ListOfPackagesCorporate1.class);
  	  return LOC1;
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
    			System.out.println("Deleted room type name is still being displayed on Package Details(Corporate)' page.");
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

