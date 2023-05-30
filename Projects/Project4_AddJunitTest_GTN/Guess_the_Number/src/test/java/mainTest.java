import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class mainTest {
//    private Main game;
//
//    @BeforeEach
//    public void setup() {
//        game = new Main();
//        outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//    }


    @Test
    public void testGuessingGame_MaxAttemptsReached() {
        String input = "Bob\n1\n1\n1\n1\n1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Main game = new Main();
        game.startGame();
        //Main.main(new String[]{});
        int target = game.getTargetNumber();
        String expectedOutput = "Hello! What is your name?\n" +
                "Well Bob I am thinking of a number between 1 and 20.\n" +
                "Take a guess.\n" +
                "Too low. Try again.\n" +
                "Too low. Try again.\n" +
                "Too low. Try again.\n" +
                "Too low. Try again.\n" +
                "Too low. Try again.\n" +
                "Sorry, Bob. You have used all your attempts." + " The number I was thinking of was " + target + ".";

        //String actualOutput = game.getOutputStream().toString().trim();
        String actualOutput = game.getOutput().trim();
        assertEquals(expectedOutput, actualOutput);
    }
}
