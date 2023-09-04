package Module1_login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.PBCountryCodeSelect;
import Module1_Login.PBHomeButton;
import Module1_Login.PBHomePage;
import Module1_Login.PBLoginPage;
import Module1_Login.PBLogoutPage;
import Module1_Login.PBMobNumPage;
import Module1_Login.PBMyAccPage;
import Module1_Login.PBProfilePage;
import Module1_Login.PBPwdPage;

public class PBLoginTest1 extends BaseClass
{
	PBLoginPage login;
	PBMobNumPage mobNum;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myAcc;
	PBProfilePage profile;
	int TCID;
	PBLogoutPage logout1;
	PBHomeButton hombtn;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		initializeBrowser(); // BaseClass method calling--> only method name bcoz we extnd base class
		 login=new PBLoginPage(driver);
		 mobNum=new PBMobNumPage(driver);
		 pwd=new PBPwdPage(driver);
		 home=new PBHomePage(driver);
		 myAcc=new PBMyAccPage(driver);
		 profile=new PBProfilePage(driver);
		logout1 = new PBLogoutPage(driver);
		hombtn= new PBHomeButton(driver);
		
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.clickPBLoginPageSignIN();
		
		
		mobNum.inpPBMobNumPageMobNum(UtilityClass.getPFData("mobNum"));
		mobNum.clickPBMobNumPageSignInWithPwd();
		pwd.inpPBPwdPagePWD(UtilityClass.getPFData("pwd"));
		pwd.clickPBPwdPageSignIn();
		Thread.sleep(3000);  
	}
	
	
	@Test
	public void verifyFullName() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		TCID=101;
		home.openDDOptionPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		profile.switchToSwitchChildWindow();
		
		String actFullName=profile.getPBProfilePageFullName();
		String expFullName=UtilityClass.getTestData(1, 0);
		
		Assert.assertEquals(actFullName, expFullName, "Failed: both names are diff- ");
	}    // check excel sheet Expected name of Profile is Amol Khamkar
	
	@AfterMethod
	public void name(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}		
	
		logout1.clickOnLogoutbtn();
		Reporter.log("Logout Successfully",true);
		//click on home button
		hombtn.clickOnPBHomebtn();
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		//driver.quit();
	}

}
