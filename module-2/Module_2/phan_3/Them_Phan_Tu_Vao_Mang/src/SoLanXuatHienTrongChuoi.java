import java.util.Scanner;
public class SoLanXuatHienTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao dong chu: ");
        String s = sc.nextLine();
        System.out.println("Nhap vao chu muon kiem tra:");
        char c = sc.next().charAt(0);
        int count = 0;
        for (int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        System.out.println("So lan xuat hien trong chuoi la: "+ count);
    }
}
