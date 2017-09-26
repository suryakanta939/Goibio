package com.goibibo.testCasses;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.commonClasses.AndroidGesture;
import com.goibibo.commonClasses.InvokeAppium;
import com.goibibo.commonClasses.StartingAppiumServer;
import com.goibibo.pageClases.HomePage;
import com.goibibo.pageClases.Menu;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalenderScrollHoriZontally {
	AndroidDriver<AndroidElement> driver;
	ExtentTest test;
	int port=4723;
	@BeforeTest
	public void setUp() throws IOException, InterruptedException{
		if(StartingAppiumServer.checkIfServerIsRunnning(port)==true){
			System.out.println("server is running");
		}else{
			StartingAppiumServer.startServerOnCommandPrompt("runappium.bat");
			Thread.sleep(10000);
			
		}
		
	}
	@BeforeMethod
	public void executeBeforeMethod() throws MalformedURLException{
		driver=InvokeAppium.runPreinstalledAPP("Android device", "com.android.calendar", "LaunchActivity");

	}
  @Test
  public void f() throws InterruptedException {
	  System.out.println("checking");
	  driver.findElementByXPath("//android.widget.Button[@text='Enable']").click();
	  driver.findElementByXPath("//android.widget.Button[@text='Allow']").click();
	  AndroidGesture.swipeLeftToRightToAnElement(driver, By.xpath("//android.widget.TextView[@text='June 2017']"));
	  
  }
}
