package game_list.order_and_chaos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import constants.GameState;
import constants.Piece;
import coordinate.Coordinate;
import game_list.tic_tac_toe.TicTacToeBoard;

public class OrderAndChaosBoard extends TicTacToeBoard {
    protected int[] lowerDiagPlayerA;
    protected int[] upperDiagPlayerA;
    protected int[] upperAntiDiagPlayerA;
    protected int[] lowerAntiDiagPlayerA;

    protected int[] upperDiagPlayerB;
    protected int[] upperAntiDiagPlayerB;
    protected int[] lowerDiagPlayerB;
    protected int[] lowerAntiDiagPlayerB;

    OrderAndChaosBoard(int row, int col) {
        super(row, col);

        this.lowerDiagPlayerA = new int[row];
        this.upperDiagPlayerA = new int[row];

        this.upperAntiDiagPlayerA = new int[row];
        this.lowerAntiDiagPlayerA = new int[row];

        this.upperDiagPlayerB = new int[row];
        this.upperAntiDiagPlayerB = new int[row];

        this.lowerDiagPlayerB = new int[row];
        this.lowerAntiDiagPlayerB = new int[row];
    }

    @Override
    public boolean set(int index, Piece piece) {
        return super.set(index, piece);
    }

    // TODO: NEED TO REDO THE CHECKING ALGORITHM FOR ORDER AND CHAOS
    @Override
    public void movePlayerA(int index, Piece piece) {
        if (index <= 0 || index > row * col) {
            return;
        }

        Coordinate coordinate = indexMap.get(index);
        if (this.checkIsLegalLine("ROW", coordinate, piece)) {
            rowPlayerA[coordinate.row]++;
        }

        if (this.checkIsLegalLine("COLUMN", coordinate, piece)) {
            colPlayerA[coordinate.col]++;
        }

        if (coordinate.row - 1 == coordinate.col) {
            if (this.checkIsLegalLine("DIAGONAL", coordinate, piece)) {
                lowerDiagPlayerA[coordinate.row]++;
            }
        }

        if (coordinate.row == coordinate.col) {
            diagPlayerA[0] = this.checkLongestPath(coordinate, true);
            // System.out.println("diagPlayerA" + diagPlayerA[0]);
        }

        if (coordinate.row == coordinate.col - 1) {
            if (this.checkIsLegalLine("DIAGONAL", coordinate, piece)) {
                upperDiagPlayerA[coordinate.row]++;
            }
        }

        if (coordinate.row + coordinate.col == 4) {
            if (this.checkIsLegalLine("ANTIDIAGONAL", coordinate, piece)) {
                lowerDiagPlayerA[coordinate.row]++;
            }
        }

        if (coordinate.row + coordinate.col == 5) {
            antiDiagPlayerA[0] = this.checkLongestPath(coordinate, false);
            // System.out.println("antiDiagPlayerA" + antiDiagPlayerA[0]);
        }

        if (coordinate.row + coordinate.col == 6) {
            if (this.checkIsLegalLine("ANTIDIAGONAL", coordinate, piece)) {
                upperAntiDiagPlayerA[coordinate.row]++;
            }
        }
    }

    // TODO: NEED TO REDO THE CHECKING ALGORITHM FOR ORDER AND CHAOS
    @Override
    public void movePlayerB(int index, Piece piece) {
        if (index <= 0 || index > row * col) {
            return;
        }

        Coordinate coordinate = indexMap.get(index);
        if (this.checkIsLegalLine("ROW", coordinate, piece)) {
            rowPlayerB[coordinate.row]++;
        }

        if (this.checkIsLegalLine("COLUMN", coordinate, piece)) {
            colPlayerB[coordinate.col]++;
        }

        if (coordinate.row - 1 == coordinate.col) {
            if (this.checkIsLegalLine("DIAGONAL", coordinate, piece)) {
                lowerDiagPlayerB[coordinate.row]++;
            }
        }

        if (coordinate.row == coordinate.col) {
            diagPlayerB[0] = this.checkLongestPath(coordinate, true);
            // System.out.println("diagPlayerB" + diagPlayerB[0]);
        }

        if (coordinate.row == coordinate.col - 1) {
            if (this.checkIsLegalLine("DIAGONAL", coordinate, piece)) {
                upperDiagPlayerB[coordinate.row]++;
            }
        }

        if (coordinate.row + coordinate.col == 4) {
            if (this.checkIsLegalLine("ANTIDIAGONAL", coordinate, piece)) {
                lowerDiagPlayerB[coordinate.row]++;
            }
        }

        if (coordinate.row + coordinate.col == 5) {
            antiDiagPlayerB[0] = this.checkLongestPath(coordinate, false);
            // System.out.println("antiDiagPlayerB" + antiDiagPlayerB[0]);
        }

        if (coordinate.row + coordinate.col == 6) {
            if (this.checkIsLegalLine("ANTIDIAGONAL", coordinate, piece)) {
                upperAntiDiagPlayerB[coordinate.row]++;
            }
        }
    }

    private boolean checkIsLegalLine(String direction, Coordinate coordinate, Piece piece) {
        switch (direction) {
            case "ROW":
                for (int i = 1; i < board.length - 1; i++) {
                    Piece curPiece = board[coordinate.row][i].getState();
                    if (curPiece != null && piece != curPiece) {
                        return false;
                    }
                }
                break;
            case "COLUMN":
                for (int i = 1; i < board.length - 1; i++) {
                    Piece curPiece = board[i][coordinate.col].getState();
                    if (curPiece != null && piece != curPiece) {
                        return false;
                    }
                }
                break;
            case "DIAGONAL":

                if (coordinate.row == coordinate.col + 1) {
                    for (int i = 0; i < board.length - 1; i++) {
                        Piece curPiece = board[i][i + 1].getState();
                        if (curPiece != null && piece != curPiece) {
                            return false;
                        }
                    }
                }

                if (coordinate.row + 1 == coordinate.col) {
                    for (int i = 0; i < board.length - 1; i++) {
                        Piece curPiece = board[i + 1][i].getState();
                        if (curPiece != null && piece != curPiece) {
                            return false;
                        }
                    }
                }

                break;
            case "ANTIDIAGONAL":
                for (int i = 1; i < board.length - 1; i++) {
                    Piece curPiece = board[coordinate.row + coordinate.col - i][i].getState();
                    if (curPiece != null && piece != curPiece) {
                        return false;
                    }
                }
                break;
            default:
                break;
        }

        return true;
    }

    private boolean hasVisited(Coordinate coordinate, HashSet<Coordinate> set) {
        for (Coordinate visited : set) {
            if (coordinate.row == visited.row && coordinate.col == visited.col) {
                return true;
            }
        }
        return false;
    }

    public int checkLongestPath(Coordinate start, boolean isDiag) {
        int longestPath = 0;
        HashSet<Coordinate> set = new HashSet<>();
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Coordinate curNode = q.poll();
            set.add(curNode);
            if (board[curNode.row][curNode.col].getState() != board[start.row][start.col].getState()
                    && board[curNode.row][curNode.col].getState() != null) {
                break;
            }

            longestPath++;

            Coordinate upperNeighbor;
            Coordinate lowerNeighbor;

            if (isDiag) {
                upperNeighbor = new Coordinate(curNode.row - 1, curNode.col - 1);
                lowerNeighbor = new Coordinate(curNode.row + 1, curNode.col + 1);
            } else {
                upperNeighbor = new Coordinate(curNode.row - 1, curNode.col + 1);
                lowerNeighbor = new Coordinate(curNode.row + 1, curNode.col - 1);
            }

            if (this.isInMap(upperNeighbor) && !this.hasVisited(upperNeighbor, set)) {
                q.offer(upperNeighbor);
            }

            if (this.isInMap(lowerNeighbor) && !this.hasVisited(lowerNeighbor, set)) {
                q.offer(lowerNeighbor);
            }
        }

        return longestPath;
    }

    public boolean isInMap(Coordinate coordinate) {
        if (coordinate.row < 0) {
            return false;
        }

        if (coordinate.col < 0) {
            return false;
        }

        if (coordinate.row >= board.length) {
            return false;
        }

        if (coordinate.col >= board.length) {
            return false;
        }

        if (board[coordinate.row][coordinate.col].getState() == null) {
            return false;
        }

        return true;
    }

    @Override
    public GameState checkStatus() {
        if (diagPlayerA[0] >= 5 || diagPlayerB[0] >= 5) {
            return GameState.ORDER;
        }

        if (antiDiagPlayerA[0] >= 5 || antiDiagPlayerB[0] >= 5) {
            return GameState.ORDER;
        }

        if (sum(lowerDiagPlayerA) == 5 || sum(upperDiagPlayerA) == 5 || sum(lowerAntiDiagPlayerA) == 5
                || sum(upperAntiDiagPlayerA) == 5) {
            return GameState.ORDER;
        }

        if (sum(lowerDiagPlayerB) == 5 || sum(upperDiagPlayerB) == 5 || sum(lowerAntiDiagPlayerB) == 5
                || sum(upperAntiDiagPlayerB) == 5) {
            return GameState.ORDER;
        }

        for (int i = 0; i < antiDiagPlayerA.length; i++) {
            if (rowPlayerA[i] == 5 || colPlayerA[i] == 5) {
                return GameState.ORDER;
            }
            if (rowPlayerB[i] == 5 || colPlayerB[i] == 5) {
                return GameState.ORDER;
            }
        }

        if (this.isFull()) {
            return GameState.CHAOS;
        }

        return GameState.NOT_END;
    }

    public static void printAll(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

}