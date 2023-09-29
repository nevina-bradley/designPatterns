package com.nevinabradley.designPatterns;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ObserverPatternExampleTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testObserverPattern() {
        Pattern pattern = new Pattern();

        Observer user1 = new User("User 1");
        Observer user2 = new User("User 2");

        pattern.addObserver(user1);
        pattern.addObserver(user2);

        pattern.notifyObservers("New resource created.");

        String expectedOutput = "User 1 received message: New resource created.\n" +
                "User 2 received message: New resource created.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testRemoveObserver() {
        Pattern pattern = new Pattern();

        Observer user1 = new User("User 1");
        Observer user2 = new User("User 2");

        pattern.addObserver(user1);
        pattern.addObserver(user2);

        pattern.removeObserver(user1);
        pattern.notifyObservers("New resource created.");

        String expectedOutput = "User 2 received message: New resource created.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testNoObservers() {
        Pattern pattern = new Pattern();

        pattern.notifyObservers("New resource created.");

        assertEquals("", outputStream.toString());
    }

    @Before
    public void restoreStreams() {
        System.setOut(originalSystemOut);
    }
}
