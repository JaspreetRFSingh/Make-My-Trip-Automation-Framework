package config;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

	static WebDriverWait wait;
	
	public static WebElement waitFor(WebDriver driver, WebElement locator) {
		WebDriverWait wait =new  WebDriverWait(driver,30);
		WebElement element = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public static boolean waitForUrl(WebDriver driver, String text) {
		WebDriverWait wait =new  WebDriverWait(driver,30);
		return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.urlContains(text));
		
	}
	
//	public static void waitFor( long timeout) {
//		try {
//			Thread.sleep(timeout);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
