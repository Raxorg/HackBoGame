package com.viscadevs.hackbo;

import com.viscadevs.util.Constants;

/**
 * Created by Kevin Viscafe on 27/7/17.
 */

public class Player {

    public String name;
    public String gender;
    public int money = 0;
    public int health = Constants.INITIAL_HEALTH;
    public int friends = 0;
    public int happiness = -20;

    public Player (String name, int money, String gender, int health, int friends, int happiness){
        this.name = name;
        this.gender = gender;
        this.money = money;
        this.health = health;
        this.friends = friends;
        this.happiness = happiness;
    }

}
