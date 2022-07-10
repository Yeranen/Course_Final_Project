package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//a[@class='navBlockTitle']/span")
    public List<WebElement> span_Titles;

    @FindBy(how = How.XPATH, using = "//a[@class='navBlockTitle']")
    public List<WebElement> btn_Titles;

    @FindBy(how = How.XPATH, using = "//div[@class='navBlockDescription']/span")
    public List<WebElement> span_TitlesDescriptions;


    @FindBy(how = How.XPATH, using = "//a[@id='siteLanguageEnglish']")
    public WebElement btn_SwitchToEng;

    @FindBy(how = How.XPATH, using = "//a[@id='siteLanguageHebrew']")
    public WebElement btn_SwitchToHeb;

}
