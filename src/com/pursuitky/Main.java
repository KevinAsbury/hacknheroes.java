package com.pursuitky;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<String>();
	    Hero hero = new Hero("Conan", 50, 5);
	    Monster monster = new Monster("Duergar", 40, 6);
        boolean quit = false;

        printMenu();

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("And the Teensy-Weensy-" + hero.getName() + " went 'WAH WAH WAH' all the way home.");
                    quit = true;
                    break;
                case 1:
                    values = hero.save();
                    break;
                case 2:
                    hero.load(values);
                    break;
                case 3:
                    Combat.fight(hero, monster);
                    printMenu();
                    break;
                case 4:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("0: Run away little girl!");
        System.out.println("1: Save Hero");
        System.out.println("2: Load Hero");
        System.out.println("3: FIGHT!");
        System.out.println("4: Print Menu");
    }
}
