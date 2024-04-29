package snakesAndLadder.design.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class BoardTest {

    @Test
    void shouldAddSnakesToBoardIfValidPositionsInBoard() {
        var board = new Board(5);
        board.addSnake(14, 7);
        board.addSnake(19, 2);
        var expectedSnakes = new HashMap<>() {{
            put(14, 7);
            put(19, 2);
        }};

        var output = board.getSnakes();

        Assertions.assertEquals(expectedSnakes, output);
    }

    @Test
    void shouldNotAddSnakeToBoardIfGivenTailOrHeadNotWithinSizeLimitOfBoard() {
        var board = new Board(5);
        board.addSnake(0, 7);
        board.addSnake(19, 26);
        var expectedSnakes = new HashMap<>();

        var output = board.getSnakes();

        Assertions.assertEquals(expectedSnakes, output);
    }

    @Test
    void shouldAddLaddersToBoardIfValidPositions() {
        var board = new Board(10);
        board.addLadder(14, 7);
        board.addLadder(19, 2);
        var expectedLadders = new HashMap<>() {{
            put(14, 7);
            put(19, 2);
        }};

        var output = board.getLadders();

        Assertions.assertEquals(expectedLadders, output);
    }

    @Test
    void shouldNotAddLaddersToBoardIfGivenBottomOrTopNotWithinSizeLimitOfBoard() {
        var board = new Board(5);
        board.addLadder(0, 7);
        board.addLadder(19, 26);
        var expectedLadders = new HashMap<>();

        var output = board.getLadders();

        Assertions.assertEquals(expectedLadders, output);
    }

    @Test
    void shouldReturnTrueIfGivenPositionIsLadderBottom() {
        var board = new Board(5);
        board.addLadder(14, 7);

        var output = board.isLadderBottom(14);

        Assertions.assertTrue(output);
    }

    @Test
    void shouldReturnTrueIfGivenPositionIsSnakeHead() {
        var board = new Board(5);
        board.addSnake(14, 7);

        var output = board.isSnakeHead(14);

        Assertions.assertTrue(output);
    }

    @Test
    void shouldGetSnakeTailIfGivenPositionIsSnakeHead() {
        var board = new Board(5);
        board.addSnake(14, 7);

        var output = board.getSnakeTailIfGivenPositionIsSnakeHead(14);

        Assertions.assertEquals(7, output);
    }

    @Test
    void shouldReturnPositionItselfIfGivenPositionIsNotSnakeHead() {
        var board = new Board(5);
        board.addSnake(14, 7);

        var output = board.getSnakeTailIfGivenPositionIsSnakeHead(7);

        Assertions.assertEquals(7, output);
    }

    @Test
    void shouldGetLadderTopIfGivenPositionIsLadderBottom() {
        var board = new Board(5);
        board.addLadder(14, 7);

        var output = board.getLadderTopIfGivenPositionIsLadderBottom(14);

        Assertions.assertEquals(7, output);
    }

    @Test
    void shouldReturnPositionItselfIfGivenPositionIsNotLadderBottom() {
        var board = new Board(5);
        board.addLadder(14, 7);

        var output = board.getLadderTopIfGivenPositionIsLadderBottom(7);

        Assertions.assertEquals(7, output);
    }
}