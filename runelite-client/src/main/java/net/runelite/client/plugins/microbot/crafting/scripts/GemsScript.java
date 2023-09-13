package net.runelite.client.plugins.microbot.crafting.scripts;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Skill;
import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.Script;
import net.runelite.client.plugins.microbot.crafting.CraftingConfig;
import net.runelite.client.plugins.microbot.crafting.enums.Gems;
import net.runelite.client.plugins.microbot.util.bank.Rs2Bank;
import net.runelite.client.plugins.microbot.util.inventory.Inventory;
import net.runelite.client.plugins.microbot.util.keyboard.VirtualKeyboard;
import net.runelite.client.plugins.microbot.util.math.Random;
import net.runelite.client.plugins.microbot.util.widget.Rs2Widget;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class ProgressiveGemModel {
    @Getter
    @Setter
    private String gem;
}

class AllInBankGemModel {
    @Getter
    @Setter
    private ArrayList<String> gemsInBank;
}

public class GemsScript extends Script {

    public static double version = 3.0;

    ProgressiveGemModel progressiveModel = new ProgressiveGemModel();
    AllInBankGemModel allInBankModel = new AllInBankGemModel();

    String chisel = "chisel";
    String gem;
    ArrayList<String> gemsInBank;

    public void run(CraftingConfig config) {

        if (config.gemType() == Gems.PROGRESSIVE)
            calculateItemToCraft();

        if (config.gemType() == Gems.ALL)
            calculateAllGemsInBank();

        mainScheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
            if (!super.run()) return;
            if (config.Afk() && Random.random(1, 100) == 2)
                sleep(1000, 60000);
            try {

                if (config.gemType() == Gems.ALL) {

                    if (Inventory.hasItemContains("uncut")
                            && Inventory.hasItem(chisel)) {
                        craft(config);
                    }
                    if (!Inventory.hasItemContains("uncut")
                            || !Inventory.hasItem(chisel)) {
                        bank(config);
                    }

                } else {
                    if (config.gemType() == Gems.PROGRESSIVE) {
                        gem = progressiveModel.getGem();
                    } else {
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

        if (config.gemType() != Gems.ALL) {
            verifyItemInBank("uncut " + gem);
        }

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

    public ProgressiveGemModel calculateItemToCraft() {
        int craftinglvl = Microbot.getClient().getRealSkillLevel(Skill.CRAFTING);
        if (craftinglvl < Gems.JADE.getLevelRequired()) {
            progressiveModel.setGem(Gems.OPAL.getName().toLowerCase());
        } else if (craftinglvl < Gems.RED_TOPAZ.getLevelRequired()) {
            progressiveModel.setGem(Gems.JADE.getName().toLowerCase());
        } else if (craftinglvl < Gems.SAPPHIRE.getLevelRequired()) {
            progressiveModel.setGem(Gems.RED_TOPAZ.getName().toLowerCase());
        } else if (craftinglvl < Gems.EMERALD.getLevelRequired()) {
            progressiveModel.setGem(Gems.SAPPHIRE.getName().toLowerCase());
        } else if (craftinglvl < Gems.RUBY.getLevelRequired()) {
            progressiveModel.setGem(Gems.EMERALD.getName().toLowerCase());
        } else if (craftinglvl < Gems.DIAMOND.getLevelRequired()) {
            progressiveModel.setGem(Gems.RUBY.getName().toLowerCase());
        } else if (craftinglvl < Gems.DRAGONSTONE.getLevelRequired()) {
            progressiveModel.setGem(Gems.DIAMOND.getName().toLowerCase());
        } else if (craftinglvl < Gems.ONYX.getLevelRequired()) {
            progressiveModel.setGem(Gems.DRAGONSTONE.getName().toLowerCase());
        } else if (craftinglvl < Gems.ZENYTE.getLevelRequired()) {
            progressiveModel.setGem(Gems.ONYX.getName().toLowerCase());
        } else if (craftinglvl < 99) {
            progressiveModel.setGem(Gems.ZENYTE.getName().toLowerCase());
        }
        return progressiveModel;
    }

    public AllInBankGemModel calculateAllGemsInBank() {
//        int craftinglvl = Microbot.getClient().getRealSkillLevel(Skill.CRAFTING);
        ArrayList<String> gemsInBank = new ArrayList<String>();

        Rs2Bank.openBank();
        sleepUntilOnClientThread(Rs2Bank::isOpen);

        for (Gems gem : Gems.values()) {
//            if (craftinglvl < gem.getLevelRequired()) {
//                break;
//            }
            if(Rs2Bank.hasItem("uncut " + gem.getName().toLowerCase())) {
                gemsInBank.add(gem.getName().toLowerCase());
            }
        }

        allInBankModel.setGemsInBank(gemsInBank);

        return allInBankModel;
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }
}
