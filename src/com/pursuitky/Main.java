package com.pursuitky;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> saveHero = new ArrayList<String>();
        ArrayList<String> saveMonster = new ArrayList<String>();
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
                    System.out.print("Hero Name:");
                    String name = scanner.nextLine().replace("\"","");
                    System.out.print("Health:");
                    int health = scanner.nextInt();
                    System.out.print("Damage:");
                    int damage = scanner.nextInt();

                    hero = new Hero(name, health, damage);
                    break;
                case 3:
                    System.out.print("Monster Name:");
                    name = scanner.nextLine().replace("\"","");
                    System.out.print("Health:");
                    health = scanner.nextInt();
                    System.out.print("Damage:");
                    damage = scanner.nextInt();

                    monster = new Monster(name, health, damage);
                    break;
                case 4:
                    saveHero = hero.save();
                    saveMonster = monster.save();
                    break;
                case 5:
                    hero.load(saveHero);
                    monster.load(saveMonster);
                    break;
                case 6:
                    combat.fight(hero, monster);
                    hero.revive();
                    monster.revive();
                    printMenu();
                    break;
                case 7:
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
        System.out.println("3: New Monster");
        System.out.println("4: Save Combatants");
        System.out.println("5: Load Combatants");
        System.out.println("6: FIGHT!");
        System.out.println("7: Print Menu");
        System.out.println("*******************************");
    }
}
