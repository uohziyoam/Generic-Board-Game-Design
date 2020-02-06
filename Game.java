import java.util.*;

public class Game {
    static Scanner in;
    final static String O = "O";
    final static String X = "X";
    final static String DRAW = "DRAW";

    final static String YES = "Y";
    final static String NO = "N";

    public static void main(String[] args) {
        Player playerX = new Player(X);
        Player playerO = new Player(O);

        while (true) {
            Board board = new Board();
            Player currentmove = playerX;
            in = new Scanner(System.in);

            System.out.println("Welcome to 2 Player Tic Tac Toe.");
            System.out.println("--------------------------------");
            board.printBoard();
            System.out.println("");
            System.out.println("X will play first.");

            while (board.checkWinner() == null) {
                int numInput;
                System.out.println("");
                System.out.print("Player " + currentmove.getPlayer() + " Enter your move: ");
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
                playerO.win();
                playerX.lose();
            }

            if (board.checkWinner().equals(X)) { 
                victoryMessage(playerX);
                playerX.win();
                playerO.lose();
            }

            if (board.checkWinner().equals(DRAW)) {
                drawMessage(playerX);
                playerX.draw();
                playerO.draw();
            }

            System.out.println("");
            System.out.print("PLAY AGAIN? (Y/N) ");
            String stringInput = in.next();

            while (!stringInput.equals(YES) && !stringInput.equals(NO)) {
                System.out.println("");
                System.out.print("INVALID INPUT; PLAY AGAIN? (Y/N) ");
                stringInput = in.next();
            }

            if (stringInput.equals(YES)) {
                continue;
            }

            if (stringInput.equals(NO)) {
                printSummary(playerX, playerO);
                break;
            }

        }

    }

    public static void victoryMessage(Player player) {
        System.out.println("");
        System.out.println("Congragulations! " + player.getPlayer() + " won the game.");
        System.out.println("");
    }

    public static void drawMessage(Player player) {
        System.out.println("");
        System.out.println("Oh! Tie Game. Do you wanna another game?");
        System.out.println("");
    }

    public static void printSummary(Player playerX, Player playerO) {
    
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
        System.out.println("|        ########        |        WIN        |       LOSE       |       DRAW       |");
        System.out.println(":------------------------+-------------------+------------------+------------------:");
        System.out.println("|        PLAYER X        |         " + playerX.getWin() + "         |         " + playerX.getLose() + "        |         " + playerX.getDraw() + "        |");
        System.out.println(":------------------------+-------------------+------------------+------------------:");
        System.out.println("|        PLAYER O        |         " + playerO.getWin() + "         |         " + playerO.getLose() + "        |         " + playerO.getDraw() + "        |");
        System.out.println("'------------------------'-------------------'------------------'------------------'");

    }

}