package KiemTraDauNgoac;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class KiemTraDauNgoac {

    public static boolean checkWord(String word){
        Stack<Character> characters = new Stack<>();
        for (char h : word.toCharArray()){
            if(h == '(' || h == '[' || h == '{'){
                characters.push(h);
            }else if (h == ')' || h == ']' || h == '}'){
                if (characters.isEmpty()){
                    return false;
                }
                char left = characters.pop();
                if (!isMatching(left,h)){
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }
    private static boolean isMatching(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao chuoi: ");
        String inputWord = sc.nextLine();
        System.out.println(checkWord(inputWord));
    }
}
