/**
 * 
 */
package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.WalletHubProfilePage;
import pages.WalletHubReviewPage;

/**
 * @author ashvinitarale
 *
 */
public class Assignment2_WalletHubReview {

	public static WebDriver driver;
	public WalletHubReviewPage walletHubReviewPage;
	public WalletHubProfilePage walletHubProfilePage;

	static String baseurl = "https://wallethub.com/join/light";
	static String review_url = "http://wallethub.com/profile/test_insurance_company/";

	// TO DO : Change username in below URL
	static String review_verification_url = "https://wallethub.com/profile/username";

	// TO DO : Change username and password here for login
	String username = " ";
	String password = " ";

	@BeforeMethod
	public void setup() {
		
		// Disable chrome notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Set chrome driver path here
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		driver = new ChromeDriver(options);

		// Page object
		walletHubReviewPage = new WalletHubReviewPage(driver);
		walletHubProfilePage = new WalletHubProfilePage(driver);

		// Open URL
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void CanPostReviewOnWalletHub() throws InterruptedException {

		// Clicking on Login link, enter credentials and log in
		walletHubReviewPage.clickOnLoginLink();
		Thread.sleep(2000);

		walletHubReviewPage.enterUserName(username); Thread.sleep(2000);

		walletHubReviewPage.enterPassword(password); Thread.sleep(2000);

		// Logging in to application
		walletHubReviewPage.clickOnLoginButton(); Thread.sleep(5000);

		// Routing to action url
		driver.navigate().to(review_url);

		// This will scroll the page till the rating section
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", walletHubReviewPage.getRatingSection());

		// Hover over ratings panel to expose ratings stars
		new Actions(driver).moveToElement(walletHubReviewPage.getReview_first_Star()).perform(); Thread.sleep(1000);

		new Actions(driver).moveToElement(walletHubReviewPage.getReview_second_Star()).perform(); Thread.sleep(1000);

		new Actions(driver).moveToElement(walletHubReviewPage.getReview_third_Star()).perform(); Thread.sleep(1000);

		new Actions(driver).moveToElement(walletHubReviewPage.getReview_fourth_Star()).perform(); Thread.sleep(1000);

		new Actions(driver).moveToElement(walletHubReviewPage.getReview_fifth_Star()).perform(); Thread.sleep(1000);

		// click fourth rating star
		walletHubReviewPage.getReview_fourth_Star().click();

		// Click on policy drop down
		walletHubReviewPage.getPolicyDropDown().click();

		// Select "Health Insurance" from policy Drop Down
		new Actions(driver).moveToElement(walletHubReviewPage.getPolicyValue()).click().build().perform();

		// Post review comment
		String reviewmsg = "";

		for (int i = 0; i < 15; i++) {
			reviewmsg += " Add review";
		}

		walletHubReviewPage.getPolicyReview().sendKeys(reviewmsg);
		walletHubReviewPage.getReviewSubmitButton().click();

		// Check confirmation
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(walletHubReviewPage.getconfirmationText()));

		// Check on profile page to see if posted review exist
		driver.navigate().to(review_verification_url);
		Assert.assertNotNull(walletHubProfilePage.getRecomadation());
		System.out.println("Test Pass : Posted review is showing in profile page");

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
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("screenshots/" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		driver.quit();

	}
}
