package steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import object_repository.Login;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import org.tinylog.Logger;
import testbase.TestBase;
import waithelper.WaitHelper;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends TestBase {
    WebDriver driver;
    WebElement element;
    Login login;
    @Before
    public void setUp(){

        driver = dockerBrowser("https://www.trendyol.com/");
        login = new Login(driver);
    }
    @Given("Navigate to HomePage")
    public void navigateToHomePage() {
        //driver.get("https://trendyol.com");
        //driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(),"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
    }





    @Then("Close PopUp if it is exist")
    public void closePopUp() {
        try{
            element =driver.findElement(By.className("fancybox-item"));
            element.click();
        }
        catch (org.openqa.selenium.NoSuchElementException e){

        }

    }

    @And("Hover to login")
    public void hoverToLogin() {
        login.hoverToLoginRegisterButtonContainer();
    }

    @Then("Click to login button")
    public void clickToLoginButton() {
        login.clickToLoginButton();
    }


    @And("Enter {string} and {string}")
    public void enterAnd(String arg0, String arg1) {
        login.waitForPopupLoginMain(30);
        login.fillEmailBox(arg0);
        login.fillPasswordBox(arg1);
    }

    @And("Click to login submit button")
    public void clickToLoginSubmitButton() {
       login.submitLogin();
    }

    @After
    public void tearDown(Scenario scenario)throws Exception{
        if(scenario.isFailed()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/src/resources/screenshots/"+scenario.getName()+".png"));
            Logger.info("Test Failure,Screenshot Saved");
        }
        driver.quit();
    }

    @Then("Check the {string}")
    public void checkThe(String arg0) {
        Assert.assertEquals(arg0,login.getErrorBoxText());
    }
}
