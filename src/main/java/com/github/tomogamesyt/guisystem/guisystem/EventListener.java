package com.github.tomogamesyt.guisystem.guisystem;

import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.iInventoryFrame;
import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.CustomInventory;
import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.GenInventory;
import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.HistoryData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class EventListener implements Listener {
    private final Main main;

    public EventListener(Main main){
        this.main = main;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        HistoryData.removeHistory(main.genInventory(), event.getPlayer());
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Inventory inventory = event.getInventory();
        InventoryHolder holder = inventory.getHolder();

        if(holder == null)return;

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        if (inventory == null)return;

        event.setCancelled(true);

        InventoryHolder holder = inventory.getHolder();
        if (holder == null)return;

        HistoryData history = HistoryData.getHistoryData(main.genInventory(), player);
        if(history.getCurrentInventory().getInventoryClass().equals(GenInventory.armor()))return;

        player.sendMessage("ClickTest");

    }
}
