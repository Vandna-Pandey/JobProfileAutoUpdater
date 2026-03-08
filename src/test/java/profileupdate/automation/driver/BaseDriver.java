package profileupdate.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;

public class BaseDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            //driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(1920,1080));

        }

        return driver;
    }

    public static void quitDriver(){

        if(driver != null){
            driver.quit();
        }

    }
}
