package com.viscadevs.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    // Splash
    public static Texture splash;

    // Menu

    // Player

    // Person
    public static Texture person;

    private static boolean loaded = false;

    public static void load() {
        if (!loaded) {
            splash = new Texture(Gdx.files.internal("other/splash.jpg"));
            person = new Texture(Gdx.files.internal("other/person.png"));
            loaded = true;
        }
    }
}
