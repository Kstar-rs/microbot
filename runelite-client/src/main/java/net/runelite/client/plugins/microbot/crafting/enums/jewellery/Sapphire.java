package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Sapphire {
    RING("sapphire ring", -1, CraftingAction.SAPPHIRE_RING.getLevel()),
    NECKLACE("sapphire necklace", -1, CraftingAction.SAPPHIRE_NECKLACE.getLevel()),
    BRACELET("sapphire bracelet", -1, CraftingAction.SAPPHIRE_BRACELET.getLevel()),
    AMULET("sapphire amulet (u)", -1, CraftingAction.SAPPHIRE_AMULET_U.getLevel());

    private final String itemName;
    private final int widgetId;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return itemName;
    }
}