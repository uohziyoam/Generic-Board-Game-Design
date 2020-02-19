


public abstract class AbstractBoard {
    protected Cell[][] board;
    protected int row;
    protected int col;
    protected IndexMap indexMap;

    AbstractBoard(int row, int col) {
        System.out.println("AbstractBoard: 8");
        this.row = row;
        this.col = col;
        this.board = new Cell[row][col];
        this.indexMap = new IndexMap(row, col);
    }

    /**
     * @param index element whose presence in this board is to be tested
     * @return <tt>true</tt> if current position is empty.
     */
    public boolean isEmpty(int index) {
        if (index <= 0 || index > row * col) {
            throw new NullPointerException("INVALID INDEX!");
        }

        Coordinate coordinate = indexMap.get(index);
        return this.board[coordinate.row][coordinate.col].isEmpty();
    };

    /**
     * @param index element whose presence in this board is to be tested
     * @return the Cell at position index.
     */
    public Cell get(int index) {
        if (index <= 0 || index > row * col) {
            throw new NullPointerException("INVALID INDEX!");
        }

        Coordinate coordinate = indexMap.get(index);
        // indexMap.print();

        return this.board[coordinate.row][coordinate.col];
    };

    /**
     * @param index element whose presence in this board is to be tested
     * @param piece indicates which type of piece.
     * @return change state the Cell at position index.
     */
    public boolean set(int index, Piece piece) {
        if (index <= 0 || index > row * col) {
            System.out.println("");
            System.out.println("Invalid input; re-enter slot number:");
            return false;
        }

        System.out.println(index);
        System.out.println(piece);

        Cell cell = new Cell(piece);
        if (this.isEmpty(index)) {
            Coordinate coordinate = indexMap.get(index);
            this.board[coordinate.row][coordinate.col] = cell;
        } else {
            System.out.println("");
            System.out.println("Slot already taken; re-enter slot number:");
            return false;
        }

        // for (Cell[] cells : board) {
        // for (Cell cella : cells) {
        // System.out.println(cella.getState());
        // }
        // }

        this.printBoard();
        return true;
    };

    /**
     * @return <tt>true</tt> if the game board is full.
     */
    public boolean isFull() {
        for (Cell[] players : this.board) {
            for (Cell player : players) {
                if (player.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    };

    /**
     * @return corresponding GameState depends on the status of the game.
     */
    public abstract GameState checkStatus();

    /**
     * this function prints the borad.
     */
    public void printBoard() {
        for (int i = 0; i < row; i++) {
            String seprator = "";
            String boardLine = "";
            for (int j = 0; j < col; j++) {
                seprator += "+------";
            }

            seprator += "+";
            System.out.println(seprator);

            for (int k = 0; k < col; k++) {
                Piece currentPiece = this.get(col * i + k + 1).getState();
                String currentPos = currentPiece == null ? "" + (col * i + k + 1) : currentPiece.toString();

                boardLine += "|" + emptyStringGenerator(6 - currentPos.length());
                // System.out.println("this.get(i + j + 1): " + (col * i + k + 1));

                boardLine += currentPos;
            }
            boardLine += "|";
            System.out.println(boardLine);

            if (i == row - 1) {
                System.out.println(seprator);
            }
        }
    };

    static String emptyStringGenerator(int n) {
        String str = "";

        for (int i = 0; i < n; i++) {
            str += " ";
        }

        return str;
    }
}