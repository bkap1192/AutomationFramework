package com.hms.hotelogix.automationframework.pages.admin.PriceManager.CorporatePackages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ListOfPackagesCorporate
{
	 @FindBy(xpath="//div[@class='headingtxt']//tbody//td[2]")
	  public  WebElement pg_title;

	  @FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[8]/a")
	  public  WebElement addviewpkg_lnk;


	  /**
	   * This method clicks on 'Add/View packages' link
	   * @return :  ListOfPackagesCorporate page and initializes all its elements
	   * @throws Exception
	   */
	  public ListOfPackagesCorporate1 click_addviewpkg() throws Exception
	  {
		  try
		  {
		  GenericClass.clickElement(addviewpkg_lnk);
		  ListOfPackagesCorporate1 LPC1=PageFactory.initElements(GenericClass.driver, ListOfPackagesCorporate1.class);
		  return LPC1;
		  }
		  catch(Exception e)
		  {
			  throw e;
		  }
	  }
	  
	  
	 
}
