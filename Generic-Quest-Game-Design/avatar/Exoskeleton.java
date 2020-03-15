package avatar;

/**
 * Exoskeleton
 */
public class Exoskeleton extends Monster {

    private double extraDefense;

    public Exoskeleton(String name, double hp, int level) {
        super(name, hp, level);
    }

    /**
     * @return the extraDefense
     */
    public double getExtraDefense() {
        return extraDefense;
    }
}