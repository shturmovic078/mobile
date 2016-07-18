package brand.automation;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SearchContent {
	
	private static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	 
	 
	  public String browser;
	  public String folder = "screenshots";
	  public String fail,error,url,name,actualText,id,actual,brand;
	 

		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    int counter=1;
		String local=(new java.io.File("").getAbsolutePath());
		String myTitle;

		@Parameters({"browser"})

	  @BeforeClass
	  public void beforeClass(String browser) throws IOException, InterruptedException
	  {	   
		  
		  
		  
		  
		  
		 if (browser.equals("browserIE11")) {
			  driver=browserIE11();
			 
			}
		 
		}

		public WebDriver browserIE11() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in BrowserIE11");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "11.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="browserIE11";
	      driver.get(System.getProperty("BrandUrl"));
	      //brand = System.getProperty("Brand");
	      brand = System.getProperty("Brand");

	  	System.out.println("The String is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      return driver;
	   
	    
	      
	 } 
		

	
	  
	  @Test(priority=1)
	  public void searchContent() throws IOException, InterruptedException{
		   name=""+ folder+"/" + brand +"_"+ browser +"_" + "product_list.png";
	  	System.out.println("Let me click on Register");
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   
	   
	   driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		  Thread.sleep(1000);
		  driver.findElement(By.id("phdesktopbody_0_phdesktopproductresults_0_imgListViewIcon")).click();
		  name=""+ System.getProperty("Browser")+"/" + "grid view" +"_"+ timeStamp + ".png";
		    takeScreenshot(name); 
		    
		  driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		  Thread.sleep(1000);
		  driver.findElement(By.id("phdesktopbody_0_phdesktoptabheader_0_anchorContentResult")).click();
		  name=""+ System.getProperty("Browser")+"/" + "content" +"_"+ timeStamp + ".png";
		    takeScreenshot(name); 
	  } 
	   
	  public WebDriver takeScreenshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshots " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		 
		    
		    
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

	 public void assertText()
	 {
	 	 System.out.println("Assert that the text is present " +actual);
		  
	 	softAssert.assertEquals(actualText,actual,"Failed to assert an element");
		




	 }


	}


