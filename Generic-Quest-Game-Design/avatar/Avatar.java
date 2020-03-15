package avatar;

import board.square.Square;

/**
 * Avatar
 */
abstract public class Avatar extends Square {
    private String name;

    private double hp;

    private int level;

    private boolean isDead;

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