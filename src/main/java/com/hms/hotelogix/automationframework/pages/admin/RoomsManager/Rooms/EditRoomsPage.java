package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class EditRoomsPage {

	@FindBy(xpath="//select[@id='rmTypeId']")
	public  WebElement drpdown_RoomType;

	@FindBy(xpath="//a[text()='Rooms List']")
	public  WebElement link_RoomList;
	
	@FindBy(xpath="//div[@id='listing-icons']//li[3]/input")
	public WebElement Btn_Save;
	
	@FindBy(xpath="//input[@name='rmNameOrNoMulName[]']")
	public  WebElement TxtBox_EditRoom;
	
	@FindBy(xpath="//input[@name='btnSave' and  @type='image']")
	public WebElement Btn_SaveNDuplicateRoomTop;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement Btn_Cancel;

	ArrayList<String> al=new ArrayList<>();
	
	public void fn_verifyAddedRoomType(String rtName) throws Exception
	{
        try
        {
		Select sel=new Select(drpdown_RoomType);
		int size=sel.getOptions().size();
		for(int i=0;i<=size;i++)
		{
			String str=sel.getOptions().get(i).getText();
			if(str.equals(rtName))
			{
				System.out.println("Added room type is being displayed on 'Edit Room' page.");
				break;
			}
		}
        }
        catch(Exception e)
        {
        	throw e;
        }
	}
	
	public RoomsLandingPage ClickOnRoomListLink() throws Exception
	{
		try
		{
	GenericClass.clickElement(link_RoomList);
	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
	return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_verifyDeletedRoomType(String rtName) throws Exception
	{

		try
		{
		Select sel=new Select(drpdown_RoomType);
		int size=sel.getOptions().size();
		for(int i=0;i<size;i++)
		{
			String str=sel.getOptions().get(i).getText();
			al.add(str);
		}

		Assert.assertFalse(al.contains(rtName));
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
	
	public void fn_verifyEditedRoomType(String rtName) throws Exception
	{
try{
		Select sel=new Select(drpdown_RoomType);
		int size=sel.getOptions().size();
		for(int i=0;i<=size;i++)
		{
			String str=sel.getOptions().get(i).getText();
			if(str.equals(rtName))
			{
				Assert.assertEquals(str.equals(rtName), true);
				break;
			}
		}
}catch(AssertionError e){
	throw e;
}catch(Exception e){
	throw e;
}
	}
	
	public void fn_verifyDeactivatedRoomType(String rtName) throws Exception
	{

		try
		{
		Select sel=new Select(drpdown_RoomType);
		int size=sel.getOptions().size();
		for(int i=0;i<size;i++)
		{
			String str=sel.getOptions().get(i).getText();
			Assert.assertFalse(str.contains(rtName));
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
	
	public RoomsLandingPage EditTheRoom(String room, WebElement ele) throws Exception{
		try{
		GenericClass.sendKeys(TxtBox_EditRoom, room);
		GenericClass.clickElement(ele);
		}catch(Exception e){
			throw e;
		}
		RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
		return RLP;
	}
	
}
