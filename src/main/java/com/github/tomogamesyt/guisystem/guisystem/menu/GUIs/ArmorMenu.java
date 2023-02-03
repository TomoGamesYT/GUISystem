package com.github.tomogamesyt.guisystem.guisystem.menu.GUIs;

import com.github.tomogamesyt.guisystem.guisystem.menu.sysFrame.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

class ArmorMenu implements iInventoryFrame{
    private Player player;

    @Override
    public Inventory getInventory(Player player) {
        this.player = player;
        return getInventory();
    }

    @Override
    public Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(player, 36, player.getDisplayName() + " armor");
        inv = new CustomInventory(player.getUniqueId(), inv).getInventory();

        //Do Something..//

        return inv;
    }
}
