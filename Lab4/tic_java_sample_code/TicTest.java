package tic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTest {

    @Test
    void constructorInitializesEmptyBoard() {
        Tic board = new Tic(3, 3);

        assertEquals(3, board.rows);
        assertEquals(3, board.cols);
        assertEquals("X", board.turn);

        for (int i = 0; i < board.rows; i++) {
            for (int j = 0; j < board.cols; j++) {
                assertEquals("_", board.board[i][j]);
            }
        }
    }

    @Test
    void twoNewBoardsWithSameSizeShouldBeEqual() {
        Tic board = new Tic(3, 3);
        Tic board2 = new Tic(3, 3);

        assertEquals(board, board2);
    }

    @Test
    void equalBoardsShouldHaveSameHashCode() {
        Tic board = new Tic(3, 3);
        Tic board2 = new Tic(3, 3);

        assertEquals(board.hashCode(), board2.hashCode());
    }
	@Test
	void emptyBoardShouldPrintAsGrid() {
		Tic board = new Tic(3, 3);

		String expected = String.join(System.lineSeparator(),
				"_ _ _",
				"_ _ _",
				"_ _ _");

		assertEquals(expected, board.toString());
	}
    @Test
    void playShouldPlaceCurrentPlayerMarkOnBoard() {
        Tic board = new Tic(3, 3);

        board.play(1, 1);

        assertEquals("X", board.board[1][1]);
    }
}