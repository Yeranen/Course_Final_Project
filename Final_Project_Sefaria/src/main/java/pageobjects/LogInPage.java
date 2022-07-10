package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {

    @FindBy(how = How.XPATH, using = "//input[@id ='id_email']")
    public WebElement input_Email;

    @FindBy(how = How.XPATH, using = "//input[@id='id_password']")
    public WebElement input_Password;

    @FindBy(how = How.XPATH, using = "//button[@id='login-submit-button']")
    public WebElement btn_Connect;
}
