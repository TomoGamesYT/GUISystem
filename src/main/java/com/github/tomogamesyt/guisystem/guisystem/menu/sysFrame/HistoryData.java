package com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame;

import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.GenInventory;
import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.iInventoryFrame;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class HistoryData {

    public static HistoryData getHistoryData(GenInventory genInventory, Player player){
        return genInventory.getHistoryData().computeIfAbsent(player.getUniqueId(), uuid -> new HistoryData(uuid, player));
    }

    public static void removeHistory(GenInventory genInventory, Player player){
        genInventory.getHistoryData().remove(player.getUniqueId());
    }

    private HistoryData(UUID uuid, Player player){
        this.uuid = uuid;
        this.player = player;
    }

    private final UUID uuid;

    private final Player player;

    private final Deque<InventoryQueue> queues = new ConcurrentLinkedDeque<>();

    public HistoryData addQueue(UUID uuid, iInventoryFrame invFrame){
        InventoryQueue invQueue = new InventoryQueue(uuid, invFrame);
        queues.push(invQueue);
        return this;
    }

    public InventoryQueue getCurrentInventory(){
        return queues.peekLast();
    }
}
