package board;

import market.*;

public class Square {
    private Coordinate coordinate;
    public boolean accessible;

    public Square(int x, int y, boolean accessible) {
        this.accessible = accessible;
        this.coordinate = this.initCoordinate(x, y);
    }

    private Coordinate initCoordinate(int x, int y) {
        return new Coordinate(x, y);
    }

    public boolean hasMonster() {
        return Math.random() < 0.3;
    }

    public boolean getAccessible() {
        return accessible;
    }
}