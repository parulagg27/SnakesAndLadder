package snakesAndLadder.design.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dice {

    private final int numberOfFaces;

    public Dice() {
        numberOfFaces = 6;
    }

    public Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int roll() {
        return (int) (Math.random() * numberOfFaces) + 1;
    }
}
