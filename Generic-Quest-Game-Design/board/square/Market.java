package board.square;

import java.util.*;
import config.Color;
import equipment.*;

public class Market extends Square {
    private HashMap<Ice_Spells, Queue<Object>> Ice_Spells_Inventory;
    private HashMap<Fire_Spells, Queue<Object>> Fire_Spells_Inventory;
    private HashMap<Lighting_Spells, Queue<Object>> Lighting_Spells_Inventory;
    private HashMap<Weapons, Queue<Object>> Weapons_Inventory;
    private HashMap<Armors, Queue<Object>> Armors_Inventory;
    private HashMap<Potions, Queue<Object>> Potions_Inventory;
    public boolean accessible;

    public Market() {
        this.accessible = false;
    }

    public int getQuantity() {
        return 1;
    }

    public Object sellEquipment(Object item) {
        if (item instanceof Weapons) {
            return this.Weapons_Inventory.get(item).poll();
        }

        if (item instanceof Armors) {
            return this.Armors_Inventory.get(item).poll();
        }

        if (item instanceof Potions) {
            return this.Potions_Inventory.get(item).poll();

        }

        if (item instanceof Ice_Spells) {
            return this.Ice_Spells_Inventory.get(item).poll();

        }

        if (item instanceof Fire_Spells) {
            return this.Fire_Spells_Inventory.get(item).poll();

        }

        if (item instanceof Lighting_Spells) {
            return this.Lighting_Spells_Inventory.get(item).poll();

        }

        return null;
    }

    public Object buyEquipment(Object item) {
        if (item instanceof Weapons) {
            return this.Weapons_Inventory.get(item).offer(item);
        }

        if (item instanceof Armors) {
            return this.Armors_Inventory.get(item).offer(item);
        }

        if (item instanceof Potions) {
            return this.Potions_Inventory.get(item).offer(item);

        }

        if (item instanceof Ice_Spells) {
            return this.Ice_Spells_Inventory.get(item).offer(item);

        }

        if (item instanceof Fire_Spells) {
            return this.Fire_Spells_Inventory.get(item).offer(item);

        }

        if (item instanceof Lighting_Spells) {
            return this.Lighting_Spells_Inventory.get(item).offer(item);

        }

        return null;
    }

    public boolean hasItem(Object item) {
        if (item instanceof Weapons) {
            return !this.Weapons_Inventory.get(item).isEmpty();
        }

        if (item instanceof Armors) {
            return !this.Armors_Inventory.get(item).isEmpty();
        }

        if (item instanceof Potions) {
            return !this.Potions_Inventory.get(item).isEmpty();
        }

        if (item instanceof Ice_Spells) {
            return !this.Ice_Spells_Inventory.get(item).isEmpty();
        }

        if (item instanceof Fire_Spells) {
            return !this.Fire_Spells_Inventory.get(item).isEmpty();
        }

        if (item instanceof Lighting_Spells) {
            return !this.Lighting_Spells_Inventory.get(item).isEmpty();
        }

        return false;
    }

    public void clear() {
        this.Weapons_Inventory.clear();
        this.Armors_Inventory.clear();
        this.Potions_Inventory.clear();
        this.Ice_Spells_Inventory.clear();
        this.Fire_Spells_Inventory.clear();
        this.Lighting_Spells_Inventory.clear();
    }

    @Override
    public String toString() {
        return Color.ANSI_RED + "M" + Color.ANSI_RESET;
    }

    public boolean getAccessible() {
        return accessible;
    }

    public boolean hasMonster() {
        return false;
    }
}