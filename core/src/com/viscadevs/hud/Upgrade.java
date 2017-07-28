package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.viscadevs.util.Button;
import com.viscadevs.util.Enums;


public abstract class Upgrade extends Button {
    public Enums.State state = Enums.State.HOMELESS;

    public Upgrade(Texture texture, float x, float y, float width, float height, Color color) {
        super(texture, x, y, width, height, color);
    }

    public void upgrade() {
        switch (state) {
            case HOMELESS:
                state = Enums.State.STANDARD;
                break;
            case STANDARD:
                state = Enums.State.RICH;
                break;
            default:
                break;
        }
    }

    public Enums.State getState() {
        return state;
    }
}
