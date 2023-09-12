package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Onyx {
    RING("onyx ring", -1, CraftingAction.ONYX_RING.getLevel()),
    NECKLACE("onyx necklace", -1, CraftingAction.ONYX_NECKLACE.getLevel()),
    BRACELET("onyx bracelet", -1, CraftingAction.ONYX_BRACELET.getLevel()),
    AMULET("onyx amulet (u)", -1, CraftingAction.ONYX_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}