package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Jade {
    RING("jade ring", -1, CraftingAction.JADE_RING.getLevel()),
    NECKLACE("jade necklace", -1, CraftingAction.JADE_NECKLACE.getLevel()),
    BRACELET("jade bracelet", -1, CraftingAction.JADE_BRACELET.getLevel()),
    AMULET("jade amulet (u)", -1, CraftingAction.JADE_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}