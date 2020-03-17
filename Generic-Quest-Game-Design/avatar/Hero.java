package avatar;

import java.util.HashMap;

import avatar.avatarName.*;
import board.square.Coordinate;
import board.square.Market;
import config.Color;
import config.DamageType;
import config.VARIABLES;
import equipment.*;

/**
 * Hero
 */
public class Hero extends Avatar {

    private double strength;

    private double agility;

    private double dexterity;

    private double money;

    private double mana;

    private double experience;

    private Armors armor;

    private Weapons weapon;

    private HashMap<Object, Integer> bag;

    public Hero(String name, Coordinate startingLocation) {
        super(name, startingLocation);
        Object hero = VARIABLES.HEROS_TO_ENUM.get(name);
        if (hero instanceof Warriors) {
            Warriors warrior = (Warriors) hero;
            initHeroProperties(

                    warrior.getStartingMoney(),

                    warrior.getMana(),

                    warrior.getStartingExperience(),

                    warrior.getStrength(),

                    warrior.getAgility(),

                    warrior.getDexterity()

            );
        }

        if (hero instanceof Sorcerers) {
            Sorcerers sorcerer = (Sorcerers) hero;
            initHeroProperties(

                    sorcerer.getStartingMoney(),

                    sorcerer.getMana(),

                    sorcerer.getStartingExperience(),

                    sorcerer.getStrength(),

                    sorcerer.getAgility(),

                    sorcerer.getDexterity()

            );
        }

        if (hero instanceof Paladins) {
            Paladins paladins = (Paladins) hero;
            initHeroProperties(

                    paladins.getStartingMoney(),

                    paladins.getMana(),

                    paladins.getStartingExperience(),

                    paladins.getStrength(),

                    paladins.getAgility(),

                    paladins.getDexterity()

            );
        }

        armor = null;
        weapon = null;
        bag = new HashMap<>();
    }

    private void initHeroProperties(

            double money,

            double mana,

            double experience,

            double strength,

            double agility,

            double dexterity

    ) {
        this.money = money;

        this.mana = mana;

        this.experience = experience;

        this.strength = strength;

        this.agility = agility;

        this.dexterity = dexterity;
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

    private void removeFromBag(Object item) {

        if (!bag.containsKey(item)) {
            throw new NullPointerException("NO SUCH EQUIPMENT IN THE BAG!");
        }

        if (bag.get(item) <= 0) {
            throw new NullPointerException("NO SUCH EQUIPMENT IN THE BAG!");
        }

        bag.put(item, bag.get(item) - 1);

        if (bag.get(item) <= 0) {
            bag.remove(item);
        }
    }

    private void addToBag(Object item) {
        if (item == null) {
            return;
        }

        if (!bag.containsKey(item)) {
            bag.put(item, 1);
        }

        bag.put(item, bag.get(item) + 1);
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

    public void useMana(double manaCost) {
        this.mana -= manaCost;
    }

    public double damageCalculation(Object damageEquipment) {
        double damage = 0.0;

        if (damageEquipment instanceof Weapons) {
            damage = ((Weapons) damageEquipment).getDamage();
            damage += (strength + damage) * 0.05;
        }

        if (damageEquipment instanceof Ice_Spells) {
            damage = ((Ice_Spells) damageEquipment).getDamage();
            damage += (dexterity / 10000) * damage;
        }

        if (damageEquipment instanceof Fire_Spells) {
            damage = ((Fire_Spells) damageEquipment).getDamage();
            damage += (dexterity / 10000) * damage;
        }

        if (damageEquipment instanceof Lighting_Spells) {
            damage = ((Lighting_Spells) damageEquipment).getDamage();
            damage += (dexterity / 10000) * damage;
        }

        return super.makeDamage(damage);
    }

    public double manaCostCalculation(Object damageEquipment) {
        double manaCost = 0.0;

        if (damageEquipment instanceof Ice_Spells) {
            manaCost = ((Ice_Spells) damageEquipment).getManaCost();
        }

        if (damageEquipment instanceof Fire_Spells) {
            manaCost = ((Fire_Spells) damageEquipment).getManaCost();
        }

        if (damageEquipment instanceof Lighting_Spells) {
            manaCost = ((Lighting_Spells) damageEquipment).getManaCost();
        }

        return manaCost;
    }

    public void changeWeapon(String targetWeapon) {
        Weapons targetEquipment = (Weapons) VARIABLES.ITEMS_TO_ENUM.get(targetWeapon);
        Weapons originalEquipment = this.weapon;
        try {
            removeFromBag(targetEquipment);
            addToBag(originalEquipment);
            this.weapon = targetEquipment;
        } catch (Exception e) {

        }
    }

    public void changeArmor(String targetArmor) {
        Armors targetEquipment = (Armors) VARIABLES.ITEMS_TO_ENUM.get(targetArmor);
        Armors originalEquipment = this.armor;
        try {
            removeFromBag(targetEquipment);
            addToBag(originalEquipment);
            this.armor = targetEquipment;
        } catch (Exception e) {

        }
    }

    public void castSpell(String targetSpell, Avatar targetAvatar) {
        Object spell = VARIABLES.ITEMS_TO_ENUM.get(targetSpell);
        double manaCost = manaCostCalculation(spell);

        if (manaCost > mana) {
            throw new NullPointerException("NO ENOUGH MANA!");
        }

        try {
            removeFromBag(spell);
        } catch (Exception e) {

        }

        targetAvatar.receiveDamage(DamageType.MAGIC_ATTACK, damageCalculation(spell));
        mana -= manaCost;

    }

    @Override
    public void receiveDamage(DamageType damageType, double damage) {
        double finalDamage = 0.0;

        if (damageType == DamageType.REGULAR_ATTACK) {
            finalDamage = damage - (armor == null ? 0 : armor.getDamageReduction());
        }

        if (damageType == DamageType.MAGIC_ATTACK) {
            finalDamage = damage;
        }
        super.receiveDamage(damageType, finalDamage);
    }

    @Override
    public boolean successfullyDodge() {
        return Math.random() < agility * 0.02;
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

        System.out.println(Color.ANSI_YELLOW + "DEAD: " + (super.isDead() ? "YES" : "NO") + Color.ANSI_RESET);

        System.out.println("");
    }
}