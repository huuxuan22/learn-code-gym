package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteAndReadFile {
    public static void writeFileToCSV(String pathFile, ArrayList<String>stringList,boolean append){
        try{
            FileWriter fileWriter = new FileWriter(pathFile,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line: stringList ){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println("error writting file");
        }
    }

    public static ArrayList<String> readFileToCSV(String pathFile){
        ArrayList<String> stringList = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = " ";
            while((line = bufferedReader.readLine()) != null){
                stringList.add(line);
            }
        }catch (Exception e){
            System.out.println("error reading file");
        }
        return stringList;
    }
}


