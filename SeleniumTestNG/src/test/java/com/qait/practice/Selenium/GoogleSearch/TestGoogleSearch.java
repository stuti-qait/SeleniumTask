package com.qait.practice.Selenium.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGoogleSearch {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		String project = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", project+"/driver/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearch() {
		
		String searchedString = "fgthio";
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys(searchedString);
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		String value = driver.findElement(By.className("LC20lb")).getText();
		
		//check if the first link contains the searched string or not
		if(value.toLowerCase().contains(searchedString.toLowerCase())) {
			Assert.assertTrue(false, "your tests has not passed");
		}
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
