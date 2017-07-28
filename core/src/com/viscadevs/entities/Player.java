package com.viscadevs.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

public class Player {

    private String name;
    private Enums.Gender gender;
    private int money = 20;
    private int health = Constants.INITIAL_HEALTH;
    private int popularity = 0;
    private int happiness = -20;
    private Vector2 position;
    private Texture texture;
    private Enums.Facing facing = Enums.Facing.RIGHT;
    private Enums.WalkState walkState = Enums.WalkState.STANDING;
    private long walkStartTime;

    public Player(String name, int money, Enums.Gender gender, int health, int popularity, int happiness, Vector2 position) {
        this.name = name;
        this.gender = gender;
        this.money = money;
        this.health = health;
        this.popularity = popularity;
        this.happiness = happiness;
        this.position = position;
    }

    private void moveLeft(float delta) {
        if (walkState != Enums.WalkState.WALKING) {
            walkStartTime = TimeUtils.nanoTime();
        }
        walkState = Enums.WalkState.WALKING;
        facing = Enums.Facing.LEFT;
        position.x -= delta * Constants.PLAYER_MOVE_SPEED;
    }

    private void moveRight(float delta) {
        if (walkState != Enums.WalkState.WALKING) {
            walkStartTime = TimeUtils.nanoTime();
        }
        walkState = Enums.WalkState.WALKING;
        facing = Enums.Facing.RIGHT;
        position.x += delta * Constants.PLAYER_MOVE_SPEED;
    }


    public void update(float delta) {

    }

    public void render(float delta) {
        Texture region = Assets.getInstance().PlayerAssets.

        if (facing == Direction.RIGHT && jumpState != Enums.JumpState.GROUNDED) {
            region = Assets.instance.gigaGalAssets.jumpingRight;
        } else if (facing == Direction.RIGHT && walkState == Enums.WalkState.NOT_WALKING) {
            region = Assets.instance.gigaGalAssets.standingRight;
        } else if (facing == Direction.RIGHT && walkState == Enums.WalkState.WALKING) {
            float walkTimeSeconds = Utils.secondsSince(walkStartTime);
            region = Assets.instance.gigaGalAssets.walkingRightAnimation.getKeyFrame(walkTimeSeconds);
        } else if (facing == Direction.LEFT && jumpState != Enums.JumpState.GROUNDED) {
            region = Assets.instance.gigaGalAssets.jumpingLeft;
        } else if (facing == Direction.LEFT && walkState == Enums.WalkState.NOT_WALKING) {
            region = Assets.instance.gigaGalAssets.standingLeft;
        } else if (facing == Direction.LEFT && walkState == Enums.WalkState.WALKING) {
            float walkTimeSeconds = Utils.secondsSince(walkStartTime);
            regio
    }

    public void dispose() {
        texture.dispose();
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
}
