
import excelreader.ExcelReader;
import object_repository.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import waithelper.WaitHelper;

import java.util.concurrent.TimeUnit;

public class ThirdTest extends MainTest{

    @Test(description = "Successful Login")
    public void myTest() throws Exception {
        Login login = new Login(driver);
        login.hoverToLoginRegisterButtonContainer();
        login.clickToLoginButton();
        login.waitForPopupLoginMain(20);
        login.fillEmailBox("kapsujasti@desoz.com");
        login.fillPasswordBox("Qwerty123");
        login.submitLogin();
    }


}
