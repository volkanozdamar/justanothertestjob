package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import waithelper.WaitHelper;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    Actions action ;
    public Login(WebDriver driver){
        //Initialise Elements
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login-register-button-container")
    WebElement loginRegisterButtonContainer;

    @FindBy(id= "loggedin-panel-container")
    WebElement loggedinPanelContainer;

    @FindBy(xpath = "//div[contains(@class,'account-button login')]")
    WebElement loginButton;

    @FindBy(id = "email")
    WebElement emailTxtBox;

    @FindBy(id = "password")
    WebElement passwordTxtBox;

    @FindBy(id = "loginSubmit")
    WebElement loginSubmit;

    @FindBy(id = "popupLoginMain")
    WebElement popupLoginMain;

    public void hoverToLoginRegisterButtonContainer(){
        action = new Actions(driver);
        action.moveToElement(loginRegisterButtonContainer).build().perform();
    }

    public void waitForLoginRegisterButtonContainer(int time){
        new WaitHelper(driver).waitForElement(loginRegisterButtonContainer,time);
    }



    public void clickToLoginButton(){
        loginButton.click();
    }

    public void fillEmailBox(String string){
        emailTxtBox.sendKeys(string);
    }

    public void fillPasswordBox(String string){
        passwordTxtBox.sendKeys(string);
    }

    public void submitLogin(){
        loginSubmit.click();
    }

    public void waitForPopupLoginMain(int time){
        new WaitHelper(driver).waitForElement(popupLoginMain,time);
    }






}
