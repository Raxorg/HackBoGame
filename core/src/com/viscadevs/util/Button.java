package com.viscadevs.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Joaco99 on 28/07/2017.
 */

public class Button {
    Texture texture;
    Rectangle rectangle;

    public Button(Texture texture, Vector2 position, Vector2 bounds){
        this(texture, position.x, position.y, bounds.x, bounds.y);
    }

    public Button(Texture texture, float x, float y, float width, float height){
        this.texture = texture;
        rectangle.set(x, y, width, height);
    }

    public boolean isTouched(Vector2 positionTouched){
        return rectangle.contains(positionTouched.x, positionTouched.y);
    }
}
