/**
 * 
 */
package CommonData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Angad Kandhari
 *
 */

public class TestDataSL {

	private static String testAccountValid = "angadtesttenmiles";
	private static String testAccountNull = "";
	private static String testUserNameValid = "angad";
	private static String testUserNameInValid = "angad#^%#%";
	private static String testEmailValid = "angad729@gmail.com";
	private static String testEmailInValid = "angad71229@gmail.com";
	private static String testEmailInValidFormat = "angad71229@^%$^gmail.com";
	private static String testAccountInValid = "usdciuwbciubciueb";
	private static String testAccountValidPassword = "!a2675288";
	private static String testAccountInValidPassword = "!a2675dciuw8";
	private static String testRailBaseUrl = "https://happyfox.testrail.net";
	private static String testRailUser = "angad@happyfox.com";
	private static String testRailPassword = "!a2675288A";
	@SuppressWarnings("serial")
	private static List<Integer> testCaseIds = new ArrayList<Integer>() {
		{
			add(5);
			add(6);
			add(27);
			add(28);
			add(29);
			add(30);
			add(31);
			add(1482);
		}
	};

	private static String testRailSuiteId = "1";
	private static String testRailProjectId = "1";
	private static Object testRailRunId = null;

	public static String getTestAccountValid() {
		return testAccountValid;
	}

	public static String getTestAccountInValid() {
		return testAccountInValid;
	}

	public static String getTestAccountNull() {
		return testAccountNull;
	}

	public static String getTestUserNameValid() {
		return testUserNameValid;
	}

	public static String getTestUserNameInValid() {
		return testUserNameInValid;
	}

	public static String getTestEmailValid() {
		return testEmailValid;
	}

	public static String getTestEmailInValid() {
		return testEmailInValid;
	}

	public static String getTestEmailInValidFormat() {
		return testEmailInValidFormat;
	}

	public static String getTestAccountValidPassword() {
		return testAccountValidPassword;
	}

	public static String getTestAccountInValidPassword() {
		return testAccountInValidPassword;
	}

	public static String getTestRailBaseUrl() {
		return testRailBaseUrl;
	}

	public static String getTestRailUser() {
		return testRailUser;
	}

	public static String getTestRailPassword() {
		return testRailPassword;
	}

	public static List<Integer> getTestCaseIds() {
		return testCaseIds;
	}

	public static Integer getTestCaseIds(Integer id) {
		id = id - 1;
		return testCaseIds.get(id);
	}

	public static String getTestRailSuiteId() {
		return testRailSuiteId;
	}

	public static void setTestRailSuiteId(String testRailSuiteId) {
		TestDataSL.testRailSuiteId = testRailSuiteId;
	}

	public static String getTestRailProjectId() {
		return testRailProjectId;
	}

	public static void setTestRailProjectId(String testRailProjectId) {
		TestDataSL.testRailProjectId = testRailProjectId;
	}

	public static Object getTestRailRunId() {
		return testRailRunId;
	}

	public static void setTestRailRunId(Object object) {
		TestDataSL.testRailRunId = object;
	}

}
