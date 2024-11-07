package phan_1;
import java.util.Scanner;
public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float USD,VND;
        System.out.println("Nhap vao so tien muon doi: ");
        USD = sc.nextInt();
        VND = USD*23000;
        System.out.println("khi chuyen ra tien Viet Nam la: "+ VND+ "VND");
    }
}
