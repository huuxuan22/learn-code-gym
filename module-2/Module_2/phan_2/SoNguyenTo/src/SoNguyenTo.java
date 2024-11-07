// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SoNguyenTo {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;

        System.out.println("20 so nguyen to dau tien la:");

        while (count < 20) {
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            }

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
    }
}