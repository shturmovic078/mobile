package parallel.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCase {

  private WebDriver driver;
  public String name;
  public String local=(new java.io.File("").getAbsolutePath());
  @BeforeClass
  @org.testng.annotations.Parameters(value={"browser","version","platform"})
  public void setUp(String browser, String version, String platform) throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("platform",platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("browserVersion", version);
    capability.setCapability("browserstack.local", "true");
    capability.setCapability("project", "P1");
    capability.setCapability("build", "1.0");
    driver = new RemoteWebDriver(
      new URL("https://zaqwsx1:Fs54nwmULt7BaSTosZxi@hub.browserstack.com/wd/hub"),
      capability);
    name=(capability.getBrowserName());
  }

  @Test
  public void testSimple() throws Exception {
	  driver.get(System.getProperty("BrandUrl"));
	 
    System.out.println("Page title is: " + driver.getTitle());
    System.out.println("Browser is: " + name);
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File(name + "_Screenshot.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
  }
}
