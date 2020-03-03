package config;

import java.util.concurrent.TimeUnit;
import driverFactory.ChromeDriverManager;
import driverFactory.DriverManager;
import driverFactory.ExplorerDriverManager;
import driverFactory.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverConfiguration {
	public static WebDriver driver;

	public static DriverManager setDriverPath(DriverType driverType) {
		if(driverType.equals(DriverType.CHROME)) {
			return setChromeDriverPath();
		}
		else if(driverType.equals(DriverType.FIREFOX)) {
			return setGeckoDriverPath();
		}
		else if(driverType.equals(DriverType.IE)) {
			return setExplorerDriverPath();
		}
		return null;
	}
	
	public static DriverManager setChromeDriverPath() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/chromedriver.exe");
		return new ChromeDriverManager();
	}
	
	public static DriverManager setExplorerDriverPath() {
		System.setProperty("webdriver.ie.driver",
				"src/main/resources/IEDriverServer.exe");
		return new ExplorerDriverManager();
	}
	
	public static DriverManager setGeckoDriverPath() {
		System.setProperty("webdriver.gecko.driver",
				"src/main/resources/geckodriver.exe");
		return new FirefoxDriverManager();
	}

	public static WebDriver getDriver(DriverType driverType) {
		DriverManager driverManager;
		driverManager = setDriverPath(driverType);
		driver = driverManager.getWebDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeDriver() {
		driver.close();
	}
}
