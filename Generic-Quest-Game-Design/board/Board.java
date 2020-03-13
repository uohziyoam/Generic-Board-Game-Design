package board;

import market.*;

public class Board {
    private Square[][] board;
    private int row;
    private int col;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        initBoard();
    }

    private void initBoard() {
        board = new Square[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isMarket(i, j)) {
                    board[i][j] = new Market(i, j);
                } else if (isTile(i, j)) {
                    board[i][j] = new Tile(i, j);
                } else {
                    board[i][j] = new Square(i, j, true);
                }
            }
        }

    }

    private boolean isMarket(int x, int y) {
        if (isValidPosition(x, y)) {
            return false;
        }

        if (x == 2 && y == 3) {
            return true;
        }

        if (x == 3 && y == 5) {
            return true;
        }

        return false;
    }

    private boolean isTile(int x, int y) {
        if (isValidPosition(x, y)) {
            return false;
        }

        if (x == 6 && y == 2) {
            return true;
        }

        if (x == 6 && y == 3) {
            return true;
        }

        return false;
    }

    private boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }

        if (x > row || y > col) {
            return false;
        }

        return true;
    }

}