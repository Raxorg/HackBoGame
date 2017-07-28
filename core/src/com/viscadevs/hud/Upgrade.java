package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.entities.Player;
import com.viscadevs.screens.GameScreen;
import com.viscadevs.util.Button;

/**
 * Created by Joaco99 on 28/07/2017.
 */

public class Upgrade extends Button{
    GameScreen screen;

    public Upgrade(Texture texture, Vector2 position, Vector2 bounds) {
        super(texture, position, bounds);
    }
}
