package com.viscadevs.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
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
        assetManager.load(Constants.STANDARD_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.STANDARD_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.STANDARD_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.STANDARD_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.STANDARD_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.STANDARD_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.STANDARD_FRONT, Texture.class);
        assetManager.load(Constants.HOMELESS_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.HOMELESS_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.HOMELESS_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.HOMELESS_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.HOMELESS_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.HOMELESS_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.HOMELESS_FRONT, Texture.class);
        // Person
        assetManager.load(Constants.PERSON, Texture.class);

        assetManager.finishLoading();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class PlayerAssets {
        public Animation<Texture> standardWalkingRightAnimation;
        public Animation<Texture> standardWalkingLeftAnimation;
        public Animation<Texture> homelessWalkingRightAnimation;
        public Animation<Texture> homelessWalkingLeftAnimation;

        public Texture standardFront, homelessFront;

        public void init() {
            standardFront = assetManager.get(Constants.STANDARD_FRONT);
            homelessFront = assetManager.get(Constants.HOMELESS_FRONT);

            Texture[] standardWalkingRightFrames = new Texture[3];
            standardWalkingRightFrames[0] = assetManager.get(Constants.STANDARD_WALKING_RIGHT_1, Texture.class);
            standardWalkingRightFrames[1] = assetManager.get(Constants.STANDARD_WALKING_RIGHT_2, Texture.class);
            standardWalkingRightFrames[2] = assetManager.get(Constants.STANDARD_WALKING_RIGHT_3, Texture.class);
            standardWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, standardWalkingRightFrames);
            standardWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


            Texture[] standardWalkingLeftFrames = new Texture[3];
            standardWalkingLeftFrames[0] = assetManager.get(Constants.STANDARD_WALKING_LEFT_1, Texture.class);
            standardWalkingLeftFrames[1] = assetManager.get(Constants.STANDARD_WALKING_LEFT_2, Texture.class);
            standardWalkingLeftFrames[2] = assetManager.get(Constants.STANDARD_WALKING_LEFT_3, Texture.class);
            standardWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, standardWalkingLeftFrames);
            standardWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] homelessWalkingRightFrames = new Texture[3];
            homelessWalkingRightFrames[0] = assetManager.get(Constants.HOMELESS_WALKING_RIGHT_1, Texture.class);
            homelessWalkingRightFrames[1] = assetManager.get(Constants.HOMELESS_WALKING_RIGHT_2, Texture.class);
            homelessWalkingRightFrames[2] = assetManager.get(Constants.HOMELESS_WALKING_RIGHT_3, Texture.class);
            standardWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, homelessWalkingRightFrames);
            standardWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] homelessWalkingLeftFrames = new Texture[3];
            homelessWalkingLeftFrames[0] = assetManager.get(Constants.HOMELESS_WALKING_LEFT_1, Texture.class);
            homelessWalkingLeftFrames[1] = assetManager.get(Constants.HOMELESS_WALKING_LEFT_2, Texture.class);
            homelessWalkingLeftFrames[2] = assetManager.get(Constants.HOMELESS_WALKING_LEFT_3, Texture.class);
            standardWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, homelessWalkingLeftFrames);
            standardWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        }
    }

    public class PersonAssets {
        public Texture person;

        public void init() {
            person = assetManager.get(Constants.PERSON, Texture.class);
        }
    }
}
