import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver = new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();

        driver.get("https://www.cleartrip.com/");
        
        //wait for page load
        
        waitFor(5000);
        hotelLink.click();
        
        //wait for page load
        
        waitFor(2000);
        
        //for selection of item in list
        
        Actions act=new Actions(driver);
        act.sendKeys(localityTextBox,"Indiranagar, Bangalore").build().perform();
        waitFor(5000);
        act.sendKeys(Keys.ENTER).build().perform();
        waitFor(2000);
        
        //this statement for clear info  checkin and checkout dates
        
        act.sendKeys(Keys.ESCAPE).build().perform();
        waitFor(2000);
        act.sendKeys(Keys.ESCAPE).build().perform();
        waitFor(2000);
        
        //this statement for selection travallers
        
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        waitFor(2000);
        
        //this statement for click search 
        
        searchButton.click();
        waitFor(2000);

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
