package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLogoutPage
{

	@FindBy(xpath="//div[@title='Logout']") private WebElement logout;
	
	public PBLogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogoutbtn() 
	{
		logout.click();
	}
	
	
}
