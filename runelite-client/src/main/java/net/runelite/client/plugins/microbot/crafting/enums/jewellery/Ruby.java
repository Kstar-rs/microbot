package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Ruby {
    RING("ruby ring", -1, CraftingAction.RUBY_RING.getLevel()),
    NECKLACE("ruby necklace", -1, CraftingAction.RUBY_NECKLACE.getLevel()),
    BRACELET("ruby bracelet", -1, CraftingAction.RUBY_BRACELET.getLevel()),
    AMULET("ruby amulet (u)", -1, CraftingAction.RUBY_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}