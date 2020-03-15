package game;

import java.util.HashSet;

import avatar.Hero;
import board.Board;
import config.VARIABLES;

/**
 * Game
 */
public class Game {
    private static int MIN_MEMEBERS = 1;
    private static int MAX_MEMEBERS = 3;

    private Board board;

    private HashSet<Hero> warriors;

    private boolean isQuit;

    public Game(Hero... heros) {
        for (Hero hero : heros) {
            warriors.add(hero);
        }
    }

    public void move(String direction) {
        String formatDirection = direction.toUpperCase();
        if (formatDirection.equals(VARIABLES.UP)) {

        }

        if (formatDirection.equals(VARIABLES.DOWN)) {

        }

        if (formatDirection.equals(VARIABLES.LEFT)) {

        }

        if (formatDirection.equals(VARIABLES.RIGHT)) {

        }
    }

}