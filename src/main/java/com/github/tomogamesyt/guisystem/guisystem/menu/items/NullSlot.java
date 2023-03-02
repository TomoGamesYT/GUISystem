package com.github.tomogamesyt.guisystem.guisystem.menu.items;

import org.bukkit.Material;

import java.util.List;

class NullSlot implements iMenuItem{
    @Override
    public String getDisplayName() {
        return " ";
    }
    @Override
    public Material getMaterial() {
        return Material.WHITE_STAINED_GLASS_PANE;
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
