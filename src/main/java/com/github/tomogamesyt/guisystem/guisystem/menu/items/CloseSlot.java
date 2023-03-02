package com.github.tomogamesyt.guisystem.guisystem.menu.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.List;

class CloseSlot implements iMenuItem{
    @Override
    public String getDisplayName() {
        return ChatColor.RED + "閉じる";
    }

    @Override
    public Material getMaterial() {
        return Material.BARRIER;
    }

    @Override
    public List<String> getLore() {
        return null;
    }

    @Override
    public int getCustomModelData() {
        return 0;
    }
}
