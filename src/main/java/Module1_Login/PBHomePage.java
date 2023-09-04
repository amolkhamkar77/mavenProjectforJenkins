package Module1_Login;
//pom class 4

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage 
{
	@FindBy(xpath = "//div[text()='My Account']") private WebElement myAcc;
	WebDriver driver1; // declared globally
	
	public PBHomePage(WebDriver driver) // 2nd part
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void openDDOptionPBHomePageMyAcc()  //3rd part method
	{		
		Actions act=new Actions(driver1);
		act.moveToElement(myAcc).perform();		
	}

}
