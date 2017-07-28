package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Assets;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class Bar {

    private Color color;
    private Vector2 position;
    private float width, height;

    public void setColor(Color color) {
        this.color = color;
    }

    public void render() {
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x,
                position.y
        );
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x + height,
                position.y,
                width,
                height
        );
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x + height + width,
                position.y
        );
        batch.setColor(color);
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x,
                position.y
        );
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x + height,
                position.y,
                width,
                height
        );
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x + height + width,
                position.y
        );
    }
}
