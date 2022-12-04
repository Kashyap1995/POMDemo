	package rahulshettyacademy.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractCompo.Abstractcompo;

public class Cartpage extends Abstractcompo{

	WebDriver driver;
	
	@FindBy(id = "checkout")
	WebElement checkoutEle;

	@FindBy(css = ".inventory_item_name")
	private List<WebElement> cartProducts;
	
	public Cartpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;

	}

	public Checkout goToCheckout() {
		// TODO Auto-generated method stub
		checkoutEle.click();
		return new Checkout(driver);
	}
		



	
	
}
