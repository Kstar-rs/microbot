package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum RedTopaz {
    RING("topaz ring", -1, CraftingAction.TOPAZ_RING.getLevel()),
    NECKLACE("topaz necklace", -1, CraftingAction.TOPAZ_NECKLACE.getLevel()),
    BRACELET("topaz bracelet", -1, CraftingAction.TOPAZ_BRACELET.getLevel()),
    AMULET("topaz amulet (u)", -1, CraftingAction.TOPAZ_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}