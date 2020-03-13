package generic_setting;

import constants.*;

public abstract interface GameRule {

    /**
     * It executes the whole game.
     */
    public void GameStart(int row, int col);

    /**
     * It executes the whole game.
     */
    public void GameStart(int row, int col, Player[] teamA, Player[] teamB);

    /**
     * It processes the logic of the game.
     */
    public void gameProcessing(int row, int col);

    /**
     * @return <tt>true</tt> if the game is over.
     */
    public boolean isEnd(AbstractBoard board);

    /**
     * @param index  element whose presence in this board is to be tested
     * @param player current player.
     * @return <tt>true</tt> if this move is valid.
     */
    boolean makeMove(AbstractBoard board, int index, Piece sign);

    /**
     * It exchanges the turn of current game.
     */
    void changeTurn();

    /**
     * It prints the welcome message to the user.
     */
    void printWelcome(AbstractBoard board);

    /**
     * It prints the instruction to choose location during the game.
     */
    void printChooseLocation(Player currentPlayer);

    /**
     * It prints the alert when the user enter invalid location during the game.
     */
    void printInvalidLocation(AbstractBoard board, Piece piece, Player currentPlayer);

    /**
     * It prints the instruction after the game.
     */
    void printPostGameInstruction(boolean validInput);

    /**
     * It prints the Victory Message after the game ends.
     */
    void printVictoryMessage(Player player);

    /**
     * It prints the Tie Message after the game ends.
     */
    void printTieMessage();

    /**
     * It prints the Game Summary for the current game.
     */
    void printGameSummary(Player[] players);
}