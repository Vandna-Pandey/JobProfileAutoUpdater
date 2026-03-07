package profileupdate.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {

        driver.get("https://www.naukri.com/nlogin/login");

//        driver.findElement(By.id("usernameField")).sendKeys(username);
//        driver.findElement(By.id("passwordField")).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameField")))
                .sendKeys(username);

        driver.findElement(By.id("passwordField")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}