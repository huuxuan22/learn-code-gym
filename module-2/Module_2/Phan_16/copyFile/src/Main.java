import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = " ",soucre = " ";
        try {// kiểm tra xem tệp đích và tệp nguồn có lỗi ở nơi nào hay không
            System.out.println("Nhập vào tên tên tệp đích: ");
            target = scanner.nextLine() + ".txt"; // nhập vào tên file muốn nhập
            System.out.println("Nhập vào tên tên tệp nguồn: ");
            soucre = scanner.nextLine() + ".txt"; // nhập vào tên file muốn nhập
        }catch (Exception e) {
            System.out.println("Tệp nguồn không tồn tại hoặc tệp đích đã tồn tại");
        }
        try {
            // đọc file để sao chép
            FileReader fileReader = new FileReader(soucre);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // chép file vào trong tệp
            FileWriter fileWriter = new FileWriter(target);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            // dùng while để sao chép tệp
            while (true){
                line = bufferedReader.readLine();
                if (line == null){
                    break;
                }
                bufferedWriter.write(line);
            }
            System.out.println("Đã sao chép thành công. ");
            bufferedWriter.close();
            fileWriter.close();
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){
            System.out.println("Cách viết đoạn code sao chép file không có đúng.");
        }

        try{
            // dòng lệnh để kiểm tra
            try{}catch (Exception e){}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
