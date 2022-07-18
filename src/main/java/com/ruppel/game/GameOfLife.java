package com.ruppel.game;

import com.ruppel.game.Universe.Position;

import java.util.Set;
import java.util.stream.Collectors;

public class GameOfLife {

    public static Universe play(final Set<Position> life, final int generations) {
        return play(new Universe(life), generations);
    }

    public static Universe play(final Universe universe, final int generations) {
        print(universe, generations);

        if (generations == 0 || universe.getVisiblePositions().isEmpty()) {
            return universe;
        }

        final Set<Position> nextGeneration = universe.getVisiblePositions()
                .stream()
                .filter(p -> Rules.shouldLive(p, universe))
                .collect(Collectors.toSet());

        return play(new Universe(nextGeneration), generations - 1);
    }

    private static void print(final Universe universe, final int generations) {
        System.out.println("-----------------------------------");
        System.out.println(generations + " generations to go");
        System.out.println(universe);
        System.out.println("-----------------------------------");
    }
}
