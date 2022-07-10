import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.LogInPage;
import pageobjects.UpperBar;
import utilities.CommonOps;
import workflows.SefariaFlows;
import workflows.UpperBarFlows;


@Listeners(utilities.Listeners.class)
public class Tests extends CommonOps{

    @Test (description = "Verify UpperBar Links" ,
            priority = 1, enabled = true)
    @Description("Verify Sources Button Link")
    public static void t01_Verify_SourcesLink(){
        UpperBarFlows.GoTo_SourcesPage();
        Verifications.verifyPage_URL(getData_From_XML_TestsData("SourcesLink"));


    }

    @Test (description = "Verify UpperBar Links" ,
            priority = 2, enabled = true)
    @Description("Verify Topics Button Link")
    public static void t02_Verify_TopicsLink(){
    UpperBarFlows.GoTo_TopicsPage();
    Verifications.verifyPage_URL(getData_From_XML_TestsData("TopicsLink"));

    }

    @Test (description = "Verify UpperBar Links" ,
            priority = 3, enabled = true)
    @Description("Verify Community Button Link")
    public static void t03_Verify_CommunityLink(){
        UpperBarFlows.GoTo_CommunityPage();
        Verifications.verifyPage_URL(getData_From_XML_TestsData("CommunityLink"));
    }

    @Test (description = "Verify UpperBar Links" ,
            priority = 4, enabled = true)
    @Description("Verify Donate Button Link -- Ignore Form ID")
    public static void t04_Verify_DonateLink(){
        UpperBarFlows.GoTo_DonatePage();
        switchToSecondWinHan();
        Verifications.verifyPage_URLContains(getData_From_XML_TestsData("DonateLinkContent"));
        driver.close();
        switchToMainWinHan();
    }

    @Test (description = "LogIn and Verify" ,
            priority = 5, enabled = true)
    @Description("Login and Verify Logged In")
    public static void t05_LogIn(){
        UpperBarFlows.GoTo_LogInPage();
        UIActions.updateTxt(LogInObj.input_Email, getData_From_XML_TestsData("UserName1"));
        UIActions.updateTxt(LogInObj.input_Password , getData_From_XML_TestsData("PassWord1"));
        UIActions.click(LogInObj.btn_Connect);
        SefariaFlows.SwitchToEnglish();
        Verifications.verifyElement_Visibility(UpperBarObj.btn_Profile,"Yes");
    }

    @Test(description = "ReLogIn - Compensation BagIssue In t05" ,
                    priority = 6, enabled = true)
    @Description("Login and Verify Logged In")
    public static void t06_Compensation_On_t05() {
        UpperBarFlows.GoTo_LogInPage();
        UIActions.updateTxt(LogInObj.input_Email, getData_From_XML_TestsData("UserName1"));
        UIActions.updateTxt(LogInObj.input_Password, getData_From_XML_TestsData("PassWord1"));
        UIActions.click(LogInObj.btn_Connect);
        SefariaFlows.SwitchToEnglish();
        Verifications.verifyElement_Visibility(UpperBarObj.btn_Profile, "Yes");
        UpperBarFlows.GoTo_HomePage();
    }

    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 7, enabled = true)
    @Description("Verify LogIn Button")
    public static void t07_Verify_UpperBarBtnsChanges_LogIn() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_LogIn, "no");
    }
    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 8, enabled = true)
    @Description("Verify SignUp Button")
    public static void t08_Verify_UpperBarBtnsChanges_SignUp() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_SignUp, "no");
    }
    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 9, enabled = true)
    @Description("Verify Help Button")
    public static void t09_Verify_UpperBarBtnsChanges_Help() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_Help, "no");
    }

    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 10, enabled = true)
    @Description("Verify SelectLang Button")
    public static void t10_Verify_UpperBarBtnsChanges_SelectLang() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_SelectLang, "no");
    }

    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 11, enabled = true)
    @Description("Verify SavedTexts Button")
    public static void t11_Verify_UpperBarBtnsChanges_SavedTexts() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_SavedTexts, "yes");
    }

    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 12, enabled = true)
    @Description("Verify Notifications Button")
    public static void t12_Verify_UpperBarBtnsChanges_Notifications() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_Notifications, "yes");
    }

    @Test(description = "Verify Upper Bar Changes After LogIn" ,
            priority = 13, enabled = true)
    @Description("Verify Profile Button")
    public static void t13_Verify_UpperBarBtnsChanges_Profile() {
        Verifications.verifyElement_Visibility(UpperBarObj.btn_Profile, "yes");
    }


    @Test (description = "DDT - Verify English Categories Titles" , dataProvider = "Categories-Titles", dataProviderClass = utilities.ManageDDT.class,
            priority = 14, enabled = true)
    @Description("DDT - Verify English Categories Titles")
    public static void t14_VerifyEnglishCategoriesTitless(String _CategoryTitle) {
        Verifications.verifyElements_text( HomeObj.span_Titles,_CategoryTitle);
    }

    @Test (description = "Sikuli - Verify Logo Visualise" ,
            priority = 15, enabled = true)
    @Description("Sikuli - Verify Logo Visualise")
    public static void t15_VerifyLogoVisualizeSikuli() {
        SefariaFlows.SwitchToEnglish();
        Verifications.verifyElement_Visuality_BySikuli("SefariaLogo");
    }



}//class
