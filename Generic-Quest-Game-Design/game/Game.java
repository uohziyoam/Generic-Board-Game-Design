package game;

import java.util.HashSet;
import java.util.Random;

import avatar.Hero;
import board.Board;
import board.square.Coordinate;
import config.VARIABLES;

/**
 * Game
 */
public class Game {
    private static int MIN_MEMEBERS = 1;
    private static int MAX_MEMEBERS = 3;

    private Board board;

    private HashSet<Hero> warriors;

    private Hero captain;

    private boolean isQuit;

    public Game(Hero... heros) {
        warriors = new HashSet<>();

        for (Hero hero : heros) {
            warriors.add(hero);
        }

        Hero[] arrayNumbers = warriors.toArray(new Hero[warriors.size()]);
        Random random = new Random();
        int randomNumber = random.nextInt(warriors.size());
        captain = arrayNumbers[randomNumber];

        // init board
        board = new Board(8, 8);

        // init locaiton
        board.setPosition(captain, captain.getCurLocation(), null);
        board.printBoard();
    }

    public void move(String direction) {
        String formatDirection = direction.toUpperCase();
        Coordinate cCoordinate = captain.getCurLocation();
        try {
            if (formatDirection.equals(VARIABLES.UP)) {
                Coordinate tCoordinate = new Coordinate(cCoordinate.getX() - 1, cCoordinate.getY());
                board.setPosition(captain, tCoordinate, cCoordinate);
            }

            if (formatDirection.equals(VARIABLES.DOWN)) {
                Coordinate tCoordinate = new Coordinate(cCoordinate.getX() + 1, cCoordinate.getY());
                board.setPosition(captain, tCoordinate, cCoordinate);
            }

            if (formatDirection.equals(VARIABLES.LEFT)) {
                Coordinate tCoordinate = new Coordinate(cCoordinate.getX(), cCoordinate.getY() - 1);
                board.setPosition(captain, tCoordinate, cCoordinate);
            }

            if (formatDirection.equals(VARIABLES.RIGHT)) {
                Coordinate tCoordinate = new Coordinate(cCoordinate.getX(), cCoordinate.getY() + 1);
                board.setPosition(captain, tCoordinate, cCoordinate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        board.printBoard();
    }

    public void encounter() {

    }

    public void displayStatistics() {
        for (Hero hero : warriors) {
            hero.printStatistics();
            System.out.println("");
        }
    }

    public void displayInstruction() {

    }

}