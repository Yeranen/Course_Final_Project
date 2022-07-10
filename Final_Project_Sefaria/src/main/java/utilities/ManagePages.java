package utilities;

import org.openqa.selenium.support.PageFactory;
import pageobjects.*;

public class ManagePages extends Base {

    public static void initSefaria(){
        UpperBarObj = PageFactory.initElements(driver, UpperBar.class);
        LogInObj = PageFactory.initElements(driver, LogInPage.class);
        HomeObj = PageFactory.initElements(driver, HomePage.class);
    }

}
