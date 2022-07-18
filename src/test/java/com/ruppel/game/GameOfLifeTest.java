package com.ruppel.game;

import com.ruppel.game.Universe.Position;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    static final boolean[][] gliderPattern = {
            {false, false, true, false, false},
            {false, false, false, true, false},
            {false, true, true, true, false},
            {false, false, false, false, false},
    };

    @Test
    public void testGliderFirstGeneration() {
        Set<Position> glider = TestUtils.extractLifePosition(gliderPattern);
        Universe universe = GameOfLife.play(glider, 1);

        String expected =
                "[   ][   ][   ][   ]\n" +
                "[   ][ A ][   ][ A ]\n" +
                "[   ][   ][ A ][ A ]\n" +
                "[   ][   ][ A ][   ]";

        assertEquals(expected, universe.toString());
    }

    @Test
    public void testGliderSecondGeneration() {
        Set<Position> glider = TestUtils.extractLifePosition(gliderPattern);
        Universe universe = GameOfLife.play(glider, 2);

        String expected =
                "[   ][   ][   ][   ]\n" +
                "[   ][   ][   ][ A ]\n" +
                "[   ][ A ][   ][ A ]\n" +
                "[   ][   ][ A ][ A ]";

        assertEquals(expected, universe.toString());
    }

    @Test
    public void testGliderThirdGeneration() {
        Set<Position> glider = TestUtils.extractLifePosition(gliderPattern);
        Universe universe = GameOfLife.play(glider, 3);

        String expected =
                "[   ][   ][   ][   ][   ]\n" +
                "[   ][   ][ A ][   ][   ]\n" +
                "[   ][   ][   ][ A ][ A ]\n" +
                "[   ][   ][ A ][ A ][   ]\n" +
                "[   ][   ][   ][   ][   ]";

        assertEquals(expected, universe.toString());
    }

    @Test
    public void testGliderFourthGeneration() {
        Set<Position> glider = TestUtils.extractLifePosition(gliderPattern);
        Universe universe = GameOfLife.play(glider, 4);

        String expected =
                "[   ][   ][   ][   ][   ]\n" +
                "[   ][   ][   ][ A ][   ]\n" +
                "[   ][   ][   ][   ][ A ]\n" +
                "[   ][   ][ A ][ A ][ A ]\n" +
                "[   ][   ][   ][   ][   ]";

        assertEquals(expected, universe.toString());
    }

}
