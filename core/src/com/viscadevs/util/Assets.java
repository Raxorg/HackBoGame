package com.viscadevs.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    private static Assets instance = new Assets();
    private AssetManager assetManager;

    public PlayerAssets playerAssets;
    public PersonAssets personAssets;

    public static Assets getInstance() {
        return instance;
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        load();

        playerAssets = new PlayerAssets();
        personAssets = new PersonAssets();
    }

    private void load() {
        assetManager.load(Constants.PERSON, Texture.class);
        assetManager.load(Constants.STANDING_LEFT, Texture.class);
        assetManager.load(Constants.STANDING_RIGHT, Texture.class);
        assetManager.load(Constants.WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.WALKING_RIGHT_3, Texture.class);
        assetManager.finishLoading();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    private class PlayerAssets {
        public final Texture standingRight, standingLeft;
        public final Animation walkingRightAnimation, walkingLeftAnimation;

        PlayerAssets() {
            standingRight = assetManager.get(Constants.STANDING_RIGHT, Texture.class);

            Array<Texture> walkingRightFrames = new Array<Texture>();
            walkingRightFrames.add(assetManager.get(Constants.WALKING_RIGHT_1, Texture.class));
            walkingRightFrames.add(assetManager.get(Constants.WALKING_RIGHT_2, Texture.class));
            walkingRightFrames.add(assetManager.get(Constants.WALKING_RIGHT_3, Texture.class));

            walkingRightAnimation = new Animation(
                    Constants.WALK_LOOP_DURATION,
                    walkingRightFrames,
                    Animation.PlayMode.LOOP_PINGPONG
            );

            standingLeft = assetManager.get(Constants.STANDING_LEFT, Texture.class);

            Array<Texture> walkingLeftFrames = new Array<Texture>();
            walkingRightFrames.add(assetManager.get(Constants.WALKING_LEFT_1, Texture.class));
            walkingRightFrames.add(assetManager.get(Constants.WALKING_LEFT_2, Texture.class));
            walkingRightFrames.add(assetManager.get(Constants.WALKING_LEFT_3, Texture.class));

            walkingLeftAnimation = new Animation(
                    Constants.WALK_LOOP_DURATION,
                    walkingLeftFrames,
                    Animation.PlayMode.LOOP_PINGPONG
            );
        }

        public void load(){
            assetManager.load(Constants.STANDING_LEFT, Texture.class);
            assetManager.load(Constants.STANDING_RIGHT, Texture.class);
            assetManager.load(Constants.WALKING_LEFT_1, Texture.class);
            assetManager.load(Constants.WALKING_LEFT_2, Texture.class);
            assetManager.load(Constants.WALKING_LEFT_3, Texture.class);
            assetManager.load(Constants.WALKING_RIGHT_1, Texture.class);
            assetManager.load(Constants.WALKING_RIGHT_2, Texture.class);
            assetManager.load(Constants.WALKING_RIGHT_3, Texture.class);
        }
    }

    public class PersonAssets {
        public final Texture person;

        PersonAssets() {
            person = assetManager.get(Constants.PERSON, Texture.class);
        }
    }
}
