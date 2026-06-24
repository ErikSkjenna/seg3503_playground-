package tic;

import java.util.Arrays;
import java.util.Objects;

public class Tic {
    String[][] board;
    int rows;
    int cols;
    String turn;

    public Tic(int row, int col) {
        board = new String[row][col];
        rows = row;
        cols = col;
        turn = "X";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = "_";
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
			for (int j = 0; j < cols; j++) {
				result.append(board[i][j]);

				if (j < cols - 1) {
					result.append(" ");
				}
			}

			if (i < rows - 1) {
				result.append(System.lineSeparator());
			}
		}

		return result.toString();
	}
}