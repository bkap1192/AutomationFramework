package com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.AddBlockPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Blocks.BlocksLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.AddFloorPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Floors.FloorsLandingPage;

public class AddRoomsPage {

	@FindBy(xpath="//td[@class='padingtd']/table/tbody/tr/th")
	public  WebElement Enterddetail_Txt;
	
	@FindBy(xpath="//td[text()='Add/Edit a Room']")
	public  WebElement Page_Header;
	
	@FindBy(xpath="//input[@name='rmNameOrNoMulName[]']")
	public  WebElement txtbox_RoomNameNumber;

	@FindBy(xpath="//select[@id='rmTypeId']")
	public  WebElement drpdown_RoomType;
	
	@FindBy(xpath="//input[@class='disablethis button']")
	public  WebElement Btn_SaveAtBtm;
	
	@FindBy(xpath="//input[@class='button' and @type='submit']")
	public  WebElement btn_SaveDuplicateRoomAtBtm;
	
	@FindBy(xpath="//a[text()='Rooms List']")
	public  WebElement link_RoomList;
	
	@FindBy(xpath="//input[@id='rmNameOrNoMulName_0']")
	public  WebElement roomNameNumber;
    
    @FindBy(xpath="//input[@name='btnSave2']")
	public  WebElement save;
    
    @FindBy(xpath="//td[text()='Add/Edit a Room']")
	public  WebElement txt_pageHeader;
    
    @FindBy(xpath="//select[@id='floorId']")
	public  WebElement drpdown_Floor;

	@FindBy(xpath="//select[@id='blockId']")
	public  WebElement drpdown_Block;

	@FindBy(xpath="//textarea[@name='description']")
	public  WebElement txtbox_Description;
	
	@FindBy(xpath="//input[@class='disablethis']")
	public  WebElement btn_SaveAtTop;

	@FindBy(xpath="//div[@id='listing-icons']/ul/li[2]/input")
	public  WebElement btn_SaveAndDuplicateRoomAtTop;

	@FindBy(xpath="//div[@id='listing-icons']/ul/li[1]/input")
	public  WebElement btn_CancelAtTop;

	@FindBy(xpath="//a[text()='Main']")
	public  WebElement link_Main;
	
	@FindBy(xpath="//input[@class='disablethis button']")
	public  WebElement btn_SaveAtBtm;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public  WebElement btn_CancelAtBtm;

	@FindBy(xpath="//a[text()='AuditTrail']")
	public  WebElement link_AuditTrail;
	
	@FindBy(xpath="//td[@class='padingtd']//tr[2]//td[2]")
	public  WebElement errorMsg;
	
	@FindBy(xpath="//td[@class='padingtd']/table/tbody/tr[3]/td[2]")
	public  WebElement Validation_Msg;
	
	public String roomNumber;
	public String rtype;
	public String rtype1;
	public static String floor;
	public static String block;
	
	ArrayList<String> al=new ArrayList<>();
	
	
	public String fn_addRoomName(int rtypeIndex) throws Exception{
        try{
            roomNumber=GenericClass.randomUniqueString();
            GenericClass.sendKeys(txtbox_RoomNameNumber, roomNumber);
            GenericClass.selectElementByIndex(drpdown_RoomType, rtypeIndex);
            rtype=GenericClass.GetSelectedValueFromDropdown(drpdown_RoomType);
            System.out.println("Added room in Room Type :" + drpdown_RoomType);
            GenericClass.clickElement(Btn_SaveAtBtm);
        }
        catch(Exception e){
            throw e;
        }
    /*    RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
        return RLP;*/
       
        return rtype;
        }

	  public String saveAndDuplicate(int rtypeIndex) throws Exception
	    {
	        //..Method adds 2 room names on clicking Save and Duplicate
	        //..Navigates to RoomsLandingPage on saving
	        try
	        {
	        //..Generates random 1st room name and stores it in variable a
	        	roomNumber=GenericClass.randomUniqueString();
	        //System.out.println(a);
	        GenericClass.sendKeys(txtbox_RoomNameNumber,roomNumber);
	        //GenericMethods.selectElement(roomType, "HMS");
	        GenericClass.selectElementByIndex(drpdown_RoomType, rtypeIndex);
	        rtype=GenericClass.GetSelectedValueFromDropdown(drpdown_RoomType);
	    GenericClass.clickElement(btn_SaveDuplicateRoomAtBtm);
	        //..Generates random 2nd room name and stores it in variable b
	    rtype1=GenericClass.randomUniqueString();
	        System.out.println(rtype1);
	        GenericClass.sendKeys(txtbox_RoomNameNumber,rtype1);
	        GenericClass.clickElement(Btn_SaveAtBtm);
	        //..Initializing RoomsLandingPage
	        /*RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
	        return RLP;*/
	        return rtype;
	        }
	        catch(Exception e)
	        {
	       
	            throw e;
	        }
	    }

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
	  			Assert.assertTrue(str.equals(rtName));
	  			System.out.println("Added room type is being displayed on 'Add Room' page.");
	  			break;
	  		}
	  	}
	      }
	      catch(Exception e)
	      {
	      	throw e;
	      }
	      catch(AssertionError e)
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
	  
	  public RoomsLandingPage RT_addRoom(int iTestCaseRow) throws Exception
		{try{
		    	//ExcelUtil.setCellData(GenericClass.generateRandomString(), iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_RoomNamesNumbers), Workbook);
		    	GenericClass.sendKeys(roomNameNumber, "RM"+GenericClass.GenerateRandomNumber(2));

		    	GenericClass.clickElement(save);

		    	RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
		    	return RLP;
		}catch(Exception e){
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
	  
	  public String verify_pageHeader() throws Exception
		{try{
			String str=GenericClass.getText(txt_pageHeader);
	        return str;
		}catch(Exception e){
			throw e;
		}
		}

	  public String verify_RoomTypeNameFilter()
	  {try{
	  	  Select sel=new Select(drpdown_RoomType);
	  	  String text=sel.getFirstSelectedOption().getText();
	        return text;
	  }catch(Exception e){
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
	  			Assert.assertEquals(str, rtName);
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
	  
	  
	  public void fn_verifyActivatedRoomType(String rtName) throws Exception
	  {

	  	try
	  	{
	  	Select sel=new Select(drpdown_RoomType);
	  	int size=sel.getOptions().size();
	  	for(int i=0;i<size;i++)
	  	{
	  		String str=sel.getOptions().get(i).getText();
	  		if(str.equals(rtName))
	  		{
	  		Assert.assertEquals(str, rtName);
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

	  
	  public RoomsLandingPage fn_AddRoom(String roomnumberandname,String discription) throws Exception{
			GenericClass.sendKeys(txtbox_RoomNameNumber, roomnumberandname);
			GenericClass.SelectByIndex(drpdown_RoomType, 1);
			GenericClass.SelectByIndex(drpdown_Block, 1);
			GenericClass.sendKeys(txtbox_Description, discription);
			GenericClass.clickElement(save);
		    RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
		   return RLP;
		}

	  
	  /**
		 * This method verifies all the page elements on the page.
		 * @throws Exception
		 */
		public void VerifyPageElements() throws Exception{
			GenericClass.checkElementDisplay("Page_Header is visible",Page_Header);
			GenericClass.checkElementDisplay("SaveAtTop_Btn is visible", btn_SaveAtTop);
			GenericClass.checkElementDisplay("SaveAndDuplicateRoomAtTop_Btn is visible",btn_SaveAndDuplicateRoomAtTop );
			GenericClass.checkElementDisplay("CancelAtTop_Btn is visible",btn_CancelAtTop );
			GenericClass.checkElementDisplay("Main_Link is visible",link_Main );
			GenericClass.checkElementDisplay("RoomList_Link is visible",link_RoomList);
			GenericClass.checkElementDisplay("SaveAtBtm_Btn is visible",btn_SaveAtBtm );
			GenericClass.checkElementDisplay("SaveDuplicateRoomAtBtm_Btn is visible",btn_SaveDuplicateRoomAtBtm );
			GenericClass.checkElementDisplay("CancelAtBtm_Btn is visible",btn_CancelAtBtm );
			GenericClass.checkElementDisplay("AuditTrail_Link is visible",link_AuditTrail );
			GenericClass.checkElementDisplay("RoomNameNumber_TB is visible",txtbox_RoomNameNumber );
			GenericClass.checkElementDisplay("RoomType_DD is visible",drpdown_RoomType );
			GenericClass.checkElementDisplay("Floor_DD is visible",drpdown_Floor );
			GenericClass.checkElementDisplay("Block_DDis visible",drpdown_Block);
			GenericClass.checkElementDisplay("Description_TB is visible",txtbox_Description);
		}

		
		
		/**
		 * This method Adding room .
		 * @param iTestCaseRow : Is used for test data.
		 * @param ele : As page having multiple save buttons . ele specifies using which button.
		 * @return
		 * @throws Exception
		 */
		public RoomsLandingPage AddingRoom(String room,WebElement ele) throws Exception{
			try{
			GenericClass.sendKeys(txtbox_RoomNameNumber, room);
			rtype=GenericClass.SelectByIndex(drpdown_RoomType, 1);
			floor=GenericClass.SelectByIndex(drpdown_Floor, 1);
			block=GenericClass.SelectByIndex(drpdown_Block, 1);
			GenericClass.sendKeys(txtbox_Description, GenericClass.generateRandomString());
			GenericClass.clickElement(ele);
			}catch(Exception e){
				throw e;
			}
		    RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
		return RLP;
		}
		
		/**
		 * This method is for getting multiple error message from the page.
		 * @return : multiple error message return as an arraylist.
		 */
		public ArrayList<String> GetValidationMsg(){
		ArrayList<String> al=new ArrayList<String>();
		String s=GenericClass.getText(errorMsg);
		System.out.println(s);
		String a[]=s.split("\n");
		System.out.println(a[0].toString());
		System.out.println(a[1].toString());
		System.out.println(a[2].toString());
		al.add(a[0].toString());
		al.add(a[1].toString());
		al.add(a[2].toString());
		return al;
		}
		
		/**
		 * This method Adding duplicate rooms.
		 * @param iTestCaseRow : Is used for test data.
		 * @param ele
		 * @throws Exception
		 */
		public void AddingDuplicateRoom(String room,WebElement ele) throws Exception{
			GenericClass.sendKeys(txtbox_RoomNameNumber, room);
			GenericClass.sendKeys(txtbox_Description, GenericClass.generateRandomString());
			GenericClass.clickElement(ele);
		}


		/**
		 * This method is also for getting error message from the page.
		 * @return : Returns eroor message in arraylist.
		 */
		public ArrayList<String>  GetValidationMsgg(){
			ArrayList<String> al=new ArrayList<String>();
			String s=GenericClass.getText(errorMsg);
			String a[]=s.split("\n");
			System.out.println(a[0].toString());
			System.out.println(a[1].toString());
			al.add(a[0].toString());
			al.add(a[1].toString());
			return al;

		}
		
		
		/**
		 * This method for Entering room name only.
		 * @param ele : Here ele is  for save button .
		 * @throws Exception
		 */
		public void AddingRoomsByEnteringRoomNameOnly(String room,WebElement ele) throws Exception{
			try{
			GenericClass.sendKeys(txtbox_RoomNameNumber, room);
		   GenericClass.clickElement(ele);
			}catch(Exception e){
				throw e;
			}
		}


		/**
		 * This method for adding room by selecting room type only.
		 * @param ele : Here ele is for save button.
		 * @throws Exception
		 */
		public void AddingRoomBySelectingRoomrTypeOnly(WebElement ele) throws Exception{
			GenericClass.SelectByIndex(drpdown_RoomType, 1);
			GenericClass.clickElement(ele);
		}
		
		
		/**
		 * This method is for creating validation format when room added using Save and duplicate room button.
		 * @param s :  Here s is room name as an string format.
		 * @return : As it returns the specified format for room added successfully.
		 */
		public String GetValidationMsgFormat(String s){
			String fst="- Room Name / Number ";
			String scnd="\""+ s+"\" ";
			String thrd="saved successfully. Do you wish to add another room?";
			String res= fst+scnd+thrd;
			return res;
		}
		
		
		public void fn_VerifyFloorAndBlocks() throws Exception{
			try{
				Select sobj=new Select(drpdown_Floor);
				List<WebElement> coll=sobj.getOptions();
				if(coll.size()<=1==true){
					AdminHome admin=PageFactory.initElements(GenericClass.driver, AdminHome.class);
					FloorsLandingPage floor=admin.fn_NavigateToFloors();
					AddFloorPage afp=floor.ClickOnAddFloorLink();
					GenericClass.switchToWindowHandle("Add Floor");
					String str=GenericClass.generateRandomString();
					afp.fn_AddFloor(str, afp.Save_Btn);
					GenericClass.switchToWindowHandle("Floors List");
				}
				RoomsLandingPage rl=new AdminHome().fn_NavigateRooms();
			    rl.ClickOnAddRoomLink();	
				Thread.sleep(2000);
				Select sob=new Select(drpdown_Block);
				List<WebElement> col=sob.getOptions();
				int se=col.size();
				if(col.size()<=1==true){
					AdminHome admin=PageFactory.initElements(GenericClass.driver, AdminHome.class);
					BlocksLandingPage blp=admin.fn_NavigateBlocks();
				    AddBlockPage ABP=blp.AddBlock_click();
				    GenericClass.switchToWindowHandle("Add Block");
				    ABP.SaveBlockTitle();
				    GenericClass.switchToWindowHandle("Add Block");
				    RoomsLandingPage RLP=admin.fn_NavigateRooms();
				    RLP.ClickOnAddRoomLink();		}
			}catch(Exception e){
				throw e;
			}
		    }
		
		
		/**
		 * This method for adding room by room name .
		 * @param s : Here s is room name.
		 * @param ele : Here ele is Save And Duplicate Button.
		 * @throws Exception
		 */
		public void AddRoomBySaveAndDuplicateButton(String s,WebElement ele) throws Exception{
			GenericClass.sendKeys(txtbox_RoomNameNumber, s);
			rtype=GenericClass.SelectByIndex(drpdown_RoomType, 1);
			floor=GenericClass.SelectByIndex(drpdown_Floor, 1);
			block=GenericClass.SelectByIndex(drpdown_Block, 1);
			GenericClass.sendKeys(txtbox_Description, s + "type");
			GenericClass.clickElement(ele);

		}
		
		
		/**
		 * This method for adding room .
		 * @param s : Here s is room name in string format.
		 * @param ele : Here ele is for save button
		 * @return : As it returns Rooms Landing page and initialize all its element.
		 * @throws Exception
		 */
		public RoomsLandingPage Add_Room(String s,WebElement ele) throws Exception{

			GenericClass.sendKeys(txtbox_RoomNameNumber, s);
			GenericClass.clickElement(ele);

			RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
			return RLP;
		}
		
		/**
		 * This method for Clicking on cancel button after filling all room details.
		 * @param iTestCaseRow : As using this we getting test data.
		 * @param ele : Here ele for save button.
		 * @return : As it returns Rooms Landing Page. And initialize all its element.
		 * @throws Exception
		 */
		public RoomsLandingPage ClickOnCancel_AfterFilling_RoomDetail(String room,WebElement ele) throws Exception{
			GenericClass.sendKeys(txtbox_RoomNameNumber, room);
			GenericClass.SelectByIndex(drpdown_RoomType, 1);
		    GenericClass.sendKeys(txtbox_Description, GenericClass.generateRandomString());
			GenericClass.clickElement(ele);
		RoomsLandingPage RLP=PageFactory.initElements(GenericClass.driver, RoomsLandingPage.class);
		return RLP;
		}

		
		/**
		 * This method clicks on Main link on Add Room page.
		 * @return : As it returns Admin Home Page and initialize all its element.
		 * @throws Exception
		 */
		public AdminHome ClickOnMainLink() throws Exception{
			GenericClass.clickElement(link_Main);
		AdminHome AH=PageFactory.initElements(GenericClass.driver, AdminHome.class);
		return AH;

		}
		
		/**
		 * This method clicks on Audit Trail link.
		 * @return : As it returns AuditTrail page and initialize all its element.
		 * @throws Exception
		 */
		public AuditTrailPage ClickOnAuditTrailPage() throws Exception{
		GenericClass.clickElement(link_AuditTrail);

		AuditTrailPage ATP=PageFactory.initElements(GenericClass.driver, AuditTrailPage.class);
		return ATP;


		}

		
}
