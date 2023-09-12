package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.microbot.crafting.enums.Gems;

@Getter
@RequiredArgsConstructor
public enum Jewellery {
    NONE("Select product"),
    RING("Ring"),
    NECKLACE("Necklace"),
    BRACELET("Bracelet"),
    AMULET("Amulet");

    private final String label;

    @Override
    public String toString()
    {
        return label;
    }
}
