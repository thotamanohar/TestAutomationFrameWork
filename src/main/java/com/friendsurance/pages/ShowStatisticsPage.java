package com.friendsurance.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShowStatisticsPage extends BasePage{
	public ShowStatisticsPage(WebDriver driver, ExtentTest test, Properties prop) {
		super(driver, test, prop);
	}
	
	public String showStatistics() throws Exception {
		String pageName="";
		click("showStatisticsLink_linktext");
		test.log(LogStatus.INFO, "Showing the statistics in the pie chart");
		pageName = getText("statisticsPage_css");
		System.out.println(pageName);
		return pageName;
	}
}
