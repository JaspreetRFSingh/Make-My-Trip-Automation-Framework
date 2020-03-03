package com.jstech.MakeMyTrip_AT.config;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class Util {

	static File source;

	public static void screenShot(WebDriver driver) {
		try {
			String screenShotPath = "../MakeMyTrip_AT/test-output/screenshots/"
					+ getCurrentDateTime() + ".png";
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			source = screenShot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File(screenShotPath));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDateTime() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return format.format(date);
	}
	
	public static String switchToLatestWindow(WebDriver driver) {
		try {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		} catch (Exception e) {
			return "Failed: Unable to Switch Window - " + e.getMessage();
		}
		return "Success!";
	}

}
