package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click")
    public static void click(WebElement _elem){
        wait.until(ExpectedConditions.elementToBeClickable(_elem));
        _elem.click();
    }

    @Step("Send Keys")
    public static void updateTxt(WebElement _elem, String _textToSend){
        wait.until((ExpectedConditions.visibilityOf(_elem)));
        _elem.sendKeys(_textToSend);
    }

    @Step("Send Keys")
    public static void updateTxtSlowly(WebElement _elem, String _textToSend){
        wait.until((ExpectedConditions.visibilityOf(_elem)));
        for (char ch : _textToSend.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            _elem.sendKeys(ch+"");
        }
    }

    @Step("Select From Drop Down")
    public static void chooseDropDown(WebElement _elem, String _selectBytext){
        wait.until((ExpectedConditions.visibilityOf(_elem)));
        Select dropDown = new Select(_elem);
        dropDown.selectByVisibleText(_selectBytext);
    }

    @Step("Mosue Hover")
    public static void mouseHover(WebElement _elem){
        wait.until((ExpectedConditions.visibilityOf(_elem)));
        action.moveToElement(_elem).build().perform();

    }

    @Step("Scroll To View Element")
    public static void scrollIntoView(WebElement _elem){
        wait.until((ExpectedConditions.visibilityOf(_elem)));
    js.executeScript("arguments[0].scrollIntoView(true);",_elem);
    }

}
