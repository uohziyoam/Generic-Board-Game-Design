package coordinate;

import constants.*;

public class Cell {
    private Piece state;

    public Cell(Piece state) {
        this.state = state;
    }

    /**
     * @return the state
     */
    public Piece getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Piece state) {
        this.state = state;
    }

    /**
     * @return <tt>true</tt> if this cell is empty.
     */
    public boolean isEmpty() {
        return this.state == null;
    }
}