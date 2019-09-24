/***  
 * RegisterAsAExistingUser_Test - Description - User should not be able to register with the existing username
 * ***** 1. Open the browser and launch the url
 * ***** 2. Click on the Register new user link
 * ***** 3. Enter the existing username
 * ***** 4. Enter the password and then repeat the password for confirmation
 * ***** 5. Click on Register button
 * ***** 6. Verify that the user should not be able to register with the existing username
***/
package com.friendsurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.friendsurance.pages.RegisterNewUserPage;
import com.relevantcodes.extentreports.LogStatus;

public class RegisterAsAExistingUser_Test extends BaseTest{
	String testCaseName = "RegisterAsAExistingUser_Test";
	@Test
	public void registerAsAExistingUser() throws Exception {
		test = extent.startTest(testCaseName, "Starting the "+ testCaseName);
		System.out.println(testCaseName);
		launchApp("url");

		RegisterNewUserPage regNewUser = new RegisterNewUserPage(driver, test, prop);
		regNewUser.registerNewUser();
		test.log(LogStatus.FAIL, "User is not able to register with the existing username but the alert message is not proper");
		Assert.assertNotEquals(regNewUser.getAlertText(), "password1 wasn't equal to password2", "Proper Alert message is not dispalyed");	
	}
}
