package avatar;

import board.square.Coordinate;
import board.square.Square;

/**
 * Avatar
 */
abstract public class Avatar extends Square {
    private String name;

    private double hp;

    private int level;

    private boolean isDead;

    private Coordinate curLocation;

    public Avatar(String name, double hp, int level, Coordinate curLocation) {

        this.name = name;
        this.hp = hp;
        this.level = level;
        this.isDead = false;
        this.curLocation = curLocation;
    }

    public Avatar(String name, double hp, int level) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.isDead = false;
    }

    /**
     * @return the hp
     */
    public double getHp() {
        return hp;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the isDead
     */
    public boolean getIsDead() {
        return isDead;
    }

    /**
     * @return the curLocation
     */
    public Coordinate getCurLocation() {
        return curLocation;
    }

    /**
     * @param curLocation the curLocation to set
     */
    public void setCurLocation(Coordinate curLocation) {
        this.curLocation = curLocation;
    }

    /**
     * @param isDead the isDead to set
     */
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp() {
        this.level += 1;
    }
}