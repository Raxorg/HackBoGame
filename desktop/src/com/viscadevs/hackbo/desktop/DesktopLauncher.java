package com.viscadevs.hackbo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.viscadevs.hackbo.HackBoGame;
import com.viscadevs.util.Constants;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = (int) Constants.WORLD_WIDTH;
        config.height = (int) Constants.WORLD_HEIGHT;
        new LwjglApplication(new HackBoGame(), config);
    }
}
