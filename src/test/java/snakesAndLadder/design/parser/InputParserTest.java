package snakesAndLadder.design.parser;

import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void shouldGetDefaultGameConfig() {
        String configFilePath = "src/test/resources/config.yaml";

        var gameConfig = InputParser.loadDefaultGameConfig(configFilePath);

        assert gameConfig != null;
        assert gameConfig.getNumberOfPlayers() == 2;
        assert gameConfig.getBoardSize() == 10;
        assert gameConfig.getNumberOfSnakes() == 5;
        assert gameConfig.getNumberOfLadders() == 5;
        assert gameConfig.getNumberOfDice() == 1;
        assert gameConfig.getMovementStrategy().equals("SUM");
    }
}