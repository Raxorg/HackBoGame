package com.viscadevs.entities;

import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

public class Player {

    private String name;
    private Enums.Gender gender;
    private int money = 20;
    private int health = Constants.INITIAL_HEALTH;
    private int popularity = 0;
    private int happiness = -20;
    private Vector2 position;

    public Player(String name, int money, Enums.Gender gender, int health, int popularity, int happiness, Vector2 position) {
        this.name = name;
        this.gender = gender;
        this.money = money;
        this.health = health;
        this.popularity = popularity;
        this.happiness = happiness;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enums.Gender getGender() {
        return gender;
    }

    public void setGender(Enums.Gender gender) {
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
        return popularity;
    }

    public void setFriends(int friends) {
        this.popularity = friends;
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
