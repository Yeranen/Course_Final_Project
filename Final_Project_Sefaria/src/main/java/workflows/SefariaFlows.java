package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class SefariaFlows extends CommonOps {

    @Step
    public static void LogIn(String _Email, String _Password){
        UpperBarFlows.GoTo_LogInPage();
        UIActions.updateTxt(LogInObj.input_Email,_Email);
        UIActions.updateTxt(LogInObj.input_Password,_Password);
        UIActions.click(LogInObj.btn_Connect);
    }

    @Step
    public static void SwitchToEnglish(){
        UIActions.scrollIntoView(HomeObj.btn_SwitchToEng);
        UIActions.click(HomeObj.btn_SwitchToEng);
    }


}//Class
