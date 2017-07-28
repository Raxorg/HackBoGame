package com.viscadevs.util;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.Color;

import static com.viscadevs.hackbo.HackBoGame.batch;

public abstract class Button implements Disposable {
    protected Texture texture;
    protected Rectangle rectangle;
    protected Color color;
    private Sound click;

    public Button(Texture texture, float x, float y, float width, float height, Color color) {
        this.texture = texture;
        rectangle = new Rectangle();
        rectangle.set(x, y, width, height);
        this.color = color;
        click = Assets.getInstance().soundAssets.click;
    }

    public void setSound(Sound click){
        this.click = click;
    }

    public Sound getSound(){
        return click;
    }

    public boolean isTouched(float x, float y) {
        return rectangle.contains(x, y);
    }

    public void render() {
        batch.setColor(color);
        batch.draw(
                texture,
                rectangle.getX(),
                rectangle.getY(),
                rectangle.width,
                rectangle.height
        );
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void onTouch();

    public void updatePosition(Vector2 position) {
        rectangle.set(position.x, position.y, rectangle.width, rectangle.height);
    }
}
