package appium.mobile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ForgotPassword extends LoginTestCase{
	public String browser="chrome";
	public String folder = "screenshots";
	public String fail,error,url;
	public String name;
	public String brand;	

	@Test
	public void invalidLogin() throws IOException, InterruptedException {

		System.out.println("Let me Reset my password");

		clickForgotPassword();

		softAssertText("Fields marked with * are mandatory. Please complete all mandatory fields and re-submit.", "phsmartphonebody_0_Message");

		waitElementsToAppear(65);

		takeScreenshot("forgot_password.png");

		enterForgotPasswordConfirmationScreen("albert.golubev@pkt.com","11235");

		waitElementsToAppear(15);

		softAssertText("Password", "phsmartphonebody_0_password");

		takeScreenshot("valid_reset_password.png");

		System.out.println("Let me reset set password");

		waitElementsToAppear(25);

		driver.findElement(By.name("phsmartphonebody_0$showpassword")).click();

		waitElementsToAppear(15);

		resetPassword("alb");

		softAssertText("The password must be minimum 8 characters, including at least 1 letter and 1 number.", "phsmartphonebody_0_revpassword");

		takeScreenshot("set_password.png");

		resetPassword("zaq12wsx");

		softAssertText("Your Password Has Been Reset","phsmartphonebody_0_Header");

		takeScreenshot("valid_set_password.png");


		loginUser("albert.golubev@pkt.com","zaq12wsx");

		waitForClickable("phsmartphonebody_0_labelvaluegrs_consumer[firstname]");

		waitElementsToAppear(120);
		softAssertText("Konstantin-Alexander", "phsmartphonebody_0_labelvaluegrs_consumer[firstname]");

		waitElementsToAppear(65);

		takeScreenshot("logged_in.png");
	}

	private void enterForgotPasswordConfirmationScreen(String userName, String zipCode) {
		driver.findElement(By.name("phsmartphonebody_0$username")).clear();
		driver.findElement(By.name("phsmartphonebody_0$username")).sendKeys(userName);
		driver.findElement(By.name("phsmartphonebody_0$zipcode")).clear();
		driver.findElement(By.name("phsmartphonebody_0$zipcode")).sendKeys(zipCode);
		driver.findElement(By.name("phsmartphonebody_0$LoginSubmitBtn")).click();
	}




	private void clickForgotPassword()
	{
		driver.findElement(By.className("icon-pics")).click();

		 WebDriverWait wait = new WebDriverWait(driver, 35);
		   WebElement element = wait.until(ExpectedConditions.elementToBeClickable((By.className("event_profile_login"))));
		   driver.findElement(By.className("event_profile_login")).click();
		waitElementsToAppear(10);

		driver.findElement(By.id("phsmartphonebody_0_forgotpassword")).click();
		waitElementsToAppear(40);
		driver.findElement(By.id("phsmartphonebody_0_LoginSubmitBtn")).click();

		waitElementsToAppear(120);
	}


	private void resetPassword(String newPassword){
		driver.findElement(By.name("phsmartphonebody_0$password")).clear();
		driver.findElement(By.name("phsmartphonebody_0$password")).sendKeys(newPassword);
		driver.findElement(By.name("phsmartphonebody_0$ResetSubmitBtn")).click();

		waitElementsToAppear(15);
	}

}