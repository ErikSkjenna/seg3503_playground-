package tic;

import java.util.Arrays;
import java.util.Objects;

public class Tic {
    private static final String EMPTY_CELL = "_";
    private static final String FIRST_PLAYER = "X";

    String[][] board;
    int rows;
    int cols;
    String turn;

    public Tic(int row, int col) {
        rows = row;
        cols = col;
        turn = FIRST_PLAYER;
        board = new String[rows][cols];

        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Tic)) {
            return false;
        }

        Tic other = (Tic) obj;

        return rows == other.rows
                && cols == other.cols
                && Objects.equals(turn, other.turn)
                && Arrays.deepEquals(board, other.board);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, cols, turn);
        result = 31 * result + Arrays.deepHashCode(board);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            appendRow(result, i);

            if (i < rows - 1) {
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    private void appendRow(StringBuilder result, int row) {
        for (int col = 0; col < cols; col++) {
            result.append(board[row][col]);

            if (col < cols - 1) {
                result.append(" ");
            }
        }
    }
    public void play(int row, int col) {
        board[row][col] = turn;
        switchTurn();
    }

    private void switchTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }
}