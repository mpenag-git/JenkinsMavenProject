package com.mpenag.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\DriversSel\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	@Test
	public void validateGoogleId() throws Exception {
		System.out.println("Opening Browser");
		driver.get("https://accounts.google.com/AccountChooser/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fservice%3Dmail%26flowName%3DGlifWebSignIn%26flowEntry%3DAccountChooser%26ec%3Dasw-gmail-globalnav-signin");
		System.out.println("Clicking Gmail Link");
		//driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).click();
		//driver.findElement(By.linkText("Gmail"));
		//System.out.println("Clicking Sign In link");
		//driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		System.out.println("Entering username");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("renju.jenkins.training");
		System.out.println("Clicking Next button");
		driver.findElement(By.xpath("(//span[normalize-space()='Siguiente'])[1]")).click();
		Thread.sleep(5000);
		boolean textFound = driver.getPageSource().contains("No se ha podido... ");
		//boolean textFound = driver.getPageSource().contains("No se ha podido iniciar sesión");
		AssertJUnit.assertTrue(textFound);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

