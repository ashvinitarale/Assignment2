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
public class WalletHubProfilePage {

	public WalletHubProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Test Insurance Company')]")
	private WebElement recomadation;

	public WebElement getRecomadation() {
		return recomadation;
	}

}
