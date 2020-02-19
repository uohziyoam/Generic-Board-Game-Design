package game_list.tic_tac_toe;

import java.util.Scanner;
import constants.*;
import generic_setting.*;

public class TicTacToeGame implements GameRule {
    static Scanner in;
    static boolean Stop;
    Player playerA;
    Player playerB;
    Player currentTurn;

    public void GameStart(int row, int col) {
        playerA = new Player(Piece.X);
        playerB = new Player(Piece.O);

        Stop = false;

        while (!Stop) {
            TicTacToeBoard board = new TicTacToeBoard(row, col);
            currentTurn = playerA;
            in = new Scanner(System.in);

            this.printWelcome(board);

            while (!this.isEnd(board)) {
                int numInput;
                this.printChooseLocation(currentTurn.getPlayerSign());
                numInput = in.nextInt();
                this.makeMove(board, numInput, currentTurn);
                this.changeTurn();
            }

            if (board.checkStatus() == GameState.PLAYERA) {
                this.printVictoryMessage(playerA);
                playerA.addWin();
                playerB.addLose();
            }

            if (board.checkStatus() == GameState.PLAYERB) {
                this.printVictoryMessage(playerB);
                playerA.addWin();
                playerB.addLose();
            }

            if (board.checkStatus() == GameState.TIE) {
                this.printTieMessage();
                playerA.addTie();
                playerB.addTie();
            }

            this.printPostGameInstruction(true);
            String stringInput = in.next();

            while (!stringInput.equals(InputState.Y.toString()) && !stringInput.equals(InputState.N.toString())) {
                this.printPostGameInstruction(false);
                stringInput = in.next();
            }

            if (stringInput.equals(InputState.Y.toString())) {
                Stop = false;
            }

            if (stringInput.equals(InputState.N.toString())) {
                Player[] listOfPlayers = new Player[] { playerA, playerB };
                printGameSummary(listOfPlayers);
                Stop = true;
            }
        }
    }

    @Override
    public boolean isEnd(AbstractBoard board) {

        if (board.checkStatus() == GameState.NOT_END) {
            return false;
        }

        if (board.isFull()) {
            return true;
        }

        if (board.checkStatus().equals(GameState.PLAYERA) || board.checkStatus().equals(GameState.PLAYERB)) {
            return true;
        }

        if (board.checkStatus().equals(GameState.TIE)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean makeMove(AbstractBoard board, int index, Player player) {
        return board.set(index, player.getPlayerSign());
    }

    @Override
    public void changeTurn() {
        if (currentTurn == playerA) {
            currentTurn = playerB;
        } else {
            currentTurn = playerA;
        }
    }

    @Override
    public void printChooseLocation(Piece currentPlayer) {
        System.out.println("");
        System.out.print("Player " + currentPlayer + " Enter your move: ");
    }

    @Override
    public void printWelcome(AbstractBoard board) {
        System.out.println("Welcome to 2 Player Tic Tac Toe.");
        System.out.println("--------------------------------");
        board.printBoard();
        System.out.println("");
        System.out.println("X will play first.");
    }

    @Override
    public void printPostGameInstruction(boolean validInput) {
        System.out.println("");
        System.out.print(validInput ? "PLAY AGAIN? (Y/N) " : "INVALID INPUT; PLAY AGAIN? (Y/N) ");
    }

    @Override
    public void printVictoryMessage(Player player) {
        System.out.println("");
        System.out.println("Congragulations! " + player.getPlayerSign() + " won the game.");
        System.out.println("");

    }

    @Override
    public void printTieMessage() {
        System.out.println("");
        System.out.println("Oh! Tie Game. Do you wanna another game?");
        System.out.println("");
    }

    @Override
    public void printGameSummary(Player[] players) {
        System.out.println("                                     _=_");
        System.out.println("                                   q(-_-)p");
        System.out.println("                                   '_) (_`");
        System.out.println("                                   /__/  \\");
        System.out.println("                                 _(<_   / )");
        System.out.println("                                (__\\_\\_|_/__)");
        System.out.println("                                (__\\_\\_|_/__)");

        System.out.println("  ______ _        _  _            _       __        ______ __    _  __  __       __ ");
        System.out.println(" (   /  /_|(__/  / )/_| /  /|/|  /_| /| )/  )  /__/(_ (_  /__)  / )/  )/  )//| )/ _ ");
        System.out.println("__) (  (  | /   (__(  |(__/   | (  |/ |//(_/  /  ) /__/__/     (__(__//(_/(/ |/(__) ");

        System.out.println("====================================================================================");
        System.out.println(".------------------------.-------------------.------------------.------------------.");
        System.out.println("|        ########        |        WIN        |       LOSE       |        TIE       |");
        System.out.println(":------------------------+-------------------+------------------+------------------:");

        for (int i = 0; i < players.length; i++) {
            System.out.println("|        " + players[i].getNickName() + "        |         " + players[i].getWin()
                    + "         |         " + players[i].getLose() + "        |         " + players[i].getTie()
                    + "        |");
            System.out.println(":------------------------+-------------------+------------------+------------------:");
        }
    }

}