package profileupdate.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import profileupdate.automation.driver.BaseDriver;
import profileupdate.automation.pages.LoginPage;
import profileupdate.automation.pages.ProfilePage;

public class JobProfileAutoUpdaterTest {

    @Test
    public void updateProfile(){

        WebDriver driver = BaseDriver.getDriver();

        LoginPage login = new LoginPage(driver);

        login.login("vandnapandey1997@gmail.com","Van@0207");

        ProfilePage profile = new ProfilePage(driver);
        profile.updateResumeHeadline();
        BaseDriver.quitDriver();

    }
}