import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {
    private int id;
    private String ten;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CSV(int id, String ten, String name) {
        this.id = id;
        this.ten = ten;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CSV{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CSV> listCSV = new ArrayList<>();
        listCSV =readFile();
        for (CSV csv : listCSV){
            System.out.println(csv);
        }
    }

    public static List<CSV> readFile(){
        List<CSV> csvList =new ArrayList<>();
        // bỏ vào trong try-width-source
        try{
            FileReader fileReader = new FileReader("D:\\Module_2\\Phan_16\\doc_File_CSV\\CSV.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";
                // cách tách ra để thêm dấu phẩy vào trong
                while ((line = bufferedReader.readLine()) != null) {
                    String[] part = line.split(",");
                        int id = Integer.parseInt(part[0]);
                        String ten = part[1];
                        String name = part[2];
                        csvList.add(new CSV(id, ten, name));
                    }

        }catch (Exception e){
            System.out.println("Đọc file không có thành công/"+ e.getMessage());
        }
        return csvList;
    }
}
