package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPwdPage
{
	@FindBy(xpath="//input[@name='password']") private WebElement pwd;
	@FindBy(xpath="//a[@id='login-in-with-password']") private WebElement SignIn;
	
	
	public PBPwdPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpPBPwdPagePwd(String Pwd) 
	{
		pwd.sendKeys(Pwd);
	}
	
	public void clickPBPwdPageSignInBtn() 
	{
		SignIn.click();
	}

}
