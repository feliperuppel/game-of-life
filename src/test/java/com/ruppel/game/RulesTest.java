package com.ruppel.game;

import com.ruppel.game.Universe.Position;
import org.junit.jupiter.api.Test;

import static com.ruppel.game.TestUtils.extractLifePosition;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RulesTest {


    @Test
    public void shouldDieByUnderPopulationWhenNoLiveNeighbor() {
        boolean[][] board = {
                {false, false, false},
                {false, true, false},
                {false, false, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertFalse(shouldLive);
    }

    @Test
    public void shouldDieByUnderPopulationWhenOneLiveNeighbor() {
        boolean[][] board = {
                {false, true, false},
                {false, true, false},
                {false, false, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertFalse(shouldLive);
    }

    @Test
    public void shouldStayAliveWhenTwoLiveNeighbors() {
        boolean[][] board = {
                {true, false, true},
                {false, true, false},
                {false, false, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertTrue(shouldLive);
    }

    @Test
    public void shouldStayAliveWhenThreeLiveNeighbors() {
        boolean[][] board = {
                {false, false, false},
                {true, true, false},
                {true, true, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertTrue(shouldLive);
    }

    @Test
    public void shouldDieByOvercrowdingWhenMoreThanThreeLiveNeighbors() {
        boolean[][] board = {
                {true, false, true},
                {false, true, true},
                {false, false, true},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertFalse(shouldLive);
    }

    @Test
    public void shouldBecomeAliveWhenThreeLiveNeighbors() {
        boolean[][] board = {
                {true, false, false},
                {true, false, false},
                {true, false, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertTrue(shouldLive);
    }

    @Test
    public void shouldStayDeadWhenLessThreeLiveNeighbors() {
        boolean[][] board = {
                {true, false, false},
                {true, false, false},
                {false, false, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertFalse(shouldLive);
    }

    @Test
    public void shouldStayDeadWhenMoreThanThreeLiveNeighbors() {
        boolean[][] board = {
                {true, true, false},
                {true, false, false},
                {true, false, false},
        };
        Position target = new Position(1, 1);
        Universe universe = new Universe(extractLifePosition(board));

        boolean shouldLive = Rules.shouldLive(target, universe);

        assertFalse(shouldLive);
    }
}
