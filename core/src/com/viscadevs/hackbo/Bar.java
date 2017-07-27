package com.viscadevs.hackbo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.viscadevs.util.Constants;

/**
 * Created by Joaco99 on 27/07/2017.
 */

public class Bar {
    private float maxCapacity = Constants.MAX_BAR_CAPACITY;
    private float capacity = 0;
    private Vector2 position;
    private float width;
    private float height;

    public Bar(Vector2 position, float width, float height){
        this.position.set(position);
        this.width = width;
        this.height = height;
    }

    public void render(ShapeRenderer renderer, float delta){
        Gdx.gl.glLineWidth(4);
        renderer.set(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.DARK_GRAY);
        renderer.rect(position.x, position.y, width, height);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.GREEN);
        renderer.rect(position.x, position.y, width * capacity / maxCapacity, height);
    }
}
