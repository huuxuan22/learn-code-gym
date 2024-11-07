package View;

import Controller.FuramaController;

import java.util.Scanner;

public class testServiceFurama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
