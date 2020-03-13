package generic_setting;

import java.util.Scanner;

import coordinate.*;
import game_list.tic_tac_toe.*;
import game_list.order_and_chaos.*;
import constants.*;

public class GameMode {

    static Scanner in;

    public void chooseGame() {
        this.gameList();
        in = new Scanner(System.in);
        Coordinate coor;
        int numInput = in.nextInt();
        Player[] teamA;
        Player[] teamB;
        switch (numInput) {
            case 1:
                GameRule ticTacToe = new TicTacToe();
                coor = this.getBoardSize();
                teamA = new Player[] { new Player(Piece.X, this.getUserName()) };
                teamB = new Player[] { new Player(Piece.O, this.getUserName()) };
                ticTacToe.GameStart(coor.row, coor.col, teamA, teamB);
                break;
            case 2:
                GameRule orderAndChaos = new OrderAndChaos();
                this.orderAndChaosInstruction();
                teamA = new Player[] { new Player(Piece.X, this.getUserName()) };
                teamB = new Player[] { new Player(Piece.O, this.getUserName()) };
                orderAndChaos.GameStart(6, 6, teamA, teamB);
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    // private int chooseTeamOrIndividual() {
    // System.out.println("Enter the number of players: e.g. 2");
    // int numInput = in.nextInt();
    // return numInput;
    // }

    private void orderAndChaosInstruction() {
        System.out.println(
                "The implementation of the game of order and chaos should only allow for play on a 6x6 board, following the original specifed winning rules.");
        System.out.println(
                "The game starts with the board empty. Order plays first, then turns alternate. On each turn, a player places either an X or an O on any open square. Once played, pieces cannot be moved, thus Order and Chaos can be played using pencil and paper.");
    }

    private Coordinate getBoardSize() {
        System.out.println("Enter the size of the board: e.g. 3x3");
        String input = in.next();
        String[] strings = input.split("x");
        int x = 3;
        int y = 3;
        try {
            x = Integer.parseInt(strings[0]);
            y = Integer.parseInt(strings[1]);
        } catch (Exception e) {
            this.getBoardSize();
        }

        Coordinate coor = new Coordinate(x, y);

        return coor;
    }

    private String getUserName() {
        System.out.println("Enter your desired nick name: e.g. Mike");
        String input = in.next();
        return input;
    }

    private void gameList() {
        System.out.println("1. Simple NxN Tic Tac Toe");
        System.out.println("2. Order and Chaos");
        System.out.println("3. Stay tuned ......");
        System.out.println("4. EXIT");
        System.out.println("Enter 1~9 to choose the game from the list: ");
    }
}