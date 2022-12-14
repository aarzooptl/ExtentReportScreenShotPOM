package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	 @FindBy(id="userEmail") 
	 WebElement useremail;
	  
	 @FindBy(id="userPassword") 
	 WebElement password;
	 
	 @FindBy(id="login") 
	 WebElement submit;
	 
	
	@FindBy(className ="btn1") 
	WebElement register;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String LoginTitle() {
		return driver.getTitle();
	}
	
	public Boolean isRegister() {
		return register.isDisplayed();
	}
	
	public ProductListPage Login(String uname, String pass) {
		useremail.sendKeys(uname);
		password.sendKeys(pass);
		submit.click();
		return new ProductListPage();
	}
}
