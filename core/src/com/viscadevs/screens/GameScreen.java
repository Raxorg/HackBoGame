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
import com.viscadevs.util.ButtonListener;
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
    private Color cloudsColor;
    private Enums.Gender gender;
    private Button upgradeHomeButton;

    public GameScreen(Enums.Gender gender) {
        this.gender = gender;
    }

    @Override
    public void show() {
        cloudsColor = Color.SALMON;

        gameHUD = new GameHUD(this);
        // TODO GET THE NAME AND GENDER FROM MENU
        player = new Player("BOB", Enums.Gender.MALE, 0, 100);
        player.setGender(gender);
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

        upgradeHomeButton = new Button(
                Assets.getInstance().upgradeAssets.homeUpgrade,
                Gdx.graphics.getWidth() - 75f,
                Gdx.graphics.getHeight() - 75f,
                75f,
                75f,
                Color.BLUE
        ) {
            @Override
            public void onTouch() {
                if (player.getMoney() >= 1000) {
                    home.upgrade();
                }
            }
        };
    }


    @Override
    public void render(float delta) {
        clearScreen();

        calculateSpawnPerson();

        updateButtons();

        updatePeople(delta);

        player.update(delta);

        batch.begin();

        drawCity();

        home.render(batch);

        player.render(batch);

        for (Person p : people) {
            p.render();
        }

        gameHUD.render(player.getMoney());

        batch.setColor(1, 1, 1, 1);

        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.SKY.r, Color.SKY.g, Color.SKY.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void calculateSpawnPerson() {
        float timeElapsed = ViscaUtils.secondsSince(startTime);
        if (timeElapsed >= Constants.PERSON_SPAWN_RATE) {
            spawnPerson();
            startTime = TimeUtils.nanoTime();
        }
    }

    private void updatePeople(float delta) {
        for (Person p : people) {
            people.begin();
            p.update(delta);
            people.end();
        }
    }

    private void drawCity() {
        batch.setColor(cloudsColor);
        batch.draw(
                Assets.getInstance().landScapeAssets.clouds,
                0,
                0,
                Constants.WORLD_WIDTH,
                Constants.WORLD_HEIGHT
        );
        batch.setColor(1, 1, 1, 1);
        batch.draw(
                Assets.getInstance().landScapeAssets.street,
                0,
                0,
                Constants.WORLD_WIDTH,
                Constants.WORLD_HEIGHT
        );
    }

    private void updateButtons() {
        Button[] buttons = new Button[1 + people.size * 2];
        for (int i = 0; i < people.size; i++) {
            buttons[2 * i] = people.get(i).getStealButton();
            buttons[2 * i + 1] = people.get(i).getBegButton();
        }
        buttons[people.size * 2] = upgradeHomeButton;
        Gdx.input.setInputProcessor(new ButtonListener(buttons));
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


    @Override
    public void dispose() {
        for (Person p : people) {
            p.dispose();
        }

        for (Button b : buttons) {
            b.dispose();
        }
    }
}