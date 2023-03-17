package com.botrpg.tomogamesyt.guilib.menu.gui;

import com.botrpg.tomogamesyt.guilib.menu.items.MenuItem;
import com.botrpg.tomogamesyt.guilib.menu.sysFrame.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

class SelectHelmet implements iInventoryFrame{
    private Player player;
    @Override
    public Inventory getInventory(Player player) {
        this.player = player;
        return getInventory();
    }
    @Override
    public iInventoryFrame getPrevious() {
        return GenInventory.armor();
    }
    @Override
    public void clickEvent(InventoryClickEvent event) {
    }
    @Override
    public void closeEvent(InventoryCloseEvent event) {
        new GenInventory().open((Player) event.getPlayer(), getPrevious());
    }
    @Override
    @NotNull
    public Inventory getInventory() {
        Inventory inventory = new CustomInventory(player.getUniqueId(), Bukkit.createInventory(player, 36, "Select Helmet")).getInventory();
        //Do Something//
        inventory.setItem(inventory.getSize()- 9, MenuItem.previousButton());


        return inventory;
    }
}
