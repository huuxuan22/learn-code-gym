package howToColor;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap bao nhieu hinh: ");
        n = Integer.parseInt(sc.nextLine());
        Shape shape = new Shape();
        Shape [] shapes= new Shape[4];
            shapes[0] = new Circle();
            shapes[1] = new retangle();
            shapes[2] = new Square();
            shapes[3] = new Square();
            for (int i=0;i<4;i++){
                System.out.println("dien tich la: "+ shapes.getArea());
            }
    }
}
