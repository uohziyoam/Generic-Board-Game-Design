package equipment;

public enum Armors {
    Platinum_Shield(150, 1, 200),

    Breastplate(350, 3, 600),

    Full_Body_Armor(1000, 8, 1100),

    Wizard_Shield(1200, 10, 1500),

    Speed_Boots(550, 4, 600);

    private final double cost;
    private final int minimumLevel;
    private final double damageReduction;

    Armors(double cost, int minimumLevel, double damageReduction) {
        this.cost = cost;
        this.minimumLevel = minimumLevel;
        this.damageReduction = damageReduction;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @return the damageReduction
     */
    public double getDamageReduction() {
        return damageReduction;
    }

    /**
     * @return the minimumLevel
     */
    public int getMinimumLevel() {
        return minimumLevel;
    }

}
