package com.hms.hotelogix.automationframework.pages.admin.General.PayModes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class PayModesLandingPage {
	
	
@FindBy(xpath="//a[contains(text(),'Main')]")
public WebElement Link_Main;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[1]/strong")
public WebElement HeaderText_SerialNum;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[2]")
public WebElement HeaderText_PayTypeMode;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[3]")
public WebElement HeaderText_PayTypeTitle;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[4]")
public WebElement HeaderText_Action;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr/th[5]")
public WebElement HeaderText_ViewOnFrontDesk;

@FindBy(xpath="//a[text()='AuditTrail']")
public WebElement Link_AuditTrail;

@FindBy(xpath="//a[text()='Edit']")
public WebElement Link_Edit;

@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
public List<WebElement> Rows_AllPayModes;

@FindBy(xpath="//form/table/tbody/tr[2]/td")
public WebElement Msg_titleSave;




public String payMode;
public String paytitle;



public AuditTrailPage fn_ClickOnAuditTrailPage() throws Exception{
try{
GenericClass.clickElement(Link_AuditTrail);	
}
catch(Exception e){
throw e;	
}
AuditTrailPage ATP=PageFactory.initElements(GenericClass.driver, AuditTrailPage.class);
return ATP;
}


public void fn_activatePayMode(String payModesToDeactivate){
try{
int size=GenericClass.tr_count(Rows_AllPayModes);
for(int i=2;i<=size;i++){
String paymode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();	
if(paymode.equals(payModesToDeactivate)){
	String stat=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[5]/a/img")).getAttribute("src");
	if(stat.endsWith("off.GIF")){
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[5]/a/img")).click();
		payMode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();
		paytitle=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText().trim();
		Reporter.log("Pay mode activated", true);
		break;
}
else{
		payMode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();
		paytitle=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText().trim();
		Reporter.log("Pay mode already activated", true);
		break;
	}
	
	
}
}	
	
}
catch(Exception e){
throw e;
}
}

public void fn_deactivatePayMode(String payModesToDeactivate){
try{
int size=GenericClass.tr_count(Rows_AllPayModes);
for(int i=2;i<=size;i++){
String paymode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();	
if(paymode.equals(payModesToDeactivate)){
	String stat=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[5]/a/img")).getAttribute("src");
	if(stat.endsWith("off.GIF")){
		Reporter.log("Mentioned pay mode already deactivate", true);
		break;
		
	}
	else{
		payMode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();
		paytitle=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText().trim();
		GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[5]/a/img")).click();
		break;
	}
	
	
}
}
}
catch(Exception e){
	throw e;
}
}

public EditPayModePage fn_ClickOnEditLinkForPayMode(String payMode){
try{
int size=GenericClass.tr_count(Rows_AllPayModes);
for(int i=2;i<=size;i++){
String paymode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();
if(paymode.equals(payMode)){
	GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[4]")).click();
	break;
	
}
}	
}
catch(Exception e){
	throw e;
}
EditPayModePage EPMP=PageFactory.initElements(GenericClass.driver, EditPayModePage.class);
return EPMP;
}


public EditPayModePage fn_ClickOnEditLink() throws Exception{
try{
GenericClass.clickElement(Link_Edit);
}
catch(Exception e){
throw e;
}
EditPayModePage EPMP=PageFactory.initElements(GenericClass.driver, EditPayModePage.class);
return EPMP;


}




public void fn_VerifyPageElements() throws Exception{
try{
GenericClass.checkElementDisplay("Displaying", Link_Main);
GenericClass.checkElementDisplay("Displaying", HeaderText_SerialNum);
GenericClass.checkElementDisplay("Displaying", HeaderText_PayTypeMode);
GenericClass.checkElementDisplay("Displaying", HeaderText_PayTypeTitle);
GenericClass.checkElementDisplay("Displaying", HeaderText_Action);
GenericClass.checkElementDisplay("Displaying", HeaderText_ViewOnFrontDesk);
GenericClass.checkElementDisplay("Displaying", Link_AuditTrail);
GenericClass.checkElementDisplay("Displaying", Link_Edit);
}
catch(Exception e){
throw e;	
}
}



public AdminHome fn_clickOnMainLink() throws Exception{
try{
GenericClass.clickElement(Link_Main);
	
}
catch(Exception e){
	throw e;
}
AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
return AH;
	
}





public ArrayList<String> fn_getAllPayModes() throws Exception{
	ArrayList<String> pm=new ArrayList<String>();
try{
int size=GenericClass.tr_count(Rows_AllPayModes);
for(int i=2;i<=size;i++){
 String payMode=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[2]")).getText().trim();
 Thread.sleep(2000);
 pm.add(payMode);
}
		
}
catch(Exception e){
throw e;
}


return pm;
}
}
