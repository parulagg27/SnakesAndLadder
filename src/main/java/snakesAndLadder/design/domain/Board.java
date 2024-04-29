package snakesAndLadder.design.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Board {

    private int size = 0;

    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;

    public Board() {
        this(10);
    }
    public Board(int boardSize) {
        this.size = boardSize * boardSize;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public int getSnakeTailIfGivenPositionIsSnakeHead(int targetPosition) {
        if (isSnakeHead(targetPosition)) {
            return getSnakeTail(targetPosition);
        }
        return targetPosition;
    }

    public int getLadderTopIfGivenPositionIsLadderBottom(int targetPosition) {
        if (isLadderBottom(targetPosition)) {
            return getLadderTop(targetPosition);
        }
        return targetPosition;
    }

    public boolean isSnakeHead(int targetPosition) {
        return snakes.containsKey(targetPosition);
    }

    public boolean isLadderBottom(int targetPosition) {
        return ladders.containsKey(targetPosition);
    }

    public void addSnake(int head, int tail) {
        if (isInvalidPosition(head) || isInvalidPosition(tail)) {
            return;
        }
        snakes.put(head, tail);
    }

    public void addLadder(int bottom, int top) {
        if (isInvalidPosition(bottom) || isInvalidPosition(top)) {
            return;
        }
        ladders.put(bottom, top);
    }

    public int getSnakeTail(int targetPosition) {
        return snakes.get(targetPosition);
    }

    public int getLadderTop(int targetPosition) {
        return ladders.get(targetPosition);
    }

    private boolean isInvalidPosition(int position) {
        return position <= 0 || position > size;
    }
}
