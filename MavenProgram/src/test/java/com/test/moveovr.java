package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class moveovr {
	WebDriver driver;
	
	@BeforeClass
	public void start()
	{
		 driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}
	
	@Test(priority=0)
	public void movetofashn()
	{

	driver.findElement(By.xpath("//button[text()='✕']")).click();

	WebElement fashion = driver.findElement(By.xpath("//div[text()='Fashion']"));
	Actions f= new Actions(driver);
	f.moveToElement(fashion).perform();
	}
	//Thread.sleep(2000);
     @Test(priority=1)
     public void movertoethic()
     {
    	 WebElement ethic= driver.findElement(By.xpath("//a[text()='Women Ethnic']"));
    		Actions e =new Actions(driver);
    		e.moveToElement(ethic).perform();
     }
	
	//Thread.sleep(2000);
    @Test(priority=2)
    public void actlick() throws InterruptedException
    {
	WebElement saree= driver.findElement(By.xpath("//a[text()='Women Sarees']"));
	saree.click();
	Thread.sleep(5000);
    }
	//Thread.sleep(4000);
    @Test(priority=3)
    public void actsaara()
    {
	WebElement Saara= driver.findElement(By.xpath("//div[text()='Saara']"));

	Saara.click();
    }
    
    @AfterClass
    public void cleanup()
    {
    	driver.quit();
    }
    }
    
	
