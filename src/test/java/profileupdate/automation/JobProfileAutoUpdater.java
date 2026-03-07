package profileupdate.automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JobProfileAutoUpdater {

    @Test
    public void updateJobProfile() throws InterruptedException {

        WebDriver driver = BaseDriver.getDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("vandnapandey1997@gmail.com", "Van@0207");

        Thread.sleep(8000);

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.updateProfile();

        Thread.sleep(5000);

        driver.quit();
    }
}