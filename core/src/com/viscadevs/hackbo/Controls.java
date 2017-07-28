package com.viscadevs.hackbo;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.viscadevs.util.Constants;

public class Controls extends InputAdapter {

    private Viewport viewport;

    public Controls() {
        viewport = new ExtendViewport(
                Constants.CONTROLS_VIEWPORT_SIZE,
                Constants.CONTROLS_VIEWPORT_SIZE
        );
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 viewportPosition = viewport.unproject(new Vector2(screenX, screenY));
        return true;
    }
}
