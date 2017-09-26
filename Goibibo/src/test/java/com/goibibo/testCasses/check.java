package com.goibibo.testCasses;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.goibibo.commonClasses.InvokeAppium;
import com.goibibo.commonClasses.StartingAppiumServer;
import com.goibibo.pageClases.HomePage;
import com.goibibo.pageClases.Menu;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class check {
	AndroidDriver<AndroidElement> driver;
	ExtentTest test;
	int port=4723;
	Menu menu;
	HomePage homepage;
	String apkFile="Goibibo Flight Hotel Bus Car IRCTC Booking App_v3.0.24_apkpure.com.apk";
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
		driver=InvokeAppium.runAppium(apkFile, "Android device");
		menu=new Menu(driver, test);
		homepage=new HomePage(driver, test);
	}
  @Test(dependsOnMethods="offer")
  public void checkSound() throws InterruptedException 
  {
	  menu.soundNotificationSetting("off");
	 
  }
  @Test
  public void offer() throws InterruptedException{
	  homepage.flightAndHotelCheck();
  }
  @AfterMethod
  public void executeAfterMethod(ITestResult result) throws IOException{
	  if(result.getStatus()==result.SUCCESS){
		  System.out.println("test case got pass");
	  }else{
		  String name=result.getMethod().getMethodName();
		  System.out.println(name);
		  EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		  File src=edriver.getScreenshotAs(OutputType.FILE);
		  File dst=new File("D:\\appiumcode\\Goibibo\\Screenshot\\"+name+".png");
		  FileUtil.copyFile(src, dst);
	  }
  }
  @AfterTest
	public void tearDown(){
	  
	  
		//StartingAppiumServer.stopServer();
	}
}
