import java.util.Scanner;

public class GameMode {

    static Scanner in;

    public void chooseGameMode() {
        this.gameList();
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