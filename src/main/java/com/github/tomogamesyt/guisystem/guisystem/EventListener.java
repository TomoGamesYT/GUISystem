package com.github.tomogamesyt.guisystem.guisystem;

import com.github.tomogamesyt.guisystem.guisystem.menu.gui.GenInventory;
import com.github.tomogamesyt.guisystem.guisystem.menu.gui.iInventoryFrame;
import com.github.tomogamesyt.guisystem.guisystem.menu.items.MenuItem;
import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.HistoryData;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
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
        HistoryData.removeHistory(GenInventory.getGenInventory(), event.getPlayer());
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();

        if(player.getGameMode() == GameMode.CREATIVE||player.getGameMode() == GameMode.SPECTATOR)return;

        InventoryHolder holder = inventory.getHolder();

        if(holder == null)return;
        if(!(holder instanceof iInventoryFrame))return;

        iInventoryFrame inventoryClass = HistoryData.getHistoryData(GenInventory.getGenInventory(), player).getCurrentInventory().getInventoryClass();
        inventoryClass.closeEvent(event);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        if (inventory == null)return;
        if(event.getCurrentItem() == null)return;

        if(player.getGameMode() == GameMode.CREATIVE||player.getGameMode() == GameMode.SPECTATOR)return;

        event.setCancelled(true);

        if(inventory.getType().equals(InventoryType.PLAYER)){
            //Player Inventory//
            GenInventory.player(main).clickEvent(event);
            return;
        }

        InventoryHolder holder = inventory.getHolder();
        if (holder == null)return;

        if(event.getCurrentItem().equals(MenuItem.toItemStack(MenuItem.nullItem())))return;

        iInventoryFrame inventoryClass = HistoryData.getHistoryData(GenInventory.getGenInventory(), player).getCurrentInventory().getInventoryClass();

        if(event.getCurrentItem().equals(MenuItem.toItemStack(MenuItem.closeButton()))){
            player.closeInventory();
            return;
        }

        if(event.getCurrentItem().equals(MenuItem.toItemStack(MenuItem.previousButton()))) {
            new GenInventory().open(player, inventoryClass.getPrevious());
            return;
        }
        inventoryClass.clickEvent(event);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE||player.getGameMode() == GameMode.SPECTATOR)return;
        GenInventory.player(main).getInventory(player);
        HistoryData.getHistoryData(new GenInventory(), player).addQueue(player.getUniqueId(), GenInventory.player(main));
        player.updateInventory();
    }
}
