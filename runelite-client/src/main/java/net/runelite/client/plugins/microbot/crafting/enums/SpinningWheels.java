package net.runelite.client.plugins.microbot.crafting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum SpinningWheels {
    // TODO: code in these locations
    NONE("Select location", "none"),
    LUMBRIDGE("Lumbridge", ""),
    FOSSIL_ISLAND("Fossil island", "");

    private final String label;
    private final String location;

    @Override
    public String toString()
    {
        return label;
    }
}
