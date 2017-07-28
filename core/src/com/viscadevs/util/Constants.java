package com.viscadevs.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final float FADING_SPEED = 0.5f;

    // Player and Person
    public static final float HUMAN_WIDTH = 60f;
    public static final float HUMAN_HEIGHT = 96f;

    // Player
    public static final float PLAYER_SPEED = 150f;
    public static final float PLAYER_SPAWN_X = 400f;
    public static final float PLAYER_SPAWN_Y = 100f;

    // Person
    public static final String PERSON = "other/person.png";
    public static final String PERSON2 = "other/person2.png";
    public static final float PERSON_SPEED = 25f;
    public static final float PERSON_MAX_BONUS_SPEED = 150f;
    public static final float PERSON_SPAWN_RATE = 1f;

    // World
    public static final float WORLD_WIDTH = 1000;
    public static final float WORLD_HEIGHT = 500;

    public static final int INITIAL_HEALTH = 100;
    public static final int MAX_BAR_CAPACITY = 100;
    public static final int INITIAL_MONEY = 100;

    public static final String STANDARD_WALKING_RIGHT_1 = "player/standard_walking_right_1.png";
    public static final String STANDARD_WALKING_RIGHT_2 = "player/standard_walking_right_2.png";
    public static final String STANDARD_WALKING_RIGHT_3 = "player/standard_walking_right_3.png";

    public static final String STANDARD_WALKING_LEFT_1 = "player/standard_walking_left_1.png";
    public static final String STANDARD_WALKING_LEFT_2 = "player/standard_walking_left_2.png";
    public static final String STANDARD_WALKING_LEFT_3 = "player/standard_walking_left_3.png";
    public static final String STANDARD_FRONT = "player/standard_front.png";

    public static final String HOMELESS_WALKING_RIGHT_1 = "player/homeless_walking_right_1.png";
    public static final String HOMELESS_WALKING_RIGHT_2 = "player/homeless_walking_right_2.png";
    public static final String HOMELESS_WALKING_RIGHT_3 = "player/homeless_walking_right_3.png";

    public static final String HOMELESS_WALKING_LEFT_1 = "player/homeless_walking_left_1.png";
    public static final String HOMELESS_WALKING_LEFT_2 = "player/homeless_walking_left_2.png";
    public static final String HOMELESS_WALKING_LEFT_3 = "player/homeless_walking_left_3.png";
    public static final String HOMELESS_FRONT = "player/homeless_front.png";

    public static final String POOR_HOME = "upgrades/poorHome.png";
    public static final String MEDIUM_HOME = "upgrades/mediumHome.png";
    public static final String RICH_HOME = "upgrades/richHome.png";

    // Upgrades
    public static final String GUN_UPGRADE = "upgrades/gun_upgrade.png";
    public static final String HOME_UPGRADE = "upgrades/home_upgrade.png";
    public static final String MONEY_UPGRADE = "upgrades/money_upgrade.png";

    // City
    public static final String STREET = "scene/street.png";
    public static final String CLOUDS = "scene/sky/clouds.png";

    public static final float WALK_LOOP_DURATION = 0.25f;

    public static final Vector2 HOME_POSITION = new Vector2(400, 100);
    public static final Vector2 HOME_DIMENTIONS = new Vector2(150, 100);

    // HUD
    public static final String BAR_LEFT = "bar/left.png";
    public static final String BAR_MID = "bar/mid.png";
    public static final String BAR_RIGHT = "bar/right.png";
    public static final String BAR_LEFT_F = "bar/leftF.png";
    public static final String BAR_MID_F = "bar/midF.png";
    public static final String BAR_RIGHT_F = "bar/rightF.png";
    public static final float BAR_WIDTH = 200f;
    public static final float BAR_HEIGHT = 25f;
    public static final String HUD_MONEY_BAR = "other/moneyBar.png";
    public static final float MONEY_BAR_WIDTH = 250f;
    public static final float MONEY_BAR_HEIGHT = MONEY_BAR_WIDTH / 8f;

    // Buttons
    public static final String BUTTONS_START = "other/start.png";
    public static final String BUTTONS_INSTRUCTIONS = "other/instructions.png";
    public static final String BUTTONS_CREDITS = "other/credits.png";
    public static final float BUTTON_WIDTH = 200;
    public static final float BUTTON_HEIGHT = BUTTON_WIDTH / 4;
    public static final float START_BUTTON_X = Gdx.graphics.getWidth() / 2 - BUTTON_WIDTH / 2;
    public static final float START_BUTTON_Y = Gdx.graphics.getHeight() * 0.7f;
    public static final float INSTRUCTIONS_BUTTON_X = START_BUTTON_X;
    public static final float INSTRUCTIONS_BUTTON_Y = START_BUTTON_Y - BUTTON_HEIGHT * 2;
    public static final float CREDITS_BUTTON_X = START_BUTTON_X;
    public static final float CREDITS_BUTTON_Y = INSTRUCTIONS_BUTTON_Y - BUTTON_HEIGHT * 2;
}
