package com.ruppel.game;

import com.ruppel.game.Universe.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UniverseTest {

    @Test
    public void shouldConsiderDeadWhenOutOfTheBoard() {
        Set<Position> life = new HashSet<>();
        life.add(new Position(2, 2));
        Universe universe = new Universe(life);
        Position target = new Position(20, 25);

        boolean isAlive = universe.isAlive(target);

        assertFalse(isAlive);
    }

    @Test
    public void shouldCreateUniverseEvenWithNull() {
        Universe u = new Universe(null);
        assertEquals("[   ]", u.toString());
    }

    @Test
    public void shouldCreateUniverseEvenWithNoLife() {
        Universe u = new Universe(Collections.emptySet());
        assertEquals("[   ]", u.toString());
    }

    @Test
    public void shouldCreateUniverseEvenWithNegativePosition() {
        Set<Position> life = new HashSet<>();
        life.add(new Position(-1, -1));
        Universe universe = new Universe(life);

        String representation = universe.toString();

        assertEquals("[ A ]", representation);
    }

    @Test
    public void shouldCreateUniverseInSquareShape() {
        Set<Position> life = new HashSet<>();
        life.add(new Position(1, 4));
        Universe universe = new Universe(life);

        String representation = universe.toString();

        String expected =
                "[   ][   ][   ][   ][   ]\n" +
                "[   ][   ][   ][   ][ A ]\n" +
                "[   ][   ][   ][   ][   ]\n" +
                "[   ][   ][   ][   ][   ]\n" +
                "[   ][   ][   ][   ][   ]";

        assertEquals(expected, representation);
    }

    @Test
    public void shouldReturnActivePositionsPlusAllDirectNeighbors() {
        Set<Position> initialLife = new HashSet<>(
                Arrays.asList(
                        new Position(0, 0),
                        new Position(0, 1),
                        new Position(1, 1),
                        new Position(1, 2),
                        new Position(4, 5)
                )
        );

        Set<Position> expected = new HashSet<>(
                Arrays.asList(
                        new Position(-1, -1),
                        new Position(-1, 0),
                        new Position(-1, 1),
                        new Position(-1, 2),
                        new Position(0, -1),
                        new Position(0, 0),
                        new Position(0, 1),
                        new Position(0, 2),
                        new Position(0, 3),
                        new Position(1, -1),
                        new Position(1, 0),
                        new Position(1, 1),
                        new Position(1, 2),
                        new Position(1, 3),
                        new Position(2, 0),
                        new Position(2, 1),
                        new Position(2, 2),
                        new Position(2, 3),
                        new Position(3, 4),
                        new Position(3, 5),
                        new Position(3, 6),
                        new Position(4, 4),
                        new Position(4, 5),
                        new Position(4, 6),
                        new Position(5, 4),
                        new Position(5, 5),
                        new Position(5, 6)
                )
        );

        Universe universe = new Universe(initialLife);

        Set<Position> visiblePortion = universe.getVisiblePositions();

        assertEquals(expected, visiblePortion);
    }

    @Test
    public void shouldReturnEmptyWhenNoLife() {
        Universe u = new Universe(Collections.emptySet());
        assertTrue(u.getVisiblePositions().isEmpty());
    }

    @Test
    public void shouldReturnEmptyWhenNull() {
        Universe u = new Universe(null);
        assertTrue(u.getVisiblePositions().isEmpty());
    }
}
