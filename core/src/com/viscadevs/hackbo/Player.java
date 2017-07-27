package com.viscadevs.hackbo;

import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Constants;

/**
 * Created by Kevin Viscafe on 27/7/17.
 */

public class Player {

    private String name;
    private String gender;
    private int money = 0;
    private int health = Constants.INITIAL_HEALTH;
    private int friends = 0;
    private int happiness = -20;
    private Vector2 position;


    public Player (String name, int money, String gender, int health, int friends, int happiness, Vector2 position){

        this.name = name;
        this.gender = gender;
        this.money = money;
        this.health = health;
        this.friends = friends;
        this.happiness = happiness;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}