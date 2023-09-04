package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomeButton 
{

	@FindBy(xpath="(//a[@href='https://www.policybazaar.com/'])[1]") private WebElement homebtn;
	
	public PBHomeButton(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnPBHomebtn() 
	{
	homebtn.click();	
	}
	
}
