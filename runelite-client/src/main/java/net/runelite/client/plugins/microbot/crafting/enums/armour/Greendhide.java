package net.runelite.client.plugins.microbot.crafting.enums.armour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Greendhide {
    NONE("Select product", "none", '0', 0),
    BODY("Body", "green d'hide body", '1', CraftingAction.GREEN_DHIDE_BODY.getLevel()),
    VAMBRACES("Vambraces", "green d'hide vambraces", '2', CraftingAction.GREEN_DHIDE_VAMB.getLevel()),
    CHAPS("Chaps", "green d'hide chaps", '3', CraftingAction.GREEN_DHIDE_CHAPS.getLevel());

    private final String label;
    private final String itemName;
    private final char menuEntry;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return label;
    }
}
