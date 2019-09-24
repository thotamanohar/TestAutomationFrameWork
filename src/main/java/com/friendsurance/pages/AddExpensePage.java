package com.friendsurance.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddExpensePage extends BasePage{
	public List<String> expecedExpList = new ArrayList<String>();
	public AddExpensePage(WebDriver driver, ExtentTest test, Properties prop) {
		super(driver, test, prop);
	}

	public void addExpense(String day, String month, String year, String category, String amt, String reason) throws Exception {
		click("addExpenseLink_linktext");
		type("dayExpense_css", day);
		clear("monExpense_css");
		type("monExpense_css", month);
		type("yearExpense_css", year);
		selectDDByVisibleText("categorySelectDD_css", category);
		expecedExpList.add(prop.getProperty(category));
		type("amount_css", amt);
		type("reason_css", reason);
		click("createExpense_css");
		test.log(LogStatus.INFO, "Added the expense with the details: "+prop.getProperty(day)+", "+prop.getProperty(month)+", "+prop.getProperty(year)+", "+prop.getProperty(category)+", "+prop.getProperty(amt)+", "+prop.getProperty(reason));
	}

	public List<String> getExpectedExpenseList() {
		System.out.println("Expected Expenses List: "+expecedExpList);
		Collections.sort(expecedExpList);
		test.log(LogStatus.INFO, "Expected Expenses List: "+expecedExpList);
		return expecedExpList;
	}
}
