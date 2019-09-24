/***  
 * End to end test steps:
 * ***** 1. Open the browser and launch the url
 * ***** 2. Register a new user
 * ***** 3. Create a new category (created 3 new categories for the example)
 * ***** 4. Verify that the newly created categories are listed in the List Categories page
 * ***** 5. Create a new expense (created 3 new expenses with the 3 categories created above for the example)
 * ***** 6. Verify that the newly created expenses are listed in the List Expenses page
 * ***** 7. Navigate to the Show Statistics page
 * ***** 8. Verify that the Show Statistics page is displayed
 * ***** 9. Logout
***/

package com.friendsurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.friendsurance.pages.AddExpensePage;
import com.friendsurance.pages.ListCategoriesPage;
import com.friendsurance.pages.ListExpensePage;
import com.friendsurance.pages.RegisterNewUserPage;
import com.friendsurance.pages.ShowStatisticsPage;
import com.relevantcodes.extentreports.LogStatus;

public class EndtoEnd_TC1 extends BaseTest{
	String testCaseName="EndtoEnd_TC1";
	@Test
	public void endtoEnd_TC1() throws Exception {
		test = extent.startTest(testCaseName, "Starting the "+ testCaseName);
		System.out.println(testCaseName);
		launchApp("url");

		RegisterNewUserPage regNewUser = new RegisterNewUserPage(driver, test, prop);
		ListCategoriesPage listCat = new ListCategoriesPage(driver, test, prop);
		AddExpensePage addExp = new AddExpensePage(driver, test, prop);
		ListExpensePage lstExp = new ListExpensePage(driver, test, prop);
		ShowStatisticsPage shwStats = new ShowStatisticsPage(driver, test, prop);

		regNewUser.registerNewUser();
		//regNewUser.login();
		listCat.addCategory("category1");
		listCat.addCategory("category2");
		listCat.addCategory("category3");
		Assert.assertEquals(listCat.getActualCategoryList(), listCat.getExpectedCategoryList(), "Actual and Expected Categories are not equal");
		test.log(LogStatus.PASS, "Actual and Expected category list is equal");

		addExp.addExpense("day1", "mon", "year", "category1", "amt1", "reason1");
		addExp.addExpense("day2", "mon", "year", "category2", "amt2", "reason2");
		addExp.addExpense("day3", "mon", "year", "category3", "amt3", "reason3");
		lstExp.listExpense();
		Assert.assertEquals(addExp.getExpectedExpenseList(), lstExp.getActualExpenseList(), "Actual and Expected Expenses for the categories are not equal");
		test.log(LogStatus.PASS, "Actual and Expected expenses categories are equal");

		Assert.assertEquals(shwStats.showStatistics(), "Test Statistics:", "Actual and Expected are not equal");
		test.log(LogStatus.PASS, "User is in the Show Statistics Page");
		regNewUser.logout();
		Assert.assertEquals(regNewUser.getLoginPageText(), "Login", "Actual and Expected are not equal");
		test.log(LogStatus.PASS, "User successfully logged out and is in the Login Page");
	}
}