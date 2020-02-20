package game_list.order_and_chaos;

import constants.GameState;
import constants.Piece;
import coordinate.Coordinate;
import game_list.tic_tac_toe.TicTacToeBoard;

public class OrderAndChaosBoard extends TicTacToeBoard {

    OrderAndChaosBoard(int row, int col) {
        super(row, col);
    }

    // TODO: NEED TO REDO THE CHECKING ALGORITHM FOR ORDER AND CHAOS
    @Override
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

    // TODO: NEED TO REDO THE CHECKING ALGORITHM FOR ORDER AND CHAOS
    @Override
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
    public GameState checkStatus() {
        if (sum(diagPlayerA) == 5 || sum(antiDiagPlayerA) == 5) {
            return GameState.ORDER;
        }

        if (sum(diagPlayerB) == 5 || sum(antiDiagPlayerB) == 5) {
            return GameState.ORDER;
        }

        for (int i = 0; i < antiDiagPlayerA.length; i++) {
            if (rowPlayerA[i] == 5 || colPlayerA[i] == 5) {
                return GameState.ORDER;
            }
            if (rowPlayerB[i] == 5 || colPlayerB[i] == 5) {
                return GameState.ORDER;
            }
        }

        if (this.isFull()) {
            return GameState.CHAOS;
        }

        return GameState.NOT_END;
    }

    public static void printAll(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

}