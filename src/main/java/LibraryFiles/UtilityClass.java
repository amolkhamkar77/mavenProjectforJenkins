package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass 
{
	
	//@Author name: Sanjay
	//This method is use to get Test data from excel sheet
	//need to pass 2 inputs: 1-rowIndex, 2-colIndex
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Amol Khamkar\\git\\SeleniumRevisionMaven1\\TestData\\SeleniumRevisionC'wad.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Amol Khamkar\\git\\SeleniumRevisionMaven1\\FailedTCSS\\TestCaseID"+TCID+".png");
		FileUtils.copyFile(src, dest);                      //TestCaseID+TCID is screenshot name
	}                      // upto FailedTcss is Folder location of screen shot storage
	
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Amol Khamkar\\git\\SeleniumRevisionMaven1\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	
	

}
