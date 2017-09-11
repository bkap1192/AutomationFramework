package com.hms.hotelogix.automationframework.pages.admin.PriceManager.RoomPrices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebReservationHomePage;

public class RoomPriceListLandingPage {

	
	@FindBy(xpath="//table[@class='table_price']//tr")
	public  List<WebElement> roomtypeCount;
	
	public WebReservationHomePage verify_RTPublishedOnWeb(String RTName) throws InterruptedException
	{
		try
		{
		  int count=GenericClass.tr_count(roomtypeCount);
	      for(int i=2;i<=count-1;i++)
	      {
	    	  
	    	  String data=GenericClass.driver.findElement(By.xpath("//table[@class='table_price']//tr["+i+"]//td[@class='main-field']")).getText();
	    	  if(data.contains(RTName))
	    	  {
	  
	    		  Assert.assertTrue(data.contains(RTName));
	    		  WebElement ele=GenericClass.driver.findElement(By.xpath("//table[@class='table_price']//tr["+i+"]//td[3]//img"));
	    		  ele.click();
	    		  WebElement ele1=GenericClass.driver.findElement(By.xpath("//table[@class='table_price']//tr["+i+"]//td[3]//table//tr[4]//td[8]/input"));
	    		  boolean value=ele1.isSelected();
	    		  if(value==true)
	    		  {
	    			  GenericClass.driver.navigate().to("http://hotelogix.stayezee.com/webreservation/index/index/hidHotelIdWebOut/QV5TX0ZSczM0XzEyOTAzX0Y1dGVyOTA4N3NfKWRoZl9kcnRlcjdfMTI5MDNfaGdmaF9nXmQ4NTQ=/hidLanguageId/1/");
	                  break;
	    		  }
	    		  else
	    		  {
	    			  ele1.click();
	    			  WebElement ele2=GenericClass.driver.findElement(By.xpath("//table[@class='table_price']//tr["+i+"]//td[3]//table//tr[4]//td[14]//img[@title='Save']"));
	    			  //GenericClass.js_Click(ele2);
	    			  if(ele2.isEnabled()==false)
	    			  {
	    				  Thread.sleep(5000);
	    			  }


	    			  new Actions(GenericClass.driver).click(ele2).build().perform();

	    			  GenericClass.driver.navigate().to("http://hotelogix.stayezee.com/webreservation/index/index/hidHotelIdWebOut/QV5TX0ZSczM0XzEyOTAzX0Y1dGVyOTA4N3NfKWRoZl9kcnRlcjdfMTI5MDNfaGdmaF9nXmQ4NTQ=/hidLanguageId/1/");
	    		  }
	          break;
	    	  }
	      }
	      WebReservationHomePage WRP=PageFactory.initElements(GenericClass.driver, WebReservationHomePage.class);
	      return WRP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
