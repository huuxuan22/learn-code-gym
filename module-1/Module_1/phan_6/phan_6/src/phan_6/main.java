package phan_6;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cylinder cylinder= new Cylinder(4,"blue",6);
        System.out.println("Dien tich cua hinh tron: "+cylinder.Area());
        System.out.println("Mau sac: "+cylinder.color);
        System.out.println("chieu cao: "+ cylinder.getHeight());
    }
}
