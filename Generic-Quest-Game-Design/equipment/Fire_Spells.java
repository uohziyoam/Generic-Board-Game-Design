package equipment;

public enum Fire_Spells {
    Flame_Tornado(700, 4, 850, 300),

    Lava_Commet(800, 7, 1000, 550),

    Breath_of_Fire(350, 1, 450, 100),

    Heat_Wave(450, 2, 600, 150);

    private final double cost;
    private final int minimumLevel;
    private final double damage;
    private final double manaCost;

    Fire_Spells(double cost, int minimumLevel, double damage, double manaCost) {
        this.cost = cost;
        this.minimumLevel = minimumLevel;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return the damage
     */
    public double getDamage() {
        return damage;
    }

    /**
     * @return the manaCost
     */
    public double getManaCost() {
        return manaCost;
    }

    /**
     * @return the minimumLevel
     */
    public int getMinimumLevel() {
        return minimumLevel;
    }

}
