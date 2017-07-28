package com.viscadevs.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public abstract class Button implements Disposable {
    Texture texture;
    Rectangle rectangle;

    public Button(Texture texture, float x, float y, float width, float height) {
        rectangle.set(x, y, width, height);
        this.texture = texture;
    }

    public boolean isTouched(float x, float y) {
        return rectangle.contains(x, y);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, rectangle.getX(), rectangle.getY());
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    abstract void onTouch();
}
