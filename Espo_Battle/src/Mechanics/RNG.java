package Mechanics;

import java.util.Random;

public class RNG {
    public static Boolean roll(int chance) {
        Random randomNum = new Random();
        int result = randomNum.nextInt(100)+1;
        return chance >= result;
    }
}
