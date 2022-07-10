package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageobjects.*;

import java.util.List;

public class Base {

    protected static WebDriver driver;
    protected static Wait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String mainWinHan;
    protected static List<String> winHands;
    protected static JavascriptExecutor js;


    //Pages Objects

    protected static UpperBar UpperBarObj;
    protected static LogInPage LogInObj;
    protected static HomePage HomeObj;

}
