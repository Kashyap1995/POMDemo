package rahulshettyacademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractCompo.Abstractcompo;

public class LandingPage extends Abstractcompo {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//pagefactory
	
	@FindBy(id="user-name")
	WebElement userEmail;
	
	
	@FindBy(id="password")
	WebElement passele;
	
	@FindBy(id="login-button")
	WebElement submit;
	
//	@FindBy(css="[Class*='flyInOut']")
//	WebElement errorMessage;
	

	public ProductCatalog loginApplicaion(String email,String password)
	{
		userEmail.sendKeys(email);
		passele.sendKeys(password);
		submit.click();
		ProductCatalog pcata = new ProductCatalog(driver);
		return pcata;
	}

//	public String getErrorMessage()
//	{
//		waitForWebElementToAppear(errorMessage);
//		return errorMessage.getText();	
//		
//	}
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}

}