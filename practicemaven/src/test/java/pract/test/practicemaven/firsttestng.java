package pract.test.practicemaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class firsttestng {
	Properties prop = new Properties();
	
@Test
	public void test1() throws IOException
	{
	WebDriver driver = new ChromeDriver();
//FileInputStream fis = new  FileInputStream(C:\Users\Parag Patil\OneDrive\Desktop\SeleniumTutorialsNew\practicemaven\src\Properties\conf.properties);
	FileInputStream fil =new FileInputStream("C:\\Users\\Parag Patil\\OneDrive\\Desktop\\SeleniumTutorialsNew\\practicemaven\\Properties\\conf.properties");
	prop.load(fil);
	driver.get(prop.getProperty("prj_url"));
	driver.manage().window().maximize();
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());

	WebElement startngpnt= driver.findElement(By.xpath(prop.getProperty("fndele_xpath")));
		WebElement endpnt =driver.findElement(By.id(prop.getProperty("endid")));
		
		Actions act = new  Actions(driver);
		act.dragAndDrop(startngpnt, endpnt).perform();
		
		WebElement srtpt= driver.findElement(By.xpath(prop.getProperty("saleft")));
		WebElement end =driver.findElement(By.id(prop.getProperty("loanend")));
		
		//Actions act1 = new Actions(driver);
		act.dragAndDrop(srtpt, end).perform();
		
		
		
		WebElement begng = driver.findElement(By.xpath("//a[text()=' 5000 ']"));
		WebElement endpt =driver.findElement(By.id("amt7"));
		
		//Actions actn = new Actions(driver);
		act.dragAndDrop(begng, endpt).perform();
		
		
		
		WebElement srt=driver.findElement(By.xpath("//a[text()=' 5000 ']"));
		WebElement endp=driver.findElement(By.id("amt8"));
		
		
		//Actions act2= new Actions(driver);
		act.dragAndDrop(srt, endp).perform();
		
	}
	
}
