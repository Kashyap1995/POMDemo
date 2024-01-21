package rahulshettyacademy.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pom.Cartpage;
import rahulshettyacademy.pom.Checkout;
import rahulshettyacademy.pom.ProductCatalog;
import rahulshettyacademy.testcompo.BaseTest;

public class Submitordertest  extends BaseTest{
	private static Logger Log=	LogManager.getLogger(Submitordertest.class.getName());


	String productName = "Sauce Labs Backpack";

	
	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
	
		//Log.debug("User enter email and password");

		//LandingPage landpage =	launchApplication();
		ProductCatalog pcata = landpage.loginApplicaion(input.get("email"), input.get("password"));
		
		List<WebElement> products= pcata.getProductList();
		//Log.debug("Add product to cart");

		pcata.addProductToCart(input.get("product"));
		Thread.sleep(5000);
		Cartpage cartpage= pcata.goToCartPage();
	//	Log.error("Product doesn't matched");

		System.out.println("I am on cart page");

		Boolean match = cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		Checkout checkoutPage = cartpage.goToCheckout();
		Thread.sleep(5000);
		checkoutPage.Formfill1(input.get("search"), input.get("engine"), input.get("yes"));
		//System.out.println("temp:******** "+ input.get("first"));
		
		
		

//		Confirmationpage confirmationPage = checkoutPage.Submitorder();
//		String confirmMessage = confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	}
	//To verify actual product is displayed in orders page "ZARA COAT 3"
	


//	@Test(dependsOnMethods= {"submitOrder"})
//	public void orderhistorytest() throws InterruptedException
//	{
//		ProductCatalog pcata = landpage.loginApplicaion("standard_user", "secret_sauce");
////		OrdersPage orderspage = pcata.goToOrdersPage();
////		Assert.assertTrue(orderspage.VerifyOrderDisplay(productName));
//		
//		
//	}
	
	
	

	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) }, {data.get(2) }  };
		
	}
	
	
	//  {
//		    return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
//	  }
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "kkdave1995@gmail.com");
//	map.put("password", "Kashyap@3552");
//	map.put("product", "ZARA COAT 3");
//
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "shetty@gmail.com");
//	map1.put("password", "Iamking@000");
//	map1.put("product", "ADIDAS ORIGINAL");

	


	}
		  

