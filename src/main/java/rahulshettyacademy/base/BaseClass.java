package rahulshettyacademy.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initialization() {
		System.setProperty("webdriver.geckodriver.driver", "C:\\Selenium_Drivers\\Firefox_driver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public static void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public static void waitForElementToDisapper(By findBy) throws InterruptedException {
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		{
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = (takesScreenshot).getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir")+"\\reports\\" + testCaseName + ".png");
			FileUtils.copyFile(source, dest);
			return System.getProperty("user.dir")+"\\reports\\" + testCaseName + ".png";
		
		}
	
}
}