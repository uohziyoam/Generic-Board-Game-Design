package avatar;

/**
 * Dragon
 */
public class Dragon extends Monster {

    private double extraDamage;

    public Dragon(String name, double hp, int level) {
        super(name, hp, level);
    }

    /**
     * @return the extraDamage
     */
    public double getExtraDamage() {
        return extraDamage;
    }

}