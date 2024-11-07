package ChuoiPalidrome;

import java.util.*;

public class chuoiPalidrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> word = new ArrayList<>();
        String inputWord = sc.nextLine();
        Stack<Character> name = new Stack<>();
        Queue<Character>  name1 = new ArrayDeque<>();
        int n=0;
        for (char h : inputWord.toCharArray()){
            name.push(h);
            name1.add(h);
            n++;
        }
        boolean check = true;
        for (int i=0;i<n;i++){
            if(!name.pop().equals(name1.poll())){
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("la chuoi Paridrome.");
        }else {
            System.out.println("Khong phai La chuoi Paridrome.");
        }
    }
}
