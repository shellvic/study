package info.sjd.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import info.sjd.users.User;

public class RegService {
	private static String baseUrl = "http://www.amazon.com";
	private static WebDriver driver;
	
	public static void regUserOnAmazon(User user) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);        
        driver.findElement(By.cssSelector("#nav-link-accountList.nav-a.nav-a-2")).click();
        driver.findElement(By.cssSelector("#createAccountSubmit")).click();
        driver.findElement(By.cssSelector("#ap_customer_name")).sendKeys(user.getFirstName());
        driver.findElement(By.cssSelector("#ap_email")).sendKeys(user.getEmail());
        driver.findElement(By.cssSelector("#ap_password")).sendKeys(user.getPassword()); 
        driver.findElement(By.cssSelector("#ap_password_check")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("#a-autoid-0.a-button.a-button-normal.a-button-span12.a-button-primary")).click();
        //driver.close();		
	}
}