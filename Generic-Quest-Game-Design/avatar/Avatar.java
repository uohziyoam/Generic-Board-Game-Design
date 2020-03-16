package avatar;

import board.square.Coordinate;
import board.square.Square;
import config.VARIABLES;

/**
 * Avatar
 */
abstract public class Avatar extends Square {
    private String name;

    private double hp;

    private double level;

    private boolean isDead;

    private Coordinate curLocation;

    public Avatar(String name, Coordinate curLocation) {
        this.name = name;
        level = 1;
        hp = level * 100;
        isDead = false;
        this.curLocation = curLocation;
    }

    public Avatar(String name) {
        this.name = name;
        level = 1;
        hp = level * 100;
        isDead = false;
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
    public double getLevel() {
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
    public void setLevel(double level) {
        this.level = level;
    }

    public void levelUp() {
        this.level += 1;
    }

    public double makeDamage(double damage) {
        return damage;
    }

    public void receiveDamage(double damage) {
        this.setHp(this.getHp() - damage);
    }
}