package com.viscadevs.util;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Random;

public class ViscaUtils {

    public static final Random random = new Random();

    public static float secondsSince(long timeNanos) {
        return MathUtils.nanoToSec * (TimeUtils.nanoTime() - timeNanos);
    }
}
