package snakesAndLadder.design.game;

import lombok.Getter;
import snakesAndLadder.design.domain.Board;
import snakesAndLadder.design.domain.Dice;
import snakesAndLadder.design.domain.Player;
import snakesAndLadder.design.parser.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {

    private final Board board;
    private List<Player> players;
    private final Dice dice;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.dice = new Dice();
    }

    public void loadGame(String filename) throws IOException {
        var reader = InputReader.readInput(filename);
        readSnakes(reader);
        readLadders(reader);
        addPlayersWithStartPosition(reader);
        reader.close();
    }

    public void startGame() {
        while (true) {
            for (var player : players) {
                int diceValue = dice.roll();
                int targetPosition = player.getPosition() + diceValue;
                if (targetPosition > board.getSize()) {
                    continue;
                }
                if (board.isSnakeHead(targetPosition)) {
                    targetPosition = board.getSnakeTail(targetPosition);
                } else if (board.isLadderBottom(targetPosition)) {
                    targetPosition = board.getLadderTop(targetPosition);
                }
                for (var otherPlayer : players) {
                    if (otherPlayer != player && otherPlayer.getPosition() == targetPosition) {
                        otherPlayer.setPosition(1);
                    }
                }

                player.movePlayer(targetPosition);
                if (targetPosition == board.getSize()) {
                    player.setWinner(true);
                    return;
                }
            }
        }
    }

    private void addPlayersWithStartPosition(BufferedReader reader) throws IOException {
        int playersCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < playersCount; i++) {
            String[] playerNameAndPosition = reader.readLine().split(" ");
            players.add(new Player(playerNameAndPosition[0], Integer.parseInt(playerNameAndPosition[1])));
            players.get(i).setPosition(Integer.parseInt(playerNameAndPosition[1]));
        }
    }

    private void readLadders(BufferedReader reader) throws IOException {
        int laddersCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < laddersCount; i++) {
            String[] ladderPosition = reader.readLine().split(" ");
            board.addLadder(Integer.parseInt(ladderPosition[0]), Integer.parseInt(ladderPosition[1]));
        }
    }

    private void readSnakes(BufferedReader reader) throws IOException {
        int snakesCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < snakesCount; i++) {
            String[] snakePosition = reader.readLine().split(" ");
            board.addSnake(Integer.parseInt(snakePosition[0]), Integer.parseInt(snakePosition[1]));
        }
    }
}
