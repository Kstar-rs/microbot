package net.runelite.client.plugins.microbot.crafting.enums.armour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Snakeskin {
    NONE("Select product", "none", '0', 0),
    BODY("Body", "snakeskin body", '1', CraftingAction.SNAKESKIN_BODY.getLevel()),
    CHAPS("Chaps", "snakeskin chaps", '2', CraftingAction.SNAKESKIN_CHAPS.getLevel()),
    VAMBRACES("Vambraces", "snakeskin vambraces", '3', CraftingAction.SNAKESKIN_VAMBRACES.getLevel()),
    BANDANA("Bandana", "snakeskin bandana", '4', CraftingAction.SNAKESKIN_BANDANA.getLevel()),
    BOOTS("Boots", "snakeskin boots", '5', CraftingAction.SNAKESKIN_BOOTS.getLevel());

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
