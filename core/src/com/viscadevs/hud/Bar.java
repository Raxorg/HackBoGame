package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Assets;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class Bar {

    private Color color;
    private Vector2 position;
    private float width = 50, height = 16;

    public Bar(Vector2 position, Color color) {
        this.color = color;
        this.position = position;
    }

    public void render() {
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x,
                position.y
        );
        batch.draw(
                Assets.getInstance().barAssets.mid,
                position.x + height,
                position.y,
                width,
                height
        );
        batch.draw(
                Assets.getInstance().barAssets.right,
                position.x + height + width,
                position.y
        );
        batch.setColor(color);
        batch.draw(
                Assets.getInstance().barAssets.leftF,
                position.x,
                position.y
        );
        batch.draw(
                Assets.getInstance().barAssets.midF,
                position.x + height,
                position.y,
                width,
                height
        );
        batch.draw(
                Assets.getInstance().barAssets.rightF,
                position.x + height + width,
                position.y
        );
    }
}
