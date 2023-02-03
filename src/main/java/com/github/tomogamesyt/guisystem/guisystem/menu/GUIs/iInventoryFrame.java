package com.github.tomogamesyt.guisystem.guisystem.menu.GUIs;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public interface iInventoryFrame extends InventoryHolder {
    Inventory getInventory(Player player);
}
