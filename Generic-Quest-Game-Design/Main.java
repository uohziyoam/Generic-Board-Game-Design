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
        Game game = new Game();
        game.gameProcessing();
    }
}