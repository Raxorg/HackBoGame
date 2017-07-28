package com.viscadevs.util;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    private static Assets instance = new Assets();
    private AssetManager assetManager;

    public PlayerAssets playerAssets;
    public PersonAssets personAssets;
    public BarAssets barAssets;
    public LandScapeAssets landScapeAssets;
    public UpgradeAssets upgradeAssets;
    public ButtonAssets buttonAssets;
    public HUDAssets hudAssets;

    public static Assets getInstance() {
        return instance;
    }

    public void init() {
        assetManager = new AssetManager();

        load();

        playerAssets = new PlayerAssets();
        playerAssets.init();
        personAssets = new PersonAssets();
        personAssets.init();
        landScapeAssets = new LandScapeAssets();
        landScapeAssets.init();
        barAssets = new BarAssets();
        barAssets.init();
        upgradeAssets = new UpgradeAssets();
        upgradeAssets.init();
        buttonAssets = new ButtonAssets();
        buttonAssets.init();
        hudAssets = new HUDAssets();
        hudAssets.init();
    }

    private void load() {
        // City
        assetManager.load(Constants.STREET, Texture.class);
        assetManager.load(Constants.CLOUDS, Texture.class);
        // Player
        //MALE
        assetManager.load(Constants.MALE_MEDIUM_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.MALE_MEDIUM_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.MALE_MEDIUM_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.MALE_MEDIUM_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.MALE_MEDIUM_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.MALE_MEDIUM_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.MALE_MEDIUM__FRONT, Texture.class);
        assetManager.load(Constants.MALE_POOR_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.MALE_POOR_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.MALE_POOR_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.MALE_POOR_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.MALE_POOR_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.MALE_POOR_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.MALE_POOR__FRONT, Texture.class);
        assetManager.load(Constants.MALE_RICH_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.MALE_RICH_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.MALE_RICH_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.MALE_RICH_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.MALE_RICH_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.MALE_RICH_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.MALE_RICH__FRONT, Texture.class);
        //FEMALE
        assetManager.load(Constants.FEMALE_MEDIUM_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.FEMALE_MEDIUM_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.FEMALE_MEDIUM_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.FEMALE_MEDIUM_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.FEMALE_MEDIUM_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.FEMALE_MEDIUM_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.FEMALE_MEDIUM__FRONT, Texture.class);
        assetManager.load(Constants.FEMALE_POOR_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.FEMALE_POOR_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.FEMALE_POOR_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.FEMALE_POOR_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.FEMALE_POOR_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.FEMALE_POOR__FRONT, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_LEFT_1, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_LEFT_2, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_LEFT_3, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_RIGHT_1, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_RIGHT_2, Texture.class);
        assetManager.load(Constants.FEMALE_RICH_WALKING_RIGHT_3, Texture.class);
        assetManager.load(Constants.FEMALE_RICH__FRONT, Texture.class);
        // Person
        assetManager.load(Constants.PERSON, Texture.class);
        assetManager.load(Constants.PERSON2, Texture.class);
        // HUD
        assetManager.load(Constants.BAR_LEFT, Texture.class);
        assetManager.load(Constants.BAR_MID, Texture.class);
        assetManager.load(Constants.BAR_RIGHT, Texture.class);
        assetManager.load(Constants.BAR_LEFT_F, Texture.class);
        assetManager.load(Constants.BAR_MID_F, Texture.class);
        assetManager.load(Constants.BAR_RIGHT_F, Texture.class);
        assetManager.load(Constants.HUD_MONEY_BAR, Texture.class);
        //Upgrades
        assetManager.load(Constants.POOR_HOME, Texture.class);
        assetManager.load(Constants.MEDIUM_HOME, Texture.class);
        assetManager.load(Constants.RICH_HOME, Texture.class);
        assetManager.load(Constants.GUN_UPGRADE, Texture.class);
        assetManager.load(Constants.HOME_UPGRADE, Texture.class);
        assetManager.load(Constants.MONEY_UPGRADE, Texture.class);
        // Buttons
        assetManager.load(Constants.BUTTONS_START, Texture.class);
        assetManager.load(Constants.BUTTONS_INSTRUCTIONS, Texture.class);
        assetManager.load(Constants.BUTTONS_CREDITS, Texture.class);

        assetManager.finishLoading();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class PlayerAssets {
        //MALE
        public Animation<Texture> maleMediumWalkingRightAnimation;
        public Animation<Texture> maleMediumWalkingLeftAnimation;
        public Animation<Texture> malePoorWalkingRightAnimation;
        public Animation<Texture> malePoorWalkingLeftAnimation;
        public Animation<Texture> maleRichWalkingRightAnimation;
        public Animation<Texture> maleRichWalkingLeftAnimation;

        public Texture maleMediumFront, malePoorFront, maleRichFront;

        //FEMALE
        public Animation<Texture> femaleMediumWalkingRightAnimation;
        public Animation<Texture> femaleMediumWalkingLeftAnimation;
        public Animation<Texture> femalePoorWalkingRightAnimation;
        public Animation<Texture> femalePoorWalkingLeftAnimation;
        public Animation<Texture> femaleRichWalkingRightAnimation;
        public Animation<Texture> femaleRichWalkingLeftAnimation;

        public Texture femaleMediumFront, femalePoorFront, femaleRichFront;

        public void init() {
            //MALE
            maleMediumFront = assetManager.get(Constants.MALE_MEDIUM__FRONT);
            malePoorFront = assetManager.get(Constants.MALE_POOR__FRONT);
            maleRichFront = assetManager.get(Constants.MALE_RICH__FRONT);

            Texture[] maleMediumWalkingRightFrames = new Texture[3];
            maleMediumWalkingRightFrames[0] = assetManager.get(Constants.MALE_MEDIUM_WALKING_RIGHT_1);
            maleMediumWalkingRightFrames[1] = assetManager.get(Constants.MALE_MEDIUM_WALKING_RIGHT_2);
            maleMediumWalkingRightFrames[2] = assetManager.get(Constants.MALE_MEDIUM_WALKING_RIGHT_3);
            maleMediumWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, maleMediumWalkingRightFrames);
            maleMediumWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


            Texture[] maleMediumWalkingLeftFrames = new Texture[3];
            maleMediumWalkingLeftFrames[0] = assetManager.get(Constants.MALE_MEDIUM_WALKING_LEFT_1);
            maleMediumWalkingLeftFrames[1] = assetManager.get(Constants.MALE_MEDIUM_WALKING_LEFT_2);
            maleMediumWalkingLeftFrames[2] = assetManager.get(Constants.MALE_MEDIUM_WALKING_LEFT_3);
            maleMediumWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, maleMediumWalkingLeftFrames);
            maleMediumWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] malePoorWalkingRightFrames = new Texture[3];
            malePoorWalkingRightFrames[0] = assetManager.get(Constants.MALE_POOR_WALKING_RIGHT_1);
            malePoorWalkingRightFrames[1] = assetManager.get(Constants.MALE_POOR_WALKING_RIGHT_2);
            malePoorWalkingRightFrames[2] = assetManager.get(Constants.MALE_POOR_WALKING_RIGHT_3);
            malePoorWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, malePoorWalkingRightFrames);
            malePoorWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] malePoorWalkingLeftFrames = new Texture[3];
            malePoorWalkingLeftFrames[0] = assetManager.get(Constants.MALE_POOR_WALKING_LEFT_1);
            malePoorWalkingLeftFrames[1] = assetManager.get(Constants.MALE_POOR_WALKING_LEFT_2);
            malePoorWalkingLeftFrames[2] = assetManager.get(Constants.MALE_POOR_WALKING_LEFT_3);
            malePoorWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, malePoorWalkingLeftFrames);
            malePoorWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] maleRichWalkingRightFrames = new Texture[3];
            maleRichWalkingRightFrames[0] = assetManager.get(Constants.MALE_RICH_WALKING_RIGHT_1);
            maleRichWalkingRightFrames[1] = assetManager.get(Constants.MALE_RICH_WALKING_RIGHT_2);
            maleRichWalkingRightFrames[2] = assetManager.get(Constants.MALE_RICH_WALKING_RIGHT_3);
            maleRichWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, maleRichWalkingRightFrames);
            maleRichWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] maleRichWalkingLeftFrames = new Texture[3];
            maleRichWalkingLeftFrames[0] = assetManager.get(Constants.MALE_RICH_WALKING_LEFT_1);
            maleRichWalkingLeftFrames[1] = assetManager.get(Constants.MALE_RICH_WALKING_LEFT_2);
            maleRichWalkingLeftFrames[2] = assetManager.get(Constants.MALE_RICH_WALKING_LEFT_3);
            maleRichWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, maleRichWalkingLeftFrames);
            maleRichWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            //FEMALE
            femaleMediumFront = assetManager.get(Constants.FEMALE_MEDIUM__FRONT);
            femalePoorFront = assetManager.get(Constants.FEMALE_POOR__FRONT);
            femaleRichFront = assetManager.get(Constants.FEMALE_RICH__FRONT);

            Texture[] femaleMediumWalkingRightFrames = new Texture[3];
            femaleMediumWalkingRightFrames[0] = assetManager.get(Constants.FEMALE_MEDIUM_WALKING_RIGHT_1);
            femaleMediumWalkingRightFrames[1] = assetManager.get(Constants.FEMALE_MEDIUM_WALKING_RIGHT_2);
            femaleMediumWalkingRightFrames[2] = assetManager.get(Constants.FEMALE_MEDIUM_WALKING_RIGHT_3);
            femaleMediumWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, femaleMediumWalkingRightFrames);
            femaleMediumWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


            Texture[] femaleMediumWalkingLeftFrames = new Texture[3];
            femaleMediumWalkingLeftFrames[0] = assetManager.get(Constants.FEMALE_MEDIUM_WALKING_LEFT_1);
            femaleMediumWalkingLeftFrames[1] = assetManager.get(Constants.FEMALE_MEDIUM_WALKING_LEFT_2);
            femaleMediumWalkingLeftFrames[2] = assetManager.get(Constants.FEMALE_MEDIUM_WALKING_LEFT_3);
            femaleMediumWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, femaleMediumWalkingLeftFrames);
            femaleMediumWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] femalePoorWalkingRightFrames = new Texture[3];
            femalePoorWalkingRightFrames[0] = assetManager.get(Constants.FEMALE_POOR_WALKING_RIGHT_1);
            femalePoorWalkingRightFrames[1] = assetManager.get(Constants.FEMALE_POOR_WALKING_RIGHT_2);
            femalePoorWalkingRightFrames[2] = assetManager.get(Constants.FEMALE_POOR_WALKING_RIGHT_3);
            femalePoorWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, femalePoorWalkingRightFrames);
            femalePoorWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] femalePoorWalkingLeftFrames = new Texture[3];
            femalePoorWalkingLeftFrames[0] = assetManager.get(Constants.FEMALE_POOR_WALKING_LEFT_1);
            femalePoorWalkingLeftFrames[1] = assetManager.get(Constants.FEMALE_POOR_WALKING_LEFT_2);
            femalePoorWalkingLeftFrames[2] = assetManager.get(Constants.FEMALE_POOR_WALKING_LEFT_3);
            femalePoorWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, femalePoorWalkingLeftFrames);
            femalePoorWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] femaleRichWalkingRightFrames = new Texture[3];
            femaleRichWalkingRightFrames[0] = assetManager.get(Constants.FEMALE_RICH_WALKING_RIGHT_1);
            femaleRichWalkingRightFrames[1] = assetManager.get(Constants.FEMALE_RICH_WALKING_RIGHT_2);
            femaleRichWalkingRightFrames[2] = assetManager.get(Constants.FEMALE_RICH_WALKING_RIGHT_3);
            femaleRichWalkingRightAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, femaleRichWalkingRightFrames);
            femaleRichWalkingRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            Texture[] femaleRichWalkingLeftFrames = new Texture[3];
            femaleRichWalkingLeftFrames[0] = assetManager.get(Constants.FEMALE_RICH_WALKING_LEFT_1);
            femaleRichWalkingLeftFrames[1] = assetManager.get(Constants.FEMALE_RICH_WALKING_LEFT_2);
            femaleRichWalkingLeftFrames[2] = assetManager.get(Constants.FEMALE_RICH_WALKING_LEFT_3);
            femaleRichWalkingLeftAnimation = new Animation<Texture>(Constants.WALK_LOOP_DURATION, femaleRichWalkingLeftFrames);
            femaleRichWalkingLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        }
    }

    public class PersonAssets {
        public Texture person, person2;

        public void init() {
            person = assetManager.get(Constants.PERSON, Texture.class);
            person2 = assetManager.get(Constants.PERSON2, Texture.class);
        }
    }

    public class BarAssets {
        public Texture left, mid, right, leftF, midF, rightF;

        public void init() {
            left = assetManager.get(Constants.BAR_LEFT);
            mid = assetManager.get(Constants.BAR_MID);
            right = assetManager.get(Constants.BAR_RIGHT);
            leftF = assetManager.get(Constants.BAR_LEFT_F);
            midF = assetManager.get(Constants.BAR_MID_F);
            rightF = assetManager.get(Constants.BAR_RIGHT_F);
        }
    }

    public class LandScapeAssets {
        public Texture street, clouds;

        public void init() {
            street = assetManager.get(Constants.STREET);
            clouds = assetManager.get(Constants.CLOUDS);
        }
    }

    public class UpgradeAssets {
        public Texture poorHome, mediumHome, richHome;
        public Texture gunUpgrade, homeUpgrade, moneyUpgrade;

        public void init() {
            poorHome = assetManager.get(Constants.POOR_HOME);
            mediumHome = assetManager.get(Constants.MEDIUM_HOME);
            richHome = assetManager.get(Constants.RICH_HOME);
            gunUpgrade = assetManager.get(Constants.GUN_UPGRADE);
            homeUpgrade = assetManager.get(Constants.HOME_UPGRADE);
            moneyUpgrade = assetManager.get(Constants.MONEY_UPGRADE);
        }
    }

    public class ButtonAssets {
        public Texture start, instructions, credits;

        public void init() {
            start = assetManager.get(Constants.BUTTONS_START);
            instructions = assetManager.get(Constants.BUTTONS_INSTRUCTIONS);
            credits = assetManager.get(Constants.BUTTONS_CREDITS);

        }
    }

    public class HUDAssets {
        public Texture moneyBar;

        public void init() {
            moneyBar = assetManager.get(Constants.HUD_MONEY_BAR);
        }
    }
}
