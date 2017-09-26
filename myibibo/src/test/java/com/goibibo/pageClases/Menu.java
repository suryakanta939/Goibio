package com.goibibo.pageClases;

import org.openqa.selenium.WebElement;

import com.goibibo.commonClasses.AndroidGesture;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Menu {
 
	public static AndroidDriver<AndroidElement> driver;
	public static AndroidElement element;
	public static ExtentTest test;
	
	public Menu(AndroidDriver<AndroidElement> driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
/*
 * Below elements are to per the skip operation
 * */	
	public static AndroidElement skip(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='SKIP']");
		return element;
	}
	
	public static AndroidElement skipPopUp(){
		element=driver.findElementByXPath("//android.widget.Button[@text='SKIP']");
		return element;
	}
	
	public void skipToGoibibo(){
		skip().click();
		if(skipPopUp().isDisplayed()){
			skipPopUp().click();
		}else{
			System.out.println("pop up is not showing");
		}
	}
	/*---------------------this function is to 
	 *----------------------- check the pop up----*/
	public static AndroidElement allowPopUp(){
		element=driver.findElementByXPath("//android.widget.Button[@text='Allow']");
		return element;
	}
	
	public static AndroidElement denyPopUp(){
		element=driver.findElementByXPath("//android.widget.Button[@text='Deny']");
		return element;
	}
	
	public void handelMobilePopUp(String urOption){
		if(urOption.equalsIgnoreCase("allow")&& allowPopUp().isDisplayed()){
			allowPopUp().click();
		}else{
			denyPopUp().click();
		}
	}
	
	public void clickOnAllowOrDeny(String option) throws InterruptedException{
		while(true){
			try{
				if(allowPopUp().isDisplayed()){
					handelMobilePopUp(option);
					break;
				}
			}catch(Throwable t){
				Thread.sleep(1000);
			}
		}
	}
	/************************************************************************************************/
	/****************this elements are to perform the menu operation************/
	public static AndroidElement menuImage(){
		element=driver.findElementByClassName("android.widget.ImageButton");
		return element;
	}
	
	public static AndroidElement settings(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Settings']");
		return element;
	}
	public static AndroidElement soundNotification(){
		element=driver.findElementById("com.goibibo:id/checkbox_sound");
		return element;
	}
	
	public void soundSetting(String urOption) throws InterruptedException{
		while(true){
			try{
				String text=soundNotification().getText();
				if(text.equalsIgnoreCase(urOption)){
					System.out.println("sound is already "+urOption);
					break;
				}else{
					soundNotification().click();
					break;
				}
			}catch(Throwable t){
				Thread.sleep(1000);
			}
		}
		
	}
	 
	public void soundNotificationSetting(String urOption) throws InterruptedException{
		while(true){
			try{
				skipToGoibibo();
				break;
			}catch(Throwable t){
				Thread.sleep(1000);
			}
		}	
		Thread.sleep(3000);
			
	      clickOnAllowOrDeny("allow");	
	      menuImage().click();
			AndroidGesture.scrollToElemntBytext(driver, "Settings");
			settings().click();
			soundSetting(urOption);
		}
	}
	

