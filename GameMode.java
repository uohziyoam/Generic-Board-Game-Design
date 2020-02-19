import generic_setting.*;
import java.util.Scanner;
import game_list.tic_tac_toe.*;
import game_list.order_and_chaos.*;

public class GameMode {

    static Scanner in;

    public void chooseGameMode() {
        this.gameList();
        in = new Scanner(System.in);

        int numInput = in.nextInt();
        switch (numInput) {
            case 1:
                GameRule ticTacToe = new TicTacToeGame();
                ticTacToe.GameStart(3, 3);
                break;
            case 2:
                GameRule orderAndChaos = new OrderAndChaos();
                orderAndChaos.GameStart(3, 3);
                break;
            case 3:
                break;
            default:
                break;
        }

        GameRule defaultGame = new TicTacToeGame();
    }

    private void gameList() {
        System.out.println("1. Simple NxN Tic Tac Toe");
        System.out.println("2. Order and Chaos");
    }
}