package com.whitecloak.training.rpg.menu;

import java.util.Scanner;

public class MainMenu {

    private static final HeroMenu heroMenu = new HeroMenu();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (showMainMenu(scanner)) { }
    }

    private static boolean showMainMenu(Scanner scanner) {
        System.out.println("\n\nWELCOME!!!\n");
        System.out.println("[1] List heroes");
        System.out.println("[2] Create hero");
        System.out.println("[0] Exit program");
        System.out.println("\n");
        System.out.print("Enter number of choice: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 0:
                return false;
            case 1:
                heroMenu.listHeroes();
                break;
            case 2:
                heroMenu.createHero(scanner);
                break;
            default:
        }
        return true;
    }
}
