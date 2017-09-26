package com.goibibo.commonClasses;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InvokeAppium {

	public static AndroidDriver<AndroidElement> runAppium(String urApkFile,String urDeviceName) throws MalformedURLException{
		File f=new File("FileFolder");
		File fs=new File(f,urApkFile);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, urDeviceName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "15");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement>	driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
	}
	public static AndroidDriver<AndroidElement> runAppiumWithBrowser(String urApkFile,String urDeviceName,String browseName) throws MalformedURLException{
		File f=new File("FileFolder");
		File fs=new File(f,urApkFile);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, urDeviceName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,browseName);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement>	driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
	}
	public static AndroidDriver<AndroidElement> runPreinstalledAPP(String urDeviceName,String packageName,String activityName) throws MalformedURLException{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, urDeviceName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "15");
	    cap.setCapability("appPackage", packageName);
	    cap.setCapability("appActivity", activityName);
		AndroidDriver<AndroidElement>	driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
	}
}
