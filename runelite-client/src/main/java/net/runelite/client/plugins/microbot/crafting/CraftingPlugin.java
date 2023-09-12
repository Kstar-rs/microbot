package net.runelite.client.plugins.microbot.crafting;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.crafting.enums.*;
import net.runelite.client.plugins.microbot.crafting.enums.armour.Armour;
import net.runelite.client.plugins.microbot.crafting.enums.jewellery.Jewellery;
import net.runelite.client.plugins.microbot.crafting.scripts.*;
import net.runelite.client.plugins.microbot.util.mouse.VirtualMouse;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.client.plugins.natepainthelper.Info.*;


@PluginDescriptor(
        name = PluginDescriptor.Mocrosoft + "Crafting",
        description = "Microbot crafting plugin",
        tags = {"skilling", "microbot", "crafting"},
        enabledByDefault = false
)
@Slf4j
public class CraftingPlugin extends Plugin {

    @Inject
    private CraftingConfig config;

    @Provides
    CraftingConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(CraftingConfig.class);
    }

    @Inject
    private Client client;
    @Inject
    private ClientThread clientThread;
    @Inject
    private Notifier notifier;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private CraftingOverlay craftingOverlay;

    private DefaultScript defaultScript = new DefaultScript();
    private AmethystScript amethystScript = new AmethystScript();
    private ArmourScript armourScript = new ArmourScript();
    private BattlestavesScript battlestavesScript = new BattlestavesScript();
    private GemsScript gemsScript = new GemsScript();
    private GlassblowingScript glassblowingScript = new GlassblowingScript();
    private JewelleryScript jewelleryScript = new JewelleryScript();
    private SpinningScript spinningScript = new SpinningScript();

    @Override
    protected void startUp() throws AWTException {
        expstarted = Microbot.getClient().getSkillExperience(Skill.CRAFTING);
        startinglevel = Microbot.getClient().getRealSkillLevel(Skill.CRAFTING);
        timeBegan = System.currentTimeMillis();
        Microbot.pauseAllScripts = false;
        Microbot.setClient(client);
        Microbot.setClientThread(clientThread);
        Microbot.setNotifier(notifier);
        Microbot.setMouse(new VirtualMouse());
        if (overlayManager != null) {
            overlayManager.add(craftingOverlay);
        }

        if(config.activityType() == Activities.NONE) shutDown("no activity selected");

        if(config.activityType() == Activities.AMETHYST) {
            if(config.amethystType() != Amethyst.NONE) {
                amethystScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

        if(config.activityType() == Activities.ARMOUR) {
            if(config.armourType() != Armour.NONE) {
                armourScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

        if(config.activityType() == Activities.BATTLESTAVES) {
            if(config.battlestaffType() != Battlestaves.NONE) {
                battlestavesScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

        if(config.activityType() == Activities.GEM_CUTTING) {
            if(config.gemType() != Gems.NONE) {
                gemsScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

        if(config.activityType() == Activities.GLASSBLOWING) {
            if(config.glassType() != Glass.NONE) {
                glassblowingScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

        if(config.activityType() == Activities.JEWELLERY) {
            if(config.jewelleryType() != Jewellery.NONE) {
                jewelleryScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

        if(config.activityType() == Activities.SPINNING) {
            if(config.spinningType() != Spinning.NONE && config.spinningWheelLocation() != SpinningWheels.NONE) {
                spinningScript.run(config);
            } else {
                shutDown("config not set for activity");
            }
        }

    }

    protected void shutDown() {
        stopScripts();
        overlayManager.remove(craftingOverlay);
    }

    protected void shutDown(String reason) {
        stopScripts();
        Microbot.status = "[Shutting down] - Reason: " + reason;
        Microbot.getNotifier().notify(Microbot.status);
        overlayManager.remove(craftingOverlay);
    }

    protected void stopScripts() {
        glassblowingScript.shutdown();
        gemsScript.shutdown();
        defaultScript.shutdown();
    }
}
