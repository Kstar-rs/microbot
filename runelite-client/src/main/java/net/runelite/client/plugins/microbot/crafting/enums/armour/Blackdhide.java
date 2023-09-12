package net.runelite.client.plugins.microbot.crafting.enums.armour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Blackdhide {
    NONE("Select product", "none", '0', 0),
    BODY("Body", "black d'hide body", '1', CraftingAction.BLACK_DHIDE_BODY.getLevel()),
    VAMBRACES("Vambraces", "black d'hide vambraces", '2', CraftingAction.BLACK_DHIDE_VAMB.getLevel()),
    CHAPS("Chaps", "black d'hide chaps", '3', CraftingAction.BLACK_DHIDE_CHAPS.getLevel());

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
