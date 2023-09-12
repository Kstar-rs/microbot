package net.runelite.client.plugins.microbot.crafting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Activities {
    NONE("None"),
    AMETHYST("Amethyst"),
    ARMOUR("Armour"),
    BATTLESTAVES("Battlestaves"),
    GEM_CUTTING("Cutting gems"),
    GLASSBLOWING("Glassblowing"),
    JEWELLERY("Jewellery"),
    SPINNING("Spinning");

    private final String name;

    @Override
    public String toString()
    {
        return name;
    }
}
