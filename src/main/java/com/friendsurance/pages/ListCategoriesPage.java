package com.friendsurance.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListCategoriesPage extends BasePage{
	
	public ListCategoriesPage(WebDriver driver, ExtentTest test, Properties prop) {
		super(driver, test, prop);
	}
	
	public void addCategory(String catName) {
		click("listCategoriesLink_linktext");
		click("addCategory_css");
		type("categoryName_css", catName);
		click("submitCategory_css");
		test.log(LogStatus.INFO, "Created the category: "+prop.getProperty(catName));
	}
	
	public List<String> getActualCategoryList() {
		click("listCategoriesLink_linktext");
		List<String> actualCatList = getwebTableData("categoriesTableData_xpath");
		System.out.println("Actual Category List: "+actualCatList);
		test.log(LogStatus.INFO, "Actual Category List: "+actualCatList);
		return actualCatList;
	}
	
	public List<String> getExpectedCategoryList() {
		List<String> expecedCatList = new ArrayList<String>();
		expecedCatList.add(prop.getProperty("category1"));
		expecedCatList.add(prop.getProperty("category2"));
		expecedCatList.add(prop.getProperty("category3"));
		System.out.println("Expected Category List: "+expecedCatList);
		test.log(LogStatus.INFO, "Expected Category List: "+expecedCatList);
		return expecedCatList;
	}
}
