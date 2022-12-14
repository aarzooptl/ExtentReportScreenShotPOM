package rahulsheetyacademytestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rahulshettyacademy.LoginPage;
import rahulshettyacademy.ProductListPage;
import rahulshettyacademy.base.BaseClass;

public class ProductListTest extends BaseClass {
	
	String prod_name ="ZARA COAT 3";
	LoginPage loginpage;
	ProductListPage productlistpage;
	
	public ProductListTest() {
		 super();
	 }
	
	 @BeforeMethod
	 public void setUp() {
		 initialization();
		 loginpage = new LoginPage();
		 productlistpage = new ProductListPage();
		 productlistpage = loginpage.Login("anshika@gmail.com", "Iamking@000");
	 }
	 
	 @Test 
	 public void ProListTest() {
		 productlistpage.getProductList();
	 }
	 
	 @Test
	 public void getNameofProduct() throws InterruptedException {
		 productlistpage.getProductName(prod_name);	 		
	 }
	 
	 @Test
	 public void AddToCart() throws InterruptedException {
		 productlistpage.addToCart(prod_name);
		 Assert.assertEquals(prod_name, "ZARA COAT 3");
	 }
	 
	 @Test
	 public void clickToCart() throws InterruptedException {
		 productlistpage.clickOnCart(prod_name);
		 Assert.assertEquals(prod_name, "ZARA COAT 3");
	 }
	 
	 @Test
	 public void cartProductList() throws InterruptedException {
		 Boolean match = productlistpage.verifyCartProducts(prod_name);
		 Assert.assertEquals(prod_name, "ZARA COAT 3");
	 }
	 
	 @Test
	 public void clickOnOrders() {
		 productlistpage.clicOnOrders();
	 }
	 
	 @Test
	 public void orderList() throws InterruptedException {
		 productlistpage.verifyOrderList(prod_name);
		 
	 }
	 @AfterMethod 
	 public void tearDown() {
		 driver.quit();
	 }
}
