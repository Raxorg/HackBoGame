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

    public void init() {
        assetManager = new AssetManager();

        load();

        playerAssets = new PlayerAssets();
        playerAssets.init();
        personAssets = new PersonAssets();
        personAssets.init();
    }

    private void load() {
        // Player
        assetManager.load(Constants.STANDING_LEFT, Texture.class);
        assetManager.load(Constants.STANDING_RIGHT, Texture.class);
        assetManager.load(Constants.WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.WALKING_RIGHT_3, Texture.class);
        // Person
        assetManager.load(Constants.PERSON, Texture.class);
        // Splash
        assetManager.load(Constants.SPLASH, Texture.class);

        assetManager.finishLoading();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class PlayerAssets {
        public Texture standingRight, standingLeft;
        public Animation<Texture> walkingRightAnimation;
        public Animation<Texture> walkingLeftAnimation;

        public void init() {
            standingRight = assetManager.get(Constants.STANDING_RIGHT, Texture.class);

            Texture[] walkingRightFrames = new Texture[3];
            walkingRightFrames[0] = assetManager.get(Constants.WALKING_RIGHT_1, Texture.class);
            walkingRightFrames[1] = assetManager.get(Constants.WALKING_RIGHT_2, Texture.class);
            walkingRightFrames[2] = assetManager.get(Constants.WALKING_RIGHT_3, Texture.class);

            walkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, walkingRightFrames);
            walkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            standingLeft = assetManager.get(Constants.STANDING_LEFT, Texture.class);

            Texture[] walkingLeftFrames = new Texture[3];
            walkingLeftFrames[0] = assetManager.get(Constants.WALKING_LEFT_1, Texture.class);
            walkingLeftFrames[1] = assetManager.get(Constants.WALKING_LEFT_2, Texture.class);
            walkingLeftFrames[2] = assetManager.get(Constants.WALKING_LEFT_3, Texture.class);

            walkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, walkingLeftFrames);
            walkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        }
    }

    public class PersonAssets {
        public Texture person;

        public void init() {
            person = assetManager.get(Constants.PERSON, Texture.class);
        }
    }
}
