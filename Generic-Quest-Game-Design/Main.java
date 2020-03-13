import board.*;
import config.*;

public class Main {

    public static void main(String[] args) {
        // Board b = new Board(10, 10);

        System.out.println(Color.ANSI_RED + "This text is red!" + Color.ANSI_RESET);
        System.out.println(
                Color.ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_RED + "This text has red text but a default background!" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN_BACKGROUND + Color.ANSI_RED
                + "This text has a green background and red text!" + Color.ANSI_RESET);
    }
}