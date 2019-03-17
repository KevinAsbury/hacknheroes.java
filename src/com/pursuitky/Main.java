package com.pursuitky;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Hero hero = new Hero("Conan", 50, 5);
	    Monster monster = new Monster("Duergar", 40, 6);

	    while (hero.isAlive() && monster.isAlive()) {
	        if (new Random().nextBoolean()) {
                hero.attack(monster);
            } else {
	            monster.attack(hero);
            }
        }
    }
}
