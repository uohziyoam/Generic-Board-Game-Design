package game_list.tic_tac_toe;

import constants.*;
import coordinate.*;
import generic_setting.*;

public class TicTacToeBoard extends AbstractBoard {
    protected int[] rowPlayerA;
    protected int[] rowPlayerB;

    protected int[] colPlayerA;
    protected int[] colPlayerB;

    protected int[] diagPlayerA;
    protected int[] diagPlayerB;

    protected int[] antiDiagPlayerA;
    protected int[] antiDiagPlayerB;

    protected TicTacToeBoard(int row, int col) {
        super(row, col);
        this.initBoard();

        this.rowPlayerA = new int[row];
        this.rowPlayerB = new int[row];

        this.colPlayerA = new int[row];
        this.colPlayerB = new int[row];

        this.diagPlayerA = new int[row];
        this.diagPlayerB = new int[row];

        this.antiDiagPlayerA = new int[row];
        this.antiDiagPlayerB = new int[row];
    }

    private void initBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Cell cell = new Cell(null);
                this.board[i][j] = cell;
            }
        }
    }

    public void movePlayerA(int index, Piece piece) {
        if (index <= 0 || index > row * col) {
            return;
        }

        Coordinate coordinate = indexMap.get(index);
        int boardSize = board[0].length;
        if (piece == Piece.X) {
            rowPlayerA[coordinate.row]++;
            colPlayerA[coordinate.col]++;
            if (coordinate.row == coordinate.col) {
                diagPlayerA[coordinate.row]++;
            }
            if (coordinate.row + coordinate.col == boardSize - 1) {
                antiDiagPlayerA[coordinate.row]++;
            }
        }
    }

    public void movePlayerB(int index, Piece piece) {
        if (index <= 0 || index > row * col) {
            return;
        }

        Coordinate coordinate = indexMap.get(index);
        int boardSize = board[0].length;

        rowPlayerB[coordinate.row]++;
        colPlayerB[coordinate.col]++;
        if (coordinate.row == coordinate.col) {
            diagPlayerB[coordinate.row]++;
        }
        if (coordinate.row + coordinate.col == boardSize) {
            antiDiagPlayerB[coordinate.row]++;
        }
    }

    @Override
    public boolean set(int index, Piece piece) {
        boolean isSuccess = super.set(index, piece);

        if (piece == Piece.X) {
            movePlayerA(index, piece);
        } else {
            movePlayerB(index, piece);
        }

        return isSuccess;
    }

    @Override
    public Cell get(int index) {
        return super.get(index);
    }

    @Override
    public boolean isEmpty(int index) {
        return super.isEmpty(index);
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    @Override
    public GameState checkStatus() {
        if (sum(diagPlayerA) == row || sum(antiDiagPlayerA) == row) {
            return GameState.PLAYERA;
        }

        if (sum(diagPlayerB) == row || sum(antiDiagPlayerB) == row) {
            return GameState.PLAYERB;
        }

        for (int i = 0; i < antiDiagPlayerA.length; i++) {
            if (rowPlayerA[i] == row || colPlayerA[i] == row) {
                return GameState.PLAYERA;
            }
            if (rowPlayerB[i] == row || colPlayerB[i] == row) {
                return GameState.PLAYERB;
            }
        }

        if (this.isFull()) {
            return GameState.TIE;
        }

        return GameState.NOT_END;
    }

    @Override
    public void printBoard() {
        super.printBoard();
    }

    public static void printAll(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    public static int sum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        return sum;
    }
}