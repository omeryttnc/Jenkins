package utilities;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//@SpringBootTest

public class ReadTxt {



    public static String returntitle(String filename){
       String fullNameList = "";
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line  = br.readLine();
            while (line != null){
                fullNameList=(line );
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fullNameList;
    }
}
