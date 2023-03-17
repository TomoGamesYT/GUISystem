package com.botrpg.tomogamesyt.guilib.menu.sysFrame;

import com.botrpg.tomogamesyt.guilib.menu.items.MenuItem;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CustomInventory implements InventoryHolder {
    private Inventory inventory;
    private final UUID uuid;

    public CustomInventory(UUID uuid, Inventory inventory){
        this.initInventory(inventory);
        this.uuid = uuid;
    }
    private void initInventory(Inventory inventory){
        int size = inventory.getSize();
        if(size % 9 != 0)return;
        ItemStack itemStack = MenuItem.nullItem();
        for(int slot = 0; slot<size; slot++){
            inventory.setItem(slot, itemStack);
        }
        this.inventory = inventory;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public UUID getUuid() {
        return uuid;
    }
}
