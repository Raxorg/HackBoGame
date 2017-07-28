package com.viscadevs.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Button {
    Texture texture;
    Rectangle rectangle;

    public Button(Texture texture, Vector2 position, Vector2 bounds){
        this(texture, position.x, position.y, bounds.x, bounds.y);
    }

    public Button(Texture texture, float x, float y, float width, float height){
        this.texture = texture;
        rectangle.set(x, y, width, height);
    }

    public boolean isTouched(float x, float y) {
        return rectangle.contains(x, y);
    }

    abstract void onTouch();
}
