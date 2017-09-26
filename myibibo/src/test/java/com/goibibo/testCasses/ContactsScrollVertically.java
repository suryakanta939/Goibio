package com.goibibo.testCasses;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.commonClasses.InvokeAppium;
import com.goibibo.commonClasses.StartingAppiumServer;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContactsScrollVertically {
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
		driver=InvokeAppium.runPreinstalledAPP("Android device", "com.android.contacts", "DialtactsActivity");

}
	@Test
	public void test() throws InterruptedException{
		System.out.println("checking");
		driver.findElementByXPath("//android.widget.Button[@text='Enable']").click();
		Thread.sleep(3000);
		int height = driver.manage().window().getSize().getHeight();
		System.out.println(height);
	//	androidDriver.swipe(5, height * 2 / 3, 5, height / 3, 1000);
		 TouchAction act=new TouchAction(driver);
		 //thsi is for scroll down
		 for(int i=0;i <3;i++){
		 act.press(5, height * 2 / 3).waitAction().moveTo(5, height / 3).release().perform();
		 Thread.sleep(2000);
		 }
		 Thread.sleep(5000);
		 //this is for scroll up
		 for(int i=0;i <2;i++){
			 act.press(5, height / 3).waitAction().moveTo(5, height * 2 / 3).release().perform();
			 Thread.sleep(2000);
			 }
	}

}
