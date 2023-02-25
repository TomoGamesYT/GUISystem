package com.github.tomogamesyt.guisystem.guisystem.menu.items;

import org.bukkit.Material;

import java.util.List;

class HelmButton implements iMenuItem{
    @Override
    public String getDisplayName() {
        return "Helmetを選ぶ";
    }
    @Override
    public Material getMaterial() {
        return Material.IRON_HELMET;
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
