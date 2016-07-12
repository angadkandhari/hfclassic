package CommonData;

/**
 * 
 */

/**
 * @author - Angad Kandhari
 * @author - Bharath K
 * @author - Arun S
 */
public class LocConstSL {

	// LocatorData
	private static String baseURL = "https://angadtesttenmiles.happyfox.com/staff";// text
	private static String loginButton = "/html/body/header/div/div/div[1]/div/div/div/div/ul/li[7]/a";// id
	private static String accountNameTextField = "accountname";// id
	private static String accountNameSubmitButton = "login-btn";// id
	private static String landingPageTitle = "Help Desk Software | Customer Support Software | Support Ticket System";
	private static String accountNameLoginError = "login-error";
	private static String loginError = "";
	private static String accountNameNullError = "helpblock-login nod_msg";
	private static String loginErrorMsg = "&nbsp;&nbsp;Account name does not exist";
	private static String loginNullMsg = "Please enter your account name.";
	private static String staffLoginHeader = "/html/body/form/div[2]/div[2]/div/div/div/div[1]/h3";
	private static String usernameEmailTextBox = "id_username";
	private static String passwordTextBox = "id_password";
	private static String invalidCredentialsMsg = "//*[@id=\"hfsc-bs-callout-invalidcredentials\"]/p";
	private static String staffLoginButton = "/html/body/form/div[2]/div[2]/div/div/div/div[2]/input";
	private static String staffLogoutButton = "logout-link";
	private static String staffRememberMe = "id_remember_me";
	private static String fieldRequiredErrorUserName = "/html/body/form/div[2]/div[2]/div/div/div/div[1]/div/div[1]/ul/li";
	private static String fieldRequiredErrorPassword = "/html/body/form/div[2]/div[2]/div/div/div/div[1]/div/div[3]/ul/li";

	// SetterProperty
	public static String getBaseURL() {
		return baseURL;
	}

	public static String getLoginButton() {
		return loginButton;
	}

	public static String getAccountNameTextField() {
		return accountNameTextField;
	}

	public static String getAccountNameSubmitButton() {
		return accountNameSubmitButton;
	}

	public static String getLandingPageTitle() {
		return landingPageTitle;
	}

	public static String getLoginError() {
		return loginError;
	}

	public static String getAccountNameNullError() {
		return accountNameNullError;
	}

	public static String getAccountNameLoginError() {
		return accountNameLoginError;
	}

	public static String getLoginErrorMsg() {
		return loginErrorMsg;
	}

	public static String getLoginNullMsg() {
		return loginNullMsg;
	}

	public static String getStaffLoginHeader() {
		return staffLoginHeader;
	}

	public static String getUsernameEmailTextBox() {
		return usernameEmailTextBox;
	}

	public static String getPasswordTextBox() {
		return passwordTextBox;
	}

	public static String getStaffLoginButton() {
		return staffLoginButton;
	}

	public static String getStaffLogoutButton() {
		return staffLogoutButton;
	}

	public static String getStaffRememberMe() {
		return staffRememberMe;
	}

	public static String getInvalidCredentialsMsg() {
		return invalidCredentialsMsg;
	}

	public static String getFieldRequiredErrorUserName() {
		return fieldRequiredErrorUserName;
	}

	public static String getFieldRequiredErrorPassword() {
		return fieldRequiredErrorPassword;
	}
}
