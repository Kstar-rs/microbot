package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Opal {
    RING("opal ring", -1, CraftingAction.OPAL_RING.getLevel()),
    NECKLACE("opal necklace", -1, CraftingAction.OPAL_NECKLACE.getLevel()),
    BRACELET("opal bracelet", -1, CraftingAction.OPAL_BRACELET.getLevel()),
    AMULET("opal amulet (u)", -1, CraftingAction.OPAL_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}