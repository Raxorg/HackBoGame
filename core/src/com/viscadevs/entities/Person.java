package com.viscadevs.entities;

import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Assets2;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;

public class Person {

    private boolean movingRight;
    private Vector2 position;

    public Person(boolean movingRight) {
        this.movingRight = movingRight;
        position = movingRight ? new Vector2(0, 0) : new Vector2(0, 0);
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
        batch.draw(
                Assets2.person,
                position.x,
                position.y
        );
    }
}
