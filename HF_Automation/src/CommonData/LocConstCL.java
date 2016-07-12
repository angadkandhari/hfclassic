package CommonData;

/**
 * 
 */

/**
 * @author - Angad Kandhari
 * @author - Bharath K
 * @author - Arun S
 */
public class LocConstCL {

	// LocatorData
	private static String baseURL = "https://angadtesttenmiles.happyfox.com/";// text
	private static String supportBaseUrl = "https://support.happyfox.com/home";
	private static String loginButton = "/html/body/div[2]/div[3]/div[2]/div[2]/div/div[1]/form/div[5]/button";// id
	private static String accountNameTextField = "accountname";// id
	private static String accountNameSubmitButton = "login-btn";// id
	private static String landingPageTitle = "Help Desk Software | Customer Support Software | Support Ticket System";
	private static String accountNameLoginError = "login-error";
	private static String loginError = "";
	private static String accountNameNullError = "helpblock-login nod_msg";
	private static String loginErrorMsg = "&nbsp;&nbsp;Account name does not exist";
	private static String loginNullMsg = "Please enter your account name.";
	private static String ClientLoginHeader = "/html/body/form/div[2]/div[2]/div/div/div/div[1]/h3";
	private static String usernameEmailTextBox = "id_username";
	private static String passwordTextBox = "id_password";
	private static String invalidCredentialsMsg = "/html/body/form/div[2]/div[2]/div/div/div/div[1]/div/ul/li";
	private static String ClientLoginButton = "/html/body/form/div[2]/div[2]/div/div/div/div[2]/input";
	private static String ClientLogoutButton = "/html/body/div[1]/div[1]/div[1]/div[2]/ul/li[3]/a";
	private static String supportClientLoginButton = "//*[@id=\"hfsc-loginlink\"]/a";
	private static String supportForgotPasswordLink = "//*[@id=\"form\"]/div[5]/a";
	private static String ClientRememberMe = "id_remember_me";
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

	public static String getClientLoginHeader() {
		return ClientLoginHeader;
	}

	public static String getUsernameEmailTextBox() {
		return usernameEmailTextBox;
	}

	public static String getPasswordTextBox() {
		return passwordTextBox;
	}

	public static String getClientLoginButton() {
		return ClientLoginButton;
	}

	public static String getClientLogoutButton() {
		return ClientLogoutButton;
	}

	public static String getClientRememberMe() {
		return ClientRememberMe;
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

	public static String getSupportBaseUrl() {
		return supportBaseUrl;
	}

	public static void setSupportBaseUrl(String supportBaseUrl) {
		LocConstCL.supportBaseUrl = supportBaseUrl;
	}

	public static String getSupportClientLoginButton() {
		return supportClientLoginButton;
	}

	public static void setSupportClientLoginButton(String supportClientLoginButton) {
		LocConstCL.supportClientLoginButton = supportClientLoginButton;
	}

	public static String getSupportForgotPasswordLink() {
		return supportForgotPasswordLink;
	}

	public static void setSupportForgotPasswordLink(String supportForgotPasswordLink) {
		LocConstCL.supportForgotPasswordLink = supportForgotPasswordLink;
	}

}
