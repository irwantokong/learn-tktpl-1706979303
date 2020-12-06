package id.ac.ui.cs.mobileprogramming.irwanto.randomgenerator;

import org.junit.Test;

public class RandomNumberGeneratorTest {
    @Test
    public void correctRangeTest() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generateFromRange(10, 20);
        assert number >= 10;
        assert number <= 20;
    }
}
