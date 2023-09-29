package com.nevinabradley.designPatterns;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonPatternExampleTest {
    private DatabaseConnection connection1;
    private DatabaseConnection connection2;

    @Before
    public void setUp() {
        connection1 = DatabaseConnection.getInstance();
        connection2 = DatabaseConnection.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        assertSame(connection1, connection2);
    }

    @Test
    public void testConnection() {
        connection1.connect();
    }
}
