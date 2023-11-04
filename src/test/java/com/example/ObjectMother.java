package com.example;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class ObjectMother {
    private static final EasyRandom simple;

    static {
        EasyRandomParameters param = new EasyRandomParameters()
                .collectionSizeRange(2, 6);
        simple = new EasyRandom(param);
    }

    public static EasyRandom get() {
        return simple;
    }
}
