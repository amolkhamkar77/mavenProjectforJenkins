package Module1_Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class aaaa {

	//this class is not working
	
	public static void main(String[] args) throws InterruptedException  {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("—disable-notifications");
		WebDriver driver=new ChromeDriver(op);
		driver.get("https://www.policybazaar.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		//WebElement cntryc = driver.findElement(By.xpath("(//label[@for='custom-dropdown-list-open'])[2]"));
		//WebElement cntryc = driver.findElement(By.xpath("(//div[@class='custom-dropdown-country-icon-wrapper'])[2]"));
		WebElement cntryc = driver.findElement(By.xpath("((//div[@class='custom-dropdown-country-icon-wrapper'])[2]//div)[1]"));

		
		Actions act = new Actions(driver);
		act.click(cntryc).perform();
		act.sendKeys(Keys.HOME).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		for(int i=0; i>=39; i++)
		{
			
			act.sendKeys(Keys.DOWN).perform();
		}
		
	}

}
