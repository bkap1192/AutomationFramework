package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.AuditTrialBlock;

public class AuditTrailPage {

	private static AuditTrialBlock ATB;



	@FindBy(xpath="//table[2]//td")
	public static WebElement titleAuditTrail;

	@FindBy(xpath="//table[2]//tr[2]/td")
	public static WebElement changes1;

	@FindBy(xpath="//table[2]//tr[3]/td")
	public static WebElement changes2;

	@FindBy(xpath="//table[2]//tr[4]/td")
	public static WebElement changes3;

	@FindBy(xpath="//table[2]//tr[5]/td")
	public static WebElement changes4;

	@FindBy(xpath="//table[2]//tr[6]/td")
	public static WebElement changes5;


	@FindBy(xpath="//table[2]//tr")
    public static List<WebElement> tr_count;



	public AuditTrialBlock auditTrailHistory(String changedfloorname){

		String str=GenericClass.getText(changes1);
		if(str.contains(changedfloorname)){

			System.out.println(str + " Record Verified");
		}else System.out.println("Not Matched in Audit Trail");

		String str1=GenericClass.getText(changes2);
	if(str1.contains(FloorsLandingPage.fname)){


			System.out.println(str1 + " Record Verified");
		}else System.out.println("Not Matched in Audit Trail");

		String str2=GenericClass.getText(changes3);
		if(str2.contains(FloorsLandingPage.fname)){

			System.out.println(str2 + " Record Verified");
		}
		else {System.out.println("Not Matched in Audit Trail");}

		String str3=GenericClass.getText(changes4);
		if(str3.contains(FloorsLandingPage.floor2del)){
			System.out.println(str3 + " Record Verified");
		}
		else{
			System.out.println("Not Matched in Audit Trail");
		}

		/*String str4=GenericClass.getText(changes5);
		if(str4.contains(AddFloorPage.editFloor)){
			System.out.println(str4 + " Record Verified");
		}
		else{
			System.out.println("Not Matched in Audit Trail");
		}*/
		return ATB;
	}
	 public List<String> verify_ChangedHistory(String changedfloorname) throws Exception{
		 try{
			 ArrayList<String> arr= new ArrayList<String>();
	        int count=GenericClass.tr_count(tr_count);
	        for(int i=2;i<=count-4;i++) {
	            String str=GenericClass.driver.findElement(By.xpath("//table[2]//tr["+i+"]/td/b")).getText();
	            if(str.contains("Floor Name")){
	                String data=GenericClass.driver.findElement(By.xpath("//table[2]//tr["+i+"]/td")).getText();
	                String parts=data.split(" ")[8];
	                arr.add(parts);
	            }
	            }
	        return arr;
		 }catch(Exception e){
			 throw e;
		 }
		
	    }
	
	
	
}
