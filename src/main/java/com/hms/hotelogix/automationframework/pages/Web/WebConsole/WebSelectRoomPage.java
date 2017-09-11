package com.hms.hotelogix.automationframework.pages.Web.WebConsole;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes.EditRoomType;

public class WebSelectRoomPage {

	@FindBy(xpath="//input[@value='Select']")
    public  WebElement btn_Select;
	
	@FindBy(xpath="//tr[starts-with(@id,'rmTypeContRwId_')]")
	public  List<WebElement> AllRoomTypeOnWeb;
	
	public WebAddMoreRoomPage fn_SelectRoomandRate() throws Exception
	{try{
        GenericClass.clickElement(btn_Select);

        WebAddMoreRoomPage WARP=PageFactory.initElements(GenericClass.driver, WebAddMoreRoomPage.class);
        return WARP;
	}catch(Exception e){
		throw e;
	}
     }
	
	public void verify_UploadedImg(String rtName)
	{
		try
		{
		int count=GenericClass.tr_count(AllRoomTypeOnWeb);
		for(int i=1;i<=count;i++)
		{
			String name1=GenericClass.driver.findElement(By.xpath("//tr[starts-with(@id,'rmTypeContRwId_')]["+i+"]//table[@class='tbl-contentNew']//tr/td/h5/strong")).getText();
			if(name1.equals(rtName))
			{
				String src=GenericClass.driver.findElement(By.xpath("//tr[starts-with(@id,'rmTypeContRwId_')]["+i+"]//table//td[@class='brdr-btm']//a/img")).getAttribute("src");
				Assert.assertTrue(src.endsWith(EditRoomType.imgName));
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
