package net.runelite.client.plugins.microbot.crafting;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.plugins.microbot.crafting.enums.*;
import net.runelite.client.plugins.microbot.crafting.enums.armour.*;
import net.runelite.client.plugins.microbot.crafting.enums.jewellery.Jewellery;
import net.runelite.client.plugins.microbot.crafting.enums.jewellery.Quality;
import net.runelite.client.plugins.microbot.tanner.enums.Location;

@ConfigGroup(CraftingConfig.GROUP)
public interface CraftingConfig extends Config {

    String GROUP = "Crafting";

    // GENERAL CONFIG

    @ConfigSection(
            name = "General",
            description = "General",
            position = 0
    )
    String generalSection = "general";

    @ConfigItem(
            keyName = "Activity",
            name = "Activity",
            description = "Choose the type of crafting activity to perform",
            position = 0,
            section = generalSection
    )
    default Activities activityType()
    {
        return Activities.NONE;
    }

    @ConfigItem(
            keyName = "Afk",
            name = "Afk randomly",
            description = "Randomy afks between 3 and 60 seconds",
            position = 1,
            section = generalSection
    )
    default boolean Afk()
    {
        return false;
    }

    // AMETHYST CONFIG

    @ConfigSection(
            name = "Amethyst",
            description = "Config for amethyst crafting",
            position = 1,
            closedByDefault = true
    )
    String amethystSection = "amethyst";

    @ConfigItem(
            keyName = "Amethyst",
            name = "Amethyst",
            description = "Choose the amethyst item to craft",
            position = 0,
            section = amethystSection
    )
    default Amethyst amethystType() { return Amethyst.NONE; }

    @ConfigItem(
            keyName = "keepAmethyst",
            name = "Keep product in inventory?",
            description = "Will not banked the crafted item",
            position = 1,
            section = amethystSection
    )
    default boolean keepAmethystProductInInventory()
    {
        return false;
    }

    // ARMOUR CONFIG

    @ConfigSection(
            name = "Armour",
            description = "Config for armour crafting",
            position = 2,
            closedByDefault = true
    )
    String armourSection = "armour";

    @ConfigItem(
            keyName = "Quality",
            name = "Quality",
            description = "Choose the quality of armour to craft",
            position = 0,
            section = armourSection
    )
    default Armour armourType() { return Armour.NONE; }

    @ConfigItem(
            keyName = "Leather",
            name = "Leather",
            description = "Choose the leather item to craft",
            position = 1,
            section = armourSection
    )
    default Leather leatherType() { return Leather.NONE; }

    @ConfigItem(
            keyName = "Hardleather",
            name = "Hardleather",
            description = "Choose the hardleather item to craft",
            position = 2,
            section = armourSection
    )
    default Hardleather hardleatherType() { return Hardleather.NONE; }

    @ConfigItem(
            keyName = "Snakeskin",
            name = "Snakeskin",
            description = "Choose the snakeskin item to craft",
            position = 3,
            section = armourSection
    )
    default Snakeskin snakeskinType() { return Snakeskin.NONE; }

    @ConfigItem(
            keyName = "Greendhide",
            name = "Green d'hide",
            description = "Choose the green d'hide item to craft",
            position = 4,
            section = armourSection
    )
    default Greendhide greendhideType() { return Greendhide.NONE; }

    @ConfigItem(
            keyName = "Bluedhide",
            name = "Blue d'hide",
            description = "Choose the blue d'hide item to craft",
            position = 5,
            section = armourSection
    )
    default Bluedhide bluedhideType() { return Bluedhide.NONE; }

    @ConfigItem(
            keyName = "Reddhide",
            name = "Red d'hide",
            description = "Choose the red d'hide item to craft",
            position = 6,
            section = armourSection
    )
    default Reddhide reddhideType() { return Reddhide.NONE; }

    @ConfigItem(
            keyName = "Blackdhide",
            name = "Black d'hide",
            description = "Choose the black d'hide item to craft",
            position = 7,
            section = armourSection
    )
    default Blackdhide blackdhideType() { return Blackdhide.NONE; }

    // BATTLESTAVES CONFIG

    @ConfigSection(
            name = "Battlestaves",
            description = "Config for battlestaff crafting",
            position = 3,
            closedByDefault = true
    )
    String battlestavesSection = "battlestaves";

    @ConfigItem(
            keyName = "Battlestaff",
            name = "Battlestaff",
            description = "Choose the battlestaff to craft",
            position = 0,
            section = battlestavesSection
    )
    default Battlestaves battlestaffType() { return Battlestaves.NONE; }

    // GEMS CONFIG

    @ConfigSection(
            name = "Gems",
            description = "Config for gem cutting",
            position = 4,
            closedByDefault = true
    )
    String gemSection = "gem";

    @ConfigItem(
            keyName = "Gem",
            name = "Gem",
            description = "Choose the type of gem to cut",
            position = 0,
            section = gemSection
    )
    default Gems gemType()
    {
        return Gems.NONE;
    }

    // GLASS CONFIG

    @ConfigSection(
            name = "Glass",
            description = "Config for glass blowing",
            position = 5,
            closedByDefault = true
    )
    String glassSection = "glass";

    @ConfigItem(
            keyName = "Glass",
            name = "Glass",
            description = "Choose the type of product to craft",
            position = 0,
            section = glassSection
    )
    default Glass glassType()
    {
        return Glass.NONE;
    }

    // JEWELLERY CONFIG

    @ConfigSection(
            name = "Jewellery",
            description = "Config for jewellery crafting",
            position = 6,
            closedByDefault = true
    )
    String jewellerySection = "jewellery";

    @ConfigItem(
            keyName = "jewellery",
            name = "Jewellery",
            description = "Choose the type of jewellery to craft",
            position = 0,
            section = jewellerySection
    )
    default Jewellery jewelleryType() { return Jewellery.NONE; }

    @ConfigItem(
            keyName = "quality",
            name = "Quality (gem)",
            description = "Choose the quality to craft jewellery with",
            position = 1,
            section = jewellerySection
    )
    default Quality qualityType() { return Quality.NONE; }

    @ConfigItem(
            keyName = "furnace",
            name = "Furnace",
            description = "Choose the location to craft at",
            position = 2,
            section = jewellerySection
    )
    default Furnaces furnaceLocation() { return Furnaces.NONE; }

    // SPINNING CONFIG
    @ConfigSection(
            name = "Spinning",
            description = "Config for spinning",
            position = 7,
            closedByDefault = true
    )
    String spinningSection = "spinning";

    @ConfigItem(
            keyName = "Spinning",
            name = "Spin",
            description = "Choose the item to produce at the spinning wheel",
            position = 0,
            section = spinningSection
    )
    default Spinning spinningType() { return Spinning.NONE; }

    @ConfigItem(
            keyName = "Location",
            name = "Location",
            description = "Choose the spinning wheel location",
            position = 1,
            section = spinningSection
    )
    default SpinningWheels spinningWheelLocation() { return SpinningWheels.NONE; }
}
