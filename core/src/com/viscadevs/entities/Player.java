package com.viscadevs.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Constants;

public class Player {

    private String name;
    private String gender;
    private int money = 0;
    private int health = Constants.INITIAL_HEALTH;
    private int popularity = 0;
    private int happiness = -20;
    private Vector2 position;
    private Texture texture;

    public Player(String name, int money, String gender, int health, int popularity, int happiness, Vector2 position) {
        this.name = name;
        this.gender = gender;
        this.money = money;
        this.health = health;
        this.popularity = popularity;
        this.happiness = happiness;
        this.position = position;
    }

    public void dispose() {
        texture.dispose();
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
