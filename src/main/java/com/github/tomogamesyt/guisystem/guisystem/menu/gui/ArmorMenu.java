package com.github.tomogamesyt.guisystem.guisystem.menu.gui;

import com.github.tomogamesyt.guisystem.guisystem.menu.items.MenuItem;
import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

class ArmorMenu implements iInventoryFrame{
    private Player player;
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
    }
    @Override
    public void closeEvent(InventoryCloseEvent event) {
    }
    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inv = new CustomInventory(player.getUniqueId(), Bukkit.createInventory(player, 54, player.getDisplayName() + " armor")).getInventory();
        //Do Something..//
        inv.setItem(inv.getSize()- 9, MenuItem.toItemStack(MenuItem.previousButton()));

        inv.setItem(10, MenuItem.toItemStack(MenuItem.helmButton()));
        inv.setItem(19, MenuItem.toItemStack(MenuItem.chstpltButton()));
        inv.setItem(28, MenuItem.toItemStack(MenuItem.leggButton()));
        inv.setItem(37, MenuItem.toItemStack(MenuItem.bootsButton()));

        return inv;
    }

    public static iInventoryFrame helm(){return new SelectHelmet();}

    public static iInventoryFrame chstplt(){return new SelectChestplate();}

    public static iInventoryFrame leggs(){return new SelectLeggings();}

    public static iInventoryFrame boots(){return new SelectBoots();}
}
