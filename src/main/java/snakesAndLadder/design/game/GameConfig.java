package snakesAndLadder.design.game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameConfig {

    private int numberOfPlayers;
    private int boardSize;
    private int numberOfSnakes;
    private int numberOfLadders;
    private int numberOfDice;
    private String movementStrategy;
}
