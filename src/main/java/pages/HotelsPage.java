package pages;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import config.CustomWait;
import config.DriverConfiguration;
import config.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage{

    public WebDriver driver;

    @FindBy(xpath = "//input[@id='city']")
    WebElement inputCityClick;

    @FindBy(xpath = "//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]")
    WebElement inputCity;

    @FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
    WebElement inputCityAutoClick;

    @FindBy(xpath = "//div[@class='hsw_inputBox dates  ']")
    WebElement checkinDate;

    @FindBy(xpath = "//div[@class='datePickerContainer']//div[1]/div[3]//div[text()='23']")
    WebElement checkinDateSelect;

    @FindBy(xpath = "//div[@class='hsw_inputBox dates   ']")
    WebElement checkoutDate;

    @FindBy(xpath = "//div[@class='datePickerContainer']//div[1]/div[3]//div[text()='26']")
    WebElement checkoutDateSelect;

    @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement nextMonth;

    @FindBy(xpath = "//input[@id='guest']")
    WebElement guestsButton;

    @FindBy(xpath = "//div[@class='widgetSection appendBottom40']//ul[1]//li[2]")
    WebElement numberOfAdults;

    @FindBy(xpath = "//button[contains(@class,'btnAddRoom')]")
    WebElement buttonAddAnotherRoom;

    @FindBy(xpath = "//button[contains(@class,'primaryBtn btnApply')]")
    WebElement buttonApplyRoomPreferences;

    @FindBy(xpath = "//button[@id='hsw_search_button']")
    WebElement buttonTriggerSearch;

    public HotelsPage() {
        DriverConfiguration.setDriverPath(DriverType.CHROME);
        driver = DriverConfiguration.getDriver(DriverType.CHROME);
        driver.get("https://www.makemytrip.com/hotels/");
        PageFactory.initElements(this.driver, this);
    }

    public void insertDetails() {
        CustomWait.waitFor(driver, inputCityClick);
        inputCityClick.click();
        inputCity.sendKeys("South Goa");
        CustomWait.waitFor(driver, inputCityAutoClick);
        inputCityAutoClick.click();
        List<WebElement> captions = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
        String caption = "";
        while (!caption.equals("April2020")) {
            caption = captions.get(1).getText();
            nextMonth.click();
        }
        //checkinDate.click();
        checkinDateSelect.click();
        checkoutDateSelect.click();
        guestsButton.click();
        numberOfAdults.click();
        buttonAddAnotherRoom.click();
        buttonApplyRoomPreferences.click();
        buttonTriggerSearch.click();
    }

}
