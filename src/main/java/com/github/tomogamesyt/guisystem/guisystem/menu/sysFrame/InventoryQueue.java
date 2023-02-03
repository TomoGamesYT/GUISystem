package com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame;

import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.iInventoryFrame;

import java.util.UUID;

public class InventoryQueue {
    private final UUID uuid;

    private final iInventoryFrame inventoryImpl;

    public InventoryQueue(UUID uuid, iInventoryFrame inv){
        this.uuid = uuid;
        this.inventoryImpl = inv;
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public iInventoryFrame getInventoryClass() {
        return inventoryImpl;
    }
}
