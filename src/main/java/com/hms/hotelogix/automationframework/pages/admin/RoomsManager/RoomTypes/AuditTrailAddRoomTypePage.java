package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.RoomTypes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;

public class AuditTrailAddRoomTypePage 
{

	@FindBy(xpath="//table[3]//tr")
	public static List<WebElement> tr_count;
	
	
	public void verify_ChangedHistory(int iTestCaseRow,String rtName) throws Exception
	{
        int count=GenericClass.tr_count(tr_count);
        for(int i=2;i<=count;i++)
        {
            String str=GenericClass.driver.findElement(By.xpath("//table[3]//tr["+i+"]/td/b")).getText();
            if(str.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))))
            {
            	String data=GenericClass.driver.findElement(By.xpath("//table[3]//tr["+i+"]/td")).getText();
                String[] parts=data.split(" ");
                String text=parts[7];
            	Assert.assertTrue(text.contains(rtName));
                break;
            }

        }
	}
}
