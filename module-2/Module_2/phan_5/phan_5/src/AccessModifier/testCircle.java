package AccessModifier;

import java.util.Scanner;

public class testCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle();
        circle.radius = sc.nextDouble();
        System.out.println("ban kinh cua hinh tron la: "+ circle.getRadius());
        System.out.println("dien tich cua hinh tron la: "+ circle.getArea());
    }
}
