package net.runelite.client.plugins.microbot.crafting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Spinning {
    NONE("Select mode", "none", "none", '0', 0),
    WOOL("Wool", "ball of wool", "wool", '1', CraftingAction.BALL_OF_WOOL.getLevel()),
    FLAX("Flax", "bow string", "flax", '3', CraftingAction.BOW_STRING.getLevel()),
    SINEW("Sinew", "crossbow string", "sinew", '5', CraftingAction.CROSSBOW_STRING.getLevel()),
    ROOTS("Magic roots", "magic string", "magic roots", '7', CraftingAction.MAGIC_STRING.getLevel()),
    YAK_HAIR("Yak hair", "rope", "yak hair", '4', CraftingAction.ROPE.getLevel());

    private final String label;
    private final String itemName;
    private final String ingredient;
    private final char menuEntry;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return label;
    }
}
