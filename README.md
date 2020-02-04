# WalletHub-Assignment
WalletHub initial Screening Test

Completed with Selenium + TestNG, Used Page Object Model to increase code reusability Tested on Chrome as maven project

How to run it (<b>Tested on Mac only</b>)

<ul><li>Install: java jdk 1.8, chrome latest version</li>
  <li>Used eclipse for development</li>
	<li>git clone</li>
	<li>Build module WalletHubAssignment with Maven</li>
	<li>Resolve TODO (insert credentials for login/pass in tests class)</li></ul>

public class Facebooklogin {

	public static WebDriver driver;
	public FacebookLoginPage facebookLoginPage = null;
	static String baseurl = "http://www.facebook.com";

	// Change username and password below for login
	public String username = " ";
	public String password = " ";
	public String post_msg = "Hello World";

	public class Assignment2_WalletHubReview {

	public static WebDriver driver;
	public WalletHubReviewPage walletHubReviewPage;
	public WalletHubProfilePage walletHubProfilePage;

	static String baseurl = "https://wallethub.com/join/light";
	static String review_url = "http://wallethub.com/profile/test_insurance_company/";

	// Change username in below URL
	static String review_verification_url = "https://wallethub.com/profile/username";

	// change username and password here for login
	String username = " ";
	String password = " ";

<ul><li>Use testng.xml to run testscript or Run Assignment1_FacebookLogin or Assignment1_FacebookLogin testscript with TestNG</li></ul>
