package rahulshettyacademy.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractCompo.Abstractcompo;

public class ProductCatalog extends Abstractcompo{

	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(css=".inventory_item")

	List<WebElement> products;
	
	
//	@FindBy(xpath = "@[class='inventory_item_description']")
//	List<WebElement> products;
	
	
	
	
	By productsBy =By.cssSelector(".inventory_item");
	By addToCart= By.cssSelector(".btn_inventory");
	
	//By toastmessage = By.cssSelector("#toast-container");
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}	
	
	public WebElement getProuctByName(String productName) {	
		
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		
		WebElement prod= getProuctByName(productName);
		prod.findElement(addToCart).click();
//		waitForElementToAppear(toastmessage);
//		waitForWebElementToDisappear(spinner);
	}


	
}