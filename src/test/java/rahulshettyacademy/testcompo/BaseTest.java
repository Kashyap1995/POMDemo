package rahulshettyacademy.testcompo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pom.Checkout;
import rahulshettyacademy.pom.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landpage;
    public Checkout checkoutPage;

    public WebDriver initializeDriver() throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
        pro.load(fis);
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : pro.getProperty("browser");

     
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\KD\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            driver = new ChromeDriver();
        }
        return driver;
    }  

	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read jason to string
	String jsonContent =	FileUtils.readFileToString(new File (filePath),
			StandardCharsets.UTF_8);
	
	//String to HashMap Jakson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
    });
	  return data;
	
	
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//extendreports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//extendreports//" + testCaseName + ".png";
		
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException 
	{
		 driver = initializeDriver();

		 landpage =new LandingPage(driver);
		 landpage.goTo();
		return landpage;
	}

//	@Test
//	public Checkout Formfill1() throws IOException 
//	{
//		 driver = initializeDriver();
//
//		 Checkout checkoutPage =new Checkout(driver);
//
//		 checkoutPage.goTocheck();
//
//		return checkoutPage;
//	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	
	}	
	}

