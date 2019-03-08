package com.qait.practice.Selenium.GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFrames {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		String project = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", project+"/driver/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public  void countFrame() {
		driver.get("http://10.0.14.57:9292/nested_frames");
		WebElement topframe = driver.findElement(By.xpath("/html[1]/frameset[1]/frame[1]"));
		WebElement bottomFrame = driver.findElement(By.xpath("/html[1]/frameset[1]/frame[2]"));
		
		
		//switching to the top frame
		driver.switchTo().frame(topframe);	
		System.out.println("In the top frame:");
		
		//traversing the frames under top frames
		for(int attempt=0 ; attempt < 3; attempt++)
		{
			driver.switchTo().frame(attempt);
			WebElement element = driver .findElement(By.cssSelector("body"));
			System.out.println("frame "+attempt+ " has body text=" + element.getText());
			driver.switchTo().parentFrame();
		}	
		
		//coming back to the main frame
		driver.switchTo().parentFrame();
		
		//switching to the bottom frame
		driver.switchTo().frame(bottomFrame);
		WebElement element = driver .findElement(By.cssSelector("body"));
		System.out.println("body of bottom frame have text = " + element.getText());
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
