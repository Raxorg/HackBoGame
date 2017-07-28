package com.viscadevs.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

public class Assets implements Disposable {

    private static Assets instance = new Assets();
    private AssetManager assetManager;
    public PlayerAssets playerAssets;

    public static final Assets getInstance() {
        return instance;
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.finishLoading();

        playerAssets = new PlayerAssets();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class PlayerAssets {
        public final Texture standingRight, standingLeft;
        public final Animation walkingRightAnimation, walkingLeftAnimation;

        public PlayerAssets() {
            standingRight = new Texture(Constants.STANDING_RIGHT);

            Array<Texture> walkingRightFrames = new Array<Texture>();
            walkingRightFrames.add(new Texture(Constants.WALKING_RIGHT_1));
            walkingRightFrames.add(new Texture(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(new Texture(Constants.WALKING_RIGHT_3));

            walkingRightAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingRightFrames, Animation.PlayMode.LOOP_PINGPONG);

            standingLeft = new Texture(Constants.STANDING_LEFT);

            Array<Texture> walkingLeftFrames = new Array<Texture>();
            walkingRightFrames.add(new Texture(Constants.WALKING_LEFT_1));
            walkingRightFrames.add(new Texture(Constants.WALKING_LEFT_2));
            walkingRightFrames.add(new Texture(Constants.WALKING_LEFT_3));

            walkingLeftAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingLeftFrames, Animation.PlayMode.LOOP_PINGPONG);
        }
    }

    public class PersonAssets {
        public final Texture person;

        public PersonAssets() {
            person = new Texture(Constants.PERSON);
        }
    }
}
