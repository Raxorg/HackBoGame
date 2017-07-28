package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class Bar {

    private Color color;
    private Vector2 position;
    private float percentage;

    public Bar(Vector2 position, Color color) {
        this.color = color;
        this.position = position;
        percentage = 0;
    }

    public void render(float porcentage) {
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                Assets.getInstance().barAssets.left,
                position.x,
                position.y,
                Constants.BAR_HEIGHT,
                Constants.BAR_HEIGHT
        );
        batch.draw(
                Assets.getInstance().barAssets.mid,
                position.x + Constants.BAR_HEIGHT,
                position.y,
                Constants.BAR_WIDTH,
                Constants.BAR_HEIGHT
        );
        batch.draw(
                Assets.getInstance().barAssets.right,
                position.x + Constants.BAR_HEIGHT + Constants.BAR_WIDTH,
                position.y,
                Constants.BAR_HEIGHT,
                Constants.BAR_HEIGHT
        );
        batch.setColor(color);
        batch.draw(
                Assets.getInstance().barAssets.leftF,
                position.x,
                position.y,
                Constants.BAR_HEIGHT,
                Constants.BAR_HEIGHT
        );
        batch.draw(
                Assets.getInstance().barAssets.midF,
                position.x + Constants.BAR_HEIGHT,
                position.y,
                Constants.BAR_WIDTH * porcentage / 100,
                Constants.BAR_HEIGHT
        );
        batch.draw(
                Assets.getInstance().barAssets.rightF,
                position.x + Constants.BAR_HEIGHT + Constants.BAR_WIDTH,
                position.y,
                Constants.BAR_HEIGHT,
                Constants.BAR_HEIGHT
        );
    }
}
