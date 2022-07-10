package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {


    //Start Season

    public void preparation(String _platform){
        if(getData_From_XML_Config("Platform").equalsIgnoreCase("web"))
            initBrowser(getData_From_XML_Config("BrowserName"));
//    else if(_platform.equalsIgnoreCase("mobile"))
//        initMobile();
        else
            throw new RuntimeException("Invaild platform name");
    }

    public static void initBrowser(String _browserType) {
        if (_browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (_browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (_browserType.equalsIgnoreCase("IE"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData_From_XML_Config("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData_From_XML_Config("Timeout")));
        action = new Actions(driver);
        screen = new org.sikuli.script.Screen();
        js = (JavascriptExecutor)driver;
        mainWinHan = driver.getWindowHandle();
        driver.get(getData_From_XML_Config("url"));
        ManagePages.initSefaria();
    }

    public static WebDriver initChromeDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {

        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }


    //Common Operations

    public static String getData_From_XML_Config(String _XML_TagName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File XmlFile = new File("./Configuration/Config.XML");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(XmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(_XML_TagName).item(0).getTextContent();


    }   //זאת פונקציה שמקלבת שם של תגית ומחזירה ערך שבתגית בקובץ XML

    public static String getData_From_XML_TestsData(String _XML_TagName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File XmlFile = new File("./Configuration/TestsData.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(XmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(_XML_TagName).item(0).getTextContent();
    }

    public static List<String> getTexts_From_ElementsList(List <WebElement> _elems){
        return readTexts_From_ElementsList(_elems);
    }

    public static List<String> readTexts_From_ElementsList(List <WebElement> _elems){

            List<String> ElementsTexts = new ArrayList<>();

            for (int i=0 ; i< _elems.size() ; i++) {
                ElementsTexts.add(i, _elems.get(i).getText());
                System.out.println(ElementsTexts.get(i) + "Added to Elements List At Index: " + i);
            }
            return ElementsTexts;
        }



    public static void switchToMainWinHan(){
                driver.switchTo().window(mainWinHan);
    }

    public static void switchToSecondWinHan(){
       Set<String> WinHandles =  driver.getWindowHandles();

       for (String WinHan : WinHandles){
           if (WinHan == mainWinHan)
               continue;
           else driver.switchTo().window(WinHan);
       }

    }





    @BeforeClass
    public void Start() {
        preparation(getData_From_XML_Config("Platform"));
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void Shutting(){
    driver.quit();
    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MonteScreenRecorder.startRecord(method.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}


