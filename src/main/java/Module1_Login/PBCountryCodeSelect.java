package Module1_Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBCountryCodeSelect
{
     WebDriver driver;
	@FindBy(xpath="(//label[@for='custom-dropdown-list-open'])[2]") private WebElement cntrycode;
	
	public PBCountryCodeSelect(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectcountrycode()
	{
		Actions act = new Actions(driver);
				
		for(int i=0; i>=39; i++)
		{
			act.sendKeys(Keys.END).perform();
		}
	}
}
