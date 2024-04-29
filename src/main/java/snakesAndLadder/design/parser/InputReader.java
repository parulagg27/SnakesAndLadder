package snakesAndLadder.design.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputReader {
    public static BufferedReader readInput(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }
}
