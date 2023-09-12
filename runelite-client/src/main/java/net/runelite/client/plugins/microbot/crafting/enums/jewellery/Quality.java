package net.runelite.client.plugins.microbot.crafting.enums.jewellery;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.plugins.microbot.crafting.enums.Gems;

@Getter
@RequiredArgsConstructor
public enum Quality {
    NONE("Select quality", Gems.NONE.toString()),
    GOLD("Gold", Gems.NONE.toString()),
    OPAL("Opal", Gems.OPAL.toString()),
    JADE("Jade", Gems.JADE.toString()),
    RED_TOPAZ("Topaz", Gems.RED_TOPAZ.toString()),
    SAPPHIRE("Sapphire", Gems.SAPPHIRE.toString()),
    EMERALD("Emerald", Gems.EMERALD.toString()),
    RUBY("Ruby", Gems.RUBY.toString()),
    DIAMOND("Diamond", Gems.DIAMOND.toString()),
    DRAGONSTONE("Dragonstone", Gems.DRAGONSTONE.toString()),
    ONYX("Onyx", Gems.ONYX.toString()),
    ZENYTE("Zenyte", Gems.ZENYTE.toString());

    private final String label;
    private final String gem;

    @Override
    public String toString()
    {
        return label;
    }
}
