package com.hms.hotelogix.automationframework.pages.GenericMethod;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Web.WebGuestConsole.WebGuestConsoleLoginPage;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.emailaccount.EmailAccountLoginPage;



public class GenericClass {

	public static Set<String> handles4;
	public static String Parent;
	public static String Child;
	public static int size;
	public static String scr_value="http://hotelogix.stayezee.com/images/off.GIF";
	public static int total_CB;

	public static String IndexText;

	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int RANDOM_STRING_LENGTH =5;
	private static final int RANDOM_SCHAR_LENGTH =3;
	private static final String SCHAR_LIST ="!@$%^&*()";


	public static WebDriver driver;
	

	private static final String NUM_LIST = "123456789";

	public static String GetSelectedValueFromDropdown(WebElement element){

        Select s=new Select(element);

        return s.getFirstSelectedOption().getText();

    }
	
	public  static String randomUniqueString()   {
        String uniqueString=null;
        try{
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = new Date();
         uniqueString = format.format(date);
  
        }catch(Exception e){
           
          e.printStackTrace();
        }
       
        return uniqueString;
        }
	public static String GenerateSpclChar(int length){
        int RANDOM_SCHAR_LENGTH = length;

       {
       StringBuffer randStr=new StringBuffer();
       for(int i=0;i<RANDOM_SCHAR_LENGTH;i++)
       {
           int num=getRandomNumber1();
           char ch=SCHAR_LIST.charAt(num);
           randStr.append(ch);
       }
       return randStr.toString();
       }}

	public static void selectElementByIndex(WebElement element, int index )
    {

        Select gender = new Select(element);
        gender.selectByIndex(index);
        //gender.selectByIndex(index);
    }

	
	public static String GenerateRandomNumber(int length){
	                 int RANDOM_STRING_LENGTH = length;

	                {
	                StringBuffer randStr=new StringBuffer();
	                for(int i=0;i<RANDOM_STRING_LENGTH;i++)
	                {
	                    int num=getRandomNumber1();
	                    char ch=NUM_LIST.charAt(num);
	                    randStr.append(ch);
	                }
	                return randStr.toString();
	                }}

	            private static int getRandomNumber1(){
	                int randomInt = 0;
	                Random randomGenerator = new Random();
	                randomInt = randomGenerator.nextInt(NUM_LIST.length());
	                if (randomInt - 1 == -1)
	                {
	                    return randomInt;
	                }
	                else
	                {
	                    return randomInt - 1;
	                }
	                }


	
	
	
	//public static String Currenthandle4;
public	static String value;

	public static void mouseOverElement( WebElement element) {

		Actions builder = new Actions(driver);

		builder.moveToElement(element).build().perform();

		}
	//

	public static String Alert_Accept()
    {
    	Alert alert = driver.switchTo().alert();
    	String str = alert.getText();
    	alert.accept();
    	return str;
    }

    public static String Alert_Dismiss()
    {

    	Alert alert = driver.switchTo().alert();
    	String str = alert.getText();
    	alert.dismiss();
    	return str;


    }

    public static String Alert_NoAction()
    {
    	Alert alert=driver.switchTo().alert();
    	String str=alert.getText();
    	alert.getText();
    	return str;
    }
    
    
    
    public static boolean   isAlertPresent()
    {
    	 
    	 try 
         { 
             driver.switchTo().alert(); 
             return true; 
         }   
         catch (NoAlertPresentException Ex) 
         { 
             return false; 
         }  
    	 
    }


	public static void alert_handle() throws InterruptedException
	{
	try{
		  Alert A1 = driver.switchTo().alert();
		  Reporter.log("Alert detected",true);

		  String Alert1 = A1.getText();
		  System.out.println("Pop_UpText :" + Alert1);



		  A1.accept();
		  Reporter.log("Alert accepted", true);}catch(Exception e){System.out.println(e);}

		  Thread.sleep(5000);

	}

	public static String getText(WebElement element) {
		return element.getText();
	 }



	public static String GetCurrentWindowID(){


	         String Currenthandle4 = driver.getWindowHandle();
//
	          System.out.println("parent window id:"+Currenthandle4);

	          return Currenthandle4;
	}

public  static void  windowHandle(String ParentID) throws InterruptedException
{


	//.........................................Window Handling..................................................................................//

//
//	         String Currenthandle4 = driver.getWindowHandle();
////
//	          System.out.println("parent window id:"+Currenthandle4);

	        //.....................................handle the child window.............................................................................//

	          Set<String> handles4= driver.getWindowHandles();


	           handles4.remove(ParentID);


	        //performing action on child window

	   driver.switchTo().window(handles4.iterator().next());

	         //   Thread.sleep(3000);
	  //          ABP.SaveBlockTitle("southwest");



	                                           Thread.sleep(2000);


	                                           //Switch back to original browser (first window)

	                                         //  driver.switchTo().window(Currenthandle4);

}

public static void Switch_Parent_Window(String ParentID){

	 driver.switchTo().window(ParentID);
	 System.out.println("Yoo Back to Parent Window...");
}




	public static void switchToWindowHandle( String title) {
		 try{
             Set<String> setHndlValColls=driver.getWindowHandles();
             //Thread.sleep(2000);
           Iterator<String>  itHandleColls= setHndlValColls.iterator();
           
           //Thread.sleep(2000);
           while(itHandleColls.hasNext()==true){
        	   //Thread.sleep(2000);
               String hndlval=itHandleColls.next();
               //Thread.sleep(1000);
               driver.switchTo().window(hndlval);
               //Thread.sleep(1000);
               String titl=driver.getTitle();
               //Thread.sleep(1000);
               if(titl.equalsIgnoreCase(title)){
            	   //Thread.sleep(1000);
                  break;
               }
               }
           }catch(Exception e){
               throw e;
           }

	}


	public static void switchToWindowHandleByURL( String url) {


		Set<String> handler = driver.getWindowHandles();
		for (String handlesname : handler) {


			driver.switchTo().window(handlesname);
			String var = driver.getCurrentUrl();
			if (var.contains(url))
			{
				break;
			} else {
				driver.switchTo().defaultContent();
			}
		}

	}

	public static AdminLogin fn_OpenAdmin(String BrowserType, String URL) throws Exception
	{
		fn_LaunchBrowser(BrowserType);
		driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.SECONDS);
		driver.get(URL);

		AdminLogin ALO = PageFactory.initElements(GenericClass.driver, AdminLogin.class);
		return ALO;
	}
//


	public static String sendKeys( WebElement element,String sValue) throws Exception {
        try{
            if(element.isDisplayed() && element.isEnabled()){
                element.clear();
                element.sendKeys(sValue);
                value=sValue;
            }
        }catch(NoSuchElementException e){
            Thread.sleep(3000);
            element.clear();
            element.sendKeys(sValue);
        }catch(Exception e){
            throw e;
        }
        return value;
    }

public static void input( WebElement element,String FieldName) {

//		try {
		//	logger.info("Waiting for an element to be clickable " + element);
			//highlightElementBorder(element);
//			WebDriverWait wait = new WebDriverWait(driver,
//					Integer.parseInt(getConfigValues("timeOutInSeconds")));
		//	ele = wait.until(ExpectedConditions.elementToBeClickable(element));
	//	   String sValue=ExcelUtil.TestCaseData.get(FieldName);
		//	element.sendKeys(sValue);
			//logger.info("Waited and send value to on element " + element);
//		} catch (Exception e) {
//			logger.info("Exception while supplying text to element"
//					+ e.getMessage());
//		}
	}

	public static String getURL()
	{
		String url=driver.getCurrentUrl();
		return url;
	}

	public static WebDriver fn_LaunchBrowser(String BrowserType) throws Exception {

		WebDriver Driver_Object = null;
		if (BrowserType.equalsIgnoreCase("FF")
				|| BrowserType.equalsIgnoreCase("Firefox")) {
			Driver_Object = new FirefoxDriver();
		} else if (BrowserType.equalsIgnoreCase("Safari")) {
			Driver_Object = new SafariDriver();
		} else if (BrowserType.equalsIgnoreCase("chrome")|| BrowserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",".\\Driverexe\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			LoggingPreferences loggingprefs = new LoggingPreferences();
		//	loggingprefs.enable(LogType.BROWSER, Level.ALL);
			capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
			capabilities.setCapability("chrome.binary", ".\\Driverexe\\chromedriver.exe");
			capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			Driver_Object = new ChromeDriver();
		} else if (BrowserType.equalsIgnoreCase("IE")|| BrowserType.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver",".\\Resources\\Drivers\\IEDriverServer.exe");
			InternetExplorerDriverService.Builder service = new InternetExplorerDriverService.Builder();
			service = service.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
			service = service.withLogFile(new File("d:\\logs\\selenium.log"));
			//	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			//	ieCapabilities.setCapability("requireWindowFocus", true);
			//.setCapability("ie.ensureCleanSession", true);
			//ieCapabilities.setCapability("nativeEvents", false);
			//			ieCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Internet Explorer");
			//			ieCapabilities.setCapability(CapabilityType.VERSION, "8");
			//		ieCapabilities.setCapability("ie.forceCreateProcessApi", true);
			//			ieCapabilities.setCapability("ie.browserCommandLineSwitches","-private");

			// ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			// true);
			Driver_Object = new InternetExplorerDriver();
			// Driver_Object = new InternetExplorerDriver();
		}
//		else if (BrowserType.equalsIgnoreCase("remote")) {
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setBrowserName("chrome");
//			Driver_Object = new RemoteWebDriver(new  (
//					"http://localhost:4446/wd/hub"), cap);
//		}
		// DO NOT DELETE IT
		/*
		 * else if(BrowserType.equalsIgnoreCase("bmp")){ ProjectSnappyProxy
		 * objProjectSnappyProxy = ProjectSnappyProxy.getInstance();
		 * System.setProperty("webdriver.chrome.driver",
		 * ".\\Resources\\chromedriver.exe"); Driver_Object=new
		 * ChromeDriver(objProjectSnappyProxy.getProxyDesiredCapabilties(4567));
		 *
		 * }
		 */
//		else {
//
//			logger.info("Provided Browser Type is invalid, please check");
//		}
		Driver_Object.manage().window().maximize();
		Driver_Object.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		driver=Driver_Object;
		return Driver_Object;
	}


	public static WebElement clickElement( WebElement element) throws Exception
	{
	element.click();
	return element;
	}


	public static void js_Click(WebElement element){

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}



public static boolean isEnable(String text ,WebElement element){



        boolean result =element.isEnabled();

        //System.out.println(result);

        if(result == true){

        System.out.println(text + "Element is Enable");

        }

        else{

            System.out.println(text + "Element is Disabled");

        }

        return result;

    }





	public static boolean checkElementDisplay(String str, WebElement element) throws Exception
	{
		boolean status = element.isDisplayed();
	if(status==true){
		System.out.println(str + "  Element is displaying");

	}else{
		System.out.println(str + "  Element not displayed");
	}


	Assert.assertTrue(status, "Validating Elements visibility");
	return status;

	}


	public static void selectElement(WebElement element, String a )
    {

        Select sel = new Select(element);
        sel.selectByVisibleText(a);
    }


	public static String selectElementByvalue(WebElement element,String b)
	{
		Select sel=new Select(element);
		sel.selectByValue(b);
		String txt=sel.getFirstSelectedOption().getText();
		return txt;
	}


	public static String jvmBitVersion(){
		 return System.getProperty("sun.arch.data.model");
		}

//		public static void autoit(String fileToUpload, String DialogTitle) throws InterruptedException {
//			String jacobDllVersionToUse;
//			if (jvmBitVersion().contains("32")){
//			jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
//			}
//			else {
//			jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
//			}
		//      File file = new File("Lib", jacobDllVersionToUse);
////			System.out.println(LibraryLoader.JACOB_DLL_PATH+"|||||||||"+file.getAbsolutePath());
////			System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
////			Runtime.getRuntime().loadLibrary(LibraryLoader.JACOB_DLL_PATH);
////			Runtime.getRuntime().loadLibrary(file.getAbsolutePath());
////			AutoItX x = new AutoItX();
////			x.winActivate(DialogTitle);
////			x.winWaitActive(DialogTitle);
////			x.ControlSetText(DialogTitle, "", "Edit1",fileToUpload) ;
////			Thread.sleep(1000);
////			x.controlClick(DialogTitle, "", "Button1") ;
////			Thread.sleep(1000);
//	}
	public static int CheckBox_Count(List<WebElement> element)
    {

         List<WebElement> checkBoxes = element;
                 //driver.findElements(By.xpath("//input[@type='Checkbox']"));
         for(int i=0; i<checkBoxes.size(); i++){
             checkBoxes.get(i).click();

         }


         /*for(WebElement checkbox:checkBoxes){
        	 checkbox.click();


         }
         */



         int checkedCount=1;
        		 int uncheckedCount=0;
         for(int i=1 ; i<checkBoxes.size(); i++){
         //    System.out.println(i+" checkbox is selected "+checkBoxes.get(i).isSelected());
             if(checkBoxes.get(i).isSelected()){
                 checkedCount++;
             }else{
                 uncheckedCount++;
             }
         }
      //----leave-   uncheckedCount=uncheckedCount;
         checkedCount=checkedCount;

      //   System.out.println(checkedCount);
     //    System.out.println(uncheckedCount);




         return checkedCount;  //change type f method to int
    }



	public static int tr_count(List<WebElement> columnelements)
	{


	int Total_tr=columnelements.size();

	System.out.println(Total_tr);
	return Total_tr;
	}


	  public static String generateRandomString(){

	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }

	    private static int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }

	    /** This method performs descending sorting behalf of the name.
	     *
	     * @param drpdwn_View : Here element is an View dropdown element.
	     * @param viewDD_Value : Here a is value which needs to be select from the dropdown.
	     * @param arrow_Downward : Its downward arrow link .
	     * @param columnelements : checkbox xpath for list<WebElement>
	     * @param xpath_NameColumn : Here xpath is Entity name column .
	     * @throws Exception
	     */
public static void sortingName_Downward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_Downward,List<WebElement> columnelements,String xpath_NameColumn) throws Exception
{
  selectElement(drpdwn_View, viewDD_Value);


//GenericClass.clickElement(room_down);
List<String> sortedNames = new ArrayList<String>();
List<String> UnsortedNames = new ArrayList<String>();

//int size=GenericClass.row_count(columnelements);
//int size1=size-2;
int size_value=tr_count(columnelements);
System.out.println(size_value);
List<WebElement> rowelement=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
String getData;
for(int i=0;i<size_value;i++)
{

   getData=rowelement.get(i).getText();
   UnsortedNames.add(getData);
}
System.out.println(UnsortedNames);
List<String> sortingOperation = UnsortedNames;
//Collections.sort(sortingOperation);
Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
//Iterator itr = sortingOperation.iterator();
//  while(itr.hasNext()){
//    System.out.println(itr.next());
//   }
System.out.println(sortingOperation);
clickElement(arrow_Downward);
List<WebElement> element1=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
String getsorted;
for(int j=0;j<size_value;j++)
{
getsorted=element1.get(j).getText();
sortedNames.add(getsorted);
}
System.out.println(sortedNames);
boolean result=sortingOperation.equals(sortedNames);
if(result==true)
{
System.out.println("Ascending Sorting function passed");
}
else
{
System.out.println("Ascending Sorting function failed");
}
}


/** This method performs descending sorting behalf of the name.
 *
 * @param drpdwn_View : Here element is an View dropdown element.
 * @param viewDD_Value : Here a is value which needs to be select from the dropdown.
 * @param arrow_upward : Its Upward arrow link .
 * @param columnelements : checkbox xpath for list<WebElement>
 * @param xpath_NameColumn : Here xpath is Entity name column .
 * @throws Exception
 */
public static void sortingName_Upward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_upward,List<WebElement> columnelements,String xpath_NameColumn) throws Exception
{
  selectElement(drpdwn_View,viewDD_Value);
//GenericClass.clickElement(room_down);
List<String> sortednames = new ArrayList<String>();
List<String> Unsortednames = new ArrayList<String>();
int size_result=GenericClass.tr_count(columnelements);
//int size1=size-2;
System.out.println(size_result);
List<WebElement> rowelement=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
String getData;
for(int i=0;i<size_result;i++)
{

   getData=rowelement.get(i).getText();
   Unsortednames.add(getData);
}

System.out.println(Unsortednames);
List<String> sortingOperation = Unsortednames;
Comparator mycomparator = Collections.reverseOrder();

//System.out.println(sortingOperation);
Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
Collections.sort(sortingOperation,mycomparator);
Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
Collections.reverse(sortingOperation);
System.out.println(sortingOperation);
GenericClass.clickElement(arrow_upward);
List<WebElement> element2=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
String getsorted;
for(int j=0;j<size_result;j++)
{
getsorted=element2.get(j).getText();
sortednames.add(getsorted);
}
System.out.println(sortednames);
boolean result=sortingOperation.equals(sortednames);
if(result==true)
{
System.out.println("Descending Sorting function passed");
}
else
{
System.out.println("Descending Sorting function failed");
}
}


/**
 *
 * @param drpdwn_View : Here element is view drop down.
 * @param viewDD_Value : Here a is drop down value to be select.
 * @param img_Active : Here b is image icon for Active
 * @param arrow_Downward : Here click is downward sort arrow
 * @param columnelements
 * @param xpath_NameColumn : Here xpath is Entity name column
 * @param xpath1_StatusColumn : Here xpath1 is Entity Status column
 * @throws Exception
 */
public static void sortstatus_Downward(WebElement drpdwn_View,String viewDD_Value,WebElement img_Active,WebElement arrow_Downward,List<WebElement> columnelements,String xpath_NameColumn,String xpath1_StatusColumn) throws Exception
{
	try
	{
selectElement(drpdwn_View, viewDD_Value);
clickElement(img_Active);
clickElement(arrow_Downward);
int count=GenericClass.tr_count(columnelements);
System.out.println(count);
//int count1=count-1;
List<WebElement> data_text=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
List<WebElement> src1=GenericClass.driver.findElements(By.xpath(xpath1_StatusColumn));
for(int i=0;i<count;i++)
{
String data=data_text.get(i).getText();
String value=src1.get(i).getAttribute("src");
if(value.equals(scr_value))
{
	Assert.assertEquals(value.equals(scr_value), true);
System.out.println("de-active room is present at the end when downward arrow is clicked,"+i+","+data+".");

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


/**
*
* @param drpdwn_View : Here element is view drop down.
* @param viewDD_Value : Here a is drop down value to be select
* @param arrow_Upward : Here click is upward sort arrow
* @param columnelements
* @param xpath_NameColumn: Here xpath is Entity name column
* @param xpath1_StatusColumn : Here xpath1 is Entity Status column
* @throws Exception
*/

public static void sortstatus_Upward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_Upward,List<WebElement> columnelement,String xpath_NameColumn,String xpath1_StatusColumn) throws Exception
{
	try
	{
 selectElement(drpdwn_View, viewDD_Value);
 GenericClass.clickElement(arrow_Upward);
int count=GenericClass.tr_count(columnelement);
//int count1=count-1;
System.out.println(count);
List<WebElement> data_text=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
List<WebElement> src1=GenericClass.driver.findElements(By.xpath(xpath1_StatusColumn));
for(int i=0;i<count;i++)
{
String data=data_text.get(i).getText();
String value=src1.get(i).getAttribute("src");
if(value.contains(scr_value))
{
	
	Assert.assertEquals(value.equals(scr_value), true);
System.out.println("de-active room is present at the top when upward arrow is clicked,"+i+","+data+".");

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



public static String ActionOnAlert(String Action){
    try{

         WebDriverWait wait = new WebDriverWait(driver, 2);
         Alert alert = wait.until(ExpectedConditions.alertIsPresent());

         value=alert.getText();
        // System.out.println(value);
       //  GenericClass.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
         if(Action.equalsIgnoreCase("Accept")){
         alert.accept();
         System.out.println("Accepted the alert successfully.");
         }
         else if(Action.equalsIgnoreCase("Dismiss")){
         alert.dismiss();
         System.out.println("Alert is successfully Dismissed.");
         }
         else if(Action.equalsIgnoreCase("")){
             System.out.println("No Action performed");
             GenericClass.driver.close();
         }
      }catch(Throwable e){
         System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
      }

    return value;
    }




public static void uploadImage(String imagelocation){
    try{
        //Setting clipboard with image location
  	  setClipboardData(imagelocation);
      //Some sleep time to detect the window popup
        Thread.sleep(500);
        //native key strokes for CTRL, V and ENTER keys
        Robot robot =  new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
      //To Click on the "Open" button to upload files
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);


        robot=null;
    } catch (Exception exp) {
        exp.printStackTrace();
    }
}


    public static void setClipboardData(String string) {
		//Copying the path of the file to the clipboard
	      //StringSelection class used for copy and paste operations.
	      StringSelection stringselect = new StringSelection(string);//Putting the path of the image to upload
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
		}

    public static void fn_isSelected(WebElement we){
   	 boolean booleobj=we.isSelected();
        if(booleobj==true){
        	System.out.println("It is Checked");
        }else{
        	System.out.println("It is Unchcked");
        }
   }

    public static WebDriver fn_switchiframe(WebElement frameval){
    	//driver.switchTo().frame("xd_frame");
    			driver.switchTo().frame(frameval);
    			//WebElement frm_WE=driver.findElement(By.xpath("//div[@id='login-form']/iframe"));
    			//driver.switchTo().frame(frm_WE);
    			//driver.findElement(By.id("Username")).sendKeys("a@b.com");


    		//	driver.switchTo().defaultContent();

    			return driver;
    }
    public static void  fn_Clear(WebElement we){
        we.clear();

    }
    public static WebDriver fn_defaultcontentofiframe(){
    	driver.switchTo().defaultContent();
    	return driver;
    }

    public static String Copy(WebElement element1)
    {
          String text = element1.getText();
        System.out.println(text);
         return text;
    }

    public static void Paste(WebElement element2, String b)
    {

        element2.getText();

         element2.sendKeys(b);
        WebElement a = element2;

        System.out.println(a);
    }
    public static boolean isInable(WebElement element, String text){

		  boolean result =element.isEnabled();
		  //System.out.println(result);
		  if(result == true){
		  System.out.println(text + "Element is Inable");
		  }
		  else{
			  System.out.println(text + "Element is Disabled");
		  }
		  return result;
	  }



    public static String SelectByIndex(WebElement ele,int ind){
		Select sel=new Select(ele);
		sel.selectByIndex(ind);
	IndexText=sel.getFirstSelectedOption().getText() ;
	return IndexText;

	}


public static FrontdeskLandingPage fn_OpenFrontdesk(String BrowserType, String URL) throws Exception{

		fn_LaunchBrowser(BrowserType);
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.get(URL);


		FrontdeskLandingPage FL=PageFactory.initElements(GenericClass.driver,FrontdeskLandingPage.class );
		return FL;

	}


public static void js_Sendkey(WebElement element, String id){
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].value='"+id+"';", element);
}

public static void fn_SwitchToWindow_Title( String titleVal){
    Set<String> setHndlValColls=driver.getWindowHandles();
    Iterator<String>  itHandleColls= setHndlValColls.iterator();
    while(itHandleColls.hasNext()==true){
        String hndlval=itHandleColls.next();
        System.out.println(hndlval);

        driver.switchTo().window(hndlval);

        String title=driver.getTitle();
        if(title.contains(titleVal)){
           break;
        }
    }
}




public static void getscreenshot(String name) throws Exception
{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
      
      
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Snapshot\\"+name+"."+"jpg"));
}




public static  EmailAccountLoginPage fn_OpenSpecificEmailBox(String BrowserType, String URL) throws Exception{
	try
	{
		String currentURL=driver.getCurrentUrl();
		
		if(currentURL.contains("livestable.hx.local"))
		{
				
	       fn_LaunchBrowser(BrowserType);
	       driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
           driver.get(URL);
	    }
		else if(currentURL.contains("stayezee.com"))
		{
			fn_LaunchBrowser(BrowserType);
		    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	        driver.get(URL);
		}
		
		else if(currentURL.contains("staygrid.com"))
		{
			fn_LaunchBrowser(BrowserType);
		    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	        driver.get(URL);
		}
		
	}
	catch(Exception e)
	{
		throw e;
	}

	EmailAccountLoginPage  EALP=PageFactory.initElements(GenericClass.driver, EmailAccountLoginPage.class);
    return EALP;
}

public static WebGuestConsoleLoginPage fn_OpenWebGuestConsolePage(String BrowserType, String URL) throws Exception{
	fn_LaunchBrowser(BrowserType);
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
    driver.get(URL);
    WebGuestConsoleLoginPage WCLP=PageFactory.initElements(GenericClass.driver,WebGuestConsoleLoginPage.class);
    return WCLP;
}



public static List<WebElement> GetAllOptionFromDropdown(WebElement ele){

	Select s=new Select(ele);


	return s.getOptions();

}


public static void fn_ActionsClick(WebElement we) throws Exception{
	try{
		webdriverWait(we);
		Actions actobj=new Actions(driver);
		actobj.click(we).build().perform();
	}catch(NoSuchElementException e){
		Thread.sleep(2000);
		Actions actobj=new Actions(driver);
		actobj.click(we).build().perform();
	}catch(Exception e){
		throw e;
	}
    }


private static void webdriverWait(WebElement element) {
    try{
	  new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
    }catch(Exception e){
  	  throw e;
    }
	}

	

public static List<WebElement> GetAllTheValueFromDropDown(WebElement ele){
	Select s=new Select(ele);

		List<WebElement> ele1=s.getOptions();

		System.out.println(ele1.size());
		return ele1;
}



}




