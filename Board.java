class Coordinate {
    public int x;
    public int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Board {
    private int row;
    private int column;
    private Player[][] board;

    /**
     * +--+--+--+ |1 |2 |3 | +--+--+--+ |4 |5 |6 | +--+--+--+ |7 |8 |9 | +--+--+--+
     */

    private Coordinate[] INT_TO_COORDINATE = { new Coordinate(0, 0), // 1
            new Coordinate(0, 1), // 2
            new Coordinate(0, 2), // 3
            new Coordinate(1, 0), // 4
            new Coordinate(1, 1), // 5
            new Coordinate(1, 2), // 6
            new Coordinate(2, 0), // 7
            new Coordinate(2, 1), // 8
            new Coordinate(2, 2), // 9
    };

    Board(int row, int column) {
        this.row = row;
        this.column = column;
        this.board = new Player[row][column];
    }

    public Player[][] setState(int index, Player state) {
        if (index < 0 || index > 9) {
            return this.board;
        }

        Coordinate coor = INT_TO_COORDINATE[index];

        this.board[coor.x][coor.y] = state;

        return this.board;
    }

    public boolean isFree(int index) {
        if (index < 0 || index > 9) {
            return false;
        }

        Coordinate coor = INT_TO_COORDINATE[index];

        if (this.board[coor.x][coor.y] != null) {
            return false;
        }

        return true;
    }

    public char getState(int index) {
        if (index < 0 || index > 9) {
            throw new NullPointerException("INVALID INDEX!");
        }

        Coordinate coor = INT_TO_COORDINATE[index - 1];

        if (this.board[coor.x][coor.y] == null) {
            return ' ';
        }

        return this.board[coor.x][coor.y].getPlayer();
    }

    public boolean isNotFull() {
        for (Player[] players : this.board) {
            for (Player player : players) {
                if (player == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("+-+-+-+");
        System.out.println("|" + this.getState(1) + "|" + this.getState(2) + "|" + this.getState(3) + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + this.getState(4) + "|" + this.getState(5) + "|" + this.getState(6) + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + this.getState(7) + "|" + this.getState(8) + "|" + this.getState(9) + "|");
        System.out.println("+-+-+-+");
    }
}
