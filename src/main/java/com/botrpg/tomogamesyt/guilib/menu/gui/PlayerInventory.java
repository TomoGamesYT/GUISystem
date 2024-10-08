package com.botrpg.tomogamesyt.guilib.menu.gui;

import com.botrpg.tomogamesyt.guilib.InventoryLib;
import com.botrpg.tomogamesyt.guilib.menu.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class PlayerInventory implements iInventoryFrame{
    private Player player;
    private final ItemStack nullSlot = MenuItem.nullItem();
    private final ItemStack armorButton = MenuItem.armorButton();

    private final InventoryLib inventoryLib;

    @Override
    public Inventory getInventory(Player player) {
        this.player = player;
        return getInventory();
    }

    @Override
    public iInventoryFrame getPrevious() {
        return null;
    }

    @Override
    public void clickEvent(InventoryClickEvent event) {
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        new BukkitRunnable() {
            @Override
            public void run() {
                if(event.getCurrentItem().equals(armorButton)){
                    new GenInventory().open(player, GenInventory.armor());
                }else{
                    GenInventory.armor().clickEvent(event);
               }
            }
        }.runTask(inventoryLib.getPlugin());
    }

    @Override
    public void closeEvent(InventoryCloseEvent event) {
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = player.getInventory();
        for(int i = 0; i < inventory.getSize(); i++){
            inventory.setItem(i, nullSlot);
        }

        inventory.setItem(9, armorButton);
        inventory.setItem(39, MenuItem.helmButton());
        inventory.setItem(38, MenuItem.chstpltButton());
        inventory.setItem(37, MenuItem.leggButton());
        inventory.setItem(36, MenuItem.bootsButton());
        return inventory;
    }

    PlayerInventory(InventoryLib inventoryLib){
        this.inventoryLib = inventoryLib;
    }
}
