import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
        //open websites
        
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        
        //click on your trip link

        driver.findElement(By.linkText("Your trips")).click();
        waitFor(2000);
        
        // click on signin button
        
        driver.findElement(By.id("SignIn")).click();
           
        // driver waiting for somefixed time for window loading
        waitFor(3000);
        
        // driver will shifted to frame
        
        driver.switchTo().frame("modal_window");
        
        waitFor(2000);
        // click on signin button
        
        driver.findElement(By.id("signInButton")).click();
        waitFor(2000);
        
        // getting error message into string variable

        String errors1 = driver.findElement(By.id("errors1")).getText();
        
        // checking error message
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        waitFor(2000);
        //close site
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
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


}
