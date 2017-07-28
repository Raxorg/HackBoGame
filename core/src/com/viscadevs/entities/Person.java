package com.viscadevs.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.screens.GameScreen;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.util.ViscaUtils.random;

public class Person {

    private boolean movingRight;
    private Vector2 position;
    private float bonusSpeed;
    private Texture texture;

    private GameScreen gameScreen;

    public Person(GameScreen gameScreen, boolean movingRight) {
        this.gameScreen = gameScreen;
        this.movingRight = movingRight;
        position = movingRight ? new Vector2(-10, 90) : new Vector2(Gdx.graphics.getWidth(), 90);
        bonusSpeed = Constants.PERSON_MAX_BONUS_SPEED * random.nextFloat();
        texture = random.nextFloat() > 0.5 ?
                Assets.getInstance().personAssets.person : Assets.getInstance().personAssets.person2;
    }

    public void update(float delta) {
        position.set(
                movingRight ?
                        position.x + bonusSpeed * delta + Constants.PERSON_SPEED * delta :
                        position.x - bonusSpeed * delta - Constants.PERSON_SPEED * delta,
                position.y
        );
        if (position.x > Gdx.graphics.getWidth() + Constants.HUMAN_WIDTH || position.x < -Constants.HUMAN_WIDTH) {
            gameScreen.removePerson(this);
        }
    }

    public void render() {
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                texture,
                position.x,
                position.y,
                Constants.HUMAN_WIDTH,
                Constants.HUMAN_HEIGHT
        );
    }
}
