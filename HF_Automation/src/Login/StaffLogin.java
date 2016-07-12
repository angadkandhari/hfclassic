package Login;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonData.LocConstSL;
import CommonData.TestDataSL;
import TestRailBinding.APIClient;
import TestRailBinding.APIException;

/**
 * This section deals with the test coverage of Login Scenarios on HappyFox WebApp
 */

/**
 * @author Angad Kandhari
 * @author Bharath K
 * @author Arun S
 */

public class StaffLogin {

	private static ChromeDriver _driver;
	WebElement element;
	public static APIClient apiHandle = new APIClient(TestDataSL.getTestRailBaseUrl());

	@BeforeClass
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void createTestRunForTestRail() {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		apiHandle.setUser(TestDataSL.getTestRailUser());
		apiHandle.setPassword(TestDataSL.getTestRailPassword());

		Map data = new HashMap();
		data.put("suite_id", new Integer(1));
		data.put("name", "This is a new Test Run forked from HFA Framework on " + ft.format(dNow));
		data.put("assignedto_id", new Integer(8));
		data.put("include_all", false);
		data.put("case_ids", TestDataSL.getTestCaseIds());

		// for (int i = 0; i < TestData.getTestCaseIds().size(); i++) {
		// System.out.println(String.valueOf(TestData.getTestCaseIds().get(i)));
		// }
		System.out.println("Date set created and ready to be passed to the API request" + data.toString());

		try {
			JSONObject r = (JSONObject) apiHandle.sendPost("add_run/" + TestDataSL.getTestRailProjectId(), data);

			System.out.println("Test Run Created :" + r.get("id"));
			TestDataSL.setTestRailRunId(r.get("id"));
		} catch (IOException | APIException e) {
			e.printStackTrace();
			fail("something went worng");
		}

	}

	public static void openBrowser() {

		try {
			_driver = new ChromeDriver();
			_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			_driver.manage().deleteAllCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cleanUpTestInstance() {

		_driver.manage().deleteAllCookies();
		_driver.quit();
	}

	/**
	 * This section holds helper methods for providing maintainability and
	 * granularity
	 */
	public void failThis() {
		fail("Something is not quite right");
	}

	public void NavigateToLoginPage() {
		// Navigating to HFC WebApp
		_driver.get(LocConstSL.getBaseURL());
		_driver.manage().window().maximize();
		System.out.println("Happyfox WebApp Launched");
		_driver.getTitle();
		// Invoking login
	}

	public void InvokeStaffLogin(String LoginId, String Password) {

		System.out.println("Feeding credentials to the login page");
		_driver.findElement(By.id(LocConstSL.getUsernameEmailTextBox())).clear();
		_driver.findElement(By.id(LocConstSL.getUsernameEmailTextBox())).sendKeys(LoginId);
		_driver.findElement(By.id(LocConstSL.getPasswordTextBox())).clear();
		_driver.findElement(By.id(LocConstSL.getPasswordTextBox())).sendKeys(Password);
		if (_driver.findElement(By.id(LocConstSL.getStaffRememberMe())).isSelected())
			_driver.findElement(By.id(LocConstSL.getStaffRememberMe())).click();
		System.out.println("Invoking login");
		_driver.findElement(By.xpath(LocConstSL.getStaffLoginButton())).click();

	}

	public void InvokeStaffLogOut() {
		WebElement logoutLink = (new WebDriverWait(_driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(LocConstSL.getStaffLogoutButton())));
		System.out.println("login complete");
		System.out.println("Invoking logout");
		logoutLink.click();
		System.out.println("Logout complete");
	}

	public void ValidateLoginErrorMessage() {

		System.out.println("Invalid login credentials message validation in progress");
		WebElement inValidCredsError = (new WebDriverWait(_driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocConstSL.getInvalidCredentialsMsg())));

		if (inValidCredsError.isDisplayed()) {
			System.out.println("Error message validation complete");

		} else {
			System.out.println("Assertion failed");
			failThis();
		}
	}

	public void ValidateNullLoginErrorMessage() {
		System.out.println("Invalid login credentials message validation in progress");
		WebElement nullCredsError = (new WebDriverWait(_driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(LocConstSL.getFieldRequiredErrorUserName())));

		if (nullCredsError.isDisplayed()) {
			System.out.println("Error message validation complete");

		} else {
			System.out.println("Assertion failed");
			failThis();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void FeedResultsIntoTestRail(Integer tc_id) {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		apiHandle.setUser(TestDataSL.getTestRailUser());
		apiHandle.setPassword(TestDataSL.getTestRailPassword());
		Map data = new HashMap();
		data.put("status_id", new Integer(1));
		data.put("comment", "Comment added via HFA Test Framework Run on" + ft.format(dNow).toString() + " \n\n"
				+ "This test worked fine!");
		try {
			System.out.println(TestDataSL.getTestRailRunId());
			JSONObject r = (JSONObject) apiHandle.sendPost(
					"add_result_for_case/" + TestDataSL.getTestRailRunId() + "/" + tc_id.toString().trim(), data);
		}

		catch (IOException | APIException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void FeedResultsIntoTestRail(Integer tc_id, String ErrMsg) {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		apiHandle.setUser(TestDataSL.getTestRailUser());
		apiHandle.setPassword(TestDataSL.getTestRailPassword());
		Map data = new HashMap();
		data.put("status_id", new Integer(5));
		data.put("comment", "Comment added via HFA Test Framework Run on \n\n" + ft.format(dNow).toString()
				+ "\n\nThis test failed due to the following reason/exception!\n\n " + ErrMsg);
		try {
			System.out.println(TestDataSL.getTestRailRunId());
			JSONObject r = (JSONObject) apiHandle.sendPost(
					"add_result_for_case/" + TestDataSL.getTestRailRunId() + "/" + tc_id.toString().trim(), data);

		} catch (IOException | APIException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This section holds Test Methods for StaffLogin Scenarios
	 * 
	 * @throws APIException
	 * @throws IOException
	 * @throws MalformedURLException
	 */

	@Test
	// user attempts to login with valid credentials
	// Corresponds to TestCase C5 in TestRail
	public void Ord01_ValidateStaffLoginWithValidUserName() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid UserName and valid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestUserNameValid(), TestDataSL.getTestAccountValidPassword());
			// Invoke logout to kill Staff session
			InvokeStaffLogOut();
			// Invoke Test Rail API and transfer results
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(1));
		} catch (Exception e) {
			// Pass the captured exception message to be fed into TestRail
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(1), e.getMessage().toString());
			failThis();
		} finally {
			cleanUpTestInstance();
		}
	}

	@Test
	// user attempts to login with valid credentials
	// Corresponds to TestCase C6 in TestRail
	public void Ord02_ValidateStaffLoginWithValidEmail() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and valid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestEmailValid(), TestDataSL.getTestAccountValidPassword());
			// Invoke logout to kill Staff session
			InvokeStaffLogOut();

			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(2));
		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(2), e.getMessage().toString());
			failThis();
		}

		finally {
			cleanUpTestInstance();
		}

	}

	@Test
	// user attempts to login with bad credentials
	// Corresponds to TestCase C27 in TestRail
	public void Ord03_ValidateStaffLoginWithValidUserNameInvalidPassword() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and Invalid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestEmailValid(), TestDataSL.getTestAccountInValidPassword());
			// Validate error message
			ValidateLoginErrorMessage();

			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(3));

		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(3), e.getMessage().toString());
			failThis();
		}

		finally {
			cleanUpTestInstance();
		}

	}

	@Test
	// user attempts to login with bad credentials
	// Corresponds to TestCase C28 in TestRail
	public void Ord04_ValidateStaffLoginWithInValidUserName() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and Invalid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			_driver.findElement(By.id("dcbvwsVB"));
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestUserNameInValid(), TestDataSL.getTestAccountValidPassword());
			// Validate error message
			ValidateLoginErrorMessage();
			// Invoke logout to kill Staff session
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(4));
		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(4), e.getMessage().toString());
			failThis();
		} finally {
			cleanUpTestInstance();
		}

	}

	@Test
	// user attempts to login with bad credentials
	// Corresponds to TestCase C29 in TestRail
	public void Ord05_ValidateStaffLoginWithInValidEmail() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and Invalid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestEmailInValid(), TestDataSL.getTestAccountValidPassword());
			// Validate error message
			ValidateLoginErrorMessage();
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(5));
		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(5), e.getMessage().toString());
			failThis();
		} finally {
			cleanUpTestInstance();
		}

	}

	@Test
	// user attempts to login with bad credentials
	// Corresponds to TestCase C30 in TestRail
	public void Ord06_ValidateStaffLoginWithValidEmailInValidPassword() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and Invalid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestEmailValid(), TestDataSL.getTestAccountInValidPassword());
			// Validate error message
			ValidateLoginErrorMessage();
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(6));
		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(6), e.getMessage().toString());
			failThis();
		} finally {
			cleanUpTestInstance();
		}

	}

	@Test
	// user attempts to login with bad credentials
	// Corresponds to TestCase C31 in TestRail
	public void Ord07_ValidateStaffLoginWithValidEmailInValidPassword() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and Invalid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			_driver.findElement(By.id("dcbvwsVB"));
			// Invoke Login from the login page
			InvokeStaffLogin(TestDataSL.getTestEmailInValidFormat(), TestDataSL.getTestAccountValidPassword());
			// Validate error message
			ValidateLoginErrorMessage();
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(7));
		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(7), e.getMessage().toString());
			failThis();
		} finally {
			cleanUpTestInstance();
		}

	}

	@Test
	// user attempts to login with bad credentials
	// Corresponds to TestCase C1482 in TestRail
	public void Ord08_ValidateStaffLoginWithNullCredentials() throws InterruptedException {

		try {
			System.out.println("-->This is a test to verify the login scenario with Valid Email and Invalid Password");
			openBrowser();
			// Open browser and navigate to HappyFox Landing page to invoke
			// Login
			NavigateToLoginPage();
			// Invoke Login from the login page
			InvokeStaffLogin("", "");
			// Validate error message
			ValidateNullLoginErrorMessage();
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(8));
		} catch (Exception e) {
			FeedResultsIntoTestRail(TestDataSL.getTestCaseIds(8), e.getMessage().toString());
			failThis();
		} finally {
			cleanUpTestInstance();
		}

	}
}