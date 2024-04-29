package snakesAndLadder.design.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void shouldMovePlayerToTargetPosition() {
        var player = new Player("Player1", 1);

        player.movePlayer(5);

        Assertions.assertEquals(5, player.getPosition());
    }
}