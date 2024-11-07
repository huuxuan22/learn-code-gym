import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class innertSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn nhập mảng có bao nhiêu phần tử: ");
        int size = Integer.parseInt(sc.nextLine());
        int [] arrays = new int[size];
        for (int i=0;i<size;i++){
            arrays[i] = random.nextInt(100) + 1;
        }
        insertionSort(arrays);
        System.out.println("Mảng của bạn sau khi sắp xếp là: ");
        for (int i=0;i<size;i++){
            System.out.println(arrays[i]);
        }
    }
}
