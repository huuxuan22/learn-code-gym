import java.util.Scanner;
import java.util.Random;
public class PhanTuLonNhat {
    public static int maxArr(int [][] arr){
        int max = 0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        return max;
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
        System.out.println("Phan tu lon nhat trong mang la: "+ maxArr(arr));
    }
}
