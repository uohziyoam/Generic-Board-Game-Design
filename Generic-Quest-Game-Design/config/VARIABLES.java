package config;

import java.util.HashMap;

import equipment.*;

/**
 * ItemToEnum
 */
public class VARIABLES {

    public static String UP = "W";
    public static String LEFT = "A";
    public static String DOWN = "S";
    public static String RIGHT = "D";
    public static String QUIT = "Q";

    public static HashMap<String, Object> ITEMS_TO_ENUM;

    static {
        ITEMS_TO_ENUM = new HashMap<>();

        ITEMS_TO_ENUM.put("Platinum_Shield", Armors.Platinum_Shield);
        ITEMS_TO_ENUM.put("Breastplate", Armors.Breastplate);
        ITEMS_TO_ENUM.put("Full_Body_Armor", Armors.Full_Body_Armor);
        ITEMS_TO_ENUM.put("Wizard_Shield", Armors.Wizard_Shield);
        ITEMS_TO_ENUM.put("Speed_Boots", Armors.Speed_Boots);

        ITEMS_TO_ENUM.put("Healing_Potion", Potions.Healing_Potion);
        ITEMS_TO_ENUM.put("Strength_Potion", Potions.Strength_Potion);
        ITEMS_TO_ENUM.put("Magic_Potion", Potions.Magic_Potion);
        ITEMS_TO_ENUM.put("Luck_Elixir", Potions.Luck_Elixir);
        ITEMS_TO_ENUM.put("Mermaid_Tears", Potions.Mermaid_Tears);
        ITEMS_TO_ENUM.put("Ambrosia", Potions.Ambrosia);

        ITEMS_TO_ENUM.put("Sword", Weapons.Sword);
        ITEMS_TO_ENUM.put("Bow", Weapons.Bow);
        ITEMS_TO_ENUM.put("Scythe", Weapons.Scythe);
        ITEMS_TO_ENUM.put("Axe", Weapons.Axe);
        ITEMS_TO_ENUM.put("Shield", Weapons.Shield);
        ITEMS_TO_ENUM.put("TSwords", Weapons.TSwords);
        ITEMS_TO_ENUM.put("Dagger", Weapons.Dagger);

        ITEMS_TO_ENUM.put("Flame_Tornado", Fire_Spells.Flame_Tornado);
        ITEMS_TO_ENUM.put("Lava_Commet", Fire_Spells.Lava_Commet);
        ITEMS_TO_ENUM.put("Breath_of_Fire", Fire_Spells.Breath_of_Fire);
        ITEMS_TO_ENUM.put("Heat_Wave", Fire_Spells.Heat_Wave);

        ITEMS_TO_ENUM.put("Snow_Canon", Ice_Spells.Snow_Canon);
        ITEMS_TO_ENUM.put("Frost_Blizzard", Ice_Spells.Frost_Blizzard);
        ITEMS_TO_ENUM.put("Arctic_storm", Ice_Spells.Arctic_storm);
        ITEMS_TO_ENUM.put("Ice_Blade", Ice_Spells.Ice_Blade);

        ITEMS_TO_ENUM.put("Thunder_Blast", Lighting_Spells.Thunder_Blast);
        ITEMS_TO_ENUM.put("Electric_Arrows", Lighting_Spells.Electric_Arrows);
        ITEMS_TO_ENUM.put("Spark_Needles", Lighting_Spells.Spark_Needles);
        ITEMS_TO_ENUM.put("LightningDagger", Lighting_Spells.LightningDagger);

    }

}