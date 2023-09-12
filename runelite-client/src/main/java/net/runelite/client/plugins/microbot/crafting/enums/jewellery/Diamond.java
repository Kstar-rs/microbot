package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Diamond {
    RING("diamond ring", -1, CraftingAction.DIAMOND_RING.getLevel()),
    NECKLACE("diamond necklace", -1, CraftingAction.DIAMOND_NECKLACE.getLevel()),
    BRACELET("diamond bracelet", -1, CraftingAction.DIAMOND_BRACELET.getLevel()),
    AMULET("diamond amulet (u)", -1, CraftingAction.DIAMOND_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}
