package appium.mobile;

import org.testng.annotations.Test;
import java.io.IOException;

public class ValidLogin extends LoginTestCase {
	public String browser="chrome";
	public String folder = "screenshots";
	public String fail,error,url;
	public String name;
	public String brand;	

	@Test
	public void invalidLogin() throws IOException, InterruptedException {

		System.out.println("Let me look at valid login");

		loginUser("albert.golubev@pkt.com", "zaq12wsx");
		waitForClickable("phsmartphonebody_0_labelvaluegrs_consumer[firstname]");
		softAssertText("Konstantin-Alexander", "phsmartphonebody_0_labelvaluegrs_consumer[firstname]");

		takeScreenshot("valid_login.png");

	}
}