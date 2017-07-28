package com.viscadevs.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.viscadevs.screens.SplashScreen;

public class AssetManager {

    // Splash
    public static Texture splash;

    // Menu

    // Player
    public static Texture standingRight, standingLeft;
    public static Animation walkingLeftAnimation, walkingRightAnimation;

    // Person
    public static Texture person;

    // Other
    public static Texture pixel;

    private static boolean loaded = false;

    private SplashScreen splashScreen;

    public void load() {
        if (!loaded) {
            splash = new Texture(Gdx.files.internal("other/splash.jpg"));
            person = new Texture(Gdx.files.internal("other/person.png"));
            pixel = new Texture(Gdx.files.internal("other/pixel.png"));
            splashScreen.doneLoadingAssets();
            loaded = true;
        }
    }

    public void setSplashScreen(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
    }

    // TODO dispose
    public void dispose() {

    }
}
