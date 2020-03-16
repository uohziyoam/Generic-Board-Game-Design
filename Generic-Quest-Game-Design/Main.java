import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import avatar.Hero;
import avatar.Monster;
import board.*;
import board.square.Coordinate;
import board.square.Market;
import board.square.Obstacle;
import config.*;
import equipment.*;
import game.Game;

public class Main {

    public static void main(String[] args) {
        // Board b = new Board(8, 8);
        // b.printBoard();
        // Hero hero = new Hero("null", new Coordinate(1, 2));
        // Hero hero2 = new Hero("null", new Coordinate(1, 2));
        // Market market = new Market();
        // hero.buy("Healing_Potion", market);
        // hero.buy("Healing_Potion", market);
        // hero.buy("Healing_Potion", market);
        // hero.buy("Healing_Potion", market);
        // hero.buy("Healing_Potion", market);
        // hero2.buy("Healing_Potion", market);
        // hero2.buy("Healing_Potion", market);
        // hero2.buy("Healing_Potion", market);

        // Game game = new Game(hero, hero2);
        // hero.printStatistics();

        // game.displayStatistics();

        Monster monster = new Monster("BunsenBurner");
        Hero hero = new Hero("Muamman_Duathall", null);
        monster.printStatistics();
        hero.printStatistics();

        // game.move("d");
        // game.move("s");
        // game.move("w");
        // game.move("a");

        // market.sellEquipment(Weapons.Axe);

        // System.out.println(Color.ANSI_RED + "This text is red!" + Color.ANSI_RESET);
        // System.out.println(
        // Color.ANSI_GREEN_BACKGROUND + "This text has a green background but default
        // text!" + Color.ANSI_RESET);
        // System.out.println(Color.ANSI_RED + "This text has red text but a default
        // background!" + Color.ANSI_RESET);
        // System.out.println(Color.ANSI_GREEN_BACKGROUND + Color.ANSI_RED
        // + "This text has a green background and red text!" + Color.ANSI_RESET);
    }
}