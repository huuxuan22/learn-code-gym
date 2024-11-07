import java.util.Scanner;
import java.util.Random;


public class TinhTongCot {
    public static int sumRow(int[][] arr,int n){
        int sum = 0;
        for (int i=0;i< arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if(j==n){
                    sum += arr[i][j];
                    break;
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
        System.out.println("Nhap vao so cot muon cong");
        int row = sc.nextInt();
        System.out.println("Tong so cot la: "+ sumRow(arr,row));
    }
}
