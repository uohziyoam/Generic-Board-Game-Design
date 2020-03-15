package avatar;

import java.util.HashMap;

import board.square.Market;
import config.VARIABLES;
import equipment.*;

/**
 * Hero
 */
abstract public class Hero extends Avatar {

    private double money;

    private double mana;

    private double experience;

    private Armors armor;

    private Weapons weapon;

    private HashMap<Object, Integer> bag;

    public Hero(String name, double hp, int level) {
        super(name, hp, level);

    }

    public void buy(String item, Market market) {
        Object equipment = market.sellEquipment(VARIABLES.ITEMS_TO_ENUM.get(item));

        if (!bag.containsKey(equipment)) {
            bag.put(equipment, 1);
        }

        bag.put(equipment, bag.get(equipment) + 1);
    }

    public void sell(String item, Market market) {
        Object equipment = market.buyEquipment(VARIABLES.ITEMS_TO_ENUM.get(item));
        bag.put(equipment, bag.get(equipment) - 1);
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

}