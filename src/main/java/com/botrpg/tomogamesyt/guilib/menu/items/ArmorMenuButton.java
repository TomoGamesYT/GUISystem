package com.botrpg.tomogamesyt.guilib.menu.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.List;

class ArmorMenuButton implements iMenuItem {
    @Override
    public String getDisplayName() {
        return ChatColor.AQUA + "装備画面を開く";
    }

    @Override
    public Material getMaterial() {
        return Material.IRON_CHESTPLATE;
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
