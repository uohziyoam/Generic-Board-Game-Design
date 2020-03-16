package config;

import java.util.HashMap;

import avatar.avatarName.*;
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
    public static HashMap<String, Object> HEROS_TO_ENUM;
    public static HashMap<String, Object> MONSTERS_TO_ENUM;

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

    static {
        HEROS_TO_ENUM = new HashMap<>();

        HEROS_TO_ENUM.put("Gaerdal_Ironhand", Warriors.Gaerdal_Ironhand);
        HEROS_TO_ENUM.put("Sehanine_Monnbow", Warriors.Sehanine_Monnbow);
        HEROS_TO_ENUM.put("Muamman_Duathall", Warriors.Muamman_Duathall);
        HEROS_TO_ENUM.put("Flandal_Steelskin", Warriors.Flandal_Steelskin);

        HEROS_TO_ENUM.put("Garl_Glittergold", Sorcerers.Garl_Glittergold);
        HEROS_TO_ENUM.put("Rillifane_Rallathil", Sorcerers.Rillifane_Rallathil);
        HEROS_TO_ENUM.put("Segojan_Earthcaller", Sorcerers.Segojan_Earthcaller);
        HEROS_TO_ENUM.put("Skoraeus_Stonebones", Sorcerers.Skoraeus_Stonebones);

        HEROS_TO_ENUM.put("Solonor_Thelandira", Paladins.Solonor_Thelandira);
        HEROS_TO_ENUM.put("Sehanine_Moonbow", Paladins.Sehanine_Moonbow);
        HEROS_TO_ENUM.put("Skoraeus_Stonebones", Paladins.Skoraeus_Stonebones);
        HEROS_TO_ENUM.put("Garl_Glittergold", Paladins.Garl_Glittergold);
    }

    static {
        MONSTERS_TO_ENUM = new HashMap<>();

        MONSTERS_TO_ENUM.put("Desghidorrah", Dragons.Desghidorrah);
        MONSTERS_TO_ENUM.put("Chrysophylax", Dragons.Chrysophylax);
        MONSTERS_TO_ENUM.put("BunsenBurner", Dragons.BunsenBurner);
        MONSTERS_TO_ENUM.put("Natsunomeryu", Dragons.Natsunomeryu);
        MONSTERS_TO_ENUM.put("TheScaleless", Dragons.TheScaleless);
        MONSTERS_TO_ENUM.put("KasEthelinh", Dragons.KasEthelinh);
        MONSTERS_TO_ENUM.put("Alexstraszan", Dragons.Alexstraszan);
        MONSTERS_TO_ENUM.put("Phaarthurnax", Dragons.Phaarthurnax);
        MONSTERS_TO_ENUM.put("DMaleficent", Dragons.DMaleficent);
        MONSTERS_TO_ENUM.put("TheWeatherbe", Dragons.TheWeatherbe);

        MONSTERS_TO_ENUM.put("Cyrrollalee", Exoskeletons.Cyrrollalee);
        MONSTERS_TO_ENUM.put("Brandobaris", Exoskeletons.Brandobaris);
        MONSTERS_TO_ENUM.put("BigBadWolf", Exoskeletons.BigBadWolf);
        MONSTERS_TO_ENUM.put("WickedWitch", Exoskeletons.WickedWitch);
        MONSTERS_TO_ENUM.put("Aasterinian", Exoskeletons.Aasterinian);
        MONSTERS_TO_ENUM.put("Chronepsish", Exoskeletons.Chronepsish);
        MONSTERS_TO_ENUM.put("Kiaransalee", Exoskeletons.Kiaransalee);
        MONSTERS_TO_ENUM.put("StShargaas", Exoskeletons.StShargaas);
        MONSTERS_TO_ENUM.put("Merrshaullk", Exoskeletons.Merrshaullk);
        MONSTERS_TO_ENUM.put("StYeenoghu", Exoskeletons.StYeenoghu);

        MONSTERS_TO_ENUM.put("Andrealphus", Spirits.Andrealphus);
        MONSTERS_TO_ENUM.put("AimHaborym", Spirits.AimHaborym);
        MONSTERS_TO_ENUM.put("Andromalius", Spirits.Andromalius);
        MONSTERS_TO_ENUM.put("Chiangshih", Spirits.Chiangshih);
        MONSTERS_TO_ENUM.put("FallenAngel", Spirits.FallenAngel);
        MONSTERS_TO_ENUM.put("Ereshkigall", Spirits.Ereshkigall);
        MONSTERS_TO_ENUM.put("Melchiresas", Spirits.Melchiresas);
        MONSTERS_TO_ENUM.put("Jormunngand", Spirits.Jormunngand);
        MONSTERS_TO_ENUM.put("Rakkshasass", Spirits.Rakkshasass);
        MONSTERS_TO_ENUM.put("Taltecuhtli", Spirits.Taltecuhtli);

    }
}