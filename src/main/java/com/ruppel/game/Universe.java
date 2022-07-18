package com.ruppel.game;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Universe {
    private static final String NO_LIFE = "[   ]";
    private static final String ALIVE = "[ A ]";
    private final boolean[][] board;
    private final Set<Position> life;

    public Universe(final Set<Position> life) {
        final Set<Position> lifePositions = Optional.ofNullable(life).orElseGet(Collections::emptySet);
        this.life = prepare(lifePositions);
        this.board = createBoard();
    }

    private static Set<Position> prepare(Set<Position> life) {
        int verticalOffset = life.stream()
                .filter(i -> i.x < 0)
                .mapToInt(i -> i.x)
                .map(Math::abs)
                .max()
                .orElse(0);

        int horizontalOffset = life.stream()
                .filter(i -> i.y < 0)
                .mapToInt(i -> i.y)
                .map(Math::abs)
                .max()
                .orElse(0);

        return life.stream()
                .map(p -> new Position(p.x + verticalOffset, p.y + horizontalOffset))
                .collect(Collectors.toSet());
    }

    private boolean[][] createBoard() {
        final int depth = life.stream()
                .flatMap(p -> Stream.of(p.x, p.y))
                .map(i -> ++i)
                .mapToInt(p -> p)
                .max()
                .orElse(0);

        boolean[][] populatedBoard = new boolean[depth][depth];

        life.forEach(position -> populatedBoard[position.x][position.y] = true);

        return populatedBoard;
    }

    public Set<Position> getVisiblePositions() {
        final Set<Position> observable = new HashSet<>();

        life.forEach(position -> {
            for (int i = position.x - 1; i <= position.x + 1; i++) {
                for (int j = position.y - 1; j <= position.y + 1; j++) {
                    observable.add(new Position(i, j));
                }
            }
        });

        return observable;
    }

    public boolean isAlive(final Position position) {
        try {
            return board[position.x][position.y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static String buildRepresentation(boolean[][] board) {
        final StringBuilder sb = new StringBuilder();
        for (boolean[] line : board) {
            for (boolean isAlive : line) {
                sb.append(isAlive ? ALIVE : NO_LIFE);
            }
            sb.append("\n");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    @Override
    public String toString() {
        return life.isEmpty() ? NO_LIFE : buildRepresentation(board);
    }

    public static class Position {
        public final int x;
        public final int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
