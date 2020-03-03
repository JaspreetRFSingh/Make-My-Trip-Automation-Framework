package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.jstech.MakeMyTrip_AT.driverFactory.ChromeDriverManager;
import com.jstech.MakeMyTrip_AT.driverFactory.DriverManager;

public class DriverConfiguration {
	public static WebDriver driver;

	public static void setDriverPath(DriverType driverType) {
		if(driverType.equals(DriverType.CHROME)) {
			setChromeDriverPath();
			return;
		}
		else if(driverType.equals(DriverType.FIREFOX)) {
			setGeckoDriverPath();
			return;
		}
		else if(driverType.equals(DriverType.IE)) {
			setExplorerDriverPath();
			return;
		}
	}
	
	public static void setChromeDriverPath() {
		System.setProperty("webdriver.chrome.driver",
				"../MakeMyTrip_AT/src/test/resources/chromedriver.exe");
	}
	
	public static void setExplorerDriverPath() {
		System.setProperty("webdriver.ie.driver",
				"../MakeMyTrip_AT/src/test/resources/IEDriverServer.exe");
	}
	
	public static void setGeckoDriverPath() {
		System.setProperty("webdriver.gecko.driver",
				"../MakeMyTrip_AT/src/test/resources/geckodriver.exe");
	}

	public static WebDriver getDriver(DriverType driverType) {
		DriverManager driverManager;
		driverManager = new ChromeDriverManager();
		driver = driverManager.getWebDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static Boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

	public static void closeDriver() {
		driver.close();
	}
}
