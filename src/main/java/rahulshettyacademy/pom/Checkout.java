package rahulshettyacademy.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractCompo.Abstractcompo;

public class Checkout extends Abstractcompo {
	public WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "checkout")
	 private WebElement submit;

	@FindBy(id="first-name")
	WebElement firstname;

	@FindBy(id="last-name")
	WebElement lastname;

	@FindBy(id="postal-code")
	WebElement code;

	@FindBy(id="continue")
	WebElement continuecheckout;
	
	public Checkout Formfill1(String first, String last, String codes) throws InterruptedException 
	{
//		
//		Actions a = new Actions(driver);
//		a.sendKeys(firstname,lastname, code, details).build().perform();
//		
//		WebElement element = driver.findElement(By.id("first-name"));
//		element.sendKeys("kash");
//		WebElement element2 = driver.findElement(By.id("last-name"));
//		element.sendKeys("test");
//		WebElement element3 = driver.findElement(By.id("postal-code"));
//		element.sendKeys("380015");
//		//a.sendKeys(firstname, lastname, code, name).build().perform();
	
		firstname.sendKeys("search");
		Thread.sleep(5000);
		lastname.sendKeys("engine");
		Thread.sleep(5000);

		code.sendKeys("yes");
		Thread.sleep(5000);

		continuecheckout.click();
		
		Checkout checkoutPage = new Checkout(driver);
		return checkoutPage;
		
//		Thread.sleep(5000);
//
//		Actions a = new Actions(driver);
//		a.sendKeys(firstname, name).build().perform();
//			
//		continuecheckout.click();
		
		
}

	public void goTocheck() {
		// TODO Auto-generated method stub
		driver.get("https://www.saucedemo.com/checkout-step-one.html");

	}


}