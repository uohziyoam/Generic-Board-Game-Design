package avatar;

import avatar.avatarName.Dragons;
import avatar.avatarName.Exoskeletons;
import avatar.avatarName.Spirits;
import config.Color;
import config.VARIABLES;

/**
 * Monster
 */
public class Monster extends Avatar {

    private double damage;
    private double defense;
    private double dodge;
    private double worth;

    public Monster(String name) {
        super(name);

        Object monster = VARIABLES.MONSTERS_TO_ENUM.get(name);
        if (monster instanceof Dragons) {
            Dragons dragons = (Dragons) monster;
            initMonsterProperties(

                    dragons.getDamage(),

                    dragons.getDefense(),

                    dragons.getDodgeChance(),

                    dragons.getLevel()

            );
        }

        if (monster instanceof Exoskeletons) {
            Exoskeletons exoskeletons = (Exoskeletons) monster;
            initMonsterProperties(

                    exoskeletons.getDamage(),

                    exoskeletons.getDefense(),

                    exoskeletons.getDodgeChance(),

                    exoskeletons.getLevel()

            );
        }

        if (monster instanceof Spirits) {
            Spirits spirits = (Spirits) monster;
            initMonsterProperties(

                    spirits.getDamage(),

                    spirits.getDefense(),

                    spirits.getDodgeChance(),

                    spirits.getLevel()

            );
        }
    }

    private void initMonsterProperties(

            double damage,

            double defense,

            double dodge,

            double level

    ) {
        this.damage = damage;

        this.defense = defense;

        this.dodge = dodge;

        super.setLevel(level);

        super.setHp(level * 100);
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

    @Override
    public boolean successfullyDodge() {
        return Math.random() < dodge * 0.01;
    }

    public void printStatistics() {
        System.out
                .println(Color.ANSI_PURPLE_BACKGROUND + Color.ANSI_YELLOW + super.getName() + ": " + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "LEVEL: " + super.getLevel() + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "HP: " + super.getHp() + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "DAMAGE: " + this.damage + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "DEFENSE: " + this.defense + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "DODGE: " + this.dodge + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "WORTH: " + this.worth + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "DEAD: " + (super.isDead() ? "YES" : "NO") + Color.ANSI_RESET);

        System.out.println("");
    }

}