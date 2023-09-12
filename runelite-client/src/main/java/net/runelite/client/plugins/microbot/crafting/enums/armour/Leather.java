package net.runelite.client.plugins.microbot.crafting.enums.armour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Leather {
    NONE("Select product", "none", '0', 0),
    GLOVES("Gloves", "leather gloves", '1', CraftingAction.LEATHER_GLOVES.getLevel()),
    BOOTS("Boots", "leather boots", '2', CraftingAction.LEATHER_BOOTS.getLevel()),
    COWL("Cowl", "leather cowl", '3', CraftingAction.COWL.getLevel()),
    VAMBRACES("Vambraces", "leather vambraces", '4', CraftingAction.LEATHER_VAMBRACES.getLevel()),
    BODY("Body", "leather body", '5', CraftingAction.LEATHER_BODY.getLevel()),
    CHAPS("Chaps", "leather chaps", '6', CraftingAction.LEATHER_CHAPS.getLevel()),
    COIF("Coif", "coif", '7', CraftingAction.COIF.getLevel());

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
