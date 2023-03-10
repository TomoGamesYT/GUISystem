package com.botrpg.tomogamesyt.guilib.menu.sysFrame;

import com.botrpg.tomogamesyt.guilib.menu.gui.iInventoryFrame;

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
