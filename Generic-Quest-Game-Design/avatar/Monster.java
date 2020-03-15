package avatar;

/**
 * Monster
 */
abstract public class Monster extends Avatar {

    private double damage;
    private double defense;
    private double dodge;
    private double worth;

    public Monster(String name, double hp, int level) {
        super(name, hp, level);
    }

    /**
     * @return the damage
     */
    public double getDamage() {
        return damage;
    }

    /**
     * @return the defense
     */
    public double getDefense() {
        return defense;
    }

    /**
     * @return the dodge
     */
    public double getDodge() {
        return dodge;
    }

    /**
     * @return the worth
     */
    public double getWorth() {
        return worth;
    }

}