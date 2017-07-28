package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.viscadevs.util.Button;


public abstract class Upgrade extends Button {

    private int moneyRequired, friendsRequired;

    public Upgrade(Texture texture, float x, float y, float width, float height, Color color,
                   int moneyRequired, int friendsRequired) {
        super(texture, x, y, width, height, color);
        this.moneyRequired = moneyRequired;
        this.friendsRequired = friendsRequired;
    }

    public int getMoneyRequired() {
        return moneyRequired;
    }

    public int getFriendsRequired() {
        return friendsRequired;
    }

}
