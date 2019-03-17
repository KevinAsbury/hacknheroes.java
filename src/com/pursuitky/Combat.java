package com.pursuitky;

import java.util.Random;

public class Combat {
    public static int damage(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public static int damage(int max) {
        return (int)(Math.random() * ((max - 1) + 1)) + 1;
    }

    public static boolean isHit() {
        return new Random().nextBoolean();
    }

    public static String score(Hero hero, Monster monster) {
        return String.format("(%s: %d, %s: %d)", hero.getName(), hero.getHp(), monster.getName(), monster.getHp());
    }

    public void fight(Hero hero, Monster monster) {
        while (hero.isAlive() && monster.isAlive()) {
            if (new Random().nextBoolean()) {
                hero.attack(monster);
            } else {
                monster.attack(hero);
            }
        }
    }
}
