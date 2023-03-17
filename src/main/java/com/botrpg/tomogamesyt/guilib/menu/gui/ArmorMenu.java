package com.botrpg.tomogamesyt.guilib.menu.gui;

import com.botrpg.tomogamesyt.guilib.menu.items.MenuItem;
import com.botrpg.tomogamesyt.guilib.menu.sysFrame.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        if (MenuItem.helmButton().equals(item)) {
            new GenInventory().open(player, helm());
        } else if (MenuItem.chstpltButton().equals(item)) {
            new GenInventory().open(player, chstplt());
        }else if(MenuItem.leggButton().equals(item)){
            new GenInventory().open(player, leggs());
        }else if(MenuItem.bootsButton().equals(item)){
            new GenInventory().open(player, boots());
        }
    }
    @Override
    public void closeEvent(InventoryCloseEvent event) {
    }
    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inv = new CustomInventory(player.getUniqueId(), Bukkit.createInventory(player, 54, player.getDisplayName() + " armor")).getInventory();
        //Do Something..//
        inv.setItem(inv.getSize()- 9, MenuItem.closeButton());

        inv.setItem(10, MenuItem.helmButton());
        inv.setItem(19, MenuItem.chstpltButton());
        inv.setItem(28, MenuItem.leggButton());
        inv.setItem(37, MenuItem.bootsButton());

        return inv;
    }

    private iInventoryFrame helm(){return new SelectHelmet();}

    private iInventoryFrame chstplt(){return new SelectChestplate();}

    private iInventoryFrame leggs(){return new SelectLeggings();}

    private iInventoryFrame boots(){return new SelectBoots();}
}
