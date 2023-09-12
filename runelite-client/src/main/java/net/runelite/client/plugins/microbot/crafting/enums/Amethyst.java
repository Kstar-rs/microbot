package net.runelite.client.plugins.microbot.crafting.enums;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Amethyst {
    NONE("Select product", "none", '0', 0),
    BOLT_TIPS("Bolt tips", "amethyst bolt tips", '1', CraftingAction.AMETHYST_BOLT_TIPS.getLevel()),
    ARROWTIPS("Arrowtips", "amethyst arrowtips", '2', CraftingAction.AMETHYST_ARROWTIPS.getLevel()),
    JAVELIN_HEADS("Javelin heads", "amethyst javelin heads", '3', CraftingAction.AMETHYST_JAVELIN_HEADS.getLevel()),
    DART_TIP("Dart tips", "amethyst dart tip", '4', CraftingAction.AMETHYST_DART_TIP.getLevel());

    private final String label;
    private final String itemName;
    private final char menuEntry;
    private final int levelRequired;

    @Override
    public String toString()
    {
        return label;
    }
}
