package com.goibibo.pageClases;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.goibibo.commonClasses.AndroidGesture;
import com.goibibo.commonClasses.AndroidKeyboardFunctions;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
	public static AndroidDriver<AndroidElement> driver;
	public static AndroidElement element;
	public static ExtentTest test;
	Menu menu;
	int i;

	public HomePage(AndroidDriver<AndroidElement> driver,ExtentTest test){
		menu=new Menu(driver, test);
		this.driver=driver;
		this.test=test;

	}

	/*bellow elements are to perform the view functions
	 * */
	public static AndroidElement viewAll(){
		//  element=driver.findElementById("com.goibibo:id/home_activity_viewall_offers_txtVw");
		element=driver.findElementByAndroidUIAutomator("resourceId(\"com.goibibo:id/home_activity_viewall_offers_txtVw\")");
		return element;
	}

	public static AndroidElement flightHotelTab(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Flight + Hotel']");
		return element;
	}

	public static AndroidElement Offer(){
		element=driver.findElementByXPath("//android.widget.TextView[contains(@text,'Get Rs.50 goCash')]");
		return element;
	}

	public static AndroidElement goContacts(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='goContacts']");
		return element;
	}


	public void flightAndHotelCheck() throws InterruptedException{
		while(true){
			try{
				menu.skipToGoibibo();
				break;
			}catch(Throwable t){
				Thread.sleep(1000);
			}
		}
		Thread.sleep(3000);
		menu.clickOnAllowOrDeny("allow");
		Thread.sleep(3000);
		AndroidGesture.scrollDownToElement(driver, By.xpath("//android.widget.TextView[@text='VIEW ALL']"));
		viewAll().click();
		Thread.sleep(1000);
		AndroidGesture.swipeRightToLeftToAnElement(driver, By.xpath("//android.widget.TextView[@text='Flight + Hotel']"));
		driver.findElementByXPath("//android.widget.TextView[@text='Flight + Hotel']").click();
		AndroidGesture.scrollDown(driver);
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Get Rs.50 goCash')]").click();
      // AndroidGesture.tapCellByTitle(driver,"Get Rs.50 goCash+ every time any of your contact books on Goibibo");
      AndroidKeyboardFunctions.clickOnBack(driver, 2);
	}
	
}
