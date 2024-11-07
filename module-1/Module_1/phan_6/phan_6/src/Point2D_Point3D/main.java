package Point2D_Point3D;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point2D point2D = new Point2D();
        System.out.println("nhap vao toa do x va y: ");
        point2D.x = sc.nextInt();
        point2D.y = sc.nextInt();
        System.out.println("toa do 2 diem x va y la: "+ point2D);
        System.out.println("Nhap vao 3 diem cua toan do x y z: ");
        Point3D point3D = new Point3D();
        point3D.x = sc.nextInt();
        point3D.y = sc.nextInt();
        point3D.setZ(sc.nextInt());
        System.out.println(Arrays.toString(point3D.getXYZ()));
        System.out.println("toa do 3 diem x,y va z la: "+ point3D);
    }
}
