package com.viscadevs.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.hud.Upgrade;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;

/**
 * Created by Joaco99 on 28/07/2017.
 */

public class Home {
    Upgrade upgrade;
    Texture homeTexture;

    public Home(){
        upgrade = new Upgrade(new Texture("other/pixel.png"), 400, 400, 200, 200) {
            @Override
            public void onTouch() {
                upgrade();
            }
        };

        homeTexture = Assets.getInstance().upgradeAssets.homelessHome;
    }

    public void render(SpriteBatch batch){
        upgrade.render(batch);
        switch (upgrade.getState()){
            case HOMELESS:
                homeTexture = Assets.getInstance().upgradeAssets.homelessHome;
                break;
            case STANDARD:
                homeTexture = Assets.getInstance().upgradeAssets.standard_home;
                break;
            case RICH:
                homeTexture = Assets.getInstance().upgradeAssets.rich_home;
                break;
        }

        batch.draw(homeTexture, Constants.HOME_POSITION.x, Constants.HOME_POSITION.y,
                Constants.HOME_DIMENTIONS.x, Constants.HOME_DIMENTIONS.y);
    }
}
