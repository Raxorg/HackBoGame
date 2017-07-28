package com.viscadevs.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets2 {

    // Splash
    public static Texture splash;

    // Menu

    // Player

    // Person

    private static boolean loaded = false;

    public static void load() {
        if (!loaded) {
            splash = new Texture(Gdx.files.internal("other/splash.jpg"));
            loaded = true;
        }
    }
}
