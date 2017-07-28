package com.viscadevs.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.viscadevs.hud.Bar;
import com.viscadevs.hud.Upgrade;
import com.viscadevs.screens.GameScreen;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Constants;
import com.viscadevs.util.ViscaUtils;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.font;

public class GameHUD implements Disposable{

    private Bar[] bars;
    private Upgrade[] upgrades;
    private GameScreen gameScreen;

    public GameHUD(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        bars = new Bar[2];
        bars[0] = new Bar(
                new Vector2(0, 0),
                Color.RED
        );
        bars[1] = new Bar(
                new Vector2(Constants.BAR_WIDTH + Constants.BAR_HEIGHT * 2, 0),
                Color.BLUE
        );

        upgrades = new Upgrade[1];

    }

    public void render(int money) {
        batch.setColor(Color.YELLOW);
        batch.draw(
                Assets.getInstance().hudAssets.moneyBar,
                0,
                Gdx.graphics.getHeight() - Constants.MONEY_BAR_HEIGHT,
                Constants.MONEY_BAR_WIDTH,
                Constants.MONEY_BAR_HEIGHT
        );
        ViscaUtils.drawCenteredFont(font, Constants.MONEY_BAR_WIDTH, Constants.MONEY_BAR_HEIGHT,
                0, Gdx.graphics.getHeight() - Constants.MONEY_BAR_HEIGHT, money + "", 1, Color.BLACK);

        bars[0].render(gameScreen.getPlayer().getEnergy());
        bars[1].render(gameScreen.getPlayer().getHealth());
    }

    @Override
    public void dispose() {
        for(Upgrade u : upgrades){
            u.dispose();
        }
    }
}