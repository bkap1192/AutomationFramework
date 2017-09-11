package com.hms.hotelogix.automationframework.tests.admin.General.DepartmentTest;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtilHM;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.General.Departments.AddAuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.General.Departments.AddaDepartmentPage;
import com.hms.hotelogix.automationframework.pages.admin.General.Departments.DLAuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.General.Departments.DepartmentsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.General.Departments.EditDepartmentPage;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.PosManager.POSPoints.EditPOSProductPage;
import com.hms.hotelogix.automationframework.pages.admin.PosManager.POSPoints.POSPointsLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.PhoneExtensions.PhoneExtensionsListPage;
import com.hms.hotelogix.automationframework.pages.admin.UserManager.Users.AddNewUserPage;

import com.hms.hotelogix.automationframework.pages.admin.UserManager.Users.UsersLandingPage;

@SuppressWarnings("static-access")
public class DepartmentTest {
	
	
	 private HashMap<String, String> TDMap;
	 public final String Departmnet_Sheet = "Sheet1";
	
	
	
	
	@BeforeMethod
	public void Login() throws Throwable {
		AdminLogin  AL=GenericClass.fn_OpenAdmin("FF", "http://hotelogix.net/admine/login/login/");
		//AdminLogin AL = GenericClass.fn_OpenAdmin("FF", "http://livestable.hx.local/admine/login/login/");
		  AdminHome AH=AL.adminlogin("12904","akash.khanna610@gmail.com","168c507d");
	   //	AL.adminlogin_12302();
       //	GenericClass.driver.manage().timeouts().pageLoadTimeout(time, unit)
	  }

	@Test(groups={"P0","Department"}, description="New department created successfully, It's verified in POSPoint, PhoneExtension and AddaUser Page.")
	public void TC_8310_1905_8875_8880_8881_8882_1906() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Department_Title"));
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("AddaDepartment_Title"));
			String title=GenericClass.generateRandomString();
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_BT,title, GenericClass.generateRandomString(), "Test");
			ArrayList<String> collect=DLP.fn_VerifyCreatedDepartment(title);
			Assert.assertEquals(collect.contains(title),true);
			POSPointsLandingPage PPLP=AH.fn_NavigateToPosPoint();
			EditPOSProductPage EPP=PPLP.fn_ClickOnEditLink();
			ArrayList<String> collec=EPP.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(collec.contains(title),true);
			PhoneExtensionsListPage PEL = AH.fn_NavigateToPhoneExtPage();
			ArrayList<String> PEDD=PEL.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(PEDD.contains(title),true);
			UsersLandingPage USL=AH.fn_NavigateUsers();
			AddNewUserPage ANU=USL.fn_ClickAddNewUserLink();
			ArrayList<String> ADU=ANU.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(ADU.contains(title),true);
			Reporter.log("New department created successfully, It's verified in POSPoint, PhoneExtension and AddaUser Page.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=1,groups={"P0","Department"}, description="To verified Add a Department with valid data, Verified reflected points.")
	public void TC_8992() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Department_Title"));
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("AddaDepartment_Title"));
			String title=GenericClass.generateRandomString();
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG,title, GenericClass.generateRandomString(), "Test");
			ArrayList<String> collect=DLP.fn_VerifyCreatedDepartment(title);
			Assert.assertEquals(collect.contains(title),true);
			POSPointsLandingPage PPLP=AH.fn_NavigateToPosPoint();
			EditPOSProductPage EPP=PPLP.fn_ClickOnEditLink();
			ArrayList<String> collec=EPP.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(collec.contains(title),true);
			PhoneExtensionsListPage PEL =AH.fn_NavigateToPhoneExtPage();
			ArrayList<String> PEDD=PEL.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(PEDD.contains(title),true);
			UsersLandingPage USL=AH.fn_NavigateUsers();
			AddNewUserPage ANU=USL.fn_ClickAddNewUserLink();
			ArrayList<String> ADU=ANU.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(ADU.contains(title),true);
			Reporter.log("To verified Add a Department with valid data");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	@Test(priority=2,groups={"P1","Department"}, description="To verify Add Department with duplicate title and short name.")
	public void TC_1907_1908_1930() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			EditDepartmentPage EUP=DLP.fn_ClickEditDepartment();
			EUP.fn_GetExistingDepartmentName();
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG,EUP.Deptname, EUP.Shortname, "Test");
			String errormsg=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg, TDMap.get("Error_MSG"));
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG,EUP.Deptname, GenericClass.generateRandomString(), "Test");
			String errormsg1=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg1, TDMap.get("Error1_MSG"));
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG, GenericClass.generateRandomString(), EUP.Shortname, "Test");
			String errormsg2=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg2, TDMap.get("Error2_MSG"));
			Reporter.log("To verified error msg when we input duplicate Department title and ShortName.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
		
	@Test(priority=3,groups={"P1","Department"}, description="To verified error msg when we input Blank data in Department title and ShortName edit boxes.")
	public void TC_1909_1910_1911_1912() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG," ", GenericClass.generateRandomString(), "Test");
			String errormsg=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg, TDMap.get("Error_MSG"));
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG,GenericClass.generateRandomString()," ", "Test");
			String errormsg1=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg1, TDMap.get("Error1_MSG"));
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG, GenericClass.generateRandomString(), GenericClass.generateRandomString(), " ");
			String errormsg2=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg2, TDMap.get("Error2_MSG"));
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG," ", " "," ");
			String errormsg3=ADP.fn_GetErrorText();
			Assert.assertEquals(errormsg3, TDMap.get("Error3_MSG"));
			Reporter.log("To verified error msg when we input Blank data in Department title and ShortName edit boxes.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	@Test(priority=4,groups={"P2","Department"}, description="Validate Cancel button and cancel image in Add/Edit Department page.")
	public void TC_1913_9169() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
			ADP.fn_FillMenedatoryfieldWithoutSave(GenericClass.generateRandomString(), GenericClass.generateRandomString(), "Test");
			ADP.fn_ClickButtonOrWebelement(ADP.Cancel_BT);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Department_Title"));
			DLP.fn_ClickAddaDepartment();
			ADP.fn_FillMenedatoryfieldWithoutSave(GenericClass.generateRandomString(), GenericClass.generateRandomString(), "Test");
			ADP.fn_ClickButtonOrWebelement(ADP.Cancel_IMG);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Department_Title"));
			Reporter.log("Validate Cancel button and cancel image in Add/Edit Department page.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=5,groups={"P1","Department"}, description="To Validated Main and Department List link in Add a Department page.")
	public void TC_1914_1915() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
		    ADP.fn_ClickButtonOrWebelement(ADP.DepartmentList_Link);
		    Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Department_Title"));
		    DLP.fn_ClickAddaDepartment();
		    ADP.fn_ClickButtonOrWebelement(ADP.Main_Link);
		    Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Admine_Title"));
		    Reporter.log("To Validated Main and Department List link in Add a Department page.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	@Test(priority=6,groups={"P1","Department"}, description="To Validate all changed information in Audit Trail page.")
	public void TC_1916() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			AddaDepartmentPage ADP=DLP.fn_ClickAddaDepartment();
			String name=GenericClass.generateRandomString();
			String shortname=GenericClass.generateRandomString();
			String Description=GenericClass.generateRandomString();
			ADP.fn_FillMenedatoryfield(ADP.SaveDepartment_IMG, name, shortname, Description);
			DLP.fn_ClickAddaDepartment();
			String str=GenericClass.GetCurrentWindowID();
			AddAuditTrailPage AATP=ADP.fn_AuditTrail();
			GenericClass.windowHandle(str);
			AATP.verify_history(name, shortname, Description);
			Reporter.log("To Validate all changed information in Audit Trail page.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	    
	
	
	@Test(priority=7,groups={"P1","Department"}, description="To Validated Main link and Cancel IMG button in Department List Page.")
	public void TC_1918_1919() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_VerifyLinkOrButton(DLP.Main_Link);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Admine_Title"));
			AH.fn_NavigateDepartments();
			DLP.fn_VerifyLinkOrButton(DLP.Cancel_IMG);
			Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Admine_Title"));
			Reporter.log("To Validated Main link and Cancel IMG button in Department List Page.");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	
	@Test(priority=8,groups={"P2","Department"}, description="To click on Master check box and verify select or deselect all check boxes.")
	public void TC_1920_8886() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_VerifyMasterCheckbox();
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=9,groups={"P2","Department"}, description="To verify short order by department name using upward and downward arrow.")
	public void TC_1921_8895() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.Sort_DepartmentTitle();
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	@Test(priority=10,groups={"P2","Department"}, description="To verify short order by department status using upward and downward arrow.")
	public void TC_1922_8898() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.SortDepartment_ByStatus();      
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	@Test(priority=11,groups={"P0","Department"}, description="Edit exist Department name and verified all reflections point.")
	public void TC_8899_1923_1924() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
		    EditDepartmentPage EDP=DLP.fn_ClickEditDepartment();
		    Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("EditDepartmentPage_Title"));
		    EDP.fn_VerifyLinkOrButton(EDP.Cancel_BT);
		    Assert.assertEquals(GenericClass.driver.getTitle(), TDMap.get("Department_Title"));
		    DLP.fn_ClickEditDepartment();
		    String existingdepname=EDP.fn_GetExistingDepartmentname();
		    String title=GenericClass.generateRandomString();
		    EDP.fn_ChangeExistingDeptname(title);
		    ArrayList<String> collect=DLP.fn_VerifyCreatedDepartment(title);
			Assert.assertEquals(collect.contains(title),true);
			Assert.assertEquals(collect.contains(existingdepname),false);
			POSPointsLandingPage PPLP=AH.fn_NavigateToPosPoint();
			EditPOSProductPage EPP=PPLP.fn_ClickOnEditLink();
			ArrayList<String> collec=EPP.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(collec.contains(title),true);
			Assert.assertEquals(collec.contains(existingdepname),false);
			PhoneExtensionsListPage PEL = AH.fn_NavigateToPhoneExtPage();
			ArrayList<String> PEDD=PEL.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(PEDD.contains(title),true);
			Assert.assertEquals(PEDD.contains(existingdepname),false);
			UsersLandingPage USL=AH.fn_NavigateUsers();
			AddNewUserPage ANU=USL.fn_ClickAddNewUserLink();
			ArrayList<String> ADU=ANU.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(ADU.contains(title),true);
			Assert.assertEquals(ADU.contains(existingdepname),false);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	/*
	@Test(priority=12,groups={"P0","Department"}, description="Deactivate Department and verified reflection point.")  // bug in livestabel
	public void TC_8900_8901() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
		    String existingdepname=DLP.fn_ActiveAndDeactiveDepName();
			POSPointsLandingPage PPLP=AH.fn_NavigateToPosPoint();
			EditPOSProductPage EPP=PPLP.fn_ClickOnEditLink();
			ArrayList<String> collec=EPP.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(collec.contains(existingdepname),false);    // bug in livestabel
			PhoneExtensionsLandingPage PEL =AH.fn_navigateToPhoneExtension();
			ArrayList<String> PEDD=PEL.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(PEDD.contains(existingdepname),false);
			UsersLandingPage USL=AH.fn_NavigateUsers();
			AddNewUserPage ANU=USL.fn_ClickAddNewUserLink();
			ArrayList<String> ADU=ANU.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(ADU.contains(existingdepname),false);
		}catch(Throwable e){
			Reporter.log("");
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }   */
	
	@Test(priority=13,groups={"P0","Department"}, description="To verify the presence of 4 default departments on the page.")
	public void TC_8993() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			GenericClass.selectElement(DLP.View_DD, "All");
			GenericClass.ActionOnAlert("Accept");
			ArrayList<String> ADU=DLP.fn_VerifyDepartmentnames();
			Assert.assertEquals(ADU.contains(TDMap.get("DefautAccount_TX")),true);
			Assert.assertEquals(ADU.contains(TDMap.get("Accout_TX")),true);
			Assert.assertEquals(ADU.contains(TDMap.get("Tax_TX")),true);
			Assert.assertEquals(ADU.contains(TDMap.get("Billing_TX")),true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=14,groups={"P1","Department"}, description="To verify view drop down,Page dropdown, Next link and Previous link.")
	public void TC_1925_1926_9166_9167_9168_1927_1928() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_VerifyPageDD("1");
			DLP.fn_SelectnumofRecord("5");
			Assert.assertEquals(DLP.Next_Link.isDisplayed() && DLP.Next_Link.isEnabled() , true);
			DLP.fn_VerifyPageDD("2");
			Assert.assertEquals(DLP.Previous_Link.isDisplayed() && DLP.Previous_Link.isEnabled(), true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=15,groups={"P1","Department"}, description="To verify Alert msg after select department and click on Delete button.")
	public void TC_1917() throws Throwable{
		try{
			String TC_ID=Thread.currentThread().getStackTrace()[1].getMethodName();
			TDMap=ExcelUtilHM.UI().getTestCaseDataMap(Constant.Departments_Path, Departmnet_Sheet,TC_ID);
			
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			String alerttext=DLP.fn_DeletedDepartment("Dismiss");
			Thread.sleep(1000);
			Assert.assertEquals(alerttext, TDMap.get("Alert_MSG"));
			ArrayList<String> colle=DLP.fn_VerifyDepartmentnames();
			Assert.assertEquals(colle.contains(DLP.DepName), true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=16,groups={"P0","Department"}, description="Delete Department and verify reflection point.")
	public void TC_8166_1918() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_DeletedDepartment("Accept");
			Thread.sleep(1000);
			ArrayList<String> colle=DLP.fn_VerifyDepartmentnames();
			Assert.assertEquals(colle.contains(DLP.DepName), false);
			POSPointsLandingPage PPLP=AH.fn_NavigateToPosPoint();
			EditPOSProductPage EPP=PPLP.fn_ClickOnEditLink();
			ArrayList<String> collec=EPP.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(collec.contains(DLP.DepName),false);        //there is a bug in live stable
			PhoneExtensionsListPage PEL =AH.fn_NavigateToPhoneExtPage();
			ArrayList<String> PEDD=PEL.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(PEDD.contains(DLP.DepName),false);
			UsersLandingPage USL=AH.fn_NavigateUsers();
			AddNewUserPage ANU=USL.fn_ClickAddNewUserLink();
			ArrayList<String> ADU=ANU.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(ADU.contains(DLP.DepName),false);
			String parent=GenericClass.GetCurrentWindowID();
			AH.fn_NavigateDepartments();
			DLAuditTrailPage DLAP=DLP.fn_ClickAuditTrail();
			GenericClass.windowHandle(parent);
			DLAP.verify_history(DLP.DepName);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=17,groups={"P1","Department"}, description="To verify Alert msg after delete department.")
	public void TC_8885() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_DeletedDepartment("Dismiss");
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	@Test(priority=18,groups={"P2","Department"}, description="To Verify any check box using select or deselect.")
	public void TC_8887_8888() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_ValidateAnyOneCheckBox();
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	    	
	@Test(priority=19,groups={"P0","Department"}, description="")
	public void TC_8900_8901_9175() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			String deptname=DLP.fn_ActiveAndDeactiveDepName();
			POSPointsLandingPage PPLP=AH.fn_NavigateToPosPoint();
			EditPOSProductPage EPP=PPLP.fn_ClickOnEditLink();
			ArrayList<String> collec=EPP.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(collec.contains(deptname),false);        //there is a bug in live stable
			PhoneExtensionsListPage PEL=AH.fn_NavigateToPhoneExtPage();
			ArrayList<String> PEDD=PEL.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(PEDD.contains(deptname),false);
			UsersLandingPage USL=AH.fn_NavigateUsers();
			AddNewUserPage ANU=USL.fn_ClickAddNewUserLink();
			ArrayList<String> ADU=ANU.fn_VerifyDepartmentnameInDropDown();
			Assert.assertEquals(ADU.contains(deptname),false);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	@Test(priority=20,groups={"P2","Department"}, description="To verify Next and Previous link with View and Page dropdown.")
	public void TC_9197_9198() throws Throwable{
		try{
			AdminHome AH=new AdminHome();
			DepartmentsLandingPage DLP=AH.fn_NavigateDepartments();
			DLP.fn_SelectnumofRecord("1");
			String option=DLP.fn_GetSelectedOptionfromDropDown(DLP.Page_DD);
			DLP.fn_VerifyLinkOrButton(DLP.Next_Link);
			String changeoption=DLP.fn_GetSelectedOptionfromDropDown(DLP.Page_DD);
			Assert.assertEquals(option.equalsIgnoreCase(changeoption), false);
			DLP.fn_VerifyLinkOrButton(DLP.Previous_Link);
			String toption=DLP.fn_GetSelectedOptionfromDropDown(DLP.Page_DD);
			Assert.assertEquals(option.equalsIgnoreCase(toption), true);
		}catch(Throwable e){
			GenericClass.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	             
	@AfterMethod
	public void fn_Close(){
		GenericClass.driver.quit();
	}
}
