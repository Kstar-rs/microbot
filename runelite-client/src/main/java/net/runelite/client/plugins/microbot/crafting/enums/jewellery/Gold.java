package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Gold {
    RING("gold ring", -1, CraftingAction.GOLD_RING.getLevel()),
    NECKLACE("gold necklace", -1, CraftingAction.GOLD_NECKLACE.getLevel()),
    BRACELET("gold bracelet", -1, CraftingAction.GOLD_BRACELET.getLevel()),
    AMULET("gold amulet (u)", -1, CraftingAction.GOLD_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}