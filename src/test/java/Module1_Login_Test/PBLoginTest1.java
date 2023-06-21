package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.PBHomePage;
import Module1_Login.PBLoginPage;
import Module1_Login.PBMobNumberPage;
import Module1_Login.PBMyAccPage;
import Module1_Login.PBMyProfilePage;
import Module1_Login.PBPwdPage;

public class PBLoginTest1 extends BaseClass
{
	PBLoginPage login;
	PBMobNumberPage mobNumber;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myAcc;
	PBMyProfilePage profile;
	int TCID;
	
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException, InterruptedException 
	{
        InitializeBrowser();
		
		login = new PBLoginPage(driver);
		mobNumber= new PBMobNumberPage(driver);
		pwd= new PBPwdPage(driver);
		home= new PBHomePage(driver);
		myAcc= new PBMyAccPage(driver);
		profile= new PBMyProfilePage(driver);
	}
	
	@BeforeMethod
	public void LoginToApp() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		login.ClickPBLoginPageSignIn();
		mobNumber.inpPBMobNumberPageMobNumber(UtilityClass.getPFData("MobNum"));
		mobNumber.clickPBMobNumberPageSignInWithPwdButton();
		pwd.inpPBPwdPagePwd(UtilityClass.getPFData("PWD"));
		pwd.clickPBPwdPageSignInBtn();
		Thread.sleep(2000);	
	}
	
	@Test
	public void VerifyFullName() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		TCID=101;
		home.openMyAccDDPBHomePagemyAcc();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		profile.switchToChildWindow();
		
		String ActFullName = profile.getPBMyProfilePagefullName();
		String ExpFullName= UtilityClass.getTestData(0, 2);
		
		Assert.assertEquals(ActFullName, ExpFullName, "Failed: both results are diff.");
	}
	
	@AfterMethod
	public void LogoutFromApp(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.CaptureSS(driver, TCID);
		}
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException 
	{
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
