package net.runelite.client.plugins.microbot.crafting.scripts;

import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.Script;
import net.runelite.client.plugins.microbot.crafting.CraftingConfig;
import net.runelite.client.plugins.microbot.util.bank.Rs2Bank;
import net.runelite.client.plugins.microbot.util.inventory.Inventory;
import net.runelite.client.plugins.microbot.util.math.Random;
import net.runelite.client.plugins.microbot.util.widget.Rs2Widget;

import java.util.concurrent.TimeUnit;

public class AmethystScript extends Script {

    public static double version = 3.0;

    String amethyst = "amethyst";
    String chisel = "chisel";
    String itemToCraft;
    char menuEntry;

    public void run(CraftingConfig config) {

        mainScheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            if (!super.run()) return;
            if (config.Afk() && Random.random(1, 100) == 2)
                sleep(1000, 60000);
            try {
                itemToCraft = config.amethystType().getItemName();
                menuEntry = config.amethystType().getMenuEntry();

                if (Inventory.hasItem(amethyst)
                        && Inventory.hasItem(chisel)) {
                    craft(config);
                }

                if (!Inventory.hasItem(amethyst)
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

        if(!config.keepAmethystProductInInventory()) {
            Rs2Bank.depositAll(itemToCraft);
            sleepUntilOnClientThread(() -> !Inventory.hasItem(itemToCraft));
        }

        Rs2Bank.withdrawItem(true, chisel);
        sleepUntilOnClientThread(() -> Inventory.hasItem(chisel));

        verifyItemInBank(amethyst);

        Rs2Bank.withdrawItemAll(true, amethyst);
        sleepUntilOnClientThread(() -> Inventory.hasItem(amethyst));

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
        Inventory.useItemOnItem(chisel, amethyst);

        sleepUntilOnClientThread(() -> Rs2Widget.getWidget(17694736) != null);

        keyPress(menuEntry);

        sleepUntilOnClientThread(() -> Rs2Widget.getWidget(17694736) == null);

        sleepUntilOnClientThread(() -> !Inventory.hasItem(amethyst), 60000);
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }
}
