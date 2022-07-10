package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpperBar {

    @FindBy(how = How.XPATH, using = "//a[@class='home']")
    public WebElement btn_Home;

    @FindBy(how = How.XPATH, using = "//span[text() = 'מקורות']")
    public WebElement btn_Sources;

    @FindBy(how = How.XPATH, using = "//span[text() = 'נושאים']")
    public WebElement btn_Topics;

    @FindBy(how = How.XPATH, using = "//span[text() = 'קהילה']")
    public WebElement btn_Community;

    @FindBy(how = How.XPATH, using = "//a[@class='textLink donate']")
    public WebElement btn_Donate;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='חיפוש']")
    public WebElement input_Search;

    @FindBy(how = How.XPATH, using = "//span[@class='readerNavMenuSearchButton']")
    public WebElement btn_Search;

    @FindBy(how = How.XPATH, using = "//a[@class='login loginLink']")
    public WebElement btn_LogIn;

    @FindBy(how = How.XPATH, using = "//a[@class='login signupLink']")
    public WebElement btn_SignUp;

    @FindBy(how = How.XPATH, using = "//div[@class='help']")
    public WebElement btn_Help;

    @FindBy(how = How.XPATH, using = "//a[@class='interfaceLinks-button']")
    public WebElement btn_SelectLang;

         @FindBy(how = How.XPATH, using = "//div[@class='interfaceLinks-options']/a[text() = 'עברית']")
          public WebElement btn_SelectHeb;

          @FindBy(how = How.XPATH, using = "//div[@class='interfaceLinks-options']/a[text() = 'English']")
          public WebElement btn_SelectEng;




                // After Log In Elements

    @FindBy(how = How.XPATH, using = "//a[@aria-label='See My Saved Texts']")
    public WebElement btn_SavedTexts;

    @FindBy(how = How.XPATH, using = "//a[@aria-label = 'See New Notifications']")
    public WebElement btn_Notifications;

    @FindBy(how = How.XPATH, using = "//a[@class='my-profile']")
    public WebElement btn_Profile;

}//Class
