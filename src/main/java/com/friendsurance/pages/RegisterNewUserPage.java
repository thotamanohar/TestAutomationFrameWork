package com.friendsurance.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegisterNewUserPage extends BasePage{

	public RegisterNewUserPage(WebDriver driver, ExtentTest test, Properties prop) {
		super(driver, test, prop);
	}

	public void registerNewUser() {
		test.log(LogStatus.INFO, "Registering a User with: "+prop.getProperty("userName")+", "+prop.getProperty("password"));
		click("registerUser_linktext");
		type("userNameNewUser_css", "userName");
		type("passwordNewUser_css", "password");
		type("passwordConfimationNewUser_css", "password");
		click("registerNewUser_css");
	}

	public void login(String username, String password) {
		test.log(LogStatus.INFO, "User logging to the application: "+prop.getProperty("userName")+", "+prop.getProperty("password"));
		type("userNameNewUser_css", username);
		type("password_css", password);
		click("loginButton_css");
	}

	public void logout() {
		test.log(LogStatus.INFO, "User logging out of the application: "+prop.getProperty("userName"));
		click("logout_css");
	}
	
	public String getLoginPageText() throws Exception {
		String pageName="";
		pageName = getText("loginPageText_css");
		System.out.println(pageName);
		return pageName;
	}
	
	public String getAlertText() throws Exception {
		String alertText="";
		alertText = getText("existingUserAlertText_css");
		System.out.println(alertText);
		return alertText;
	}
}
