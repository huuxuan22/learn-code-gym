package DaoNguocSoNguyenToInStack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> listInt = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int soNguyen;
        boolean flag = true;
        do {
            System.out.println("Nhập 0 để dừng: ");
            soNguyen = Integer.parseInt(sc.nextLine());
            if (soNguyen != 0){
                list.add(soNguyen);
            }
            if (soNguyen==0){
                flag = false;
            }
        }while(flag);
        System.out.println("Dãy số sau khi nhập là: ");
        System.out.println(list);
        System.out.println("Danh sách sau khi đảo ngược là: ");
        for (int i=0;i<list.size();i++){
            listInt.push(list.get(i));
        }
        for (int i=0;i<list.size();i++){
            list.set(i,listInt.pop());
        }
        System.out.println("Danh sách đảo ngược là: "+ list);
    }
}
