package TimChuoiLienTiepCoDoDaiLonNhat;

import java.util.ArrayList;
import java.util.Scanner;

public class ChuoiLienTiep {
    public static String findStringMax(String inputWord){
        ArrayList<Character> subString = new ArrayList<>(0);
        ArrayList<Character> maxString = new ArrayList<>(0);

        // chèn từng phần tử muốn kiếm tra vào trong mảng subString
        for (char word : inputWord.toCharArray()){
            subString.add(word);
        }
        ArrayList<Character> sub = new ArrayList<>();
        for (int i=0;i<subString.size();i++){
            char firstCharacter = subString.get(i);
            sub.clear();
            sub.add(subString.get(i));
            for (int j=i+1;j<subString.size();j++){
                if (firstCharacter < subString.get(j)){
                    sub.add(subString.get(j));
                    firstCharacter = subString.get(j);
                }else {
                    break;
                }
            }
            if (sub.size() > maxString.size()){
                maxString.clear();
                maxString.addAll(sub);
            }
        }

        return maxString.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi để tìm kiếm: ");
        String inputWord = sc.nextLine();
        System.out.println("Chuỗi sau khi tìm là: "+ findStringMax(inputWord));
    }
}
