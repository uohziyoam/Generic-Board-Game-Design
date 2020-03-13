package game_list.order_and_chaos;

import java.util.Scanner;
import game_list.tic_tac_toe.TicTacToe;
import generic_setting.*;
import constants.*;

public class OrderAndChaos extends TicTacToe {

    @Override
    public void GameStart(int row, int col) {
        super.GameStart(row, col);
    }

    @Override
    public void GameStart(int row, int col, Player[] teamA, Player[] teamB) {
        super.GameStart(row, col, teamA, teamB);
    }

    @Override
    public void gameProcessing(int row, int col) {
        this.Stop = false;
        while (!this.Stop) {
            OrderAndChaosBoard board = new OrderAndChaosBoard(row, col);
            currentTurn = teamA[0];
            in = new Scanner(System.in);

            this.printWelcome(board);

            while (!this.isEnd(board)) {
                this.printChoosePiece(currentTurn);
                String inputPieceString = this.printInvalidPiece();
                Piece piece = inputPieceString.equals("X") ? Piece.X : Piece.O;

                this.printChooseLocation(currentTurn);
                this.printInvalidLocation(board, piece, currentTurn);
                this.changeTurn();
            }

            if (board.checkStatus() == GameState.ORDER) {
                this.printVictoryMessage(teamA[0]);
                teamA[0].addWin();
                teamB[0].addLose();
            }

            if (board.checkStatus() == GameState.CHAOS) {
                this.printVictoryMessage(teamB[0]);
                teamB[0].addWin();
                teamA[0].addLose();
            }

            this.printPostGameInstruction(true);
            String stringInput = in.next();

            while (!stringInput.toUpperCase().equals(InputState.Y.toString())
                    && !stringInput.toUpperCase().equals(InputState.N.toString())) {
                this.printPostGameInstruction(false);
                stringInput = in.next();
            }

            if (stringInput.toUpperCase().equals(InputState.Y.toString())) {
                this.Stop = false;
            }

            if (stringInput.toUpperCase().equals(InputState.N.toString())) {
                Player[] listOfPlayers = new Player[] { teamA[0], teamB[0] };
                printGameSummary(listOfPlayers);
                this.Stop = true;
            }
        }
        GameMode mode = new GameMode();
        mode.chooseGame();
    }

    @Override
    public boolean isEnd(AbstractBoard board) {
        if (board.checkStatus() == GameState.NOT_END) {
            return false;
        }

        if (board.checkStatus().equals(GameState.CHAOS) || board.checkStatus().equals(GameState.ORDER)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean makeMove(AbstractBoard board, int index, Piece piece) {
        return super.makeMove(board, index, piece);
    }

    @Override
    public void changeTurn() {
        super.changeTurn();
    }

    @Override
    public void printWelcome(AbstractBoard board) {
        System.out.println("Welcome to Order and Chaos.");
        System.out.println("--------------------------------");
        board.printBoard();
        System.out.println("");
        System.out.println("Order will play first.");
    }

    public void printChoosePiece(Player currentPlayer) {
        System.out.println("");
        System.out
                .print("Player " + currentPlayer.getNickName() + " Enter the Piece you want to place (e.g. X or O): ");
    }

    public String printInvalidPiece() {
        in = new Scanner(System.in);
        String pieceString = in.next().toUpperCase();

        if (!pieceString.equals("X") && !pieceString.equals("O")) {
            System.out.println("");
            System.out.print("Invalid Input! Please try again! " + "Enter the Piece you want to place (e.g. X or O): ");
            return this.printInvalidPiece();
        }

        return pieceString;
    }

    @Override
    public void printChooseLocation(Player currentPlayer) {
        super.printChooseLocation(currentPlayer);
    }

    @Override
    public void printInvalidLocation(AbstractBoard board, Piece piece, Player currentPlayer) {
        super.printInvalidLocation(board, piece, currentPlayer);
    }

    @Override
    public void printPostGameInstruction(boolean validInput) {
        super.printPostGameInstruction(validInput);
    }

    @Override
    public void printVictoryMessage(Player player) {
        super.printVictoryMessage(player);
    }

    @Override
    public void printTieMessage() {
        super.printTieMessage();
    }

    @Override
    public void printGameSummary(Player[] players) {
        super.printGameSummary(players);
    }

}