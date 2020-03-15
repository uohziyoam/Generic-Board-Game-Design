package avatar;

/**
 * Spirit
 */
public class Spirit extends Monster {

    private double extraDodge;

    public Spirit(String name, double hp, int level) {
        super(name, hp, level);
    }

    /**
     * @return the extraDodge
     */
    public double getExtraDodge() {
        return extraDodge;
    }

}