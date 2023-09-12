package net.runelite.client.plugins.microbot.crafting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Furnaces {
    // TODO: code in these furnaces
    NONE("Select location", "none"),
    EDGEVILLE("Edgeville", ""),
    PRIFDDINAS("prifddinas", "");

    private final String label;
    private final String location;

    @Override
    public String toString()
    {
        return label;
    }
}
