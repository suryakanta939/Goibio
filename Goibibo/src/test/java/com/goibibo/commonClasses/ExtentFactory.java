package com.goibibo.commonClasses;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports report;
	 public static ExtentReports getinstance(){
		 File f=new File("Report");
		 File fs=new File(f,"");
		 report=new ExtentReports(fs.getAbsolutePath()+"\\goibio.html",false);
		 return report;
	 }

}
