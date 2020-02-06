import java.util.*;

class Coordinate {
    public int x;
    public int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Board {
    private String[][] board; 

    /**
     * +--+--+--+ 
     * |1 |2 |3 | 
     * +--+--+--+ 
     * |4 |5 |6 | 
     * +--+--+--+ 
     * |7 |8 |9 |
     * +--+--+--+
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

    Board() {
        this.board = new String[3][3];
        this.initBoard();
    }

    public void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = Integer.toString(i * 3 + j + 1);
            }
        }
    }

    public boolean move(int index, String player) {
        try {
            if (!(index > 0 && index <= 9)) {
                System.out.println("Invalid input; re-enter slot number:");
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input; re-enter slot number:");
            return false;
        }
        
        if (this.isSlotFree(index)) {
            Coordinate coor = INT_TO_COORDINATE[index - 1];
            this.board[coor.x][coor.y] = player;
        } else {
            System.out.println("Slot already taken; re-enter slot number:");
            return false;
        }

        this.printBoard();

        return true;
    }

    public boolean isSlotFree(int index) {
        if (index < 0 || index > 9) {
            return false;
        }
        if (!this.getPlayer(index).equals(Integer.toString(index))) {
            return false;
        }

        return true;
    }

    public String getPlayer(int index) {
        if (index < 0 || index > 9) {
            throw new NullPointerException("INVALID INDEX!");
        }

        Coordinate coor = INT_TO_COORDINATE[index - 1];

        if (this.board[coor.x][coor.y] == null) {
            return Integer.toString(index);
        }

        return this.board[coor.x][coor.y];
    }

    public boolean isFull() {
        for (String[] players : this.board) {
            for (String player : players) {
                if (player == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEnd(Player playerX, Player playerO) {
        if (this.checkWinner() == null) {
            return false;
        }

        if (this.isFull()) {
            return true;
        }

        if (this.checkWinner().equals("X") || this.checkWinner().equals("O")) {
            return true;
        }

        if (this.checkWinner().equals("draw")) {
            return true;
        }

        return false;
    }

    public String checkWinner () {
        for (int a = 0; a < 8; a++) {
            String line = null;
            
			switch (a) {
			case 0:
				line = this.getPlayer(1) + this.getPlayer(2) + this.getPlayer(3);
				break;
			case 1:
				line = this.getPlayer(4) + this.getPlayer(5) + this.getPlayer(6);
				break;
			case 2:
				line = this.getPlayer(7) + this.getPlayer(8) + this.getPlayer(9);
				break;
			case 3:
				line = this.getPlayer(1) + this.getPlayer(4) + this.getPlayer(7);
				break;
			case 4:
				line = this.getPlayer(2) + this.getPlayer(5) + this.getPlayer(8);
				break;
			case 5:
				line = this.getPlayer(3) + this.getPlayer(6) + this.getPlayer(9);
				break;
			case 6:
				line = this.getPlayer(1) + this.getPlayer(5) + this.getPlayer(9);
				break;
			case 7:
				line = this.getPlayer(3) + this.getPlayer(5) + this.getPlayer(7);
				break;
            }
            
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
        }
        
        for (int i = 1; i <= 9; i++) {
            if (this.getPlayer(i).equals(Integer.toString(i))) {
                break;
            } else if (i == 9) {
                return "DRAW";
            }
		}

        return null;
    }

    public void printBoard() {
        System.out.println("+---+---+---+");
        System.out.println("| " + this.getPlayer(1) + " | " + this.getPlayer(2) + " | " + this.getPlayer(3) + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + this.getPlayer(4) + " | " + this.getPlayer(5) + " | " + this.getPlayer(6) + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + this.getPlayer(7) + " | " + this.getPlayer(8) + " | " + this.getPlayer(9) + " |");
        System.out.println("+---+---+---+");
    }
}
