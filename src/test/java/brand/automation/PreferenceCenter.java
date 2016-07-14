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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class PreferenceCenter {
	
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

	  @BeforeTest
	  public void beforeClass(String browser) throws IOException, InterruptedException
	  {	   
			browser = System.getProperty("Browser");
			System.out.println("The Browser is  " +browser);
		  
		  
		  
		 if (browser.equals("windows7IE11")) {
			  driver=windows7IE11();
			 
			}
		 else if (browser.equals("iPadMini")){
			 driver=iPadMini();
		 }
		 else if (browser.equals("windows7Firefox46")){
			 driver=windows7Firefox46();
		 }
		 
		 else if (browser.equals("windows7Chrome49")){
			 driver=windows7Firefox46();
		 }
		 else if (browser.equals("safari9")){
			 driver=safari9();
		 }
		}

		public WebDriver safari9() throws MalformedURLException  
		 {  
		  
			 System.out.println("Let me run in Safari");
			 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("browser", "Safari");
			 caps.setCapability("browser_version", "9.0");
			 caps.setCapability("os", "OS X");
			 caps.setCapability("os_version", "El Capitan");
			 caps.setCapability("resolution", "1024x768");
			 caps.setCapability("browserstack.debug", "true");
			 caps.setCapability("browserstack.local", "true");
			 caps.setCapability("browserstack.selenium_version", "2.47.1");
			 caps.setCapability("acceptSslCerts", "true");
			  driver = new RemoteWebDriver(new URL(URL), caps);
		      browser="windows7IE10";
		      driver.get(System.getProperty("BrandUrl"));
		      brand = System.getProperty("Brand");
		  

		  	System.out.println("The String is " +brand);
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      return driver;
		   
		    
		      
		 } 
		
		public WebDriver windows7IE11() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in Windows 7 IE11");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "11.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.local", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="windows7IE10";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("The String is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      return driver;
	   
	    
	      
	 } 
		
		public WebDriver windows7Chrome49() throws MalformedURLException  
		 {  
		  
			 System.out.println("Let me run in Windows 7 Chrome 49");
			 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("browser", "Chrome");
			 caps.setCapability("browser_version", "49.0");
			 caps.setCapability("os", "Windows");
			 caps.setCapability("os_version", "7");
			 caps.setCapability("resolution", "1024x768");
			 caps.setCapability("browserstack.debug", "true");
			 caps.setCapability("browserstack.local", "true");
			 caps.setCapability("browserstack.selenium_version", "2.47.1");
			 caps.setCapability("acceptSslCerts", "true");
			  driver = new RemoteWebDriver(new URL(URL), caps);
		      browser="windows7IE10";
		      driver.get(System.getProperty("BrandUrl"));
		      brand = System.getProperty("Brand");
		  

		  	System.out.println("The String is " +brand);
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      return driver;
		   
		    
		      
		 } 
		
		public WebDriver windows7Firefox46() throws MalformedURLException  
		 {  
		  
			 System.out.println("Let me run in Windows 7 Firefox 46");
			 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("browser", "Firefox");
			 caps.setCapability("browser_version", "45.0");
			 caps.setCapability("os", "Windows");
			 caps.setCapability("os_version", "7");
			 caps.setCapability("resolution", "1024x768");
			 caps.setCapability("browserstack.debug", "true");
			 caps.setCapability("browserstack.local", "true");
			 caps.setCapability("browserstack.selenium_version", "2.47.1");
			 caps.setCapability("acceptSslCerts", "true");
			  driver = new RemoteWebDriver(new URL(URL), caps);
		      browser="windows7IE10";
		      driver.get(System.getProperty("BrandUrl"));
		      brand = System.getProperty("Brand");
		  

		  	System.out.println("The String is " +brand);
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      return driver;
		   
		    
		      
		 } 
		
		

		public WebDriver iPadMini() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in iPad Mini");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "iPad");
		 caps.setCapability("platform", "MAC");
		 caps.setCapability("device", "iPad Mini 2");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		 caps.setCapability("browserstack.local", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="iPadMini";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("The String is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      return driver;
	   
	    
	      
	 } 
		
	  
	  @Test(priority=1)
	  public void invalidLogin() throws IOException, InterruptedException{
		   name= "invalid_login.png";
	  	System.out.println("Let me click on login");
	   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
	   driver.findElement(By.className("event_profile_login")).click();
	   
	  
	   
	   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
	  driver.findElement(By.id("phdesktopbody_0_username")).clear();
	  driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("puck2stick@gma22il.com");
	  driver.findElement(By.id("phdesktopbody_0_password")).clear();
	  driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("zaq12wsx");
	  driver.findElement(By.id("phdesktopbody_0_submit")).click();

	  id="phdesktopbody_0_Message";
	  actualText=driver.findElement(By.id(id)).getText();
	  actual="The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  assertText();
     takeScreenshot(name);
	  
	  }
	  
	  @Test(priority=2)
	  public void validLogin() throws IOException{
		    name= "valid_login.png";
		 
		  System.out.println("Let me check on valid login");
		   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		   driver.findElements(By.className("event_profile_login"));

		  driver.findElement(By.id("phdesktopbody_0_username")).clear();
		  driver.findElement(By.id("phdesktopbody_0_username")).sendKeys("albert.golubev@pkt.com");
		  driver.findElement(By.id("phdesktopbody_0_password")).clear();
		  driver.findElement(By.id("phdesktopbody_0_password")).sendKeys("zaq12wsx");
		  driver.findElement(By.id("phdesktopbody_0_submit")).click();

		  id="phdesktopbody_0_lblDOBValue";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="12/1962";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
		  
	  }
	  
	 
	  @Test(priority=3)
	  public void resetPassword() throws IOException{
		  
		    name= "invalid_reset_password.png";
		  System.out.println("Let me reset password");
		  driver.findElement(By.id("phdesktopbody_0_HlinkEdit")).click();
		   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
			  driver.findElement(By.id("phdesktopbody_0_HlinkReset")).click();
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 
		 

		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.findElement(By.name("phdesktopbody_0$username")).clear();
		  driver.findElement(By.name("phdesktopbody_0$username")).sendKeys("asfsaf2qao@sdasd.com");
		  driver.findElement(By.name("phdesktopbody_0$zipcode")).clear();
		  driver.findElement(By.name("phdesktopbody_0$zipcode")).sendKeys("11235");
		  driver.findElement(By.name("phdesktopbody_0$LoginSubmitBtn")).click();
		  
		  id="phdesktopbody_0_Message";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="We could not find an account with that Email address and Birthday/ZIP code.";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	        name= "valid_reset_password.png";
	      driver.findElement(By.name("phdesktopbody_0$username")).clear();
		  driver.findElement(By.name("phdesktopbody_0$username")).sendKeys("albert.golubev@pkt.com");
		  driver.findElement(By.name("phdesktopbody_0$zipcode")).clear();
		  driver.findElement(By.name("phdesktopbody_0$zipcode")).sendKeys("11235");
		  driver.findElement(By.name("phdesktopbody_0$LoginSubmitBtn")).click();
		  
		  id="phdesktopbody_0_Header";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Set Password";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	     
	  
	  }
	  
	  @Test(priority=4)
	  public void setPassword() throws IOException{
		  
		    name= "set_password.png";
		  System.out.println("Let me reset set password");
		   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		 
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		  driver.findElement(By.name("phdesktopbody_0$showpassword")).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  driver.findElement(By.name("phdesktopbody_0$password")).clear();
		  driver.findElement(By.name("phdesktopbody_0$password")).sendKeys("alb");
		  driver.findElement(By.name("phdesktopbody_0$ResetSubmitBtn")).click();
		  
		  id="phdesktopbody_0_revpassword";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="The password must be minimum 8 characters, including at least 1 letter and 1 number.";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	        name= "valid_set_password.png";
	        
	        id="phdesktopbody_0_revpassword";
			  actualText=driver.findElement(By.id(id)).getText();
			  actual="The password must be minimum 8 characters, including at least 1 letter and 1 number.";
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  assertText();
		      takeScreenshot(name);
		        name= "blank_password.png";
		        driver.findElement(By.name("phdesktopbody_0$password")).sendKeys("");
				  driver.findElement(By.name("phdesktopbody_0$ResetSubmitBtn")).click();
				  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        id="phdesktopbody_0_revpassword";
				  actualText=driver.findElement(By.id(id)).getText();
				  actual="This is a mandatory field.";
				 
				  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				  assertText();
			      takeScreenshot(name);
			        name= "valid_set_password.png";
			        
			        
	      driver.findElement(By.name("phdesktopbody_0$password")).clear();
		  driver.findElement(By.name("phdesktopbody_0$password")).sendKeys("zaq12wsx");
		  driver.findElement(By.name("phdesktopbody_0$ResetSubmitBtn")).click();
		  id="phdesktopbody_0_Header";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Your Password Has Been Reset";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	       name= "after_reset_password.png";
	       
	     
	      driver.findElement(By.name("phdesktopbody_0$username")).sendKeys("albert.golubev@pkt.com");
		  driver.findElement(By.name("phdesktopbody_0$password")).clear();
		  driver.findElement(By.name("phdesktopbody_0$password")).sendKeys("zaq12wsx");
		  driver.findElement(By.name("phdesktopbody_0$submit")).click();

		  id="phdesktopbody_0_labelDOB";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Birthday";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	     
	  
	  }
	  @Test(priority=5)
	  public void loginAndLogout() throws IOException{
		  
		  driver.findElement(By.className("logoutbtn")).click();
		

		  id="phdesktopheader_0_phdesktopheadertop_2_anchrContinue";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="LOG OUT";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	  
	  }
	  public WebDriver takeScreenshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		 
		    
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

	 public void assertText()
	 {
	 	 System.out.println("Assert that the text is present " +actual);
		  
	 	softAssert.assertEquals(actualText,actual,"Failed to assert an element");
		




	 }


	}



