package com.viscadevs.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class Person {

    private boolean movingRight;
    private Vector2 position;

    public Person(boolean movingRight) {
        this.movingRight = movingRight;
        position = movingRight ? new Vector2(-10, 90) : new Vector2(Gdx.graphics.getWidth(), 90);
    }

    public void update(float delta) {
        position.set(
                movingRight ?
                        position.x + Constants.PERSON_SPEED * delta :
                        position.x - Constants.PERSON_SPEED * delta,
                position.y
        );
    }

    public void render() {
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                Assets.getInstance().personAssets.person,
                position.x,
                position.y,
                Constants.HUMAN_WIDTH,
                Constants.HUMAN_HEIGHT
        );
    }
}
