package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {

	
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

	public static Boolean isElementPresent(By locator) {
		return DriverConfiguration.driver.findElements(locator).size() > 0;
	}

}
