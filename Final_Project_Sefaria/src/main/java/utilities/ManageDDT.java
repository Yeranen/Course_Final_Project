package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;


public class ManageDDT extends CommonOps{


    @DataProvider(name = "Categories-Titles")
    public Object[] getDataObjectTiles(){
        return getDataFromCSVTitles(".\\DDTFiles\\Titles.csv");
    }

    public static Object[] getDataFromCSVTitles(String _filePath){
        Object[] data = new Object[14];
        List<String> csvData = readCSV(_filePath);
        for (int i = 0; i < csvData.size(); i++){
            data[i] = csvData.get(i);

        }return  data;
    }






    //Serves all Providers reading from CSV

    static public List<String> readCSV(String _csvFile){
        List<String> lines = null;
        File file = new File(_csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        }catch (IOException e){

            e.printStackTrace();

        }return lines;
    }

}//class
