package net.runelite.client.plugins.microbot.crafting.scripts;

import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.Script;
import net.runelite.client.plugins.microbot.crafting.CraftingConfig;
import net.runelite.client.plugins.microbot.util.bank.Rs2Bank;
import net.runelite.client.plugins.microbot.util.inventory.Inventory;
import net.runelite.client.plugins.microbot.util.keyboard.VirtualKeyboard;
import net.runelite.client.plugins.microbot.util.math.Random;
import net.runelite.client.plugins.microbot.util.widget.Rs2Widget;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class BattlestavesScript extends Script {

    public static double version = 3.0;

    String battlestaff = "battlestaff";
    String orb;
    String itemToCraft;

    public void run(CraftingConfig config) {

        mainScheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            if (!super.run()) return;
            if (config.Afk() && Random.random(1, 100) == 2)
                sleep(1000, 60000);
            try {
                orb = config.battlestaffType().getOrb();
                itemToCraft = config.amethystType().getItemName();

                if (Inventory.hasItem(battlestaff)
                        && Inventory.hasItem(orb)) {
                    craft(config);
                }

                if (!Inventory.hasItem(battlestaff)
                        || !Inventory.hasItem(orb)) {
                    bank(config);
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }, 0, 600, TimeUnit.MILLISECONDS);
    }

    private void bank(CraftingConfig config) {
        Rs2Bank.openBank();
        sleepUntilOnClientThread(Rs2Bank::isOpen);

        Rs2Bank.depositAll(itemToCraft);
        sleepUntilOnClientThread(() -> !Inventory.hasItem(itemToCraft));

        verifyItemInBank(battlestaff);

        Rs2Bank.withdrawItemX(true, battlestaff, 14);
        sleepUntilOnClientThread(() -> Inventory.hasItem(battlestaff));

        verifyItemInBank(orb);

        Rs2Bank.withdrawItemX(true, orb, 14);
        sleepUntilOnClientThread(() -> Inventory.hasItem(orb));

        sleep(600, 3000);
        Rs2Bank.closeBank();
    }

    private void verifyItemInBank(String item) {
        if (Rs2Bank.isOpen() && !Rs2Bank.hasItem(item)) {
            Rs2Bank.closeBank();
            Microbot.status = "[Shutting down] - Reason: " + item + " not found in the bank.";
            Microbot.getNotifier().notify(Microbot.status);
            shutdown();
            return;
        }
    }

    private void craft(CraftingConfig config) {
        Inventory.useItemOnItem(battlestaff, orb);

        sleepUntilOnClientThread(() -> Rs2Widget.getWidget(17694736) != null);

        VirtualKeyboard.keyPress(KeyEvent.VK_SPACE);

        sleepUntilOnClientThread(() -> Rs2Widget.getWidget(17694736) == null);

        sleepUntilOnClientThread(() -> !Inventory.hasItem(orb), 60000);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }
}
