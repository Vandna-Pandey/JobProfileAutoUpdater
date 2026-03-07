package profileupdate.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void updateProfile() {

        driver.get("https://www.naukri.com/mnjuser/profile");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Click Resume Headline Edit Icon
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Resume headline']/following::span[contains(@class,'edit')]")
        )).click();

        // Wait for headline textbox
        WebElement headline = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("resumeHeadlineTxt")
        ));

        String text = headline.getAttribute("value");

        // Update headline by adding a space (counts as activity)
        headline.clear();
        headline.sendKeys(text + " ");

        // Click Save
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Save']")
        )).click();

        System.out.println("Profile updated successfully");
    }
}