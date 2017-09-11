package com.hms.hotelogix.automationframework.pages.emailaccount;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebConfirmReservationPrintPage;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;

public class EmailHomePage {

	@FindBy(xpath="//a[@title='Sent Mail']")
	public WebElement link_CASetting;

	@FindBy(xpath="//a[starts-with(@title,'Support')]")
	public WebElement link_supportMail;
	
	@FindBy(xpath="//div[starts-with(@data-tooltip,'Back to ')]")
	public WebElement btn_backTo;
	
	@FindBy(xpath="//div[@class='gs']//div[7]//a")
	public  WebElement Lnk_WebConsole;
	
	@FindBy(xpath="//div[@class='gs']//div[7]")
	public  WebElement data;
	
	@FindBy(xpath="//div[@class='Cp']//tbody//tr")
	public List<WebElement> mailCount;
	
	@FindBy(xpath="//form[@action='move_messages.php']//tbody/tr[5]//table//tr//tbody//tr")
	public  List<WebElement>  AllMails;
	
	public static ArrayList<String> al=new ArrayList<String>();
	public static ArrayList<String> al1=new ArrayList<String>();
	public  ArrayList<String> ar;
	
	public void fn_navigateSupportMails() throws Exception
	{
		try
		{
		GenericClass.mouseOverElement(link_CASetting);
		GenericClass.clickElement(link_supportMail);
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void clk_backToBtn() throws Exception
	{
		try
		{
			GenericClass.clickElement(btn_backTo);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public  ArrayList<String> GetChargesFromMail(){
		try{
	//List<WebElement> Alltr=	GenericMethods.driver.findElements(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr"));
	//int c=GenericMethods.tr_count(GenericMethods.driver.findElements(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr")));
	//Thread.sleep(2000);
	//for(int i=2;i<=3;i++){
	String ta=GenericClass.driver.findElement(By.xpath("//div[@class='gs']/div[7]/div/table//tr/td/div//tr[7]/td/table//tr[4]/td/table//tr[2]//td[2]/strong")).getText();
	
	String tt=GenericClass.driver.findElement(By.xpath("//div[@class='gs']/div[7]/div/table//tr/td/div//tr[7]/td/table//tr[4]/td/table//tr[3]//td[2]/strong")).getText();	
	Thread.sleep(2000);
	al.add(ta);
	al.add(tt);
	
	String policy=GenericClass.driver.findElement(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[15]//tr[2]//td[2]")).getText();
	al.add(policy);

		
	}
	catch(Exception e){
	System.out.println(e);
	}
	return al;

	}
	
	
	public ArrayList<String> GetAccDetail() throws Exception
	{
		try
		{
		String link=Lnk_WebConsole.getAttribute("href");
		System.out.println(link);
		al1.add(link);
		String a=GenericClass.getText(data);
		int a1= a.indexOf("Password");
		String pwd=a.substring(a1+9,a1+18).trim();
		int b1=a.indexOf("Username");
		String uname= a.substring(b1+9, a1-1).trim();
		int c1=a.indexOf("Login Id");
		String id=a.substring(c1+9, b1-1).trim();
		al1.add(id);
		al1.add(uname);
		al1.add(pwd);
		return al1;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public ArrayList<String> GetGuestLoginDetails()
	{try{
		String dtail=GenericClass.getText(GenericClass.driver.findElement(By.xpath("//html/body/table[4]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td")));
		System.out.println(dtail);

		int i=dtail.indexOf("http");
		int k= dtail.indexOf("&hidLanguageId=1");
		int l=dtail.indexOf("Login Id");
		int m=dtail.indexOf("Username");
		int n=dtail.indexOf("Password");
		int o=dtail.indexOf("Thank you");
		String guestLink= dtail.substring(i, k+18).trim();
		String lId=dtail.substring(l+10,m-1).trim();
		String uName=dtail.substring(m+10, n-1).trim();
		String pwd=dtail.substring(n+9, o-1).trim();
		al1.add(guestLink);
		al1.add(lId);
		al1.add(uName);
		al1.add(pwd);

		return al1;
	}catch(Exception e){
		throw e;
	}

	}
	
	public void fn_navigateToConfirmationMail(String hotelName,int iTestCaseRow) throws Exception
	{
		try
		{
			String str=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject));
			//int g=ExcelUtil.GetColumnIndex(Constant.Col_MailSubject);
		//GenericMethods.driver.switchTo().frame(1);
		Thread.sleep(5000);
//		txtbox_search.clear();
//		GenericMethods.sendKeys(txtbox_search,hotelName);
//		GenericMethods.clickElement(btn_Search);
		int count1=GenericClass.tr_count(mailCount);		
		for(int i=1;i<=count1;i++)
		{
		String hname=GenericClass.driver.findElement(By.xpath("//div[@class='Cp']//tr["+i+"]//td[4]//div[2]/span")).getText();
		String sub=GenericClass.driver.findElement(By.xpath("//div[@class='Cp']//tr["+i+"]//td[6]//span/b")).getText();
		boolean  b=(hname.contains(hotelName))&(sub.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject))));
		if(b==true)
		{
			GenericClass.driver.findElement(By.xpath("//div[@class='Cp']//tr["+i+"]//td[6]")).click();
		 break;

		}
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	
	public void fn_navigateToAccDetailMail(String hotelName,int iTestCaseRow) throws Exception
	{
		try
		{
			int f=ExcelUtil.GetColumnIndex(Constant.Col_MailSubject1);
			String str=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject1));
		//GenericMethods.driver.switchTo().frame(1);
			Thread.sleep(3000);
		int count1=GenericClass.tr_count(mailCount);		
		for(int i=1;i<=count1;i++)
		{
		String hname=GenericClass.driver.findElement(By.xpath("//div[@class='Cp']//tr["+i+"]//td[4]//div[2]/span")).getText();
		String sub=GenericClass.driver.findElement(By.xpath("//div[@class='Cp']//tr["+i+"]//td[6]//span")).getText();
		boolean a=(hname.contains(hotelName))&(sub.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject1))));
		if(a==true)
		{
			GenericClass.driver.findElement(By.xpath("//div[@class='Cp']//tr["+i+"]//td[6]")).click();
		 break;

		}
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public void fn_SquirrelConfirmationMail(String hotelName,int iTestCaseRow) throws Exception
	{
		try
		{
			GenericClass.driver.switchTo().frame(1);
		int count=GenericClass.tr_count(AllMails);
		for(int i=2;i<=count;i+=2)
		{
		String hname=GenericClass.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[2]/label")).getText();
		String sub=GenericClass.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[5]//a")).getText();
		String a=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject))+WebConfirmReservationPrintPage.rid;
		System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject)));
		if(hname.contains(hotelName)&&sub.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject)))==true)
		{
			GenericClass.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[5]//a")).click();
		 break;

		}
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	
	public void fn_SquirrelAccDetailMail(String hotelName,int iTestCaseRow) throws Exception
	{
		try
		{
		//GenericMethods.driver.switchTo().frame(1);
		int count=GenericClass.tr_count(AllMails);
		for(int i=2;i<=count;i+=2)
		{
		String hname=GenericClass.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[2]/label")).getText();
		String sub=GenericClass.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[5]//a")).getText();
		if((hname.contains(hotelName))&(sub.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_MailSubject1))))==true)
		{
			GenericClass.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[5]//a")).click();
		 break;

		}
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	
	public ArrayList<String> fn_navigateToSpecificInbox(int iTestCaseRow) throws Exception
	{
		try
		{
		String url1=GenericClass.driver.getCurrentUrl();
		if(url1.contains("https://mail.google.com/"))
		{
			fn_navigateSupportMails();
			GenericClass.driver.navigate().refresh();
			Thread.sleep(3000);
			fn_navigateToConfirmationMail(AdminHome.hname,iTestCaseRow);
			ArrayList<String> arr=GetChargesFromMail();
			Assert.assertEquals(arr.equals(WebConfirmReservationPrintPage.al1), true);
			clk_backToBtn();
			fn_navigateToAccDetailMail(AdminHome.hname,iTestCaseRow);
			ArrayList<String> ar=GetAccDetail();
            						
		}
		
		else
		{
			Thread.sleep(3000);
			fn_SquirrelConfirmationMail(AdminHome.hname,iTestCaseRow);
			Thread.sleep(3000);
			//ArrayList<String> arr=GetBookingAmtDetail();
			//Assert.assertEquals(arr.equals(WebConfirmReservationPrintPage.al1), true);
			GenericClass.driver.navigate().back();
            fn_SquirrelAccDetailMail(AdminHome.hname,iTestCaseRow);
            ar=GetGuestLoginDetails();
		}
		return ar;
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
