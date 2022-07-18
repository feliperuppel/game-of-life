package com.ruppel;

import com.ruppel.game.GameOfLife;
import com.ruppel.game.Universe.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Position> seeds = getGliderPattern();
        GameOfLife.play(seeds, 10);
    }

    private static Set<Position> getGliderPattern() {
        return new HashSet<>(
                Arrays.asList(
                        new Position(2, 1),
                        new Position(2, 2),
                        new Position(2, 3),
                        new Position(0, 2),
                        new Position(1, 3)
                )
        );
    }
}
