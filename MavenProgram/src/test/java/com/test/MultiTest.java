package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {

	WebDriver driver;
	Properties prop = new Properties();

	@BeforeClass 
	public void Initalization() throws IOException {
		
		//they are telling where config.properties file are available
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
		prop.load(fis); //data we are loading inside into the properties file
		
		driver = new ChromeDriver();

		driver.get(prop.getProperty("QA_Url"));

		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void SelectDropDown() {

		WebElement seldropdown = driver.findElement(By.id(prop.getProperty("DropBox")));

		Select sel = new Select(seldropdown);

		sel.selectByIndex(3); // least priority

		sel.selectByValue("search-alias=appliances"); // medium priority

		sel.selectByVisibleText("Beauty & Personal Care");// high priority

	}

	@Test(dependsOnMethods = "SelectDropDown")
	public void MouseHovering() {

		// int i = 10;

		WebElement accountlist = driver.findElement(By.xpath(prop.getProperty("AccountList_xpath")));

		Actions act = new Actions(driver);

		act.moveToElement(accountlist).perform();

		driver.findElement(By.xpath("//span[text()='Account']")).click();

	}

	@AfterClass
	public void CleanUp() {
		driver.quit();
	}

}
