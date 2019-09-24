package com.friendsurance.pages;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListExpensePage extends BasePage{
	public ListExpensePage(WebDriver driver, ExtentTest test, Properties prop) {
		super(driver, test, prop);
	}
	
	public void listExpense() throws Exception {
		click("listExpenseLink_linktext");
		test.log(LogStatus.INFO, "Listing all the registered expenses");
	}
	
	public List<String> getActualExpenseList() {
		click("listExpenseLink_linktext");
		List<String> actualExpList = getwebTableData("listExpensesTable_xpath");
		System.out.println("Actual Expenses List: "+actualExpList);
		Collections.sort(actualExpList);
		System.out.println("Actual Expenses List after sorting: "+actualExpList);
		test.log(LogStatus.INFO, "Actual Expenses List: "+actualExpList);
		return actualExpList;
	}
}