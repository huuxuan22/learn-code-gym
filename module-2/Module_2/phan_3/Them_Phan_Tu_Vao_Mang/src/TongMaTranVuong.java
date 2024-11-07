import java.util.Random;
import java.util.Scanner;

public class TongMaTranVuong {
    // pphuong thuc tinh tong duong cheo
    public static int sumDiagonalLine(int [][] arr){
        int sum = 0;
        for (int i=0;i< arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(i==j){
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("so hang va so cot: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int [n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                arr[i][j] = random.nextInt(100);
            }
        }
        System.out.println("mang cua ban sau khi nhap: ");
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("tong cua duong cheo: "+ sumDiagonalLine(arr));
    }
}
