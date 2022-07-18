package com.ruppel.game;

import java.util.HashSet;
import java.util.Set;

public class TestUtils {
    public static Set<Universe.Position> extractLifePosition(boolean[][] board) {
        Set<Universe.Position> life = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    life.add(new Universe.Position(i, j));
                }
            }
        }
        return life;
    }
}
