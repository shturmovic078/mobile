package appium.mobile;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class QuickView {
	
	protected static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public String tmp;
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  public static String browser;
	public String brand;
	public static String name;
	public static int counter=1;
	public static int variant=1;

 
	private boolean existsElement(String id) {
	    try {
	        driver.findElement(By.id(id));
	    } catch (NoSuchElementException e) {
	    	 
	        return false;
	       
	    }
	    return true;
	}

  public static void getQuick(String typeProduct, String quickView) throws InterruptedException, IOException
  {
	  System.out.println("Let me look at Quick View from Search Page");
	  driver.get(System.getProperty("BrandUrl"));

		//*[@id="phdesktopbody_0_phdesktopproductresults_1_RptrProductList_imgProducts_1"]

	      WebElement element = driver.findElement(By.id(typeProduct));
	      Actions action = new Actions(driver);
	      
	    //*[@id="phdesktopbody_0_phdesktopproductresults_1_RptrProductList_imgProducts_0"]
	      action.moveToElement(element).perform();
	      
	      driver.manage().timeouts().implicitlyWait(45000, TimeUnit.SECONDS);	
	      driver.findElement(By.id(quickView)).click();
	      Thread.sleep(5000);
	      
	      name=""+ browser+"/" + "loaded" +"_"+ "1st quickview" + ".png";
	      
	      takeScreeshot(name); 
  }
  
  public Boolean checkElement(String productPackVariation)
  {
	  try {
	        return driver.findElement(By.id(productPackVariation)).isDisplayed();
	      }
	  
	 catch (      NoSuchElementException ignored) {
	        return false;
	      }
	catch (      StaleElementReferenceException ignored) {
	        return false;
	      }
	  
	  
	 
	  
  }
  
  public static void variantName(String productPackSize, String productPackVariation ) throws InterruptedException, IOException {
	  
	  System.out.println("Let me look at the drop down");
	  
	  
	  
	  WebElement pack_size=driver.findElement(By.id(productPackSize));
	  List<WebElement> pack  = pack_size.findElements(By.tagName("option"));
	  
	  for(int i=pack.size();i>0;i--)
	 // for(int i=0;i<pack.size();i++)
	  {   
		  
		  String value = pack.get(i-1).getText();
	
		  System.out.println("For Pack Size#" +counter +" " +value);
		
		  new Select(driver.findElement(By.id(productPackSize))).selectByVisibleText(value);
		  counter+=1;
		  Thread.sleep(5000);
		  boolean anotherName=true;
		  String quickProduct =driver.findElement(By.className("popup-product-title")).getText(); 
		  if (driver.getPageSource().contains(productPackVariation))
		  {
			  WebElement pack_variation=driver.findElement(By.id(productPackVariation));
			  Dimension dropDown = pack_variation.getSize();
			
			  List<WebElement> variation  = pack_variation.findElements(By.tagName("option"));
			  for(int j=variation.size();j>0;j--)
					
			  {   
				 
				  
				  String value2 = variation.get(j-1).getText();
				  System.out.println("Variation #" + variant +" " +value2);
				  
				  
				  new Select(driver.findElement(By.id(productPackVariation))).selectByIndex(j-1);
				  
				  
				 
				  
				  
				  name=""+ browser+"/" +quickProduct + "_" + value +"_"+ value2 + ".png";
				  Thread.sleep(1000);
				  takeScreeshot(name);
				  variant+=1;
				  if (variant==variation.size()-1)
				  {
					  variant=1;
					  break;
				  }
				  
				
				  
				  
			  }
			 
			  
		  }
		  
		  else
			  
		  {
			  name=""+ browser+"/" + quickProduct + "_" + value +"_"+ ".png";
			  Thread.sleep(1000);
			  takeScreeshot(name);
			  anotherName=false;
		  }
			  
			  
		  
		  
		 
		  
		
	  }
	  
  }
  


  // Reads and returns field

  
  @BeforeMethod
  @BeforeTest
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  
	  System.out.println("Let me run in Firefox");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "43.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.local", "true");
		 caps.setCapability("browserstack.selenium_version", "2.48.2");
		 //caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="Firefox42";
	      
	     

	  	System.out.println("The brand is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      driver.manage().window().maximize();
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }
  
  public static WebDriver takeScreeshot(String name) throws IOException
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

}

