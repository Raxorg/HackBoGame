package com.viscadevs.util;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class ViscaUtils {
    public static float secondsSince(long timeNanos) {
        return MathUtils.nanoToSec * (TimeUtils.nanoTime() - timeNanos);
    }
}
