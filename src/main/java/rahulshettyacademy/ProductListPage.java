package rahulshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.base.BaseClass;

public class ProductListPage extends BaseClass{
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement myorders;

	@FindBy(xpath="//tr/td[3]")
	private List<WebElement> ordernames;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	private List<WebElement> cart_products;
	
	By productby = By.cssSelector(".mb-3");
	
	@FindBy(xpath="//div[@class='card-body']/h5/b")
	List<WebElement> products;

	By addtocart = By.xpath("//div[@class='card-body']/button[2]");
	By toastmessage = By.id("toast-container");
	//By loading = By.className("ng-animating");
	
	public ProductListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productby);
		return products;
		
	}
	
	public WebElement getProductName(String prod_name) {
		waitForElementToAppear(productby);
		WebElement prod = products.stream().filter(product->product.findElement(By.xpath("//div[@class='card-body']/h5/b")).getText().equals(prod_name)).findFirst().orElse(null);
		System.out.println("ALl the product from product list"+prod);
		return prod;
	}

	public WebElement addToCart(String prod_name) throws InterruptedException {
		WebElement prod = getProductName(prod_name);
		prod.findElement(addtocart).click();
		waitForElementToAppear(toastmessage);
		Thread.sleep(1000);
		return prod;
	}
	
	public void clickOnCart(String prod_name) throws InterruptedException {
		Thread.sleep(1000);
		cart.click();
		
	}
	
	public Boolean verifyCartProducts(String prod_name) throws InterruptedException {
		Boolean match = cart_products.stream().anyMatch(product->product.getText().equalsIgnoreCase(prod_name));
		return match;
	}
	
	public void clicOnOrders() {
		myorders.click();
	}
	
	public WebElement verifyOrderList(String prod_name) throws InterruptedException {
		Thread.sleep(1000);
		WebElement prod = products.stream().filter(product->product.findElement(By.xpath("//tr/td[3]")).getText().equals(prod_name)).findFirst().orElse(null);
		return prod;
	}
}