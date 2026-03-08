package profileupdate.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver){

        this.driver = driver;

    }
    public void updateResumeHeadline(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //wait.until(ExpectedConditions.urlContains("homepage"));

        driver.navigate().to("https://www.naukri.com/mnjuser/profile");

        // wait for profile page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'Resume headline')]")
        ));

        // click edit button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Resume headline')]//following::span[contains(@class,'edit')][1]")
        )).click();

        WebElement headline = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("resumeHeadlineTxt")
        ));

        String text = headline.getAttribute("value");

        headline.clear();
        headline.sendKeys(text+" ");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Save']")
        )).click();

        System.out.println("Profile Updated Successfully");
    }


}
