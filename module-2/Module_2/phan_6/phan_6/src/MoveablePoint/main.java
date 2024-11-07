package MoveablePoint;

import Point2D_Point3D.Point3D;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point point = new Point(2,3);
        System.out.println(point);
        MoveablePoint moveablePoint = new MoveablePoint(2,4);
        System.out.println(moveablePoint);
    }
}
