package com.example.springboot;

import java.awt.*;
import java.util.Random;

public class Test {

    public static final int FIVE_SECONDS = 80000;
    public static final int MAX_Y = 200;
    public static final int MAX_X = 200;

    public static void main(String... args) throws Exception {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(FIVE_SECONDS);
        }
    }

}
