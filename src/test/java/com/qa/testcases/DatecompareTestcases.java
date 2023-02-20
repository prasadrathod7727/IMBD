package com.qa.testcases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatecompareTestcases {
	
	
	WebDriver chromedriver;
	@Test(groups = { "Simple", "UI" },priority=1)
	public void TC001_VerifyDate() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement release1=driver.findElement(By.xpath("//a[normalize-space()='December 17, 2021 (United States)']"));
		String releasedate1=release1.getText();
		System.out.println(releasedate1);
		String start = StringUtils.substringBefore(releasedate1, " ("); 
		System.out.println(start);
		String str=start.replace(",","");
		System.out.println(str);
		//System.out.println(start.getMonth());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(start, formatter);
		System.out.println(date);
		
		driver.close();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver1=new ChromeDriver();
		
		driver1.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		driver1.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement releasew=driver1.findElement(By.xpath("//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]"));//td.infobox-data div.plainlist ul li(1)"));
		String releasedatew=releasew.getText();
		System.out.println(releasedatew);
		//System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(releasedatew));
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
		LocalDate date1 = LocalDate.parse(releasedatew, formatter1);
		System.out.println(date1);
		
		if(date.equals(date1))
			System.out.println("Date is same in IMDB and wiki page");
		else
			System.out.println("Date not same in IMDB and wiki page");
		driver.close();
	}
	
	@Test(groups = { "Simple", "UI" },priority=2)
	public void TC002_VerifyCountry() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement release1c=driver.findElement(By.xpath("//a[normalize-space()='India']"));
		String releasedate1c=release1c.getText();
		System.out.println(releasedate1c);
		
		driver.close();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver1=new ChromeDriver();
		
		driver1.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		driver1.manage().window().maximize();
		Thread.sleep(2000);
		WebElement release1w=driver1.findElement(By.xpath("//td[normalize-space()='India']"));
		String releasedate1w=release1w.getText();
		System.out.println(releasedate1w);
		if(releasedate1c.equals(releasedate1w))
			System.out.println("Country is same in IMDB and wiki page");
		else
			System.out.println("Country not same in IMDB and wiki page");
		
		driver.close();
}

	
	@AfterTest()
	public void tearDown() {
		// FormatResult();
		tearDown();
		

}
}