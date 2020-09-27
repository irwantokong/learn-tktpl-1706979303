package id.ac.ui.cs.mobileprogramming.irwanto.randomgenerator;

import java.util.Random;

public class RandomNumberGenerator {

    public int generateFromRange(int a, int b) {
        Random rand = new Random();
        return rand.nextInt(b - a + 1) + a;
    }
}
