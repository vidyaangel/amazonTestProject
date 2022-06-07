package com.abma.android.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class Config  {
	public final static String configFile = "C:/Users/vidya/eclipse-workspace/Demos/properties.xml";

	public static WebDriver defaultDriver;
	public static final int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 20;
	public static String status;
	public static AndroidDriver driver;
	public static int duration;
	/*
	 * Initializing a logger instance using the root logger
	 * Created by Vidya Bhushan
	 */
	//private static Logger logger = Logger.getLogger(Config.class.getName());

	private static Properties init() {
		Properties props = new Properties();

		InputStream is = null;
		try {
			is = new FileInputStream(configFile);
			System.out.println(is);
		} catch (FileNotFoundException ex) {
			System.out.println("Came here");
			////logger.error(ex);
		}
		try {
			// load the xml file into properties format
			props.loadFromXML(is);
		} catch (IOException ex) {
			//logger.error(ex);
		}
		return props;
	}

	public static String getServerURL() {
		return init().getProperty("server.url");
	}


	/**
	 * Method to wait for an element until it doesn't visible
	 * @param driver the driver passed to element
	 * @param ele specifies the element for which wait is applied
	 * @throws InterruptedException 
	 */

	public static void waitForElement(WebDriver driver,WebElement ele) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		waitForTime();
	}


	/**
	 * Method to wait for sometime
	 * @throws InterruptedException 
	 */

	public static void waitForTime() throws InterruptedException
	{
		Thread.sleep(1500);
	}



	/**
	 * Function to switch window from one to another or tabs switching
	 * @param driver is an instance of Browser
	 * @param winHandleBefore is the window object which is available before switch 
	 */
	public static void windowSwitch(WebDriver driver,String winHandleBefore){
		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(winHandleBefore))
			{
				driver.switchTo().window(winHandle);
			}
			else{
				driver.switchTo().window(winHandle);  
			}
		}
	}



	public static WebElement scrollToAnElementByText(AppiumDriver<MobileElement> driver, String text) {
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
				".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
	}



	/*public static void swipeFunctions(MobileElement1,MobileElement2) {

		 new TouchAction(driver).press(ele1)
		 .waitAction(Duration.ofMillis(1000))com.angelbroking.angelbrokinglite.testApp:id/tvScriptTitle
		 .moveTo(ele2).release().perform();

	}*/

	public static void listOfStocksOnHOmeScreen() {
		List<MobileElement> ele2 = driver.findElements(By.id("com.angelbroking.angelbrokinglite.testApp:id/tvScriptTitle"));
		System.out.println(ele2.size());
		for (WebElement webElement : ele2) {
			String name = webElement.getText();
		}
	}


	public static void clickSevenAddBtnOnSearch() {

		List<MobileElement> ele3 = driver.findElements(By.id("com.angelbroking.angelbrokinglite.testApp:id/cbScriptAddRemove"));
		System.out.println(ele3.size());
		for (WebElement webElement : ele3) {
			webElement.click();

		}
		
		
		
	}

}























