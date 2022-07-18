package com.ruppel.game;

import com.ruppel.game.Universe.Position;

public class Rules {

    public static boolean shouldLive(final Position position, final Universe universe) {
        final int aliveNeighbors = countLiveNeighbors(position, universe);

        boolean isUnderpopulated = aliveNeighbors < 2;
        boolean isOvercrowded = aliveNeighbors > 3;
        boolean isAlive = universe.isAlive(position);
        boolean isNotAlive = !isAlive;

        return (isNotAlive && aliveNeighbors == 3) || (isAlive && !isOvercrowded && !isUnderpopulated);
    }

    private static int countLiveNeighbors(final Position position, final Universe universe) {
        int count = 0;
        for (int i = position.x - 1; i <= position.x + 1; i++) {
            for (int j = position.y - 1; j <= position.y + 1; j++) {
                Position neighbor = new Position(i, j);
                if (!position.equals(neighbor) && universe.isAlive(neighbor)) {
                    count++;
                }
            }
        }
        return count;
    }
}