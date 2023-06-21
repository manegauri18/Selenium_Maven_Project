package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginPage 
{
	//step1: Declaration
	@FindBy(xpath="//a[text()='Sign in']") private WebElement Sign_in;
	
	
	//step2: Initialization
	public PBLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);    // DifferClassName.methodName(webdriverObjectName, this_keyword)
	}
	
	
	//step3: Usage
	public void ClickPBLoginPageSignIn() 
	{
		Sign_in.click();
	}

}
