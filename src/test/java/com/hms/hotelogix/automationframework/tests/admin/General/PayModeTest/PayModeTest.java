package com.hms.hotelogix.automationframework.tests.admin.General.PayModeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.FrontdeskLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.CashCounterPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.FrontDeskHomePage.ConfirmLoginPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.AccountStatementLandingPage;
import com.hms.hotelogix.automationframework.pages.Frontdesk.Payment.ReservationFolioPage;
import com.hms.hotelogix.automationframework.pages.GenericMethod.Constant;
import com.hms.hotelogix.automationframework.pages.GenericMethod.ExcelUtil;
import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
import com.hms.hotelogix.automationframework.pages.admin.General.PayModes.AuditTrailPage;
import com.hms.hotelogix.automationframework.pages.admin.General.PayModes.EditPayModePage;
import com.hms.hotelogix.automationframework.pages.admin.General.PayModes.PayModesLandingPage;
import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.AddRoomsPage;
import com.hms.hotelogix.automationframework.pages.admin.RoomsManager.Rooms.RoomsLandingPage;

public class PayModeTest {

	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private AdminHome AH;
	public ArrayList<String> paymodes = new ArrayList<String>(
			Arrays.asList("Cash", "Cheque", "Credit Card", "Bank Transfer", "Others", "Revenue Loss"));

@BeforeMethod()
public void Login() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
AdminLogin AL = GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)),"http://hotelogix.stayezee.com/admine/");
AH = AL.adminlogin("13135", "vj@stayzee.com", "deepak");// for http://hotelogix.stayezee.com/admine/
//AH=AL.fn_adminLogin("12487","deepakTest3@stayezee.com","18e44afe");// //http://livestable.hx.local/admine/ yrl.
ExcelUtil.CloseAllExcelReferences();
Reporter.log("Login Successfull", true);
} catch (Exception e) {
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 1,description="To Verify navigation to Pay Modes Page.", groups = { "P0", "PayModeTest" })
public void HMS9100() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
AH.fn_NavigateToPayModes();
Reporter.log("Landed to Pay mode  page", true);
Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Page Title verified", true);
ExcelUtil.CloseAllExcelReferences();
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 2,description=" To verify title on Pay Modes page", groups = { "P0", "PayModeTest" }) // Page header in unavilable verified acc to page title
public void HMS9101() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
AH.fn_NavigateToPayModes();
Reporter.log("Landed to Pay mode  page", true);
Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Page Title verified", true);
ExcelUtil.CloseAllExcelReferences();
} 
catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}



@Test(priority=3,description="To verify the presence of all the Links, buttons and fields on 'Pay Modes' page",groups = { "P1", "PayModeTest" })
public void HMS9102() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
Reporter.log("Landed to Pay mode  page", true);
PMLP.fn_VerifyPageElements();
Reporter.log("Page Elements verified", true);
ExcelUtil.CloseAllExcelReferences();
}
catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 4,description=" To verify the functionality of 'Main' button on Pay Modes Page.", groups = { "P1", "PayModeTest" })
public void HMS9107() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
Reporter.log("Landed to Pay mode  page", true);
AH = PMLP.fn_clickOnMainLink();
Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
Reporter.log("Admin home page title verified", true);
ExcelUtil.CloseAllExcelReferences();
}
catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}
@Test(priority = 5,description=" To verify wheather Pay modes grid have data or not.", groups = { "P0", "PayModeTest" })
public void HMS9108() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
ArrayList<String> pm = PMLP.fn_getAllPayModes();
Thread.sleep(2000);
Assert.assertEquals(pm.toArray(), paymodes.toArray());
Reporter.log("All the pay modes are verified", true);
} 
catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 6,description="To Verify navigation to Pay Modes Page.",groups = { "P0", "PayModeTest" })
public void HMS9109() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
Thread.sleep(2000);
String urlBeforeEdit = GenericClass.driver.getCurrentUrl();
PMLP.fn_ClickOnEditLink();
String urlAfterEditClick = GenericClass.driver.getCurrentUrl();
Thread.sleep(2000);
Assert.assertNotEquals(urlAfterEditClick.toString(), urlBeforeEdit.toString());
Reporter.log("Url Changed i.e. page has been changed after clicking on edit link.", true);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 7,description=" Verify the title of the page after clicking 'Pencil icon/Edit' link",groups = { "P1", "PayModeTest" })
public void HMS9111() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLink();
Assert.assertEquals(GenericClass.getText(EPMP.Header_Page).trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
Reporter.log("Edit pay type page header verified.", true);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 8,description="To Verify navigation to Pay Modes Page.", groups = { "P1", "PayModeTest" })
public void HMS9110() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLink();
EPMP.fn_verifyPageElements();
Reporter.log("All the page elements of Edit pay Type Page are verified.", true);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 9,description=" To verify the functionality of 'CANCEL' button on the page.",groups = { "P2", "PayModeTest" })
public void HMS9112() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLink();
PMLP = EPMP.fn_clickOnCancelBtn();
Assert.assertEquals(GenericClass.driver.getTitle().trim(),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)).trim());
Reporter.log("Cancel button on the page is working fine.", true);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 10,description=" To verify whether edit pay mode saves or not with blank data.",groups = { "P1", "PayModeTest" }) // NEED TO DISCUSS AS FOR THIS TEST CASE THERE IS NO VALIDATION FROM DEV.
public void HMS9113() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLinkForPayMode("Cash");
GenericClass.sendKeys(EPMP.TB_PayTypeTitle,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
GenericClass.clickElement(EPMP.Btn_Save);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 11,description=" To verify whether edit pay mode saves or not with valid data.",groups = { "P0", "PayModeTest" })
public void HMS9114() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLinkForPayMode("Cash");
PMLP = EPMP.fn_setPayTypeTitle(EPMP.TB_PayTypeTitle,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Thread.sleep(2000);
Assert.assertTrue(GenericClass.getText(PMLP.Msg_titleSave).trim().contains(
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle))));
Reporter.log("Pay type title got saved and edited.", true);
RoomsLandingPage RLP = AH.fn_NavigateRooms();
AddRoomsPage ARP = RLP.ClickOnAddRoomLink();
String rtype=ARP.fn_addRoomName(1);
AH.fn_NavigateToPayModes();
String admin = GenericClass.driver.getTitle();
ConfirmLoginPage CLP = AH.ClickOnFrontdeskLink();
GenericClass.driver.getWindowHandles();
GenericClass.switchToWindowHandle("Frontdesk");
CashCounterPage CCP = CLP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage FLP = CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
FLP.fn_createFDReserv(rtype, "3", "3");
FLP.FillQuickResForm(iTestCaseRow);
FLP.fn_verifyReservation();
Thread.sleep(2000);
WebElement ele = FLP.getWebElement(FLP.resvId);
FLP.fn_rightClickOnReservation(ele);
FLP.fn_clickCheckIn();
GenericClass.ActionOnAlert("Accept");
WebElement ele1 = FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele1);
AccountStatementLandingPage ASLP = FLP.fn_clickOnPayment();
String pm = ASLP.fn_verifyEditedPayMode(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Assert.assertEquals(pm,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Reporter.log("Edited Pay Mode verified at Account statment payment dropdown", true);
GenericClass.clickElement(ASLP.Btn_OtherCharges);
ASLP.fn_addOtherCharge(iTestCaseRow);
Thread.sleep(2000);
GenericClass.clickElement(ASLP.Btn_GenerateFolio);
GenericClass.ActionOnAlert("Accept");
ReservationFolioPage RFP = ASLP.fn_ClickOnPI();
String pm1 = RFP.fn_verifyEditedPayMode(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Assert.assertEquals(pm1,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Reporter.log("Edited Pay Mode verified at Reservation folio page", true);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 12,description=" To verify whether edit pay mode saves or not with special characters.",groups = { "P0", "PayModeTest" })
public void HMS9195() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLinkForPayMode("Cash");
PMLP = EPMP.fn_setPayTypeTitle(EPMP.TB_PayTypeTitle,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Thread.sleep(2000);
Assert.assertTrue(GenericClass.getText(PMLP.Msg_titleSave).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle))));
Reporter.log("Pay type title got saved and edited.", true);
RoomsLandingPage RLP = AH.fn_NavigateRooms();
AddRoomsPage ARP = RLP.ClickOnAddRoomLink();
String rtype=ARP.fn_addRoomName(1);
AH.fn_NavigateToPayModes();
String admin = GenericClass.driver.getTitle();
ConfirmLoginPage CLP = AH.ClickOnFrontdeskLink();
GenericClass.driver.getWindowHandles();
GenericClass.switchToWindowHandle("Frontdesk");
CashCounterPage CCP = CLP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage FLP = CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
FLP.fn_createFDReserv(rtype, "3", "3");
FLP.FillQuickResForm(iTestCaseRow);
FLP.fn_verifyReservation();
Thread.sleep(2000);
WebElement ele = FLP.getWebElement(FLP.resvId);
FLP.fn_rightClickOnReservation(ele);
FLP.fn_clickCheckIn();
GenericClass.ActionOnAlert("Accept");
WebElement ele1 = FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele1);
AccountStatementLandingPage ASLP = FLP.fn_clickOnPayment();
String pm = ASLP.fn_verifyEditedPayMode(
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Assert.assertEquals(pm,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Reporter.log("Edited Pay Mode verified at Account statment payment dropdown", true);
GenericClass.clickElement(ASLP.Btn_OtherCharges);
Thread.sleep(2000);
ASLP.fn_addOtherCharge(iTestCaseRow);
Thread.sleep(2000);
GenericClass.js_Click(ASLP.Btn_GenerateFolio);
GenericClass.ActionOnAlert("Accept");
Thread.sleep(2000);
ReservationFolioPage RFP = ASLP.fn_ClickOnPI();
String pm1 = RFP.fn_verifyEditedPayMode(
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Assert.assertEquals(pm1,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Reporter.log("Edited Pay Mode verified at Reservation folio page", true);
} catch (Throwable e) {
GenericClass.getscreenshot(sTestCaseName);
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}

@Test(priority = 13,description=" To verify whether edit pay mode saves or not with numeric digit.",groups = { "P0", "PayModeTest" })
public void HMS9196() throws Exception {
try {
sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
EditPayModePage EPMP = PMLP.fn_ClickOnEditLinkForPayMode("Cash");
PMLP = EPMP.fn_setPayTypeTitle(EPMP.TB_PayTypeTitle,
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Thread.sleep(2000);
Assert.assertTrue(GenericClass.getText(PMLP.Msg_titleSave).trim().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle))));
Reporter.log("Pay type title got saved and edited.", true);
RoomsLandingPage RLP = AH.fn_NavigateRooms();
AddRoomsPage ARP = RLP.ClickOnAddRoomLink();
String rtype=ARP.fn_addRoomName(1);
AH.fn_NavigateToPayModes();
String admin = GenericClass.driver.getTitle();
ConfirmLoginPage CLP = AH.ClickOnFrontdeskLink();
GenericClass.driver.getWindowHandles();
GenericClass.switchToWindowHandle("Frontdesk");
CashCounterPage CCP = CLP.fn_ClickCountinueWithTrail_BT();
FrontdeskLandingPage FLP = CCP.fn_ClickContinueButton();
FLP.fn_ClickCancelButton();
FLP.fn_createFDReserv(rtype, "3", "3");
FLP.FillQuickResForm(iTestCaseRow);
FLP.fn_verifyReservation();
Thread.sleep(2000);
WebElement ele = FLP.getWebElement(FLP.resvId);
FLP.fn_rightClickOnReservation(ele);
FLP.fn_clickCheckIn();
GenericClass.ActionOnAlert("Accept");
WebElement ele1 = FLP.getWebElement(FLP.resvId);
Thread.sleep(2000);
FLP.fn_rightClickOnReservation(ele1);
AccountStatementLandingPage ASLP = FLP.fn_clickOnPayment();
String pm = ASLP.fn_verifyEditedPayMode(
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Assert.assertEquals(pm,
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Reporter.log("Edited Pay Mode verified at Account statment payment dropdown", true);
GenericClass.clickElement(ASLP.Btn_OtherCharges);
Thread.sleep(2000);
ASLP.fn_addOtherCharge(iTestCaseRow);
Thread.sleep(2000);
GenericClass.clickElement(ASLP.Btn_GenerateFolio);
GenericClass.ActionOnAlert("Accept");
ReservationFolioPage RFP = ASLP.fn_ClickOnPI();
String pm1 = RFP.fn_verifyEditedPayMode(
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Assert.assertEquals(pm1,
ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PayTypeTitle)));
Reporter.log("Edited Pay Mode verified at Reservation folio page", true);
} catch (Throwable e) {
	GenericClass.getscreenshot(sTestCaseName);
	ExcelUtil.CloseAllExcelReferences();
	throw e;
		}
	}

	@Test(priority = 14,description=" To verify whether clicking on de-activation button, activate 'Pay Type Mode' or not.",groups = { "P1", "PayModeTest" })
	public void HMS9115() throws Exception {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			
			PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
			PMLP.fn_deactivatePayMode("Cash");
			Thread.sleep(2000);
			PMLP.fn_activatePayMode("Cash");
			RoomsLandingPage RLP = AH.fn_NavigateRooms();
			AddRoomsPage ARP = RLP.ClickOnAddRoomLink();
			String rtype=ARP.fn_addRoomName(1);
			AH.fn_NavigateToPayModes();
			String admin = GenericClass.driver.getTitle();
			ConfirmLoginPage CLP = AH.ClickOnFrontdeskLink();
			GenericClass.driver.getWindowHandles();
			GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP = CLP.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP = CCP.fn_ClickContinueButton();
			FLP.fn_ClickCancelButton();
			FLP.fn_createFDReserv(rtype, "3", "3");
			FLP.FillQuickResForm(iTestCaseRow);
			FLP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FLP.getWebElement(FLP.resvId);
			FLP.fn_rightClickOnReservation(ele);
			FLP.fn_clickCheckIn();
			GenericClass.ActionOnAlert("Accept");
			WebElement ele1 = FLP.getWebElement(FLP.resvId);
			Thread.sleep(2000);
			FLP.fn_rightClickOnReservation(ele1);
			AccountStatementLandingPage ASLP = FLP.fn_clickOnPayment();
			ASLP.fn_verifyActivatedPayMode(PMLP.paytitle);
			GenericClass.clickElement(ASLP.Btn_OtherCharges);
			Thread.sleep(2000);
			ASLP.fn_addOtherCharge(iTestCaseRow);
			Thread.sleep(2000);
			GenericClass.clickElement(ASLP.Btn_GenerateFolio);
			// GenericClass.ActionOnAlert("Accept");
			ReservationFolioPage RFP = ASLP.fn_ClickOnPI();
			RFP.fn_verifyActivatedPayMode(PMLP.paytitle);
			Reporter.log("Active pay mode verified to the payment section of account statement and folio page.", true);
		} catch (Throwable e) {
			GenericClass.getscreenshot(sTestCaseName);
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 15,description=" To verify whether clicking on activation button, de-activate 'Pay Type Mode' or not.",groups = { "P1", "PayModeTest" })
	public void HMS9116() throws Exception {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			
			PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
			PMLP.fn_deactivatePayMode("Cash");
			RoomsLandingPage RLP = AH.fn_NavigateRooms();
			AddRoomsPage ARP = RLP.ClickOnAddRoomLink();
			String rtype=ARP.fn_addRoomName(1);
			PMLP = AH.fn_NavigateToPayModes();
			String admin = GenericClass.driver.getTitle();
			ConfirmLoginPage CLP = AH.ClickOnFrontdeskLink();
			GenericClass.driver.getWindowHandles();
			GenericClass.switchToWindowHandle("Frontdesk");
			CashCounterPage CCP = CLP.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP = CCP.fn_ClickContinueButton();
			FLP.fn_ClickCancelButton();
			FLP.fn_createFDReserv(rtype, "3", "3");
			FLP.FillQuickResForm(iTestCaseRow);
			FLP.fn_verifyReservation();
			Thread.sleep(2000);
			WebElement ele = FLP.getWebElement(FLP.resvId);
			FLP.fn_rightClickOnReservation(ele);
			FLP.fn_clickCheckIn();
			GenericClass.ActionOnAlert("Accept");
			WebElement ele1 = FLP.getWebElement(FLP.resvId);
			Thread.sleep(2000);
			FLP.fn_rightClickOnReservation(ele1);
			AccountStatementLandingPage ASLP = FLP.fn_clickOnPayment();
			ASLP.fn_verifyDeactivatedPayMode(PMLP.paytitle);
			GenericClass.clickElement(ASLP.Btn_OtherCharges);
			Thread.sleep(2000);
			ASLP.fn_addOtherCharge(iTestCaseRow);
			Thread.sleep(2000);
			GenericClass.clickElement(ASLP.Btn_GenerateFolio);
			Thread.sleep(3000);
			ReservationFolioPage RFP = ASLP.fn_ClickOnPI();
			RFP.fn_verifyDeactivatedPayMode(PMLP.paytitle);
			GenericClass.switchToWindowHandle(admin);
			PMLP.fn_activatePayMode("Cash");
			Thread.sleep(2000);
			Reporter.log("Deactive pay mode verified to the payment section of account statement and folio page.",
					true);
		} catch (Throwable e) {
			GenericClass.getscreenshot(sTestCaseName);
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@Test(priority = 16,description=" To verify Audit Trail", groups = { "P1", "PayModeTest" })
	public void HMS9117() throws Exception {
		try {
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_PayModes, Constant.Sheet_PayModes);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			
			PayModesLandingPage PMLP = AH.fn_NavigateToPayModes();
			EditPayModePage EPMP = PMLP.fn_ClickOnEditLinkForPayMode("Cash");
			String random = GenericClass.generateRandomString();
			PMLP = EPMP.fn_setPayTypeTitle(EPMP.TB_PayTypeTitle, random);
			String tit = GenericClass.driver.getTitle();
			AuditTrailPage ATP = PMLP.fn_ClickOnAuditTrailPage();
			GenericClass.driver.getWindowHandles();
			GenericClass.switchToWindowHandleByURL(
					"http://hotelogix.stayezee.com/admine/audittrail/popup/controllerName/paymode/id/");
			String pageTitle = ATP.fn_getPageTitle();
			Assert.assertEquals(pageTitle,
					ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			ATP.fn_VerifyChanges("Title " + EPMP.valueBeforeEdit + " modified by ");
			Reporter.log("Audit Trail showing the change history for the current change.", true);

		} catch (Throwable e) {
			GenericClass.getscreenshot(sTestCaseName);
			ExcelUtil.CloseAllExcelReferences();
			throw e;
		}
	}

	@AfterMethod()
	public void closeApp() throws Exception {
		Set<String> handles = GenericClass.driver.getWindowHandles();
		for (String windowId : handles) {
			GenericClass.driver.switchTo().window(windowId);
			GenericClass.driver.close();
		}

	}

}
