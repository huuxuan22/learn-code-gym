import java.util.Random;
import java.util.Scanner;
public class xoaPhanTuMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("ban muon nhap bao nhieu phan tu: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println("mang cua ban sau khi nhap la: ");
        for (int i=0;i<n;i++){
            System.out.print("a["+i+"]= " + arr[i]);
            System.out.println();
        }
        System.out.println(" ban muon xoa phan tu thu may: ");
        int m = sc.nextInt();
        if (m >= n){
            System.out.println("khong co trong danh sach");
        }else {
            for (int i = 0; i < n; i++) {
                if (i == m) {
                    for (int j = m; j < n-1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    n--;
                    break;
                }
            }
        }
        System.out.println("mang cua ban sau khi xoa la: ");
        for (int i=0;i<n;i++){
            System.out.print("a["+i+"]= " + arr[i]);
            System.out.println();
        }
    }
}
