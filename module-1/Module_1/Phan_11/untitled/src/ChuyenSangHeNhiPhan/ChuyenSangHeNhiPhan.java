package ChuyenSangHeNhiPhan;

import java.util.Scanner;
import java.util.Stack;

public class ChuyenSangHeNhiPhan {
    public static void chuyenDoiNhiPhan(Stack<Integer> list,int n){
        if (n == 0){
            return;
        }else {
            while (n != 0) {
                int r = n % 2;
                list.push(r);
                n = n / 2;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Stack<Integer> list = new Stack<>();
        boolean flag = false;
        do {
            System.out.println("Nhập vào số để chuyển đổi: ");
            int n = Integer.parseInt(sc.nextLine());
            chuyenDoiNhiPhan(list,n);
            System.out.println("Chuyen sang he nhi phan: "+ list);
        }while (flag);
    }
}
