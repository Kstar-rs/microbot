package net.runelite.client.plugins.microbot.crafting.scripts;

import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.Script;
import net.runelite.client.plugins.microbot.crafting.CraftingConfig;
import net.runelite.client.plugins.microbot.crafting.enums.Gems;
import net.runelite.client.plugins.microbot.crafting.enums.Glass;
import net.runelite.client.plugins.microbot.util.bank.Rs2Bank;
import net.runelite.client.plugins.microbot.util.inventory.Inventory;
import net.runelite.client.plugins.microbot.util.keyboard.VirtualKeyboard;
import net.runelite.client.plugins.microbot.util.math.Random;
import net.runelite.client.plugins.microbot.util.widget.Rs2Widget;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class GemsScript extends Script {

    public static double version = 3.0;

    String chisel = "chisel";
    String gem;

    public void run(CraftingConfig config) {

        mainScheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            if (!super.run()) return;
            if (config.Afk() && Random.random(1, 100) == 2)
                sleep(1000, 60000);
            try {

                if (config.glassType() == Glass.PROGRESSIVE) {
                    gem = config.gemType().getName().toLowerCase();
                } else if (config.gemType() == Gems.ALL) {
                    gem = config.gemType().getName().toLowerCase();
                }  else {
                    gem = config.gemType().getName().toLowerCase();
                }

                if (Inventory.hasItem("uncut " + gem)
                        && Inventory.hasItem(chisel)) {
                    craft(config);
                }
                if (!Inventory.hasItem("uncut " + gem)
                        || !Inventory.hasItem(chisel)) {
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

        Rs2Bank.depositAll("crushed gem");
        sleepUntilOnClientThread(() -> !Inventory.hasItem(gem));

        Rs2Bank.depositAll(gem);
        sleepUntilOnClientThread(() -> !Inventory.hasItem(gem));

        Rs2Bank.withdrawItem(true, chisel);
        sleepUntilOnClientThread(() -> Inventory.hasItem(chisel));

        verifyItemInBank("uncut " + gem);

        Rs2Bank.withdrawItemAll(true, "uncut " + gem);
        sleepUntilOnClientThread(() -> Inventory.hasItem("uncut " + gem));

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
        Inventory.useItemOnItem(chisel, "uncut " + gem);

        sleepUntilOnClientThread(() -> Rs2Widget.getWidget(17694736) != null);

        VirtualKeyboard.keyPress(KeyEvent.VK_SPACE);

        sleepUntilOnClientThread(() -> Rs2Widget.getWidget(17694736) == null);

        sleepUntilOnClientThread(() -> !Inventory.hasItem("uncut " + gem), 60000);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }
}
