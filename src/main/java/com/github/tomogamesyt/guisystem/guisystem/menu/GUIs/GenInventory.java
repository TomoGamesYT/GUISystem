package com.github.tomogamesyt.guisystem.guisystem.menu.GUIs;

import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.HistoryData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GenInventory {
    private static GenInventory genInventory;

    public GenInventory(){
        genInventory = this;
    }

    public static iInventoryFrame armor(){
        return new ArmorMenu();
    }

    public void open(Player player, iInventoryFrame inventoryFrame){
        if(inventoryFrame == null)return;
        HistoryData.getHistoryData(this, player).addQueue(player.getUniqueId(), inventoryFrame);
        player.openInventory(inventoryFrame.getInventory(player));
    }

    private final HashMap<UUID, HistoryData> historyMap = new HashMap<>();

    public Map<UUID, HistoryData> getHistoryData(){
        return historyMap;
    }

    public static GenInventory getGenInventory() {
        return genInventory;
    }
}
