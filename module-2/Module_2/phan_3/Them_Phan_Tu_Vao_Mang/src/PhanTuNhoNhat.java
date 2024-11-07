import java.util.Random;
import java.util.Scanner;

public class PhanTuNhoNhat {
    public static int minArr(int [][] arr){
        int min = arr[0][0];
        for (int i=0;i<arr.length;i++){
        for (int j=0;j<arr[i].length;j++){
            if (min > arr[i][j]){
                min = arr[i][j];
            }
        }
    }
        return min;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("so cot:");
        int col = sc.nextInt();
        System.out.println("So hang");
        int row = sc.nextInt();
        int [][] arr = new int [row][col];
        // nhap mang
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                arr[i][j]= random.nextInt(100);
            }
        }
        // xuat mang
        System.out.println("Mang cua ban sau khi nhap: ");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Phan tu nho nhat trong mang la: "+ minArr(arr));
    }
}
