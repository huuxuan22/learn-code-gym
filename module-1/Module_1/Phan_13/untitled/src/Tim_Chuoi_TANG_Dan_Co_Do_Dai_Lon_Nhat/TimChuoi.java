package Tim_Chuoi_TANG_Dan_Co_Do_Dai_Lon_Nhat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TimChuoi {
    public static String timChuoiMax(String inputWord) {
        if (inputWord == null || inputWord.isEmpty()) {
            return "";
        }
        // tạo ra 1 mảng maxString là mảng chứa chuỗi tăng dần có độ dài lớn nhất l chuỗi hiện tại
        // maxString là chuỗi cuối cùng
        // còn man subString là để tạo ra các chuỗi con tăng dần
        ArrayList<Character> subString = new ArrayList<>();
        ArrayList<Character> maxString = new ArrayList<>();

        // ép hết từng kí tự trong chuỗi vafo trong chuỗi subString
        for (char word : inputWord.toCharArray()) {
            subString.add(word);
        }

        // sub chính là mảng đại diện cho chuỗi đem so sánh với maxString nếu subString lớn hơn
        // thì cập nhật là maxString = maxString
        ArrayList<Character> sub = new ArrayList<>();
        for (int i = 0; i < subString.size(); i++) {
            char firstCharacter = subString.get(i);
            sub.clear();
            sub.add(firstCharacter);

            // tìm chuỗi tăng dần với mỗi kí tự đầu khi vòng for i chạy
            int j = i + 1;
            while (j < subString.size()) {
                if (firstCharacter < subString.get(j)) {
                    sub.add(subString.get(j));
                    firstCharacter = subString.get(j);
                }
                j++;
            }
            // nếu chuỗi sub hiện tại vừa tạo đem ra so sánh với chuỗi maxString nếu maxString nhỏ hơn thì cập nhật lại.
            if (sub.size() > maxString.size()) {
                maxString.clear();
                maxString.addAll(sub);
            }
        }


        return maxString.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 từ để tìm: ");
        String inputWord = sc.nextLine();
        System.out.println("Tìm Chuỗi có độ dài lớn nhất là: " + timChuoiMax(inputWord));
    }
}
