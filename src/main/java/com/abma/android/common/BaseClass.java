package com.abma.android.common;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	
	public static AppiumDriver<MobileElement> driver;
	public static AndroidDriver<MobileElement> androiddriver;
		@BeforeClass
		public void setup()
		{
			try{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName","Redmi Note 4");
			cap.setCapability("udid","emulator-5554");	
			cap.setCapability("platformName","Android");
			cap.setCapability("platformVersion","10");
			//cap.setCapability("automationName", "UiAutomator2");
			//cap.setCapability("browserName","Chrome");
			//cap.setCapability("appPackage","com.angelbroking.angelbrokinglite.testApp");
			cap.setCapability("appPackage","com.spark.angelbroking.uat");
			cap.setCapability("appActivity","com.angelbroking.spark.uiModules.MainActivity");
			cap.setCapability(MobileCapabilityType.FULL_RESET, "False");
	        cap.setCapability(MobileCapabilityType.NO_RESET, "True");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url,cap);
			
			
			
			
			System.out.println("application startted......");		
			}catch(Exception exp){
				System.out.println("cause is : "+exp.getCause());
				System.out.println("Message is : "+exp.getMessage());
			     exp.printStackTrace();     
			}}	     
		public WebDriver getDriver() {
			// TODO Auto-generated method stub
			return driver;
		}	     
		
		//@AfterTest()
		//@AfterMethod
		/*@AfterClass
		public void teardown() throws InterruptedException{
			Config.waitForTime();
			driver.closeApp();
			
		}*/



}
