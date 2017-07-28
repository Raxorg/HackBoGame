package com.viscadevs.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

public class Assets implements Disposable {

    private static Assets instance = new Assets();
    private AssetManager assetManager;

    public static final Assets getInstance(){
        return instance;
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.finishLoading();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class PlayerAssets{
        Texture standingRight, standingLeft;
        public final Animation walkingRightAnimation; // walkingLeftAnimation;

        public PlayerAssets(){
            standingRight = new Texture("player/perfil2");

            ArrayList<Texture> walkingRightFrames = new ArrayList<Texture>();
            walkingRightFrames.add(new Texture(Constants.WALKING_RIGHT_1));
            walkingRightFrames.add(new Texture(Constants.WALKING_RIGHT_2));
            walkingRightFrames.add(new Texture(Constants.WALKING_RIGHT_3));

            walkingRightAnimation = new Animation(Constants.WALK_LOOP_DURATION, walkingRightFrames, Animation.PlayMode.LOOP_PINGPONG);
        }
    }
}
