package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Emerald {
    RING("emerald ring", -1, CraftingAction.EMERALD_RING.getLevel()),
    NECKLACE("emerald necklace", -1, CraftingAction.EMERALD_NECKLACE.getLevel()),
    BRACELET("emerald bracelet", -1, CraftingAction.EMERALD_BRACELET.getLevel()),
    AMULET("emerald amulet (u)", -1, CraftingAction.EMERALD_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}
