package com.viscadevs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.TimeUtils;
import com.viscadevs.entities.Home;
import com.viscadevs.entities.Person;
import com.viscadevs.entities.Player;
import com.viscadevs.hud.Upgrade;
import com.viscadevs.overlays.GameHUD;
import com.viscadevs.util.Assets;
import com.viscadevs.util.Button;
import com.viscadevs.util.Constants;
import com.viscadevs.util.Enums;
import com.viscadevs.util.ViscaUtils;

import static com.viscadevs.hackbo.HackBoGame.batch;
import static com.viscadevs.util.ViscaUtils.random;


public class GameScreen extends ScreenAdapter {

    private Player player;
    private DelayedRemovalArray<Person> people;
    private GameHUD gameHUD;
    private long startTime;
    private Button[] buttons;
    private Home home;

    @Override
    public void show() {
        gameHUD = new GameHUD();
        // TODO GET THE NAME AND GENDER FROM MENU
        player = new Player("BOB", Enums.Gender.MALE, 0, 100);
        people = new DelayedRemovalArray<Person>();
        startTime = TimeUtils.nanoTime();

        home = new Home();

        buttons = new Button[1];
        buttons[0] = new Upgrade(
                new Texture("other/pixel.png"),
                0,
                0,
                200,
                200,
                Color.CORAL,
                500,
                10
        ) {
            @Override
            public void onTouch() {

            }
        };
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.SKY.r, Color.SKY.g, Color.SKY.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float timeElapsed = ViscaUtils.secondsSince(startTime);
        if (timeElapsed >= Constants.PERSON_SPAWN_RATE) {
            spawnPerson();
            startTime = TimeUtils.nanoTime();
        }

        batch.begin();

        // Update the people
        for (Person p : people) {
            people.begin();
            p.update(delta);
            people.end();
        }

        // Update the player
        player.update(delta);

        // Draw the city
        batch.draw(
                Assets.getInstance().landScapeAssets.street,
                0,
                0,
                Constants.WORLD_WIDTH,
                Constants.WORLD_HEIGHT
        );
        batch.draw(
                Assets.getInstance().landScapeAssets.street,
                0,
                0,
                Constants.WORLD_WIDTH,
                Constants.WORLD_HEIGHT
        );

        batch.setColor(1, 1, 1, 1);

        home.render(batch);

        // Draw the player
        player.render(batch);
        batch.setColor(1, 1, 1, 1);

        // Draw the people
        for (Person p : people) {
            p.render();
        }
        batch.setColor(1, 1, 1, 1);

        // Draw the HUD
        gameHUD.render(player.getMoney());
        batch.setColor(1, 1, 1, 1);

        batch.end();
    }

    /**
     * This method spawns an NPC the player can interact with
     */
    private void spawnPerson() {
        people.add(new Person(this, random.nextFloat() > 0.5f));

    }

    public Player getPlayer() {
        return player;
    }

    public void removePerson(Person person) {
        people.removeValue(person, true);
        System.out.println(people.size);
    }
}