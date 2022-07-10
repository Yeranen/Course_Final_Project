package extensions;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class Verifications extends CommonOps {

    @Step("Verify Element Text")
    public static void verifyElement_Text(String _expected, WebElement _elem) {
        wait.until(ExpectedConditions.visibilityOf(_elem));
        assertEquals(_expected, _elem.getText());
    }

    @Step("Verify Elements Number")
    public static void verifyElements_Number(int _expected, List<WebElement> _elems) {
        wait.until(ExpectedConditions.visibilityOf(_elems.get(_elems.size() - 1))); // ממתין עד שהאלמנט האחרון ברשימה יופיע
        assertEquals(_expected, _elems.size());
    }

    @Step("Verify Element Visibility")
    public static void verifyElement_Visibility(WebElement _elem, String _shouldVisible) {
        if (_shouldVisible.equalsIgnoreCase("Yes")) {
            try {
                wait.until(ExpectedConditions.visibilityOf(_elem));
            } catch (NoSuchElementException e) {
                assertTrue(false);
                fail();
            }
            assertTrue(_elem.isDisplayed());
        }
        else if (_shouldVisible.equalsIgnoreCase("No")){
            try {
                wait.until(ExpectedConditions.visibilityOf(_elem));
            } catch (TimeoutException e) {
                assertFalse(false);
        }
    }
        else throw new RuntimeException(("Invalid Expected Output Option, Should Be 'Yes' or 'No'"));
    }


    @Step("Business Flow: Search and verify User")
    public static void verifyElement_Existence(String  _Xpath, String _shouldExist){
        if (_shouldExist.equalsIgnoreCase("Yes"))
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_Xpath)));
                assertTrue(true);
                System.out.println("Test Passed: Element Is Exist On DOM");
            }catch (NoSuchElementException e) {
                System.out.println("Test Failed: Element Should Exist On DOM, But It's Not ");

            }catch (Exception e){
                System.out.println("Some Thing is Wrong: ");
                System.out.println("------------------");
                System.out.println(e);
                System.out.println("------------------");
                e.printStackTrace();
                System.out.println("------------------");
            }
        else if (_shouldExist.equalsIgnoreCase("No"))
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(_Xpath)));
                System.out.println("Test Failed: Element Should Not Exist on Dom, But It Is");
                fail();

            }catch (NoSuchElementException e) {
                assertFalse(false);
                System.out.println("Test Passed: Element Not Exist On DOM");
            }catch (Exception e){
                System.out.println("Some Thing is Wrong: ");
                System.out.println("-----------------");
                System.out.println(e);
                System.out.println("-----------------");
                e.printStackTrace();
                System.out.println("-----------------");
            }
            else throw new RuntimeException(("Invalid Expected Output Option, Should Be 'Yes' or 'No'"));
            }

    @Step("Verify Element Visualise By Sikuli")
    public static void verifyElement_Visuality_BySikuli(String _expectedImageName){
        try {
            screen.find(getData_From_XML_Config("SikuliImageRepo") + _expectedImageName + ".png");
        }catch (FindFailed findFailed){
            System.out.println("Error Comparing Image File: " + findFailed);
           fail();
        }

    }

    @Step("Verify Elements Visibility") // מוודא כל פעם שאלמנט אחר מהרשימה מוצג בדף
    public static void verifyElements_Visibility(List<WebElement> _elems){
//        wait.until(ExpectedConditions.visibilityOf(_elems.get(_elems.size() - 1)));  כנראה  השורה הזו לא הולכת כשעובדים עם וידוא נראות של רשימת אלמנטים
        for (WebElement elem : _elems){
            softAssert.assertTrue(elem.isDisplayed(),"elem "+ elem.getText() + "is not displayed");
        }
        softAssert.assertAll();

    }

    @Step("Verify Elements Text With DDT")
    public static void verifyElements_text(List<WebElement> _elems,String _expectedText) {

        List<String> _elemsTexts = getTexts_From_ElementsList(_elems);
        assertTrue( _elemsTexts.contains(_expectedText));
    }




    @Step("Verify Page URL")
    public static void verifyPage_URL(String _expectedURL) {
        assertEquals(_expectedURL, driver.getCurrentUrl());

    }

    @Step("Verify Page URL Contains")
    public static void verifyPage_URLContains(String _expectedURLContent) {
        String URL = driver.getCurrentUrl();
        assertTrue(URL.contains(_expectedURLContent));

    }

    @Step("Verify Page Title")
    public static void VerifyPage_Title(String _expectedTitle) {
        assertEquals(_expectedTitle, driver.getTitle());

    }

    // Soft Verifies

    @Step("Soft Verify Element Text")
    public static void softVerifyElement_Text(String _expected, WebElement _elem) {
        wait.until(ExpectedConditions.visibilityOf(_elem));
        softAssert.assertEquals(_expected, _elem.getText());

    }

    @Step("Soft Verify Element Visibility")
    public static void softVerifyElement_Visibility(WebElement _elem){
        wait.until(ExpectedConditions.visibilityOf(_elem));
        softAssert.assertTrue(_elem.isDisplayed());

    }

    @Step("Soft Verify Element Visibility")
    public static void softVerifyElement_Invisibility(WebElement _elem){
        softAssert.assertFalse(_elem.isDisplayed());

    }

    @Step( "Soft Verify Element Existence")
    public static void softVerifyElement_Existence(WebElement _elem){
        boolean present;
        try {
            wait.until(ExpectedConditions.visibilityOf(_elem));
            present = true;
        } catch (TimeoutException e) {
            present = false;
        }
        softAssert.assertTrue(present);

    }

    @Step( "Soft Verify Element UnExistence")
    public static void softVerifyElement_UnExistence(WebElement _elem){
        boolean present;
        try {
            wait.until(ExpectedConditions.visibilityOf(_elem));
            present = false;
        } catch (TimeoutException e) {
            present = true;
            System.out.println("Exeption Details: " + e);
        }
        softAssert.assertTrue(present);

    }

    @Step("Soft Verify Assert All")
    public static void softVerify_AssertAll(){
        softAssert.assertAll();

    }

}//Class