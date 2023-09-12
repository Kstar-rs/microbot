package net.runelite.client.plugins.microbot.crafting.enums.armour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Reddhide {
    NONE("Select product", "none", '0', 0),
    BODY("Body", "red d'hide body", '1', CraftingAction.RED_DHIDE_BODY.getLevel()),
    VAMBRACES("Vambraces", "red d'hide vambraces", '2', CraftingAction.RED_DHIDE_VAMB.getLevel()),
    CHAPS("Chaps", "red d'hide chaps", '3', CraftingAction.RED_DHIDE_CHAPS.getLevel());

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
