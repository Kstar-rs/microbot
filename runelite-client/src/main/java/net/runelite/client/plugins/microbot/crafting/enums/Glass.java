package net.runelite.client.plugins.microbot.crafting.enums;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.skillcalculator.skills.CraftingAction;

@Getter
@RequiredArgsConstructor
public enum Glass {
    NONE("Select product/mode", "none", '0',1),
    PROGRESSIVE("Progressive Mode","none", '0', 1),
    BEER_GLASS("Beer glass", "beer glass", '1', CraftingAction.BEER_GLASS.getLevel()),
    CANDLE_LANTERN("Empty candle lantern", "empty candle lantern", '2', CraftingAction.EMPTY_CANDLE_LANTERN.getLevel()),
    OIL_LAMP("Empty oil lamp", "empty oil lamp", '3', CraftingAction.EMPTY_OIL_LAMP.getLevel()),
    VIAL("Vial", "vial", '4', CraftingAction.VIAL.getLevel()),
    FISHBOWL("Empty fishbowl", "empty fishbowl", '5', CraftingAction.FISHBOWL.getLevel()),
    UNPOWERED_ORB("Unpowered orb", "unpowered orb", '6', CraftingAction.UNPOWERED_ORB.getLevel()),
    LANTERN_LENS("Lantern lens", "lantern lens", '7', CraftingAction.LANTERN_LENS.getLevel()),
    LIGHT_ORB("Empty light orb", "empty light orb", '8', CraftingAction.LIGHT_ORB.getLevel());

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
