package imdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class imdbrating {

	public imdbrating() throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement release=driver.findElement(By.xpath("//a[normalize-space()='Release date']"));
		String releasedate=release.getText();
		System.out.println(releasedate);
		
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
		
			
		WebElement release1c=driver.findElement(By.xpath("//a[normalize-space()='India']"));
		String releasedate1c=release1c.getText();
		System.out.println(releasedate1c);
		
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
		
		WebElement release1w=driver1.findElement(By.xpath("//td[normalize-space()='India']"));
		String releasedate1w=release1w.getText();
		System.out.println(releasedate1w);
		driver1.close();
		
		if(releasedate1c.equals(releasedate1w))
			System.out.println("Country is same in IMDB and wiki page");
		else
			System.out.println("Country not same in IMDB and wiki page");
		
		if(date.equals(date1))
			System.out.println("Date is same in IMDB and wiki page");
		else
			System.out.println("Date not same in IMDB and wiki page");

	}

}
