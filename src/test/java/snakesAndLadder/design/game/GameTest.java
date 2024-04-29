package snakesAndLadder.design.game;

import org.junit.jupiter.api.Test;
import snakesAndLadder.design.domain.Board;
import snakesAndLadder.design.domain.Player;

import java.io.IOException;
import java.util.List;

class GameTest {

    @Test
    void shouldLoadGameGivenInput() throws IOException {
        String inputFilePath = "src/test/resources/input.txt";
        Game game = new Game();
        var expectedBoard = getExpectedBoard();
        var expectedPlayers = List.of(
                new Player("Gaurav", 1),
                new Player("Sagar", 1)
        );

        game.loadGame(inputFilePath);

        assert game.getBoard().getSnakes().equals(expectedBoard.getSnakes());
        assert game.getBoard().getLadders().equals(expectedBoard.getLadders());
        assert game.getPlayers().equals(expectedPlayers);
        assert game.getDice().getNumberOfFaces() == 6;
    }

    @Test
    void shouldStartTheGameAndContinueTillAnyPlayerSucceeds() throws IOException {
        String inputFilePath = "src/test/resources/input.txt";
        Game game = new Game();
        game.loadGame(inputFilePath);

        game.startGame();

        assert game.getPlayers().stream().anyMatch(Player::isWinner);
    }

    private static Board getExpectedBoard() {
        var expectedBoard = new Board();
        expectedBoard.addSnake(62, 5);
        expectedBoard.addSnake(33, 6);
        expectedBoard.addSnake(49, 9);
        expectedBoard.addSnake(88, 16);
        expectedBoard.addSnake(41, 20);
        expectedBoard.addSnake(56, 53);
        expectedBoard.addSnake(98, 64);
        expectedBoard.addSnake(93, 73);
        expectedBoard.addSnake(95, 75);
        expectedBoard.addLadder(2, 37);
        expectedBoard.addLadder(27, 46);
        expectedBoard.addLadder(10, 32);
        expectedBoard.addLadder(51, 68);
        expectedBoard.addLadder(61, 79);
        expectedBoard.addLadder(65, 84);
        expectedBoard.addLadder(71, 91);
        expectedBoard.addLadder(81, 100);
        return expectedBoard;
    }
}