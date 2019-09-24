package com.friendsurance.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {
	public WebDriver driver;
	public ExtentTest test;
	public Properties prop;

	public BasePage(WebDriver driver,ExtentTest test, Properties prop) {
		this.driver = driver;
		this.test=test;
		this.prop=prop;
	}

	public void click(String eleLocator) {
		getWebElement(eleLocator).click();
	}

	public void type(String eleLocator, String data) {
		getWebElement(eleLocator).sendKeys(prop.getProperty(data));
	}

	public void clear(String eleLocator) {
		getWebElement(eleLocator).clear();
	}

	public void scrollToEnd() throws Exception {
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

	public String getText(String eleLocator) throws Exception {

		try {
			String text = getWebElement(eleLocator).getText();
			return text;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	public boolean verifyText(String eleLocator, String expectedText) {
		Boolean text = null;
		if(getWebElement(eleLocator).getText().equals(expectedText)) {
			text = true;
		}else {
			text = false;
		}

		return text;
	}

	public List<String> getAllDropDownValues(String eleLocator){

		List<String> values = new ArrayList<String>();
		List<WebElement> allDDElements = new Select(getWebElement(eleLocator)).getOptions();

		for(WebElement menuitem:allDDElements) {
			System.out.println(menuitem.getText());
			values.add(menuitem.getText());
		}
		return values;
	}

	public void selectDDByVisibleText(String eleLocator, String text){
		Select dd = new Select(getWebElement(eleLocator));
		dd.selectByVisibleText(prop.getProperty(text));
	}

	public List<String> getwebTableData(String eleLocator){
		List<WebElement> tabData = driver.findElements(By.xpath(prop.getProperty(eleLocator)));
		List<String> stringData = new ArrayList<String>();
		for(WebElement e : tabData){
			stringData.add(e.getText());
		}
		return stringData;
	}

public WebElement getWebElement(String eleLocator) {
	WebElement element = null;
	if(eleLocator.endsWith("_xpath")) {
		element = driver.findElement(By.xpath(prop.getProperty(eleLocator)));
	}else if(eleLocator.endsWith("_css")) {
		element = driver.findElement(By.cssSelector(prop.getProperty(eleLocator)));
	}else if(eleLocator.endsWith("id")) {
		element = driver.findElement(By.id(prop.getProperty(eleLocator)));
	}else if(eleLocator.endsWith("name")) {
		element = driver.findElement(By.name(prop.getProperty(eleLocator)));
	}else if(eleLocator.endsWith("linktext")) {
		element = driver.findElement(By.linkText(prop.getProperty(eleLocator)));
	}

	return element;
}

}
