package snakesAndLadder.design.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import snakesAndLadder.design.game.GameConfig;

import java.io.*;

public class InputParser {

    public static BufferedReader readInput(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    public static GameConfig loadDefaultGameConfig(String configFilePath) {
        File configFile = new File(configFilePath);
        var objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            return objectMapper.readValue(configFile, GameConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
