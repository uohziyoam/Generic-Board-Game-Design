package avatar;

import java.util.HashMap;
import board.square.Coordinate;
import board.square.Market;
import config.Color;
import config.VARIABLES;
import equipment.*;

/**
 * Hero
 */
// abstract
public class Hero extends Avatar {

    private double money;

    private double mana;

    private double experience;

    private Armors armor;

    private Weapons weapon;

    private HashMap<Object, Integer> bag;

    public Hero(String name, double hp, int level) {
        super(name, hp, level);
        money = 10000;
        mana = 0;
        experience = 0;
        bag = new HashMap<>();
    }

    public Hero(String name, double hp, int level, Coordinate curLocation) {
        super(name, hp, level, curLocation);
        money = 10000;
        mana = 0;
        experience = 0;
        bag = new HashMap<>();
    }

    public void buy(String item, Market market) {
        Object equipment = market.sellEquipment(VARIABLES.ITEMS_TO_ENUM.get(item), this);

        if (!bag.containsKey(equipment)) {
            bag.put(equipment, 1);
        }

        bag.put(equipment, bag.get(equipment) + 1);
    }

    public void sell(String item, Market market) {
        Object equipment = VARIABLES.ITEMS_TO_ENUM.get(item);
        double money = market.buyEquipment(equipment);
        if (money < 0) {
            throw new NullPointerException("FAILED TO SELL EQUIPMENTS!");
        }
        addMoney(money);
        bag.put(equipment, bag.get(equipment) - 1);
    }

    public void reduceMoney(double cost) {
        money -= cost;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    @Override
    public String toString() {
        return Color.ANSI_YELLOW + "H" + Color.ANSI_RESET;
    }

    /**
     * @return the money
     */
    public double getMoney() {
        return money;
    }

    private void addMoney(double money) {
        this.money += money;
    }

    public void recover() {
        super.setHp(100);
    }

    public void printStatistics() {
        System.out
                .println(Color.ANSI_PURPLE_BACKGROUND + Color.ANSI_YELLOW + super.getName() + ": " + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "LEVEL: " + super.getLevel() + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "HP: " + super.getHp() + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "MANA: " + this.mana + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "MONEY: " + this.money + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "EXPERIENCE: " + this.experience + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "ARMOR: " + this.armor + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "WEAPON: " + this.weapon + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "BAGS: " + this.bag + Color.ANSI_RESET);

        System.out.println(Color.ANSI_YELLOW + "DEAD: " + (super.getIsDead() ? "YES" : "NO") + Color.ANSI_RESET);
    }
}