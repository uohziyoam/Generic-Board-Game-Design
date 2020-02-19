package generic_setting;

import constants.*;

public class Player {
    private String nickName;
    private Piece playerSign;
    private int numOfWin;
    private int numOfLose;
    private int numOfTie;

    public Player(Piece playerSign) {
        this.nickName = " default";
        this.playerSign = playerSign;
    }

    /**
     * @return The sign of the current player. e.g. X, O, King, Rook, Bishop.
     */
    public Piece getPlayerSign() {
        return this.playerSign;
    }

    /**
     * @return The nick name of current user.
     */
    public String getNickName() {
        return this.nickName;
    }

    /**
     * @return The number of rounds that the current player has won.
     */
    public int getWin() {
        return this.numOfWin;
    }

    /**
     * @return The number of rounds that the current player has lost.
     */
    public int getLose() {
        return this.numOfLose;
    }

    /**
     * @return The number of rounds that the current player has tied.
     */
    public int getTie() {
        return this.numOfTie;
    }

    /**
     * Increment number of wins if the current player has won the current round.
     * 
     * @return The number of rounds that the current player has won.
     */
    public int addWin() {
        return this.numOfWin += 1;
    }

    /**
     * Increment number of loss if the current player has lost the current round.
     * 
     * @return The number of rounds that the current player has lost.
     */
    public int addLose() {
        return this.numOfLose += 1;
    }

    /**
     * Increment number of ties if the current player has tied the current round.
     * 
     * @return The number of rounds that the current player has tied.
     */
    public int addTie() {
        return this.numOfTie += 1;
    }
}