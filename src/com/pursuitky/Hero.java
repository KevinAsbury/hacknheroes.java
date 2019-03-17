package com.pursuitky;

import java.util.ArrayList;

public class Hero implements ISaveable {
    private String name;
    private int hp;
    private int damage;

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public void attack(Monster monster){
        if (Combat.isHit() && monster.isAlive()) {
            System.out.println(this.name + " hacks at " + monster.getName() + " and hits! " + Combat.score(this, monster));
            monster.getHit(Combat.damage(this.damage));
        }
    }

    public int getHit(int damage) {
        return this.hp -= damage;
    }

    public boolean isAlive() {
        if (this.hp > 0) {
            return true;
        }

        System.out.println(this.name + " dies an agonizing death crying for their mommy. :*(");
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public ArrayList<String> save() {
        return null;
    }

    @Override
    public void load(ArrayList<String> data) {

    }
}
