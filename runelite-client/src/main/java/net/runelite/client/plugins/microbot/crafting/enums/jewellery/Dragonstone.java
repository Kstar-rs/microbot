package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Dragonstone {
    RING("dragonstone ring", -1, CraftingAction.DRAGONSTONE_RING.getLevel()),
    NECKLACE("dragonstone necklace", -1, CraftingAction.DRAGONSTONE_NECKLACE.getLevel()),
    BRACELET("dragonstone bracelet", -1, CraftingAction.DRAGONSTONE_BRACELET.getLevel()),
    AMULET("dragonstone amulet (u)", -1, CraftingAction.DRAGONSTONE_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}
