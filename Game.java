import java.util.*;

public class Game {
    static Scanner in;
    final static String O = "O";
    final static String X = "X";
    final static String DRAW = "DRAW";

    final static String YES = "Y";
    final static String NO = "N";

    public static void main(String[] args) {
        Player playerX = new Player(X, "x");
        Player playerO = new Player(O, "o");

        while (true) {
            Board board = new Board();
            Player currentmove = playerX;
            in = new Scanner(System.in);

            System.out.println("Welcome to 2 Player Tic Tac Toe.");
            System.out.println("--------------------------------");
            board.printBoard();
            System.out.println("X's will play first.");

            while (board.checkWinner() == null) {
                int numInput;
                System.out.print("Player " + currentmove.getName() + " Enter your move: ");
                numInput = in.nextInt();

                if (board.move(numInput, currentmove.getPlayer())) {
                    if (currentmove.getPlayer().equals(X)) {
                        currentmove = playerO;
                    } else {
                        currentmove = playerX;
                    }
                }
            }

            
            if (board.checkWinner().equals(O)) { 
                victoryMessage(playerO);
            }

            if (board.checkWinner().equals(X)) { 
                victoryMessage(playerX);
            }

            if (board.checkWinner().equals(DRAW)) {
                drawMessage(playerX);
                
            }

            System.out.print("PLAY AGAIN? (Y/N)");
            String stringInput = in.next();

            while (!stringInput.equals(YES) && !stringInput.equals(NO)) {
                System.out.print("INVALID INPUT; PLAY AGAIN? (Y/N)");
                stringInput = in.next();
            }

            if (stringInput.equals(YES)) {
                continue;
            }

            if (stringInput.equals(NO)) {
                break;
            }

        }

    }

    public static void victoryMessage(Player player) {
        System.out.println("Congragulations! " + player.getPlayer() + " won the game.");
    }

    public static void drawMessage(Player player) {
        System.out.println("Oh! Tie Game. Do you wanna another game?");
    }

    public static void printSummary(Player player) {
        System.out.println("");
    }

}