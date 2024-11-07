import java.util.Random;
import java.util.Scanner;
public class GopMang {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("ban muon mang thu 1 co bn phan tu: ");
        int n1 = sc.nextInt();
        int [] arr1 = new int[n1];
        System.out.println("Ban muon mang thu 2 co bn phan tu:");
        int n2 = sc.nextInt();
        int [] arr2 = new int[n2];
        for (int i=0;i<n1;i++){
            arr1[i] = random.nextInt(100);
        }
        for (int i=0;i<n2;i++){
            arr2[i] = random.nextInt(100);
        }
        System.out.println("Mang cua ban sau khi nhap:");
        for (int i=0;i<n1;i++){
            System.out.println("arr1["+i+"]= "+ arr1[i]);
        }
        for (int i=0;i<n2;i++){
            System.out.println("arr1["+i+"]= "+ arr2[i]);
        }
        int [] arr3 = new int [n1+n2];
        // gop mang
        for (int i=0;i<n1;i++){
            arr3[i] = arr1[i];
        }
        for (int i=0;i<n2;i++){
            arr3[n1+i]  = arr2[i];
        }
        // xuat mang sau khi gop
        System.out.println("Mang sau khi gop:");
        for (int i=0;i<(n1+n2);i++){
            System.out.println("arr3["+i+"]= "+ arr3[i]);
        }
    }
}
