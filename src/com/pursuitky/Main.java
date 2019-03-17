package com.pursuitky;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> save = new ArrayList<String>();
        Hero hero = new Hero("Conan", 50, 5);
        Monster monster = new Monster("Duergar", 40, 6);
        boolean quit = false;

        printMenu();

        while (!quit) {
            Combat combat = new Combat();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("And the Teensy-Weensy-" + hero.getName() + " went 'WAH WAH WAH' all the way home.");
                    quit = true;
                    break;
                case 1:
                    System.out.println(hero.toString());
                    break;
                case 2:
                    System.out.println("Name:");
                    String name = scanner.nextLine().replace("\"","");
                    System.out.println("Health:");
                    int health = scanner.nextInt();
                    System.out.println("Damage:");
                    int damage = scanner.nextInt();

                    hero = new Hero(name, health, damage);
                    break;
                case 3:
                    save = hero.save();
                    break;
                case 4:
                    hero.load(save);
                    break;
                case 5:
                    combat.fight(hero, monster);
                    hero.revive();
                    monster.revive();
                    printMenu();
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("*******************************");
        System.out.println("0: Run away!");
        System.out.println("1: Hero Information");
        System.out.println("2: New Hero");
        System.out.println("3: Save Hero");
        System.out.println("4: Load Hero");
        System.out.println("5: FIGHT!");
        System.out.println("6: Print Menu");
        System.out.println("*******************************");
    }
}
