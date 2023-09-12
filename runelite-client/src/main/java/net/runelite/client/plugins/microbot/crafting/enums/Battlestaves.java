package net.runelite.client.plugins.microbot.crafting.enums;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Battlestaves {
    NONE("Select product", "none", "none", 0),
    WATER("Water", "water battlestaff", "water orb", CraftingAction.WATER_BATTLESTAFF.getLevel()),
    EARTH("Earth", "earth battlestaff", "earth orb", CraftingAction.EARTH_BATTLESTAFF.getLevel()),
    FIRE("Fire", "fire battlestaff", "fire orb", CraftingAction.FIRE_BATTLESTAFF.getLevel()),
    AIR("Air", "air battlestaff", "air orb", CraftingAction.AIR_BATTLESTAFF.getLevel());

    private final String label;
    private final String itemName;
    private final String orb;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return label;
    }
}
