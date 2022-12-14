package rahulsheetyacademytestcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rahulshettyacademy.LoginPage;
import rahulshettyacademy.ProductListPage;
import rahulshettyacademy.base.BaseClass;

public class LoginPageTest extends BaseClass{
	 LoginPage loginpage;
	 ProductListPage productlistPage;
	 
	 public LoginPageTest() {
		 super();
	 }
	 
	 @BeforeMethod
	 public void setUp() {
		 initialization();
		 loginpage = new LoginPage();
	 }
	 
	 @Test
	 public void loginPageTitleTest() {
		 String title = loginpage.LoginTitle();
		 Assert.assertEquals(title, "Let's Shop");
	 }
	 
	 @Test
	 public void LoginPageRegister() {
		 boolean flag = loginpage.isRegister();
		 Assert.assertTrue(flag);
	 }
	 
	 @Test
	 public void UserLogin() {
		 productlistPage = loginpage.Login("anshika@gmail.com", "Iamking@000");
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
