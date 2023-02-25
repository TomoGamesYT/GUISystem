package com.github.tomogamesyt.guisystem.guisystem.menu.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public interface iInventoryFrame extends InventoryHolder {
    Inventory getInventory(Player player);
    iInventoryFrame getPrevious();
    void clickEvent(InventoryClickEvent event);
    void closeEvent(InventoryCloseEvent event);
}
