package com.viscadevs.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;

public class Home {

    private Enums.Level level;

    public Home() {
        level = Enums.Level.POOR;
    }

    public void render(SpriteBatch batch) {

        switch (level) {
            case POOR:
                batch.draw(
                        Assets.getInstance().upgradeAssets.poorHome,
                        Constants.HOME_POSITION.x,
                        Constants.HOME_POSITION.y,
                        Constants.HOME_DIMENTIONS.x,
                        Constants.HOME_DIMENTIONS.y
                );
                break;
            case MEDIUM:
                batch.draw(
                        Assets.getInstance().upgradeAssets.mediumHome,
                        Constants.HOME_POSITION.x,
                        Constants.HOME_POSITION.y,
                        Constants.HOME_DIMENTIONS.x + 80,
                        Constants.HOME_DIMENTIONS.y + 80
                );
                break;
            case RICH:
                batch.draw(
                        Assets.getInstance().upgradeAssets.richHome,
                        Constants.HOME_POSITION.x,
                        Constants.HOME_POSITION.y,
                        Constants.HOME_DIMENTIONS.x + 100,
                        Constants.HOME_DIMENTIONS.y + 200
                );
                break;
        }
    }

    public Enums.Level getLevel() {
        return level;
    }

    public void upgrade() {
        switch (level) {
            case POOR:
                level = Enums.Level.MEDIUM;
                break;
            case MEDIUM:
                level = Enums.Level.RICH;
                break;
            default:
                break;
        }
    }
}
