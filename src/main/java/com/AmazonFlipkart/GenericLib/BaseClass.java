package com.AmazonFlipkart.GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import com.AmazonFlipkart.ObjectRepo.HomePage;
import com.AmazonFlipkart.ObjectRepo.LoginPage;
/**
 * 
 * @author SanjayKumar
 *
 */
@Listeners
public class BaseClass {


public WebDriver driver;
public static LoginPage loginPage;
public static HomePage HomePage;
public EventFiringWebDriver edr;

@BeforeSuite
public void configurBeforeSuite() {
	//ExtentReportLib.extentInit();
}
@BeforeTest
public void configurBrforeTest() {
	String url=System.getProperty("url");
	String browser=System.getProperty("browser");
	if(browser.equals("Chrome")) {
		driver=new ChromeDriver();
	}else if(browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	edr = new EventFiringWebDriver(driver);
	
}
@AfterTest
public void configAfterTest() {
	//HomePage.signOut();
	driver.quit();
}
@AfterSuite
public void configAfterSuite() throws Throwable {
	Runtime.getRuntime().exec("taskkill -im chromedriver.exe /f");
	Runtime.getRuntime().exec("taskkill -im geckodriver.exe /f");
}
}
