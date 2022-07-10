package workflows;

import extensions.UIActions;
import utilities.CommonOps;

public class UpperBarFlows extends CommonOps {


    public static void GoTo_HomePage(){
        UIActions.click(UpperBarObj.btn_Home);
    }

    public static void GoTo_SourcesPage(){
        UIActions.click(UpperBarObj.btn_Sources);
    }

    public static void GoTo_TopicsPage(){
        UIActions.click(UpperBarObj.btn_Topics);
    }

    public static void GoTo_CommunityPage(){
        UIActions.click(UpperBarObj.btn_Community);
    }

    public static void GoTo_DonatePage(){
        UIActions.click(UpperBarObj.btn_Donate);
    }

    public static void Search_SearchBar(String _text){
        UIActions.updateTxt(UpperBarObj.input_Search, _text);
        UIActions.click(UpperBarObj.btn_Search);
    }

    public static void GoTo_LogInPage(){
        UIActions.click(UpperBarObj.btn_LogIn);
    }

    public static void GoTo_SignUp(){
        UIActions.click(UpperBarObj.btn_SignUp);
    }

    public static void GoTo_HelpPage(){
        UIActions.click(UpperBarObj.btn_Help);
    }

    public static void SelectLang_Heb(){
        UIActions.click(UpperBarObj.btn_SelectLang);
        UIActions.click(UpperBarObj.btn_SelectHeb);
    }

    public static void SelectLang_Eng(){
        UIActions.click(UpperBarObj.btn_SelectLang);
        UIActions.click(UpperBarObj.btn_SelectEng);
    }


}//Class
