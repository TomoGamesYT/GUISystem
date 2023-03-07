package com.github.tomogamesyt.guisystem.guisystem.menu.gui;

import com.github.tomogamesyt.guisystem.guisystem.Main;
import com.github.tomogamesyt.guisystem.guisystem.menu.items.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class PlayerInventory implements iInventoryFrame{
    private Player player;
    private final ItemStack nullSlot = MenuItem.toItemStack(MenuItem.nullItem());
    private final ItemStack armorButton = MenuItem.toItemStack(MenuItem.armorButton());

    private final Main main;

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
        player.sendMessage("Slot: " + event.getSlot());
        new BukkitRunnable() {
            @Override
            public void run() {
                if(event.getCurrentItem().equals(armorButton)){
                    new GenInventory().open(player, GenInventory.armor());
                }else{
                    GenInventory.armor().clickEvent(event);
               }
            }
        }.runTask(main.getPlugin());
        getInventory(player);
        player.updateInventory();
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
        inventory.setItem(39, MenuItem.toItemStack(MenuItem.helmButton()));
        inventory.setItem(38, MenuItem.toItemStack(MenuItem.chstpltButton()));
        inventory.setItem(37, MenuItem.toItemStack(MenuItem.leggButton()));
        inventory.setItem(36, MenuItem.toItemStack(MenuItem.bootsButton()));
        return inventory;
    }

    PlayerInventory(Main main){
        this.main = main;
    }
}
