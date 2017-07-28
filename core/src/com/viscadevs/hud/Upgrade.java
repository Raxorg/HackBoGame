package com.viscadevs.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.viscadevs.util.Button;
import com.viscadevs.util.Enums;


public abstract class Upgrade extends Button{
    public Enums.State state = Enums.State.HOMELESS;

    public Upgrade(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }

    public void upgrade(){
        switch(state){
            case HOMELESS:
                state = Enums.State.STANDARD;
                break;
            case STANDARD:
                state = Enums.State.RICH;
                break;
            default:
                break;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
    }

    public Enums.State getState() {
        return state;
    }
}
