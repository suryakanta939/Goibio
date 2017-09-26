package com.goibibo.commonClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class AndroidKeyboardFunctions {
	
	public static void clickOnBack(AndroidDriver<AndroidElement> driver,int noOfTime) throws InterruptedException{
		for(int i=0;i<noOfTime;i++){
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(500);
		}
	}
}
