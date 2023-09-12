package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Zenyte {
    RING("zenyte ring", -1, CraftingAction.ZENYTE_RING.getLevel()),
    NECKLACE("zenyte necklace", -1, CraftingAction.ZENYTE_NECKLACE.getLevel()),
    BRACELET("zenyte bracelet", -1, CraftingAction.ZENYTE_BRACELET.getLevel()),
    AMULET("zenyte amulet (u)", -1, CraftingAction.ZENYTE_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}