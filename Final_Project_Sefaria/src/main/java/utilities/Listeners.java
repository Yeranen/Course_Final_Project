package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

//שימוש ב extnds זה הורשה, שימוש ב implements זה שימוש באינטרפייס
public class Listeners extends CommonOps implements ITestListener {

    @Attachment(value = "page screenshot", type = "image/png")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


    public void onStart(ITestContext execution){
        // TODO Auto-generated method stub
        System.out.println("<<----------------- Starting Execution ----------------->>");
    }

    public void onFinish(ITestContext execution){
        // TODO Auto-generated method stub
        System.out.println("<<----------------- Ending Execution ----------------->>");
    }

    public void onTestStart(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("----------------- Starting Test: " + test.getName() + "-----------------");


    }

    public void onTestSuccess(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("----------------- Test: " + test.getName() + " Passed-----------------");

        //Stop Recording
        try{
            MonteScreenRecorder.stopRecord();
        }catch (Exception e){
                     e.printStackTrace();
                             }
        //Delete Recorded File
        File file = new File("C:\\Users\\yrnp7\\Desktop\\MidProject_Sefaria\\RecordedTests\\"+ test.getName() +".avi");
   if (file.delete())
       System.out.println("File Deleted Successfully");
   else
       System.out.println("Failed to Delete File");
    }

    public void onTestFailure(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("----------------- Test: " + test.getName() + " Failed-----------------");

        //Stop Recording
               try{
            MonteScreenRecorder.stopRecord();
                 }catch (Exception e){
                     e.printStackTrace();
                            }
        saveScreenshot();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Implements this....
    }

    public void onTestSkipped(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("----------------- Skipped Test: " + test.getName() + "-----------------");
    }

}//class

