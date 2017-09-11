package com.hms.hotelogix.automationframework.pages.admin.PriceManager.TravelAgentPackages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class ListOfPackagesTravelAgent
{
	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[8]/a")
	public static WebElement addviewpkg_lnk;


	/**
	 * This method clicks on 'Add/View Package' link on ListOfPackagesTravelAgent page
	 * @return :  ListOfPackageTravelAgent1 page and initializes all its elements
	 * @throws Exception
	 */
	public  ListOfPackageTravelAgent1 click_addviewpkg() throws Exception
	  {

		try
		{
		GenericClass.js_Click(addviewpkg_lnk);
		ListOfPackageTravelAgent1 LPTA1=PageFactory.initElements(GenericClass.driver, ListOfPackageTravelAgent1.class);
		  return LPTA1;
		}
		catch(Exception e)
		{
			throw e;
		}
	  }
}
