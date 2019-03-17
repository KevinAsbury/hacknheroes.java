package com.pursuitky;

import java.util.ArrayList;
import java.util.Random;

public class Monster implements ISaveable {
    private String name;
    private int hp;
    private int maxhp;
    private int damage;

    public Monster(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.maxhp = hp;
        this.damage = damage;
    }

    public void attack(Hero hero){
        if (Combat.isHit() && hero.isAlive()) {
            System.out.println(this.name + " swings at " + hero.getName() + " and hits! " + Combat.score(hero, this));
            hero.getHit(Combat.damage(this.damage));
        }
    }

    public void revive() {
        if (maxhp > 0) {
            this.hp = this.maxhp;
        }
    }

    public int getHit(int damage) {
        return this.hp -= damage;
    }

    public int getHp() {
        return this.hp;
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

    @Override
    public ArrayList<String> save() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(this.name);
        data.add(Integer.toString(this.hp));
        data.add(Integer.toString(this.damage));
        return data;
    }

    @Override
    public void load(ArrayList<String> data) {
        if (!data.isEmpty()) {
            this.name = data.get(0);
            this.hp = Integer.parseInt(data.get(1));
            this.damage = Integer.parseInt(data.get(2));
        }
    }
}
