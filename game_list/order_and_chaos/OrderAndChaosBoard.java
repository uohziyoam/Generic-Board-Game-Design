package game_list.order_and_chaos;

import constants.GameState;
import game_list.tic_tac_toe.TicTacToeBoard;

public class OrderAndChaosBoard extends TicTacToeBoard {

    OrderAndChaosBoard(int row, int col) {
        super(row, col);
    }

    @Override
    public GameState checkStatus() {
        // printAll(diagPlayerA);
        // printAll(antiDiagPlayerA);
        // printAll(rowPlayerA);
        // printAll(colPlayerA);
        // printAll(diagPlayerB);
        // printAll(antiDiagPlayerB);
        // printAll(rowPlayerB);
        // printAll(colPlayerB);
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