// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.util.Random;
public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Ban muon nhap mang co bao nhieu phan tu: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println("Mang cua ban sau khi nhap: ");
        for (int i=0;i<n;i++){
            System.out.print("a["+i+"]= " + arr[i]);
            System.out.println();
        }
        System.out.println("Ban muon them phan tu thu may: ");
        int m = sc.nextInt();
        System.out.println("phan tu them vao: ");
        int l = sc.nextInt();
        int [] brr = new int[n+1];
        for (int i=0;i<n;i++){
            brr[i] = arr[i];
        }
        for (int i=0;i<n;i++){
            if(i==m){
                for (int j=n;j>m;j--){
                    brr[j] = brr[j-1];
                }
                brr[m] = l;
            }
        }
        System.out.println("Mang cua ban sau khi them");
        for (int i=0;i<=n;i++){
            System.out.print("a["+i+"]= "+ brr[i]);
            System.out.println();
        }
    }
}