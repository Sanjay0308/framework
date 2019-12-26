package com.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.AmazonFlipkart.GenericLib.BaseClass;

public class TC_001 extends BaseClass {
@Test
public void AmazonIphonePrice() {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[//@name='field-keywords' and @name='field-keywords']")).sendKeys("apple iphone xr 64 gb",Keys.ENTER);
		String xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../../div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[2]/span[2]";
		String priceIphone=driver.findElement(By.xpath(xpath)).getText();
        System.out.println("price is;-"+priceIphone);	
	}


		
	
}

