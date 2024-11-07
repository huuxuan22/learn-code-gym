import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 3 so a b c");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        QuadraticEquation PTB2 = new QuadraticEquation(a,b,c);
        System.out.println("delta= "+ PTB2.getDiscriminant());
        double delta = PTB2.getDiscriminant();
        if(delta > 0){
            System.out.print("x1 = "+ PTB2.getRoot1());
            System.out.print("\nx2 = "+ PTB2.getRoot2());
        }else if (delta == 0){
            System.out.print("phuong trinh co nghiem kep x1=x2="+ -b/2*a);
        }else {
            System.out.print("The equation has no roots1");
        }
    }
}
