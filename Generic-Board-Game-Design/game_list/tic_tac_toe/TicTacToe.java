package game_list.tic_tac_toe;

import java.util.Scanner;
import constants.*;
import generic_setting.*;

public class TicTacToe implements GameRule {
    protected static Scanner in;
    protected boolean Stop;
    protected Player[] teamA;
    protected Player[] teamB;
    protected Player currentTurn;

    public void GameStart(int row, int col, Player[] teamA, Player[] teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.gameProcessing(row, col);
    }

    public void GameStart(int row, int col) {
        this.teamA = new Player[] { new Player(Piece.X) };
        this.teamB = new Player[] { new Player(Piece.O) };
        this.gameProcessing(row, col);
    }

    @Override
    public void gameProcessing(int row, int col) {
        this.Stop = false;
        while (!this.Stop) {
            TicTacToeBoard board = new TicTacToeBoard(row, col);
            currentTurn = teamA[0];
            in = new Scanner(System.in);

            this.printWelcome(board);

            while (!this.isEnd(board)) {
                this.printChooseLocation(currentTurn);
                this.printInvalidLocation(board, currentTurn.getPlayerSign(), currentTurn);
                this.changeTurn();
            }

            if (board.checkStatus() == GameState.PLAYERA) {
                this.printVictoryMessage(teamA[0]);
                teamA[0].addWin();
                teamB[0].addLose();
            }

            if (board.checkStatus() == GameState.PLAYERB) {
                this.printVictoryMessage(teamB[0]);
                teamA[0].addWin();
                teamB[0].addLose();
            }

            if (board.checkStatus() == GameState.TIE) {
                this.printTieMessage();
                teamA[0].addTie();
                teamB[0].addTie();
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
    public boolean makeMove(AbstractBoard board, int index, Piece sign) {
        return board.set(index, sign);
    }

    @Override
    public void changeTurn() {
        if (currentTurn == teamA[0]) {
            currentTurn = teamB[0];
        } else {
            currentTurn = teamA[0];
        }
    }

    @Override
    public void printChooseLocation(Player currentPlayer) {
        System.out.println("");
        System.out.print("Player " + currentPlayer.getNickName() + " Enter your move: ");
    }

    @Override
    public void printInvalidLocation(AbstractBoard board, Piece piece, Player currentPlayer) {
        in = new Scanner(System.in);
        int numInput = in.nextInt();

        boolean success = this.makeMove(board, numInput, piece);

        if (!success) {
            this.printChooseLocation(currentPlayer);
            this.printInvalidLocation(board, piece, currentPlayer);
        }
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
        System.out.println("Congragulations! " + player.getNickName() + " won the game.");
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
            System.out.println("|        " + AbstractBoard.emptyStringGenerator(8 - players[i].getNickName().length())
                    + players[i].getNickName() + "        |         " + players[i].getWin() + "         |         "
                    + players[i].getLose() + "        |         " + players[i].getTie() + "        |");
            System.out.println(":------------------------+-------------------+------------------+------------------:");
        }
    }

}