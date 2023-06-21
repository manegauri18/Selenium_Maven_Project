package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	
	//@AuthorName: Gauri
	//This method is used to test get data from excel
	//need to pass 2 inputs: 1-RowIndex, 2-CellIndex
	public static String getTestData(int RowIndex, int ColIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("D:\\Eclipse\\workspace\\Selenium_Maven_Project\\Test_Data\\28th Jan.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(RowIndex).getCell(ColIndex).getStringCellValue();
		return value;
	}
	
	public static void CaptureSS(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File des = new File("D:\\Eclipse\\workspace\\Selenium_Maven_Project\\FailedTCes_SS\\TestCaseID"+TCID+".jpg");
		
		FileHandler.copy(src, des);
	}
	
	public static String getPFData(String key) throws IOException 
	{
		FileInputStream file= new FileInputStream("D:\\Eclipse\\workspace\\Selenium_Maven_Project\\Property_File\\PropertyFile.properties");
	
	    Properties p = new Properties();
	    p.load(file);
	    
	    String value = p.getProperty(key);
	    
	    return value;
	}

}
