package com.viscadevs.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.GridLayout;
import java.util.Random;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.hackbo.HackBoGame.font;

public class ViscaUtils {

    public static final Random random = new Random();

    public static float secondsSince(long timeNanos) {
        return MathUtils.nanoToSec * (TimeUtils.nanoTime() - timeNanos);
    }

    public static float stringWidht(BitmapFont font, String text){
        GlyphLayout layout = new GlyphLayout(font, text);
        return layout.width;
    }

    public static float stringHeight(BitmapFont font, String text){
        GlyphLayout layout = new GlyphLayout(font, text);
        return layout.height;
    }

    public static void drawCenteredFont(BitmapFont font, float widht, float height, float x, float y, String text, float scale, Color color){
        font.setColor(color);
        font.getData().setScale(scale);
        float stringWidth = stringWidht(font, text);
        float stringHeight = stringHeight(font, text);
        font.draw(batch, text, x + widht / 2 - stringWidth / 2, y + height / 2 + stringHeight / 2);
    }
}
