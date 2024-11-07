import java.util.Arrays;
public class MinhHoaThuatToan {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử lớn hơn key đến vị trí cao hơn trong mảng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            // Hiển thị mảng sau mỗi bước
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        System.out.println("Mảng ban đầu: " + Arrays.toString(array));
        System.out.println("Bắt đầu sắp xếp chèn:");
        insertionSort(array);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array));
    }
}
