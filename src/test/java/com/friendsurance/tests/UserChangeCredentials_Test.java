/***  
 * UserChangeCredentials_Test - Description - User should be able to change the credentials and successfully login with the new password
 * ***** 1. Open the browser and launch the url
 * ***** 2. Login as a existing user
 * ***** 3. Navigate to the Edit Account page by clicking on user account on the top right corner
 * ***** 4. Enter the current password
 * ***** 5. Provide a new Password and then repeat the new password for confirmation
 * ***** 6. Click on Update Account button
 * ***** 7. Logout and login with the new password
 * ***** 8. Verify that the user should be able to login with the new password
 * ***** 9. Logout
***/
package com.friendsurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.friendsurance.pages.EditAccountPage;
import com.friendsurance.pages.RegisterNewUserPage;
import com.relevantcodes.extentreports.LogStatus;

public class UserChangeCredentials_Test extends BaseTest{
	String testCaseName="UserChangeCredentials";
	@Test
	public void changePassword() throws Exception {
		test = extent.startTest(testCaseName, "Starting the "+ testCaseName);
		System.out.println(testCaseName);
		launchApp("url");

		RegisterNewUserPage regNewUser = new RegisterNewUserPage(driver, test, prop);
		EditAccountPage editAcc = new EditAccountPage(driver, test, prop);

		regNewUser.login("userName", "password");
		editAcc.changePassword();
		regNewUser.logout();
		regNewUser.login("userName", "newpassword");
		Assert.assertEquals(editAcc.getUserAccount(), prop.getProperty("userName"), "User not logged in");
		test.log(LogStatus.PASS, "Successfully logged in with the new password: "+ prop.getProperty("newpassword"));
		regNewUser.logout();
	}
}
