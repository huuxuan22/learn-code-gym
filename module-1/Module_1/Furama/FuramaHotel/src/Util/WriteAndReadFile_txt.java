package Util;

import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile_txt {
    public static void WriteArrayListToTXT(String pathFile, List<String> list, boolean append) {
        try(
                FileWriter fileWriter = new FileWriter(pathFile,append);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                ){

            for (String line: list){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        }catch (Exception e){
            System.out.println("Đọc file không thành công. Lỗi trong packet File");
        }
    }


    // tách ra đối với mảng chính của nó là Facility
    public static ArrayList<String> readFileTXT(String pathFile){
        ArrayList<String> stringList = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line ="";
            while ((line=bufferedReader.readLine())!=null){
                stringList.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return (ArrayList<String>) stringList;
    }
    public  static void deteleFileTXT(String FILE_PATH){
        File file = new File(FILE_PATH);

    }
}
