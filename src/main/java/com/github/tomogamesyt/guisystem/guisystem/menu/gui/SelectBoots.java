package com.github.tomogamesyt.guisystem.guisystem.menu.gui;

import com.github.tomogamesyt.guisystem.guisystem.menu.items.MenuItem;
import com.github.tomogamesyt.guisystem.guisystem.menu.items.iMenuItem;
import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

class SelectBoots implements iInventoryFrame{
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

    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = new CustomInventory(player.getUniqueId(), Bukkit.createInventory(player, 36, "Select Boots")).getInventory();
        //Do Something//

        inventory.setItem(inventory.getSize()- 9, MenuItem.toItemStack(MenuItem.previousButton()));

        return inventory;
    }
}
