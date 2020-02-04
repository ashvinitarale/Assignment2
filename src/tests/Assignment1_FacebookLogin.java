/**
 * 
 */
package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FacebookLoginPage;

/**
 * @author ashvinitarale
 *
 */
public class Assignment1_FacebookLogin {

	public static WebDriver driver;
	public FacebookLoginPage facebookLoginPage = null;
	static String baseurl = "http://www.facebook.com";

	// TO DO : Change username and password below for login
	public String username = " ";
	public String password = " ";
	public String post_msg = "Hello World";

	@BeforeMethod
	public void setUp() {

		// Disable chrome notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Set chrome driver path here
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		driver = new ChromeDriver(options);

		// Page Object
		facebookLoginPage = new FacebookLoginPage(driver);

		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testFacebookLogin() throws InterruptedException {

		// Enter credentials and click on Login Button
		facebookLoginPage.enterUserName(username);
		facebookLoginPage.enterPassword(password);
		facebookLoginPage.clickLoginButton();

		// wait, untill logged in and status box does not appears
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(facebookLoginPage.getStatusBox()));
		
		// Click to enter post
		facebookLoginPage.getStatusBox().click();
		
		// Enter Message
		facebookLoginPage.getPostPopUp().sendKeys(post_msg);
		
		// Click on post button
		facebookLoginPage.getPostButton().click(); Thread.sleep(3000);

		Assert.assertTrue(driver.getPageSource().contains(post_msg), post_msg + " status post has been failed, Failing Test!\n\n");

		System.out.println(post_msg + " status post has been completed, Passing Test!\n\n");

	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			try {

				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, new File("screenshots/" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		driver.quit();

	}

}
