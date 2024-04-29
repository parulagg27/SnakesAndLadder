package snakesAndLadder.design.domain;

import org.junit.jupiter.api.Test;

class DiceTest {

    @Test
    void shouldGenerateRandomValuesWithinRangeForDiceWithDefault6Faces() {
        var dice = new Dice();

        for (int i = 0; i < 100; i++) {
            var output = dice.roll();
            assert output >= 1 && output <= 6;
        }
    }

    @Test
    void shouldGenerateRandomValuesWithinRangeForDiceWithCustomFaces() {
        var dice = new Dice(10);

        for (int i = 0; i < 100; i++) {
            var output = dice.roll();
            assert output >= 1 && output <= 10;
        }
    }
}