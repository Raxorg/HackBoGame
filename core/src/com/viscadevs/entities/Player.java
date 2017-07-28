package com.viscadevs.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;
import com.viscadevs.util.ViscaUtils;

public class Player {

    private String name;

    private Texture standing;
    private Animation<Texture> walkingRightAnimation, walkingLeftAnimation;

    private int money;
    private int health;
    private int popularity = 0;
    private int happiness = -20;
    private int energy = 50;

    private Enums.Gender gender;
    private Enums.Facing facing = Enums.Facing.RIGHT;
    private Enums.WalkState walkState = Enums.WalkState.STANDING;
    private Enums.Level level;

    private Vector2 position;

    private long walkStartTime = 0;

    public Player(String name, Enums.Gender gender, int popularity, int happiness) {
        this.name = name;
        this.gender = gender;
        this.popularity = popularity;
        this.happiness = happiness;
        position = new Vector2(Constants.PLAYER_SPAWN_X, Constants.PLAYER_SPAWN_Y);

        level = Enums.Level.POOR;
        money = Constants.INITIAL_MONEY;
        health = Constants.INITIAL_HEALTH;

        updateDrawing();
    }

    private void moveLeft(float delta) {
        if (walkState != Enums.WalkState.WALKING) {
            walkStartTime = TimeUtils.nanoTime();
        }
        walkState = Enums.WalkState.WALKING;
        facing = Enums.Facing.LEFT;
        position.x -= delta * Constants.PLAYER_SPEED;
    }

    private void moveRight(float delta) {
        if (walkState != Enums.WalkState.WALKING) {
            walkStartTime = TimeUtils.nanoTime();
        }
        walkState = Enums.WalkState.WALKING;
        facing = Enums.Facing.RIGHT;
        position.x += delta * Constants.PLAYER_SPEED;
    }

    public void updateDrawing() {

        switch (level) {
            case POOR:
                if (gender == Enums.Gender.MALE) {
                    standing = Assets.getInstance().playerAssets.malePoorFront;
                    walkingRightAnimation = Assets.getInstance().playerAssets.malePoorWalkingRightAnimation;
                    walkingLeftAnimation = Assets.getInstance().playerAssets.malePoorWalkingLeftAnimation;
                }else{
                    standing = Assets.getInstance().playerAssets.femalePoorFront;
                    walkingRightAnimation = Assets.getInstance().playerAssets.femalePoorWalkingRightAnimation;
                    walkingLeftAnimation = Assets.getInstance().playerAssets.femalePoorWalkingLeftAnimation;
                }
                break;
            case MEDIUM:
                if (gender == Enums.Gender.MALE) {
                    standing = Assets.getInstance().playerAssets.maleMediumFront;
                    walkingRightAnimation = Assets.getInstance().playerAssets.maleMediumWalkingRightAnimation;
                    walkingLeftAnimation = Assets.getInstance().playerAssets.maleMediumWalkingLeftAnimation;
                }else{
                    standing = Assets.getInstance().playerAssets.femaleMediumFront;
                    walkingRightAnimation = Assets.getInstance().playerAssets.femaleMediumWalkingRightAnimation;
                    walkingLeftAnimation = Assets.getInstance().playerAssets.femaleMediumWalkingLeftAnimation;
                }
                break;
            case RICH:
                if (gender == Enums.Gender.MALE) {
                    standing = Assets.getInstance().playerAssets.maleRichFront;
                    walkingRightAnimation = Assets.getInstance().playerAssets.maleRichWalkingRightAnimation;
                    walkingLeftAnimation = Assets.getInstance().playerAssets.maleRichWalkingLeftAnimation;
                }else{
                    standing = Assets.getInstance().playerAssets.femaleRichFront;
                    walkingRightAnimation = Assets.getInstance().playerAssets.femaleRichWalkingRightAnimation;
                    walkingLeftAnimation = Assets.getInstance().playerAssets.femaleRichWalkingLeftAnimation;
                }
                break;
        }

    }


    public void update(float delta) {
        updateDrawing();
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);

        if (left && !right) {
            moveLeft(delta);
        } else if (right && !left) {
            moveRight(delta);
        } else {
            walkState = Enums.WalkState.STANDING;
        }
    }

    public void render(SpriteBatch batch) {
        batch.setColor(1, 1, 1, 1);
        Texture region = Assets.getInstance().playerAssets.maleMediumFront;

        if (walkState == Enums.WalkState.STANDING) {
            region = standing;
        } else if (facing == Enums.Facing.RIGHT && walkState == Enums.WalkState.WALKING) {
            float walkTimeSeconds = ViscaUtils.secondsSince(walkStartTime);
            region = walkingRightAnimation.getKeyFrame(walkTimeSeconds);
        } else if (facing == Enums.Facing.LEFT && walkState == Enums.WalkState.WALKING) {
            float walkTimeSeconds = ViscaUtils.secondsSince(walkStartTime);
            region = walkingLeftAnimation.getKeyFrame(walkTimeSeconds);
        }

        batch.draw(region, position.x, position.y, Constants.HUMAN_WIDTH, Constants.HUMAN_HEIGHT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enums.Gender getGender() {
        return gender;
    }

    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFriends() {
        return popularity;
    }

    public void setFriends(int friends) {
        this.popularity = friends;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Enums.Level getLevel() {
        return level;
    }

    public int getEnergy() {
        return energy;
    }
}
