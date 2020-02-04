/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ashvinitarale
 *
 */
public class FacebookLoginPage {
	
	public FacebookLoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "email") 
	private WebElement loginEmailId;
	
	@FindBy(how = How.ID, using = "pass") 
	private WebElement fbpassword;
	
	@FindBy(how = How.ID, using = "loginbutton") 
	private WebElement loginbutton;
	
	@FindBy(how = How.LINK_TEXT, using = "Home") 
	private WebElement homeLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='pagelet_composer']") 
	private WebElement status_box;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1mf _1mj']")
	private WebElement postPopUp;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Post')]")
	private WebElement postButton;
		
	public void enterUserName(String email){
		loginEmailId.sendKeys(email);		
	}
	
	public void enterPassword(String password) {
		fbpassword.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginbutton.click();
	}
	
	public WebElement getHomeLink() {
		return homeLink;
	}
	
	public WebElement getStatusBox() {
		return status_box;
	}
	
	public WebElement getPostButton() {
		return postButton;
	}
	
	public WebElement getPostPopUp() {
		return postPopUp;
	}

}
