package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Texture;
import com.viscadevs.util.Button;

public abstract class Upgrade extends Button{

    public Upgrade(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }
}
