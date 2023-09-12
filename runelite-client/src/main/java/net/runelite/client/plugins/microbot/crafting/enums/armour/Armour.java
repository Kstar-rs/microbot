package net.runelite.client.plugins.microbot.crafting.enums.armour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Armour {
    NONE("Select quality", "None"),
    LEATHER("Leather", "leather"),
    HARD_LEATHER("Hard leather", "hard leather"),
    SNAKESKIN("Snakeskin", "snakeskin"),
    GREEN_DHIDE("Green d'hide", "green dragon leather"),
    BLUE_DHIDE("Blue d'hide", "blue dragon leather"),
    RED_DHIDE("Red d'hide", "red dragon leather"),
    BLACK_DHIDE("Black d'hide", "black dragon leather");

    private final String label;
    private final String itemName;

    @Override
    public String toString()
    {
        return label;
    }
}
