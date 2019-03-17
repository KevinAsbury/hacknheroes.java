package com.pursuitky;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
    private String name;
    private int hp;
    private int damage;

    public Monster(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public void attack(Hero hero){
        if (Combat.isHit() && hero.isAlive()) {
            System.out.println(this.name + " swings at " + hero.getName() + " and hits! " + Combat.score(hero, this));
            hero.getHit(Combat.damage(this.damage));
        }
    }

    public int getHit(int damage) {
        return this.hp -= damage;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        if (this.hp > 0) {
            return true;
        }

        System.out.println(this.name + " gurgles one last breath and falls over dead.");
        return false;
    }

    public String getName() {
        return this.name;
    }

}
