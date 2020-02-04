/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ashvinitarale
 *
 */
public class WalletHubReviewPage {

	public WalletHubReviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Login')]")
	private WebElement loginlink;

	@FindBy(how = How.XPATH, using = "//input[@type='text' and contains(@placeholder,'Email')]")
	private WebElement user_email_id;

	@FindBy(how = How.XPATH, using = "//input[@type='password' and contains(@placeholder,'Password')]")
	private WebElement passwd;

	@FindBy(how = How.XPATH, using = "//button//span[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(how = How.CLASS_NAME, using = "rating-box-wrapper")
	private WebElement review_stars;

	@FindBy(how = How.XPATH, using = "//a[contains(@data-target,'Health')]")
	private WebElement healthoption;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Write your review...']")
	private WebElement policyReview;

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Your review has been posted.')]")
	private WebElement confirmationText;

	@FindBy(how = How.XPATH, using = "//div[@class='btn rvc-continue-btn']")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//review-star[@class='rvs-svg']")
	private WebElement ratingSection;

	@FindBy(how = How.XPATH, using = "//review-star[@class='rvs-svg']/div/*[1]")
	private WebElement review_first_Star;

	@FindBy(how = How.XPATH, using = "//review-star[@class='rvs-svg']/div/*[2]")
	private WebElement review_second_Star;

	@FindBy(how = How.XPATH, using = "//review-star[@class='rvs-svg']/div/*[3]")
	private WebElement review_third_Star;

	@FindBy(how = How.XPATH, using = "//review-star[@class='rvs-svg']/div/*[4]")
	private WebElement review_fourth_Star;

	@FindBy(how = How.XPATH, using = "//review-star[@class='rvs-svg']/div/*[5]")
	private WebElement review_fifth_Star;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select...')]")
	private WebElement policyDropDown;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Health Insurance')]")
	private WebElement policyValue;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Submit')]")
	private WebElement reviewSubmitButton;

	// Click on Login link
	public void clickOnLoginLink() {
		loginlink.click();
	}

	// Enter email id
	public void enterUserName(String email) {
		user_email_id.sendKeys(email);
	}

	// Enter password
	public void enterPassword(String password) {
		passwd.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public WebElement getReviewStar() {
		return review_stars;
	}

	public WebElement getRatingSection() {
		return ratingSection;
	}

	public void selectPolicyDropDown(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(policyDropDown));
		policyDropDown.click();
		Thread.sleep(2000);
	}

	public void selectHealthOption() throws InterruptedException {
		healthoption.click();
		Thread.sleep(2000);
	}

	public WebElement getconfirmationText() {
		return confirmationText;
	}

	/**
	 * @return the review_first_Star
	 */
	public WebElement getReview_first_Star() {
		return review_first_Star;
	}

	/**
	 * @return the review_second_Star
	 */
	public WebElement getReview_second_Star() {
		return review_second_Star;
	}

	/**
	 * @return the review_third_Star
	 */
	public WebElement getReview_third_Star() {
		return review_third_Star;
	}

	/**
	 * @return the review_fourth_Star
	 */
	public WebElement getReview_fourth_Star() {
		return review_fourth_Star;
	}

	/**
	 * @return the review_fifth_Star
	 */
	public WebElement getReview_fifth_Star() {
		return review_fifth_Star;
	}

	/**
	 * @return the policyDropDown
	 */
	public WebElement getPolicyDropDown() {
		return policyDropDown;
	}

	/**
	 * @return the policyValue
	 */
	public WebElement getPolicyValue() {
		return policyValue;
	}

	/**
	 * @return the policyReview
	 */
	public WebElement getPolicyReview() {
		return policyReview;
	}

	/**
	 * @return the reviewSubmitButton
	 */
	public WebElement getReviewSubmitButton() {
		return reviewSubmitButton;
	}

}
