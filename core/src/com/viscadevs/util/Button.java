package com.viscadevs.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

import static com.viscadevs.hackbo.HackBoGame.batch;

public abstract class Button implements Disposable {
    protected Texture texture;
    protected Rectangle rectangle;
    protected Color color;

    public Button(Texture texture, float x, float y, float width, float height, Color color) {
        this.texture = texture;
        rectangle = new Rectangle();
        rectangle.set(x, y, width, height);
        this.color = color;
    }

    public boolean isTouched(float x, float y) {
        return rectangle.contains(x, y);
    }

    public void render() {
        batch.setColor(color);
        batch.draw(texture, rectangle.getX(), rectangle.getY(), rectangle.width, rectangle.height);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public abstract void onTouch();
}
